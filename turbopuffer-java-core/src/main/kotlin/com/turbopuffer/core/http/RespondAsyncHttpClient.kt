package com.turbopuffer.core.http

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.json.JsonMapper
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.Sleeper
import com.turbopuffer.core.Timeout
import com.turbopuffer.errors.TurbopufferException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.net.URI
import java.time.Duration
import java.util.concurrent.CompletableFuture

private const val PREFER_HEADER = "Prefer"
private const val PREFERENCE_APPLIED_HEADER = "Preference-Applied"
private const val LOCATION_HEADER = "Location"
private const val RESPOND_ASYNC = "respond-async"

/** Interval between successive polls of the operations endpoint. Overridable for tests. */
internal var POLL_INTERVAL: Duration = Duration.ofSeconds(1)

/** Per-poll request timeout cap. */
private val POLL_REQUEST_TIMEOUT: Duration = Duration.ofSeconds(60)

/**
 * Transparent polling for tpuf APIs that accept `prefer: respond-async`.
 *
 * Every outgoing request is stamped with `Prefer: respond-async`. If the server applies the
 * preference (i.e. responds with `202 Accepted` + `Preference-Applied: respond-async`), this client
 * polls the operation URL from the `Location` header until the operation finishes and returns the
 * final response as if the call had been synchronous.
 */
class RespondAsyncHttpClient(
    private val httpClient: HttpClient,
    private val sleeper: Sleeper,
    private val jsonMapper: JsonMapper,
    private val clientHeaders: Headers,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val initialReq = prepareHeaders(request)
        val initialRes = httpClient.execute(initialReq, requestOptions)
        if (!respondAsyncApplied(initialRes)) {
            return initialRes
        }

        val location = initialRes.use { extractLocation(it, initialReq.url()) }
        val deadline = Deadline(requestOptions)
        while (true) {
            val pollReq = pollRequest(location)
            val pollOpts = pollOptions(deadline)
            val finalRes = httpClient.execute(pollReq, pollOpts).use { resolvePollResponse(it) }
            if (finalRes != null) {
                return finalRes
            }
            sleeper.sleep(deadline.sleepDuration())
        }
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val initialReq = prepareHeaders(request)
        return httpClient.executeAsync(initialReq, requestOptions).thenCompose { initialRes ->
            if (!respondAsyncApplied(initialRes)) {
                CompletableFuture.completedFuture(initialRes)
            } else {
                val location = initialRes.use { extractLocation(it, initialReq.url()) }
                val deadline = Deadline(requestOptions)
                pollAsync(location, deadline)
            }
        }
    }

    override fun close() = httpClient.close()

    private fun pollAsync(location: String, deadline: Deadline): CompletableFuture<HttpResponse> {
        val pollReq = pollRequest(location)
        val pollOpts = pollOptions(deadline)
        return httpClient.executeAsync(pollReq, pollOpts).thenCompose { resp ->
            val finalRes = resp.use { resolvePollResponse(it) }
            if (finalRes != null) {
                CompletableFuture.completedFuture(finalRes)
            } else {
                sleeper.sleepAsync(deadline.sleepDuration()).thenCompose {
                    pollAsync(location, deadline)
                }
            }
        }
    }

    private fun prepareHeaders(request: HttpRequest): HttpRequest {
        // Don't overwrite an existing `Prefer` header. Lets callers opt out per-request.
        if (request.headers.names().contains(PREFER_HEADER)) {
            return request
        }
        return request.toBuilder().putHeader(PREFER_HEADER, RESPOND_ASYNC).build()
    }

    private fun respondAsyncApplied(response: HttpResponse): Boolean {
        if (response.statusCode() != 202) {
            return false
        }
        val applied =
            response.headers().values(PREFERENCE_APPLIED_HEADER).firstOrNull() ?: return false
        return applied.trim().equals(RESPOND_ASYNC, ignoreCase = true)
    }

    /** Reads the `Location` header and resolves it against the given request URL. */
    private fun extractLocation(response: HttpResponse, requestUrl: String): String {
        val rawLocation =
            response.headers().values(LOCATION_HEADER).firstOrNull()
                ?: throw TurbopufferException(
                    "server returned async response without a `Location` header"
                )
        val origUri = URI.create(requestUrl)
        val resolved =
            try {
                origUri.resolve(rawLocation)
            } catch (e: IllegalArgumentException) {
                throw TurbopufferException("malformed `Location` header: $rawLocation", e)
            }
        // Reject a Location pointing at a different origin, to prevent API key exfiltration.
        if (origin(resolved) != origin(origUri)) {
            throw TurbopufferException(
                "`Location` origin does not match request origin: $rawLocation"
            )
        }
        return resolved.toString()
    }

    /** `(scheme, host, port)` triple with the scheme's default port substituted when omitted. */
    private fun origin(uri: URI): Triple<String?, String?, Int> {
        val port =
            if (uri.port != -1) uri.port
            else
                when (uri.scheme) {
                    "http" -> 80
                    "https" -> 443
                    else -> -1
                }
        return Triple(uri.scheme, uri.host, port)
    }

    private fun pollRequest(location: String): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl(location)
            .putAllHeaders(clientHeaders)
            .build()

    private fun pollOptions(deadline: Deadline): RequestOptions {
        // Floor timeout at 1ms to avoid OkHttp's "0 means no timeout" semantics.
        // https://square.github.io/okhttp/5.x/okhttp/okhttp3/-ok-http-client/-builder/call-timeout.html
        val timeout = maxOf(Duration.ofMillis(1), deadline.pollTimeout())
        return RequestOptions.builder().timeout(Timeout.builder().request(timeout).build()).build()
    }

    private fun resolvePollResponse(response: HttpResponse): HttpResponse? {
        val body =
            try {
                jsonMapper.readValue(response.body(), PollBody::class.java)
            } catch (t: Throwable) {
                throw TurbopufferException("malformed poll response", t)
            }
        if (body.status == "running") return null
        if (body.status != "finished" || body.result == null) {
            throw TurbopufferException("malformed poll response")
        }
        val (success, error) = body.result
        val (statusCode, payload) =
            when {
                success != null && error == null -> 200 to success
                error != null && success == null -> error.statusCode to error.detail
                else -> throw TurbopufferException("malformed poll response")
            }

        val bytes = jsonMapper.writeValueAsBytes(payload)
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        return object : HttpResponse {
            override fun statusCode(): Int = statusCode

            override fun headers(): Headers = headers

            override fun body(): InputStream = ByteArrayInputStream(bytes)

            override fun close() {}
        }
    }
}

/** Tracks a polling-loop timeout. */
private class Deadline(requestOptions: RequestOptions) {

    // `Timeout.request()` uses `Duration.ZERO` to mean "no timeout".
    private val deadlineNs: Long = run {
        val request = requestOptions.timeout?.request()
        if (request == null || request.isZero) Long.MAX_VALUE
        else System.nanoTime() + request.toNanos()
    }

    fun remaining(): Duration = Duration.ofNanos(maxOf(0L, deadlineNs - System.nanoTime()))

    fun pollTimeout(): Duration = minOf(POLL_REQUEST_TIMEOUT, remaining())

    fun sleepDuration(): Duration = minOf(POLL_INTERVAL, remaining())
}

@JsonIgnoreProperties(ignoreUnknown = true)
private data class PollBody(val status: String, val result: PollResult? = null)

@JsonIgnoreProperties(ignoreUnknown = true)
private data class PollResult(val success: JsonNode? = null, val error: PollError? = null)

@JsonIgnoreProperties(ignoreUnknown = true)
private data class PollError(@JsonProperty("status_code") val statusCode: Int, val detail: JsonNode)
