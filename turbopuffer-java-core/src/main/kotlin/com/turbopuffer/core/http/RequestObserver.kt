package com.turbopuffer.core.http

import java.util.concurrent.ConcurrentHashMap

/**
 * Observes the requests a client makes, such as to record their timings. Custom code installs one
 * with `ClientOptions.Builder.requestObserver`.
 *
 * Observers are called synchronously at fixed points of each request, so they must be cheap.
 * Anything they throw is logged and ignored, so they can never break a request. An observer is
 * shared by concurrent requests, so per request state belongs on the [RequestScope] it returns.
 */
internal fun interface RequestObserver {

    /**
     * Called once per request, before its first attempt. Returns a scope to observe the request, or
     * null to leave it unobserved.
     */
    fun start(info: RequestInfo): RequestScope?
}

/** Observes one request across its attempts. */
internal interface RequestScope {

    /** Called before each attempt is sent. May change the request's headers. */
    fun attemptBegin(attempt: Int, request: HttpRequest.Builder) {}

    /** Called after each attempt, before its response is closed. */
    fun attemptEnd(result: AttemptResult) {}

    /**
     * Called at most once, after the response is parsed or when the request fails for good.
     * Responses whose body the caller reads itself, such as raw or streamed ones, don't finish.
     */
    fun finish(result: RequestResult) {}
}

/** Describes a request as it starts. */
internal class RequestInfo(
    val method: HttpMethod,
    /**
     * The path the request was made with, such as `/v1/things/abc`, or its full URL when it has no
     * path segments. Includes a query that's part of the endpoint's path, but not query parameters
     * added from request params.
     */
    val url: String,
)

/** The outcome of one attempt of a request. */
internal class AttemptResult(
    /** The attempt's 0-based index. */
    val attempt: Int,
    val request: HttpRequest,
    val response: HttpResponse?,
    /** Set when the attempt failed without a response. */
    val error: Throwable?,
    val errorKind: ErrorKind?,
    /**
     * False when the attempt certainly never reached the server, true when a response arrived, and
     * null when unknown.
     */
    val reachedServer: Boolean?,
    val timings: Timings,
)

/** The final outcome of a request. */
internal class RequestResult(
    /** The number of retries made, which is also the final attempt's index. */
    val retries: Int,
    /** The response the request ended with, if any. */
    val response: HttpResponse?,
    /**
     * The error the request failed with. For an error response it's the API error, which has no
     * [errorKind].
     */
    val error: Throwable?,
    val errorKind: ErrorKind?,
    /** The parsed response body, or null if it wasn't parsed. */
    val parsed: Any?,
    /** The final attempt's timings. */
    val timings: Timings,
)

/** Classifies why an attempt or request failed. */
internal enum class ErrorKind(val value: String) {
    POOL_TIMEOUT("pool_timeout"),
    CONNECT_TIMEOUT("connect_timeout"),
    CONNECT_ERROR("connect_error"),
    WRITE_TIMEOUT("write_timeout"),
    READ_TIMEOUT("read_timeout"),
    READ_ERROR("read_error"),
    /** Any other timeout. */
    TIMEOUT("timeout"),
    /** The caller canceled the request or interrupted its thread. */
    CANCELED("canceled"),
    OTHER("other"),
}

/**
 * Marks the progress of one attempt with readings from [System.nanoTime]. A mark stays null when
 * its phase didn't happen or couldn't be observed. Phases may overlap.
 */
internal class Timings {
    /** The attempt began, before the request was built. */
    @Volatile var attemptBegin: Long? = null
    /** Encoding the request body, which happens once before the first attempt. */
    @Volatile var serializeBegin: Long? = null
    @Volatile var serializeEnd: Long? = null
    /** The request was built and handed to the HTTP client. */
    @Volatile var requestReady: Long? = null
    /** Opening a new connection: DNS, TCP and TLS. Null when a connection was reused. */
    @Volatile var connectBegin: Long? = null
    @Volatile var connectEnd: Long? = null
    /** Writing the request headers and body. */
    @Volatile var sendBegin: Long? = null
    @Volatile var sendEnd: Long? = null
    /** The response headers were received. */
    @Volatile var responseHeaders: Long? = null
    /** The response body was fully read. */
    @Volatile var bodyEnd: Long? = null
    /** Parsing the response body. Only on the final attempt. */
    @Volatile var deserializeBegin: Long? = null
    @Volatile var deserializeEnd: Long? = null
    /** Whether the attempt used an existing connection, or null when unknown. */
    @Volatile var reused: Boolean? = null
    /** Marks added by custom code, such as HTTP clients that compress request bodies. */
    val extra: MutableMap<String, Long> = ConcurrentHashMap()

    /** Records the current time in [extra] under [name]. */
    fun mark(name: String) {
        extra[name] = System.nanoTime()
    }
}
