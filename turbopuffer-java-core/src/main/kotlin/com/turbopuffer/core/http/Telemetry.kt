package com.turbopuffer.core.http

import com.turbopuffer.core.jsonMapper
import com.turbopuffer.models.namespaces.NamespaceBranchFromResponse
import com.turbopuffer.models.namespaces.NamespaceCopyFromResponse
import com.turbopuffer.models.namespaces.NamespaceMultiQueryResponse
import com.turbopuffer.models.namespaces.NamespaceQueryResponse
import com.turbopuffer.models.namespaces.NamespaceWriteResponse
import com.turbopuffer.models.namespaces.QueryPerformance
import com.turbopuffer.models.namespaces.WritePerformance
import java.lang.ref.WeakReference
import java.net.URI
import java.util.concurrent.ThreadLocalRandom
import java.util.logging.Logger
import kotlin.jvm.optionals.getOrNull

// Client telemetry reported to turbopuffer on subsequent requests.
//
// When enabled, the client buffers a small timing record for each request and attaches buffered
// records to a later request in the `X-turbopuffer-Client-Telemetry` header. The server controls
// how many requests are recorded by advertising a sample rate in the
// `X-turbopuffer-Client-Telemetry-Sample-Rate` response header.

internal const val TELEMETRY_ENV_VAR = "TURBOPUFFER_TELEMETRY"
internal const val TELEMETRY_HEADER = "X-turbopuffer-Client-Telemetry"
internal const val SAMPLE_RATE_HEADER = "X-turbopuffer-Client-Telemetry-Sample-Rate"

private const val TELEMETRY_VERSION = 1

// Keeps the header well under the 8 KB per-line limit of common proxies.
internal const val MAX_RECORDS_PER_HEADER = 20
internal const val MAX_BUFFERED_RECORDS = 1000

private val TRUE_VALUES = setOf("1", "true", "yes", "on")
private val FALSE_VALUES = setOf("", "0", "false", "no", "off")

private val NAMESPACE_PATTERN = Regex("^(/v\\d+/namespaces/)[^/?]+")
private val OPERATION_PATTERN = Regex("(/operations/)[^/?]+")

private val logger = Logger.getLogger("com.turbopuffer.core.http.Telemetry")

/** Resolves whether telemetry is enabled, preferring an explicit value over the environment. */
@JvmSynthetic
internal fun resolveTelemetryEnabled(
    value: Boolean?,
    getenv: (String) -> String? = System::getenv,
): Boolean {
    if (value != null) {
        return value
    }
    val raw = getenv(TELEMETRY_ENV_VAR) ?: ""
    val env = raw.trim().lowercase()
    if (env in TRUE_VALUES) {
        return true
    }
    if (env !in FALSE_VALUES) {
        logger.warning("Ignoring invalid $TELEMETRY_ENV_VAR=\"$raw\", expected 1 or 0")
    }
    return false
}

/** Returns the method and path of a request with identifiers like the namespace replaced. */
@JvmSynthetic
internal fun routeTemplate(method: String, url: String): String {
    var path = url
    if ("://" in path) {
        path =
            try {
                val uri = URI(path)
                uri.rawPath.ifEmpty { "/" } + (uri.rawQuery?.let { "?$it" } ?: "")
            } catch (e: Exception) {
                path
            }
    }
    path = NAMESPACE_PATTERN.replaceFirst(path, "$1{ns}")
    path = OPERATION_PATTERN.replace(path, "$1{token}")
    return "${method.uppercase()} $path"
}

/** Returns the duration in nanoseconds of each client-side phase of an attempt ending at [end]. */
@JvmSynthetic
internal fun computeDurations(timings: Timings, end: Long): Map<String, Long> {
    val durations = linkedMapOf<String, Long>()
    val attemptStart = timings.attemptStart ?: return durations
    durations["total"] = end - attemptStart

    val serializeStart = timings.serializeStart
    val serializeEnd = timings.serializeEnd
    if (serializeStart != null && serializeEnd != null) {
        durations["serialize"] = serializeEnd - serializeStart
    }

    // Set by HTTP clients that compress request bodies.
    val compressStart = timings.extra["compress_start"]
    val compressEnd = timings.extra["compress_end"]
    if (compressStart != null && compressEnd != null) {
        durations["compress"] = compressEnd - compressStart
    }

    // Waiting for a free connection, until connecting a new one or sending on a reused one.
    val poolStart = compressEnd ?: timings.requestReady
    val connectionReady = timings.connectStart ?: timings.sendStart
    if (poolStart != null && connectionReady != null) {
        durations["pool"] = maxOf(connectionReady - poolStart, 0)
    }

    val connectStart = timings.connectStart
    val connectEnd = timings.connectEnd
    if (connectStart != null && connectEnd != null) {
        durations["connect"] = connectEnd - connectStart
    }

    val sendStart = timings.sendStart
    val sendEnd = timings.sendEnd
    if (sendStart != null && sendEnd != null) {
        durations["send"] = sendEnd - sendStart
    }

    // Covers the network round trip and the server.
    val responseHeaders = timings.responseHeaders
    if (sendEnd != null && responseHeaders != null) {
        durations["wait"] = maxOf(responseHeaders - sendEnd, 0)
    }

    val bodyEnd = timings.bodyEnd
    if (bodyEnd != null && responseHeaders != null) {
        durations["body_read"] = bodyEnd - responseHeaders
    }

    val deserializeStart = timings.deserializeStart
    val deserializeEnd = timings.deserializeEnd
    if (deserializeStart != null && deserializeEnd != null) {
        durations["deserialize"] = deserializeEnd - deserializeStart
    }

    return durations
}

/** Records taken from a buffer, encoded as a header value. */
internal class TelemetryBatch(val records: List<Pair<Long, Map<String, Any>>>, val dropped: Long) {

    val header: String = run {
        val now = System.nanoTime()
        val envelope =
            linkedMapOf<String, Any>(
                "version" to TELEMETRY_VERSION,
                "records" to
                    records.map { (recordedAt, record) ->
                        LinkedHashMap(record).apply {
                            put("age_ms", Math.round((now - recordedAt) / 1e6))
                        }
                    },
            )
        if (dropped > 0) {
            envelope["dropped"] = dropped
        }
        jsonMapper().writeValueAsString(envelope)
    }
}

/** Buffers per-request telemetry records until a later request can carry them. */
internal class TelemetryBuffer(
    private val random: () -> Double = { ThreadLocalRandom.current().nextDouble() }
) {

    private val records = ArrayDeque<Pair<Long, Map<String, Any>>>()
    private var dropped = 0L

    /** Used until the server advertises a rate. */
    @Volatile
    var sampleRate = 1.0
        private set

    /** Adopts the sample rate advertised by the server, ignoring invalid values. */
    fun observeResponse(headers: Headers) {
        val rate =
            headers.values(SAMPLE_RATE_HEADER).firstOrNull()?.trim()?.toDoubleOrNull() ?: return
        // Also rejects NaN, since every comparison with NaN is false.
        if (rate >= 0.0 && rate <= 1.0) {
            sampleRate = rate
        }
    }

    /** Samples and buffers a record for one request. [durations] are in nanoseconds. */
    fun record(
        method: String,
        url: String,
        status: Int,
        retries: Int,
        durations: Map<String, Long>,
        serverTotalMs: Double? = null,
        error: String? = null,
        reused: Boolean? = null,
    ) {
        val rate = sampleRate
        if (rate <= 0.0 || (rate < 1.0 && random() >= rate)) {
            return
        }

        val record =
            linkedMapOf<String, Any>("route" to routeTemplate(method, url), "status" to status)
        error?.let { record["error"] = it }
        if (retries != 0) {
            record["retries"] = retries
        }
        if (rate < 1.0) {
            record["sample_rate"] = rate
        }
        for ((name, duration) in durations) {
            // A zero compress duration means the body wasn't compressed.
            if (name == "compress" && duration == 0L) {
                continue
            }
            record["${name}_us"] = Math.floorDiv(duration, 1000L)
        }
        serverTotalMs?.let { record["server_total_us"] = Math.round(it * 1000) }
        reused?.let { record["reused"] = it }

        synchronized(this) {
            if (records.size >= MAX_BUFFERED_RECORDS) {
                records.removeFirst()
                dropped++
            }
            records.addLast(System.nanoTime() to record)
        }
    }

    /** Removes up to [MAX_RECORDS_PER_HEADER] of the oldest records. */
    fun take(): TelemetryBatch? {
        val records: List<Pair<Long, Map<String, Any>>>
        val dropped: Long
        synchronized(this) {
            if (this.records.isEmpty()) {
                return null
            }
            records =
                List(minOf(this.records.size, MAX_RECORDS_PER_HEADER)) {
                    this.records.removeFirst()
                }
            dropped = this.dropped
            this.dropped = 0
        }
        return TelemetryBatch(records, dropped)
    }

    /** Returns a batch that never reached the server to the front of the buffer. */
    fun restore(batch: TelemetryBatch) {
        synchronized(this) {
            dropped += batch.dropped
            for (record in batch.records.asReversed()) {
                // The batch holds the oldest records, so they're the ones to drop when full.
                if (records.size >= MAX_BUFFERED_RECORDS) {
                    dropped++
                    continue
                }
                records.addFirst(record)
            }
        }
    }
}

private val sharedBuffers = HashMap<Pair<String, String>, WeakReference<TelemetryBuffer>>()

/**
 * Returns the buffer shared by clients with the same API key and base URL.
 *
 * Sharing lets records ride on any client's requests, including copies, but never to another org or
 * region.
 */
@JvmSynthetic
internal fun telemetryBuffer(apiKey: String, baseUrl: String): TelemetryBuffer =
    synchronized(sharedBuffers) {
        sharedBuffers.values.removeIf { it.get() == null }
        val key = apiKey to baseUrl
        sharedBuffers[key]?.get()
            ?: TelemetryBuffer().also { sharedBuffers[key] = WeakReference(it) }
    }

/** Records telemetry for each request and sends buffered records on later requests. */
internal class TelemetryObserver(private val buffer: TelemetryBuffer) : RequestObserver {

    override fun start(info: RequestInfo): RequestScope = TelemetryScope(buffer, info)
}

private class TelemetryScope(private val buffer: TelemetryBuffer, private val info: RequestInfo) :
    RequestScope {

    // Kept for later attempts until one of them may have reached the server.
    @Volatile private var batch: TelemetryBatch? = null

    override fun attemptBegin(attempt: Int, request: HttpRequest.Builder) {
        // Taken only once a request is about to be sent, so one that fails before then can't lose
        // it.
        if (attempt == 0) {
            batch = buffer.take()
        }
        batch?.let { request.replaceHeaders(TELEMETRY_HEADER, it.header) }
    }

    override fun attemptEnd(result: AttemptResult) {
        if (result.reachedServer != false) {
            batch = null
        }
        result.response?.let { buffer.observeResponse(it.headers()) }
    }

    override fun finish(result: RequestResult) {
        // A batch that never reached the server goes back for a later request.
        batch?.let {
            buffer.restore(it)
            batch = null
        }

        val timings = result.timings
        val error =
            when (val kind = result.errorKind) {
                null -> null
                ErrorKind.CANCELED -> "canceled"
                ErrorKind.OTHER -> "other"
                else -> if (kind.value.endsWith("timeout")) "timeout" else "connect"
            }
        buffer.record(
            method = info.method.name,
            url = info.url,
            status = result.response?.statusCode() ?: 0,
            retries = result.retries,
            durations = computeDurations(timings, timings.deserializeEnd ?: System.nanoTime()),
            serverTotalMs = serverTotalMs(result.parsed),
            error = error,
            reused = timings.reused,
        )
    }
}

private fun serverTotalMs(parsed: Any?): Double? {
    val performance =
        when (parsed) {
            is NamespaceQueryResponse -> parsed._performance().asKnown().getOrNull()
            is NamespaceMultiQueryResponse -> parsed._performance().asKnown().getOrNull()
            is NamespaceWriteResponse -> parsed._performance().asKnown().getOrNull()
            is NamespaceCopyFromResponse -> parsed._performance().asKnown().getOrNull()
            is NamespaceBranchFromResponse -> parsed._performance().asKnown().getOrNull()
            else -> null
        }
    val serverTotalMs =
        when (performance) {
            is QueryPerformance -> performance._serverTotalMs().asKnown().getOrNull()
            is WritePerformance -> performance._serverTotalMs().asKnown().getOrNull()
            else -> null
        }
    return serverTotalMs?.toDouble()
}
