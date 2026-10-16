package com.turbopuffer.core.http

import com.turbopuffer.errors.TurbopufferIoException
import com.turbopuffer.errors.TurbopufferServiceException
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.URLEncoder
import java.net.UnknownHostException
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicBoolean
import java.util.logging.Level
import java.util.logging.Logger
import javax.net.ssl.SSLHandshakeException
import javax.net.ssl.SSLPeerUnverifiedException

/**
 * Drives one request's [RequestScope] through its attempts. It only exists for observed requests,
 * so unobserved ones do no extra work.
 */
internal class RequestObservation
private constructor(private val scope: RequestScope, start: Long) {

    private val finished = AtomicBoolean()
    @Volatile private var attempt = 0
    @Volatile private var trace = AttemptTrace(start)
    @Volatile private var request: HttpRequest? = null
    @Volatile private var response: HttpResponse? = null
    @Volatile private var bodyError: Throwable? = null

    /** The current attempt's timings, to which custom code may add marks. */
    val timings: Timings
        get() = trace.timings

    /** Returns the request to send as [attempt], after letting the scope change it. */
    fun attemptBegin(attempt: Int, request: HttpRequest): HttpRequest {
        if (attempt > 0) {
            this.attempt = attempt
            trace = AttemptTrace(System.nanoTime())
        } else {
            request.body?.let { body ->
                // Bodies encode lazily, so encode up front to time it. Failures surface when sent.
                timings.serializeStart = System.nanoTime()
                runCatching { body.contentLength() }
                timings.serializeEnd = System.nanoTime()
            }
        }
        timings.requestReady = System.nanoTime()

        var builder = request.toBuilder()
        if (!call { scope.attemptBegin(attempt, builder) }) {
            builder = request.toBuilder()
        }
        val attemptRequest = builder.trace(trace).build()
        this.request = attemptRequest
        return attemptRequest
    }

    /** Reports the outcome of the current attempt. */
    fun attemptEnd(response: HttpResponse?, error: Throwable?) {
        if (finished.get()) {
            return
        }
        val trace = trace
        this.response = response
        val result =
            AttemptResult(
                attempt = attempt,
                request = request!!,
                response = response,
                error = error,
                errorKind = error?.let { errorKind(it, trace.phase()) },
                reachedServer =
                    when {
                        response != null -> true
                        error != null && neverReachedServer(error, trace.phase()) -> false
                        else -> null
                    },
                timings = trace.timings,
            )
        call { scope.attemptEnd(result) }
    }

    /**
     * Returns [response] as the one the request ends with, carrying this observation to where it's
     * parsed. Custom code that replaces a response passes the replacement here.
     */
    fun respond(response: HttpResponse): HttpResponse {
        val delegate = if (response is ObservedHttpResponse) response.delegate else response
        this.response = delegate
        return ObservedHttpResponse(delegate, this)
    }

    /**
     * Marks the response body as read, unless custom code that replaced the response already did.
     */
    fun bodyRead() {
        if (timings.bodyEnd == null) {
            timings.bodyEnd = System.nanoTime()
        }
    }

    /** Ends the request with [error], unless it already finished. */
    fun fail(error: Throwable) = finish(error, null)

    /** Parses [response] with [parse], finishing the request. */
    fun <T> parse(response: ObservedHttpResponse, parse: () -> T): T {
        if (finished.get()) {
            return parse()
        }
        timings.deserializeStart = System.nanoTime()
        response.buffering = true
        val parsed =
            try {
                parse()
            } catch (e: Throwable) {
                finish(e, null)
                throw e
            }
        finish(null, parsed)
        return parsed
    }

    /** Called when reading the response body to parse it failed. */
    fun bodyFailed(error: Throwable) {
        bodyError = error
    }

    private fun finish(error: Throwable?, parsed: Any?) {
        if (!finished.compareAndSet(false, true)) {
            return
        }
        val trace = trace
        val timings = trace.timings
        val errorResponse = error != null && unwrap(error) is TurbopufferServiceException
        // An error response's body was read to build its error.
        if (errorResponse) {
            bodyRead()
        }
        timings.deserializeStart?.let { deserializeStart ->
            val deserializeEnd = System.nanoTime()
            timings.deserializeEnd = deserializeEnd
            // Parsing starts once the body is read, even when a handler closes it unread.
            timings.bodyEnd?.let {
                timings.deserializeStart = maxOf(deserializeStart, minOf(it, deserializeEnd))
            }
        }
        val bodyError = bodyError
        val errorKind =
            when {
                error == null -> null
                // An error response, which the response describes.
                errorResponse -> null
                bodyError != null -> errorKind(bodyError, Phase.READ)
                // The body couldn't be parsed.
                timings.deserializeStart != null -> ErrorKind.OTHER
                // Failing after a response arrived, such as while polling for a result, isn't a
                // read error.
                response != null -> errorKind(error, Phase.UNKNOWN)
                else -> errorKind(error, trace.phase())
            }
        val result =
            RequestResult(
                retries = attempt,
                response = response,
                error = error,
                errorKind = errorKind,
                parsed = parsed,
                timings = timings,
            )
        call { scope.finish(result) }
    }

    companion object {

        private val logger = Logger.getLogger(RequestObservation::class.java.name)

        /** Starts observing [request], or returns null if [observer] doesn't observe it. */
        @JvmSynthetic
        internal fun start(observer: RequestObserver?, request: HttpRequest): RequestObservation? {
            if (observer == null) {
                return null
            }
            val start = System.nanoTime()
            val info = RequestInfo(request.method, observedUrl(request))
            var scope: RequestScope? = null
            call { scope = observer.start(info) }
            return scope?.let { RequestObservation(it, start) }
        }

        /** Calls [block], logging anything it throws. Returns whether it succeeded. */
        private inline fun call(block: () -> Unit): Boolean =
            try {
                block()
                true
            } catch (e: Exception) {
                logger.log(Level.WARNING, "Request observer threw an exception", e)
                false
            }
    }
}

/** Returns the observation of the request behind this response, or null if it isn't observed. */
@JvmSynthetic
internal fun HttpResponse.observation(): RequestObservation? =
    (this as? ObservedHttpResponse)?.observation

/** Parses this response with [parse], finishing the observation of the request behind it. */
@JvmSynthetic
internal fun <T> HttpResponse.observedParse(parse: () -> T): T {
    val response = this as? ObservedHttpResponse ?: return parse()
    return response.observation.parse(response, parse)
}

/** A response that carries the observation of its request to where it's parsed. */
internal class ObservedHttpResponse(
    val delegate: HttpResponse,
    val observation: RequestObservation,
) : HttpResponse {

    /** Set while parsing, to read the body in full first so reading and parsing are timed apart. */
    @Volatile var buffering = false
    private var bytes: ByteArray? = null

    override fun statusCode(): Int = delegate.statusCode()

    override fun headers(): Headers = delegate.headers()

    override fun body(): InputStream {
        if (!buffering) {
            return delegate.body()
        }
        val bytes =
            bytes
                ?: try {
                    delegate.body().use { it.readBytes() }
                } catch (e: Throwable) {
                    observation.bodyFailed(e)
                    throw e
                }
        if (this.bytes == null) {
            this.bytes = bytes
            observation.bodyRead()
            observation.timings.deserializeStart = System.nanoTime()
        }
        return ByteArrayInputStream(bytes)
    }

    override fun close() = delegate.close()
}

/**
 * Records the progress of one attempt from HTTP client events. HTTP clients find it on the request
 * they send with [HttpRequest.trace].
 */
internal class AttemptTrace(attemptStart: Long) {

    val timings = Timings().apply { this.attemptStart = attemptStart }

    @Volatile private var started = false
    @Volatile private var dialing = false
    @Volatile private var connected = false
    @Volatile private var connectEnded = false
    @Volatile private var responded = false

    fun callStart() {
        started = true
    }

    /** Called when opening a connection starts, from DNS lookup on. */
    fun connectStart() {
        if (connected) {
            return
        }
        dialing = true
        if (timings.connectStart == null) {
            timings.connectStart = System.nanoTime()
        }
    }

    /** Called when a new connection is ready, including its TLS handshake. */
    fun connectEnd() {
        if (connected) {
            return
        }
        connectEnded = true
        timings.connectEnd = System.nanoTime()
    }

    fun connectionAcquired() {
        connected = true
        val reused = !connectEnded
        timings.reused = reused
        if (reused) {
            timings.connectStart = null
            timings.connectEnd = null
        }
    }

    fun sendStart() {
        timings.sendStart = System.nanoTime()
    }

    fun sendEnd() {
        timings.sendEnd = System.nanoTime()
    }

    fun responseHeaders() {
        responded = true
        timings.responseHeaders = System.nanoTime()
    }

    /** Called when the response body was fully read, unless custom code already marked it. */
    fun responseBodyEnd() {
        if (timings.bodyEnd == null) {
            timings.bodyEnd = System.nanoTime()
        }
    }

    /** How far the attempt got. */
    fun phase(): Phase =
        when {
            responded -> Phase.READ
            // The HTTP client doesn't report events.
            !started -> Phase.UNKNOWN
            !connected && dialing -> Phase.CONNECT
            !connected -> Phase.POOL
            timings.sendEnd == null -> Phase.WRITE
            else -> Phase.READ
        }
}

internal enum class Phase {
    UNKNOWN,
    POOL,
    CONNECT,
    WRITE,
    READ,
}

/** The path the request was made with, or its full URL when it has no path segments. */
private fun observedUrl(request: HttpRequest): String {
    val path =
        if (request.pathSegments.isEmpty()) request.baseUrl
        else request.pathSegments.joinToString("/", prefix = "/") { URLEncoder.encode(it, "UTF-8") }
    return request.pathQuery?.let { "$path?$it" } ?: path
}

private fun errorKind(error: Throwable, phase: Phase): ErrorKind {
    val cause = unwrap(error)
    if (isCanceled(cause)) {
        return ErrorKind.CANCELED
    }
    val timeout = cause is InterruptedIOException || cause is TimeoutException
    val actualPhase = if (isConnectError(cause)) Phase.CONNECT else phase
    return when {
        actualPhase == Phase.POOL && timeout -> ErrorKind.POOL_TIMEOUT
        actualPhase == Phase.CONNECT && timeout -> ErrorKind.CONNECT_TIMEOUT
        actualPhase == Phase.CONNECT -> ErrorKind.CONNECT_ERROR
        actualPhase == Phase.WRITE && timeout -> ErrorKind.WRITE_TIMEOUT
        actualPhase == Phase.READ && timeout -> ErrorKind.READ_TIMEOUT
        actualPhase == Phase.READ && cause is IOException -> ErrorKind.READ_ERROR
        timeout -> ErrorKind.TIMEOUT
        else -> ErrorKind.OTHER
    }
}

private fun neverReachedServer(error: Throwable, phase: Phase): Boolean =
    phase == Phase.POOL || phase == Phase.CONNECT || isConnectError(unwrap(error))

/** The client's own I/O errors wrap the error that caused them, as do futures. */
private fun unwrap(error: Throwable): Throwable {
    var cause = error
    while (
        (cause is TurbopufferIoException ||
            cause is CompletionException ||
            cause is ExecutionException) && cause.cause != null
    ) {
        cause = cause.cause!!
    }
    return cause
}

private fun isCanceled(error: Throwable): Boolean =
    error is CancellationException ||
        error is InterruptedException ||
        // I/O on an interrupted thread fails with a plain InterruptedIOException.
        (error is InterruptedIOException &&
            error !is SocketTimeoutException &&
            Thread.currentThread().isInterrupted)

private fun isConnectError(error: Throwable): Boolean =
    error is ConnectException ||
        error is UnknownHostException ||
        error is NoRouteToHostException ||
        error is SSLHandshakeException ||
        error is SSLPeerUnverifiedException
