// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.core.http

import com.turbopuffer.core.DefaultSleeper
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.Sleeper
import com.turbopuffer.core.checkRequired
import com.turbopuffer.errors.TurbopufferIoException
import com.turbopuffer.errors.TurbopufferRetryableException
import java.io.IOException
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.function.Function
import kotlin.math.min
import kotlin.math.pow

class RetryingHttpClient
private constructor(
    private val httpClient: HttpClient,
    private val sleeper: Sleeper,
    private val clock: Clock,
    private val maxRetries: Int,
    private val idempotencyHeader: String?,
    private val requestObserver: RequestObserver?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val observation =
            RequestObservation.start(requestObserver, request)
                ?: return execute(request, requestOptions, null)
        return try {
            observation.respond(execute(request, requestOptions, observation))
        } catch (throwable: Throwable) {
            observation.fail(throwable)
            throw throwable
        }
    }

    private fun execute(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observation: RequestObservation?,
    ): HttpResponse {
        var modifiedRequest = maybeAddIdempotencyHeader(request)

        // Don't send the current retry count in the headers if the caller set their own value.
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        while (true) {
            if (shouldSendRetryCount) {
                modifiedRequest = setRetryCountHeader(modifiedRequest, retries)
            }

            if (!isRetryable(modifiedRequest)) {
                return executeAttempt(modifiedRequest, requestOptions, observation, retries)
            }

            val response =
                try {
                    val response =
                        executeAttempt(modifiedRequest, requestOptions, observation, retries)
                    if (++retries > maxRetries || !shouldRetry(response)) {
                        return response
                    }

                    response
                } catch (throwable: Throwable) {
                    if (++retries > maxRetries || !shouldRetry(throwable)) {
                        throw throwable
                    }

                    null
                }

            val backoffDuration = getRetryBackoffDuration(retries, response)
            // All responses must be closed, so close the failed one before retrying.
            response?.close()
            sleeper.sleep(backoffDuration)
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val observation =
            RequestObservation.start(requestObserver, request)
                ?: return executeAsync(request, requestOptions, null)
        val future =
            try {
                executeAsync(request, requestOptions, observation)
            } catch (throwable: Throwable) {
                observation.fail(throwable)
                throw throwable
            }
        val observed = future.thenApply(observation::respond)
        // Also ends the request when the returned future is canceled.
        observed.whenComplete { _, throwable -> throwable?.let(observation::fail) }
        return observed
    }

    private fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observation: RequestObservation?,
    ): CompletableFuture<HttpResponse> {
        val modifiedRequest = maybeAddIdempotencyHeader(request)

        // Don't send the current retry count in the headers if the caller set their own value.
        val shouldSendRetryCount =
            !modifiedRequest.headers.names().contains("X-Stainless-Retry-Count")

        var retries = 0

        fun executeWithRetries(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val requestWithRetryCount =
                if (shouldSendRetryCount) setRetryCountHeader(request, retries) else request

            val responseFuture =
                executeAttemptAsync(requestWithRetryCount, requestOptions, observation, retries)
            if (!isRetryable(requestWithRetryCount)) {
                return responseFuture
            }

            return responseFuture
                .handleAsync(
                    fun(
                        response: HttpResponse?,
                        throwable: Throwable?,
                    ): CompletableFuture<HttpResponse> {
                        if (response != null) {
                            if (++retries > maxRetries || !shouldRetry(response)) {
                                return CompletableFuture.completedFuture(response)
                            }
                        } else {
                            if (++retries > maxRetries || !shouldRetry(throwable!!)) {
                                val failedFuture = CompletableFuture<HttpResponse>()
                                failedFuture.completeExceptionally(throwable)
                                return failedFuture
                            }
                        }

                        val backoffDuration = getRetryBackoffDuration(retries, response)
                        // All responses must be closed, so close the failed one before retrying.
                        response?.close()
                        return sleeper.sleepAsync(backoffDuration).thenCompose {
                            executeWithRetries(requestWithRetryCount, requestOptions)
                        }
                    }
                ) {
                    // Run in the same thread.
                    it.run()
                }
                .thenCompose(Function.identity())
        }

        return executeWithRetries(modifiedRequest, requestOptions)
    }

    override fun close() {
        httpClient.close()
        sleeper.close()
    }

    private fun executeAttempt(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observation: RequestObservation?,
        attempt: Int,
    ): HttpResponse {
        if (observation == null) {
            return httpClient.execute(request, requestOptions)
        }
        val response =
            try {
                httpClient.execute(observation.attemptBegin(attempt, request), requestOptions)
            } catch (throwable: Throwable) {
                observation.attemptEnd(null, throwable)
                throw throwable
            }
        observation.attemptEnd(response, null)
        return response
    }

    private fun executeAttemptAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
        observation: RequestObservation?,
        attempt: Int,
    ): CompletableFuture<HttpResponse> {
        if (observation == null) {
            return httpClient.executeAsync(request, requestOptions)
        }
        val future =
            try {
                httpClient.executeAsync(observation.attemptBegin(attempt, request), requestOptions)
            } catch (throwable: Throwable) {
                observation.attemptEnd(null, throwable)
                throw throwable
            }
        return future.whenComplete { response, throwable ->
            observation.attemptEnd(response, throwable)
        }
    }

    private fun isRetryable(request: HttpRequest): Boolean =
        // Some requests, such as when a request body is being streamed, cannot be retried because
        // the body data aren't available on subsequent attempts.
        request.body?.repeatable() ?: true

    private fun setRetryCountHeader(request: HttpRequest, retries: Int): HttpRequest =
        request.toBuilder().replaceHeaders("X-Stainless-Retry-Count", retries.toString()).build()

    private fun idempotencyKey(): String = "stainless-java-retry-${UUID.randomUUID()}"

    private fun maybeAddIdempotencyHeader(request: HttpRequest): HttpRequest {
        if (idempotencyHeader == null || request.headers.names().contains(idempotencyHeader)) {
            return request
        }

        return request
            .toBuilder()
            // Set a header to uniquely identify the request when retried.
            .putHeader(idempotencyHeader, idempotencyKey())
            .build()
    }

    private fun shouldRetry(response: HttpResponse): Boolean {
        // Note: this is not a standard header
        val shouldRetryHeader = response.headers().values("X-Should-Retry").getOrNull(0)
        val statusCode = response.statusCode()

        return when {
            // If the server explicitly says whether to retry, obey
            shouldRetryHeader == "true" -> true
            shouldRetryHeader == "false" -> false

            // Retry on request timeouts
            statusCode == 408 -> true
            // Retry on lock timeouts
            statusCode == 409 -> true
            // Retry on rate limits
            statusCode == 429 -> true
            // Retry internal errors
            statusCode >= 500 -> true
            else -> false
        }
    }

    private fun shouldRetry(throwable: Throwable): Boolean =
        // Only retry known retryable exceptions, other exceptions are not intended to be retried.
        throwable is IOException ||
            throwable is TurbopufferIoException ||
            throwable is TurbopufferRetryableException

    private fun getRetryBackoffDuration(retries: Int, response: HttpResponse?): Duration {
        // About the Retry-After header:
        // https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After
        response
            ?.headers()
            ?.let { headers ->
                headers
                    .values("Retry-After-Ms")
                    .getOrNull(0)
                    ?.toFloatOrNull()
                    ?.times(TimeUnit.MILLISECONDS.toNanos(1))
                    ?: headers.values("Retry-After").getOrNull(0)?.let { retryAfter ->
                        retryAfter.toFloatOrNull()?.times(TimeUnit.SECONDS.toNanos(1))
                            ?: try {
                                ChronoUnit.NANOS.between(
                                    OffsetDateTime.now(clock),
                                    OffsetDateTime.parse(
                                        retryAfter,
                                        DateTimeFormatter.RFC_1123_DATE_TIME,
                                    ),
                                )
                            } catch (e: DateTimeParseException) {
                                null
                            }
                    }
            }
            ?.let { retryAfterNanos ->
                // If the API asks us to wait a certain amount of time, do what it says.
                return Duration.ofNanos(retryAfterNanos.toLong())
            }

        // Apply exponential backoff, but not more than the max.
        val backoffSeconds = min(0.25 * 2.0.pow(retries - 1), 8.0)

        // Apply some jitter
        val jitter = 1.0 - 0.25 * ThreadLocalRandom.current().nextDouble()

        return Duration.ofNanos((TimeUnit.SECONDS.toNanos(1) * backoffSeconds * jitter).toLong())
    }

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var sleeper: Sleeper? = null
        private var clock: Clock = Clock.systemUTC()
        private var maxRetries: Int = 4
        private var idempotencyHeader: String? = null
        private var requestObserver: RequestObserver? = null

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun sleeper(sleeper: Sleeper) = apply { this.sleeper = sleeper }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun idempotencyHeader(header: String) = apply { this.idempotencyHeader = header }

        @JvmSynthetic
        internal fun requestObserver(requestObserver: RequestObserver?) = apply {
            this.requestObserver = requestObserver
        }

        fun build(): HttpClient =
            RetryingHttpClient(
                checkRequired("httpClient", httpClient),
                sleeper ?: DefaultSleeper(),
                clock,
                maxRetries,
                idempotencyHeader,
                requestObserver,
            )
    }
}
