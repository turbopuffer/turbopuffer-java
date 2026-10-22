package com.turbopuffer.core.http

import com.fasterxml.jackson.databind.JsonNode
import com.github.tomakehurst.wiremock.client.WireMock.anyRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.resetAllScenarios
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.github.tomakehurst.wiremock.verification.LoggedRequest
import com.turbopuffer.client.TurbopufferClient
import com.turbopuffer.client.TurbopufferClientAsyncImpl
import com.turbopuffer.client.TurbopufferClientImpl
import com.turbopuffer.client.okhttp.OkHttpClient
import com.turbopuffer.core.ClientOptions
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.Sleeper
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.NotFoundException
import com.turbopuffer.errors.TurbopufferException
import com.turbopuffer.errors.TurbopufferIoException
import com.turbopuffer.errors.UnprocessableEntityException
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.Query
import java.net.ConnectException
import java.time.Duration
import java.util.Collections
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.logging.Handler
import java.util.logging.LogRecord
import java.util.logging.Logger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

private const val QUERY_PATH = "/v2/namespaces/my-ns/query"
private const val QUERY_ROUTE = "POST /v2/namespaces/{ns}/query"

private val QUERY_RESPONSE =
    """
    {
      "rows": [],
      "performance": {
        "approx_namespace_size": 1,
        "cache_hit_ratio": 1.0,
        "cache_temperature": "hot",
        "exhaustive_search_count": 0,
        "query_execution_ms": 5,
        "server_total_ms": 7
      }
    }
    """
        .trimIndent()

private fun takePayload(buffer: TelemetryBuffer): JsonNode =
    jsonMapper().readTree(buffer.take()!!.header)

private fun addRecord(buffer: TelemetryBuffer, status: Int = 200, rate: Double = 1.0) =
    buffer.record(
        method = "post",
        url = QUERY_PATH,
        status = status,
        retries = 0,
        durations = mapOf("total" to 5_000_000L),
        rate = rate,
    )

/** The millisecond time and random bytes of a generated request ID, checking its format. */
private fun decodeRequestId(id: String): Pair<Long, List<Byte>> {
    assertThat(id).startsWith(REQUEST_ID_PREFIX)
    val encoded = id.removePrefix(REQUEST_ID_PREFIX)
    assertThat(encoded).describedAs(id).hasSize((REQUEST_ID_BYTES * 8 + 4) / 5)
    val bytes = mutableListOf<Byte>()
    var buffer = 0
    var bits = 0
    for (c in encoded) {
        val value = REQUEST_ID_ALPHABET.indexOf(c)
        assertThat(value).describedAs(id).isNotNegative()
        buffer = (buffer shl 5) or value
        bits += 5
        if (bits >= 8) {
            bits -= 8
            bytes.add((buffer ushr bits).toByte())
            buffer = buffer and ((1 shl bits) - 1)
        }
    }
    assertThat(bytes.size to buffer).describedAs(id).isEqualTo(REQUEST_ID_BYTES to 0)
    var millis = 0L
    for (i in REQUEST_ID_RANDOM_BYTES until REQUEST_ID_BYTES) {
        val byte = bytes[i].toInt() xor bytes[i - REQUEST_ID_RANDOM_BYTES].toInt()
        millis = (millis shl 8) or (byte and 0xff).toLong()
    }
    return millis to bytes.subList(0, REQUEST_ID_RANDOM_BYTES)
}

private fun hexBytes(hex: String): List<Byte> = hex.chunked(2).map { it.toInt(16).toByte() }

private fun timings(extra: Map<String, Long> = emptyMap(), init: Timings.() -> Unit): Timings =
    Timings().apply {
        this.extra.putAll(extra)
        init()
    }

internal class TelemetryTest {

    @Test
    fun disabledByDefault() {
        assertThat(resolveTelemetryEnabled(null) { null }).isFalse()
    }

    @ParameterizedTest
    @CsvSource(
        "1,true",
        "true,true",
        "' ON ',true",
        "yes,true",
        "0,false",
        "false,false",
        "'',false",
    )
    fun envVar(value: String, expected: Boolean) {
        assertThat(resolveTelemetryEnabled(null) { if (it == TELEMETRY_ENV_VAR) value else null })
            .isEqualTo(expected)
    }

    @Test
    fun invalidEnvVarWarnsAndDisables() {
        val warnings = Collections.synchronizedList(mutableListOf<LogRecord>())
        val handler =
            object : Handler() {
                override fun publish(record: LogRecord) {
                    warnings.add(record)
                }

                override fun flush() {}

                override fun close() {}
            }
        val logger = Logger.getLogger("com.turbopuffer.core.http.Telemetry")
        logger.addHandler(handler)
        try {
            assertThat(resolveTelemetryEnabled(null) { "sometimes" }).isFalse()
        } finally {
            logger.removeHandler(handler)
        }
        // Other tests may log concurrently, so only look for this one's warning.
        assertThat(warnings.map { it.message }).anySatisfy {
            assertThat(it).contains(TELEMETRY_ENV_VAR).contains("sometimes")
        }
    }

    @Test
    fun explicitValueBeatsEnvVar() {
        assertThat(resolveTelemetryEnabled(false) { "1" }).isFalse()
        assertThat(resolveTelemetryEnabled(true) { "0" }).isTrue()
    }

    @ParameterizedTest
    @CsvSource(
        "post,/v2/namespaces/my-ns/query,POST /v2/namespaces/{ns}/query",
        "post,/v2/namespaces/my-ns/query?stainless_overload=multiQuery,POST /v2/namespaces/{ns}/query?stainless_overload=multiQuery",
        "post,/v2/namespaces/my-ns?stainless_overload=copyFrom,POST /v2/namespaces/{ns}?stainless_overload=copyFrom",
        "post,/v2/namespaces/my%2Fns,POST /v2/namespaces/{ns}",
        "get,/v1/namespaces,GET /v1/namespaces",
        "get,/v1/namespaces/my-ns/operations/abc123?stainless_overload=pollCopyFrom,GET /v1/namespaces/{ns}/operations/{token}?stainless_overload=pollCopyFrom",
        "get,https://gcp-us-central1.turbopuffer.com/v1/namespaces/my-ns/metadata,GET /v1/namespaces/{ns}/metadata",
        "get,http://127.0.0.1:4010/v1/namespaces/my-ns/operations/op-abc,GET /v1/namespaces/{ns}/operations/{token}",
    )
    fun routeTemplate(method: String, url: String, expected: String) {
        assertThat(routeTemplate(method, url)).isEqualTo(expected)
    }

    @Test
    fun recordsAreTakenWhenTheFirstAttemptBegins() {
        val buffer = TelemetryBuffer()
        addRecord(buffer)
        val scope = TelemetryObserver(buffer).start(RequestInfo(HttpMethod.POST, QUERY_PATH))

        // A request that fails before it's sent never takes them.
        buffer.take()!!.also { buffer.restore(it) }

        val request = HttpRequest.builder().method(HttpMethod.POST).baseUrl("http://localhost")
        scope.attemptBegin(0, request)
        assertThat(request.build().headers.values(TELEMETRY_HEADER)).hasSize(1)
        assertThat(buffer.take()).isNull()
    }

    @Test
    fun durationsAreIntegerMicroseconds() {
        val buffer = TelemetryBuffer()
        buffer.record(
            method = "post",
            url = QUERY_PATH,
            status = 200,
            retries = 2,
            durations = mapOf("total" to 1_234_567L, "compress" to 0L, "deserialize" to 999L),
            rate = 1.0,
            serverTotalMs = 7.0,
        )

        val record = takePayload(buffer)["records"].single()
        assertThat(record["total_us"].isIntegralNumber).isTrue()
        assertThat(record["total_us"].asLong()).isEqualTo(1234)
        assertThat(record["deserialize_us"].asLong()).isEqualTo(0)
        assertThat(record["server_total_us"].asLong()).isEqualTo(7000)
        assertThat(record["retries"].asInt()).isEqualTo(2)
        // A zero compress duration means the body wasn't compressed.
        assertThat(record.has("compress_us")).isFalse()
    }

    @Test
    fun headerIsCompactJson() {
        val buffer = TelemetryBuffer()
        addRecord(buffer)

        val header = buffer.take()!!.header

        assertThat(header).startsWith("""{"version":1,"records":[{"route":"$QUERY_ROUTE",""")
        assertThat(header).doesNotContain(" {").doesNotContain(": ").doesNotContain("dropped")
        val record = jsonMapper().readTree(header)["records"].single()
        assertThat(record["age_ms"].isIntegralNumber).isTrue()
        assertThat(record["age_ms"].asLong()).isGreaterThanOrEqualTo(0)
    }

    @Test
    fun fullBufferDropsOldestRecords() {
        val buffer = TelemetryBuffer()
        for (status in 0 until MAX_BUFFERED_RECORDS + 5) {
            addRecord(buffer, status = status)
        }

        val first = takePayload(buffer)
        assertThat(first["dropped"].asInt()).isEqualTo(5)
        assertThat(first["records"].size()).isEqualTo(MAX_RECORDS_PER_HEADER)
        assertThat(first["records"][0]["status"].asInt()).isEqualTo(5)

        val second = takePayload(buffer)
        assertThat(second.has("dropped")).isFalse()
        assertThat(second["records"][0]["status"].asInt()).isEqualTo(5 + MAX_RECORDS_PER_HEADER)
    }

    @Test
    fun restorePutsRecordsBackInOrder() {
        val buffer = TelemetryBuffer()
        for (status in 0 until 3) {
            addRecord(buffer, status = status)
        }
        val batch = buffer.take()!!

        addRecord(buffer, status = 99)
        buffer.restore(batch)

        assertThat(takePayload(buffer)["records"].map { it["status"].asInt() })
            .containsExactly(0, 1, 2, 99)
    }

    @Test
    fun restoreIntoFullBufferCountsDropped() {
        val buffer = TelemetryBuffer()
        for (status in 0 until MAX_BUFFERED_RECORDS) {
            addRecord(buffer, status = status)
        }
        val batch = buffer.take()!!
        repeat(MAX_RECORDS_PER_HEADER) { addRecord(buffer) }

        buffer.restore(batch)

        assertThat(takePayload(buffer)["dropped"].asInt()).isEqualTo(MAX_RECORDS_PER_HEADER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1.5", "-0.1", "NaN", ""])
    fun invalidSampleRateIsIgnored(value: String) {
        val buffer = TelemetryBuffer()
        buffer.observeResponse(Headers.builder().put(SAMPLE_RATE_HEADER, "0.5").build())
        buffer.observeResponse(Headers.builder().put(SAMPLE_RATE_HEADER, value).build())
        assertThat(buffer.sampleRate).isEqualTo(0.5)
    }

    @Test
    fun sampleRateIsApplied() {
        var random = 0.2
        val buffer = TelemetryBuffer { random }
        buffer.observeResponse(Headers.builder().put(SAMPLE_RATE_HEADER, "0.25").build())

        assertThat(buffer.sample()).isEqualTo(0.25)
        addRecord(buffer, rate = 0.25)
        random = 0.3
        assertThat(buffer.sample()).isNull()

        val record = takePayload(buffer)["records"].single()
        assertThat(record["sample_rate"].asDouble()).isEqualTo(0.25)

        buffer.observeResponse(Headers.builder().put(SAMPLE_RATE_HEADER, "0").build())
        random = 0.0
        assertThat(buffer.sample()).isNull()

        // A full rate isn't reported.
        buffer.observeResponse(Headers.builder().put(SAMPLE_RATE_HEADER, "1").build())
        assertThat(buffer.sample()).isEqualTo(1.0)
        addRecord(buffer)
        assertThat(takePayload(buffer)["records"].single().has("sample_rate")).isFalse()
    }

    @Test
    fun base32MatchesKnownVectors() {
        // The vectors of riverpro's uuidbase32, which uses the same encoding.
        val vectors =
            mapOf(
                "00000000000000000000000000000000" to "22222222222222222222222222",
                "00000000000000000000000000000001" to "22222222222222222222222226",
                "0000000000000000000000000000000f" to "2222222222222222222222223w",
                "000000000000000000000000000000ff" to "222222222222222222222222zw",
                "ffffffffffffffffffffffffffffffff" to "zzzzzzzzzzzzzzzzzzzzzzzzzw",
            )
        for ((hex, encoded) in vectors) {
            assertThat(encodeBase32(hexBytes(hex).toByteArray())).isEqualTo(encoded)
        }

        // A request ID, generated by Python's base64 module independently of either implementation.
        val random = hexBytes("9f1c2e7a4b6d8e0f1a2b3c4d")
        val id = newRequestId(1_792_497_600_123L, random.toByteArray())
        assertThat(id).isEqualTo("tpreq_nwi4wymfhqb2yalfblatxjfremalg")
        assertThat(decodeRequestId(id)).isEqualTo(1_792_497_600_123L to random)
    }

    @Test
    fun generatedRequestIdsCarryTheirTime() {
        val (millis, random) = decodeRequestId(newRequestId(1_792_497_600_123L))
        assertThat(millis).isEqualTo(1_792_497_600_123L)
        val (_, other) = decodeRequestId(newRequestId(1_792_497_600_123L))
        assertThat(other).isNotEqualTo(random)

        val before = System.currentTimeMillis()
        val (now, _) = decodeRequestId(newRequestId())
        assertThat(now).isBetween(before, System.currentTimeMillis())
    }

    @Test
    fun computesDurations() {
        val newConnection =
            timings(extra = mapOf("compress_begin" to 60L, "compress_end" to 100L)) {
                attemptBegin = 0
                requestReady = 50
                connectBegin = 150
                connectEnd = 400
                sendBegin = 410
                sendEnd = 500
                responseHeaders = 900
            }
        assertThat(computeDurations(newConnection, 1000))
            .containsAllEntriesOf(
                mapOf(
                    "total" to 1000L,
                    "compress" to 40L,
                    "pool" to 50L,
                    "connect" to 250L,
                    "send" to 90L,
                    "wait" to 400L,
                )
            )

        val reusedConnection = timings {
            attemptBegin = 0
            requestReady = 100
            sendBegin = 130
            sendEnd = 160
            responseHeaders = 300
        }
        val durations = computeDurations(reusedConnection, 400)
        assertThat(durations).doesNotContainKey("connect")
        assertThat(durations["pool"]).isEqualTo(30)

        // Sending can finish after the response headers arrive.
        reusedConnection.sendEnd = 350
        assertThat(computeDurations(reusedConnection, 400)["wait"]).isEqualTo(0)

        // Untraced requests, such as through a custom HTTP client.
        assertThat(computeDurations(timings { attemptBegin = 0 }, 400))
            .isEqualTo(mapOf("total" to 400L))
    }
}

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TelemetryRequestsTest {

    private lateinit var baseUrl: String
    // Unique per test, so tests never share a buffer.
    private val apiKey = "tpuf_${UUID.randomUUID()}"
    // Buffers are shared through weak references, so this keeps the clients' buffer alive after
    // the clients are collected.
    private lateinit var buffer: TelemetryBuffer

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        buffer = telemetryBuffer(apiKey, baseUrl)
        resetAllScenarios()
    }

    @Test
    fun recordsRideOnNextRequest() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val ns = client().namespace("my-ns")

        ns.query(queryParams())
        ns.query(queryParams())

        val (first, second) = sentRecords()
        assertThat(first).isNull()
        val record = second!!.single()
        assertThat(record["route"].asText()).isEqualTo(QUERY_ROUTE)
        assertThat(record["status"].asInt()).isEqualTo(200)
        assertThat(record["server_total_us"].asLong()).isEqualTo(7000)
        for (key in listOf("total_us", "serialize_us", "deserialize_us", "age_ms")) {
            assertThat(record[key].isIntegralNumber).describedAs(key).isTrue()
            assertThat(record[key].asLong()).describedAs(key).isGreaterThanOrEqualTo(0)
        }
        assertThat(record["total_us"].asLong())
            .isGreaterThanOrEqualTo(
                record["serialize_us"].asLong() + record["deserialize_us"].asLong()
            )
        for (key in listOf("compress_us", "response_us", "retries", "error", "sample_rate")) {
            assertThat(record.has(key)).describedAs(key).isFalse()
        }
    }

    @Test
    fun routeKeepsOverloadQuery() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .willReturn(okJson("""{"results":[],"performance":{"server_total_ms":7}}"""))
        )
        val ns = client().namespace("my-ns")

        ns.multiQuery(
            NamespaceMultiQueryParams.builder().addQuery(Query.builder().topK(1L).build()).build()
        )

        val record = takePayload(buffer)["records"].single()
        assertThat(record["route"].asText())
            .isEqualTo("POST /v2/namespaces/{ns}/query?stainless_overload=multiQuery")
        assertThat(record["server_total_us"].asLong()).isEqualTo(7000)
    }

    @Test
    fun recordsConnectionPhases() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val ns = client().namespace("my-ns")

        ns.query(queryParams())
        val first = takePayload(buffer)["records"].single()
        ns.query(queryParams())
        val second = takePayload(buffer)["records"].single()

        assertThat(first["reused"].asBoolean()).isFalse()
        assertThat(first.has("connect_us")).isTrue()
        assertThat(second["reused"].asBoolean()).isTrue()
        assertThat(second.has("connect_us")).isFalse()
        for (record in listOf(first, second)) {
            for (key in listOf("pool_us", "send_us", "wait_us", "body_read_us")) {
                assertThat(record[key].isIntegralNumber).describedAs(key).isTrue()
                assertThat(record[key].asLong()).describedAs(key).isGreaterThanOrEqualTo(0)
            }
            assertThat(record["wait_us"].asLong() + record["body_read_us"].asLong())
                .isLessThanOrEqualTo(record["total_us"].asLong())
        }
    }

    @Test
    fun asyncClientRecords() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val ns = TurbopufferClientAsyncImpl(clientOptions()).namespace("my-ns")

        ns.query(queryParams()).get()
        ns.query(queryParams()).get()

        val (first, second) = sentRecords()
        assertThat(first).isNull()
        val record = second!!.single()
        assertThat(record["route"].asText()).isEqualTo(QUERY_ROUTE)
        assertThat(record["server_total_us"].asLong()).isEqualTo(7000)
        assertThat(record["reused"].asBoolean()).isFalse()
        assertThat(record["request_id"].asText()).isEqualTo(sentRequestIds()[0])
    }

    @Test
    fun disabledClientSendsNothing() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val ns = client(telemetry = false).namespace("my-ns")

        ns.query(queryParams())
        ns.query(queryParams())

        assertThat(sentRecords()).containsExactly(null, null)
        assertThat(sentRequestIds()).containsExactly(null, null)
    }

    @Test
    fun recordsRepeatRequestIds() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val ns = client().namespace("my-ns")

        ns.query(queryParams())
        ns.query(queryParams())

        val (first, second) = sentRequestIds()
        assertThat(first).isNotEqualTo(second)
        decodeRequestId(first!!)
        decodeRequestId(second!!)
        assertThat(sentRecords()[1]!!.single()["request_id"].asText()).isEqualTo(first)
    }

    @Test
    fun retriesKeepTheirRequestIds() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(status(503))
                .willSetStateTo("ok")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("retry")
                .whenScenarioStateIs("ok")
                .willReturn(okJson(QUERY_RESPONSE))
        )
        val ns = client(maxRetries = 1).namespace("my-ns")

        ns.query(queryParams())

        val (first, retried) = sentRequestIds()
        assertThat(first).isNotNull()
        assertThat(retried).isEqualTo(first)
        val record = takePayload(buffer)["records"].single()
        assertThat(record["request_id"].asText()).isEqualTo(first)
        assertThat(record["retries"].asInt()).isEqualTo(1)
    }

    @Test
    fun callerRequestIdsAreKept() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val options = clientOptions().toBuilder().putHeader("X-Request-Id", "my-request").build()

        TurbopufferClientImpl(options).namespace("my-ns").query(queryParams())

        assertThat(sentRequestIds()).containsExactly("my-request")
        assertThat(takePayload(buffer)["records"].single().has("request_id")).isFalse()
    }

    @Test
    fun copiesKeepSettingAndShareBuffer() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val options = clientOptions()
        assertThat(options.telemetry).isTrue()
        assertThat(options.toBuilder().build().telemetry).isTrue()
        assertThat(clientOptions(telemetry = false).toBuilder().build().telemetry).isFalse()

        val client = TurbopufferClientImpl(options)
        client.namespace("my-ns").query(queryParams())
        // Another org's client doesn't carry this one's records.
        client
            .withOptions { it.apiKey("tpuf_other_${UUID.randomUUID()}") }
            .namespace("my-ns")
            .query(queryParams())
        client.withOptions { it.telemetry(false) }.namespace("my-ns").query(queryParams())
        client.withOptions { it.maxRetries(1) }.namespace("my-ns").query(queryParams())

        val records = sentRecords()
        assertThat(records.subList(0, 3)).containsExactly(null, null, null)
        assertThat(records[3]!!.single()["route"].asText()).isEqualTo(QUERY_ROUTE)
    }

    @Test
    fun parseFailuresAreRecorded() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("parse failure")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(ok("not json").withHeader("Content-Type", "application/json"))
                .willSetStateTo("ok")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("parse failure")
                .whenScenarioStateIs("ok")
                .willReturn(okJson(QUERY_RESPONSE))
        )
        val ns = client().namespace("my-ns")

        assertThatThrownBy { ns.query(queryParams()) }
            .isInstanceOf(TurbopufferException::class.java)
        ns.query(queryParams())

        val record = sentRecords()[1]!!.single()
        assertThat(record["status"].asInt() to record["error"].asText()).isEqualTo(200 to "other")
    }

    @Test
    fun failuresAreRecorded() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("failures")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(okJson(QUERY_RESPONSE).withFixedDelay(2000))
                .willSetStateTo("bad request")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("failures")
                .whenScenarioStateIs("bad request")
                .willReturn(status(422).withBody("""{"error":"bad request"}"""))
                .willSetStateTo("ok")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("failures")
                .whenScenarioStateIs("ok")
                .willReturn(okJson(QUERY_RESPONSE))
        )
        val httpClient = FlakyHttpClient(OkHttpClient.builder().build())
        val ns = client(httpClient = httpClient).namespace("my-ns")
        val timeout = RequestOptions.builder().timeout(Duration.ofMillis(200)).build()

        assertThatThrownBy { ns.query(queryParams(), timeout) }
            .isInstanceOf(TurbopufferIoException::class.java)
        httpClient.connectFailures = 1
        assertThatThrownBy { ns.query(queryParams()) }
            .isInstanceOf(TurbopufferIoException::class.java)
        assertThatThrownBy { ns.query(queryParams()) }
            .isInstanceOf(UnprocessableEntityException::class.java)
        ns.query(queryParams())

        // The connect error never reached the server.
        val (timedOut, afterConnect, afterStatus) = sentRecords()
        assertThat(timedOut).isNull()
        // The connect error's batch is sent again with the new record.
        assertThat(afterConnect!!.map { it["status"].asInt() to it["error"].asText() })
            .containsExactly(0 to "timeout", 0 to "connect")
        val record = afterStatus!!.single()
        assertThat(record["status"].asInt()).isEqualTo(422)
        assertThat(record.has("error")).isFalse()
    }

    @Test
    fun batchIsResentAfterConnectError() {
        stubFor(post(urlPathEqualTo(QUERY_PATH)).willReturn(okJson(QUERY_RESPONSE)))
        val httpClient = FlakyHttpClient(OkHttpClient.builder().build())
        val ns = client(maxRetries = 1, httpClient = httpClient).namespace("my-ns")

        ns.query(queryParams())
        httpClient.connectFailures = 1
        ns.query(queryParams())

        val (first, retried) = sentRecords()
        assertThat(first).isNull()
        assertThat(retried!!.single()["route"].asText()).isEqualTo(QUERY_ROUTE)
    }

    @Test
    fun batchIsNotResentAfterServerError() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(okJson(QUERY_RESPONSE))
                .willSetStateTo("unavailable")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("retry")
                .whenScenarioStateIs("unavailable")
                .willReturn(status(503))
                .willSetStateTo("ok")
        )
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .inScenario("retry")
                .whenScenarioStateIs("ok")
                .willReturn(okJson(QUERY_RESPONSE))
        )
        val ns = client(maxRetries = 1).namespace("my-ns")

        ns.query(queryParams())
        ns.query(queryParams())
        ns.query(queryParams())

        val records = sentRecords()
        assertThat(records[1]).isNotNull()
        assertThat(records[2]).isNull()
        // The retried query reports how many retries it took.
        assertThat(records[3]!!.single()["retries"].asInt()).isEqualTo(1)
    }

    @Test
    fun serverSampleRateOfZeroStopsRecording() {
        stubFor(
            post(urlPathEqualTo(QUERY_PATH))
                .willReturn(okJson(QUERY_RESPONSE).withHeader(SAMPLE_RATE_HEADER, "0"))
        )
        val ns = client().namespace("my-ns")

        repeat(3) { ns.query(queryParams()) }

        assertThat(sentRecords()).containsExactly(null, null, null)
        assertThat(buffer.sampleRate).isEqualTo(0.0)
        // Unrecorded requests have no request IDs to link.
        assertThat(sentRequestIds().drop(1)).containsExactly(null, null)
    }

    @Test
    fun respondAsyncPollsAndRequestAreRecorded() {
        accepted()
        stubFor(
            get(urlPathEqualTo(POLL_PATH))
                .inScenario("poll")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(okJson("""{"status":"running"}"""))
                .willSetStateTo("finished")
        )
        stubFor(
            get(urlPathEqualTo(POLL_PATH))
                .inScenario("poll")
                .whenScenarioStateIs("finished")
                .willReturn(
                    okJson("""{"status":"finished","result":{"success":{"status":"OK"}}}""")
                )
        )

        write()

        val records = allRecords()
        val polls = records.dropLast(1)
        val request = records.last()
        assertThat(polls.map { it["route"].asText() to it["status"].asInt() })
            .containsExactly(POLL_ROUTE to 200, POLL_ROUTE to 200)
        // The request reports the final outcome, and its total spans the polling.
        assertThat(request["route"].asText()).isEqualTo(WRITE_ROUTE)
        assertThat(request["status"].asInt()).isEqualTo(200)
        assertThat(request.has("error")).isFalse()
        assertThat(request["total_us"].asLong())
            .isGreaterThanOrEqualTo(polls.sumOf { it["total_us"].asLong() })
    }

    @Test
    fun respondAsyncFailedOperationIsRecorded() {
        accepted()
        stubFor(
            get(urlPathEqualTo(POLL_PATH))
                .willReturn(
                    okJson(
                        """{"status":"finished","result":{"error":{"status_code":404,"detail":{"error":"gone"}}}}"""
                    )
                )
        )

        assertThatThrownBy { write() }.isInstanceOf(NotFoundException::class.java)

        val (poll, request) = allRecords()
        assertThat(poll["route"].asText()).isEqualTo(POLL_ROUTE)
        assertThat(request["route"].asText()).isEqualTo(WRITE_ROUTE)
        assertThat(request["status"].asInt()).isEqualTo(404)
        assertThat(request.has("error")).isFalse()
    }

    @ParameterizedTest
    @CsvSource("false,false", "false,true", "true,false", "true,true")
    fun respondAsyncPollingDeadlineIsRecorded(inSleep: Boolean, async: Boolean) {
        accepted()
        if (inSleep) {
            // The deadline passes while sleeping, so the next poll times out at once.
            stubFor(
                get(urlPathEqualTo(POLL_PATH))
                    .inScenario("poll")
                    .whenScenarioStateIs(Scenario.STARTED)
                    .willReturn(okJson("""{"status":"running"}"""))
                    .willSetStateTo("slow")
            )
            stubFor(
                get(urlPathEqualTo(POLL_PATH))
                    .inScenario("poll")
                    .whenScenarioStateIs("slow")
                    .willReturn(okJson("""{"status":"running"}""").withFixedDelay(200))
            )
        } else {
            // The deadline passes while a poll is in flight.
            stubFor(
                get(urlPathEqualTo(POLL_PATH))
                    .willReturn(okJson("""{"status":"running"}""").withFixedDelay(1000))
            )
        }
        val sleeper = if (inSleep) OversleepingSleeper else NoSleeper
        val timeout = RequestOptions.builder().timeout(Duration.ofMillis(200)).build()

        assertThatThrownBy { write(timeout, sleeper, async) }
            .isInstanceOf(TurbopufferIoException::class.java)

        val records = allRecords()
        val (poll, request) = records.takeLast(2)
        assertThat(poll["route"].asText()).isEqualTo(POLL_ROUTE)
        assertThat(poll["status"].asInt()).isEqualTo(0)
        assertThat(poll["error"].asText()).isEqualTo("timeout")
        // The request finishes last, with the accepted response and the polling deadline.
        assertThat(request["route"].asText()).isEqualTo(WRITE_ROUTE)
        assertThat(request["status"].asInt()).isEqualTo(202)
        assertThat(request["error"].asText()).isEqualTo("timeout")
        // Any earlier polls succeeded.
        assertThat(records.dropLast(2)).allSatisfy {
            assertThat(it["route"].asText()).isEqualTo(POLL_ROUTE)
            assertThat(it["status"].asInt()).isEqualTo(200)
        }
    }

    /** Delegates to another client, failing to connect while [connectFailures] remain. */
    private class FlakyHttpClient(private val delegate: HttpClient) : HttpClient {
        @Volatile var connectFailures = 0

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            if (connectFailures > 0) {
                connectFailures--
                throw TurbopufferIoException("Request failed", ConnectException("refused"))
            }
            return delegate.execute(request, requestOptions)
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            CompletableFuture.supplyAsync { execute(request, requestOptions) }

        override fun close() = delegate.close()
    }

    private object NoSleeper : Sleeper {
        override fun sleep(duration: Duration) {}

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.completedFuture(null)

        override fun close() {}
    }

    /** Sleeps past any deadline shorter than [OVERSLEEP], whatever duration it's asked for. */
    private object OversleepingSleeper : Sleeper {
        override fun sleep(duration: Duration) = Thread.sleep(OVERSLEEP.toMillis())

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.runAsync { sleep(duration) }

        override fun close() {}
    }

    private fun clientOptions(
        telemetry: Boolean = true,
        maxRetries: Int = 0,
        httpClient: HttpClient = OkHttpClient.builder().build(),
        sleeper: Sleeper = NoSleeper,
    ): ClientOptions =
        ClientOptions.builder()
            .httpClient(httpClient)
            .baseUrl(baseUrl)
            .apiKey(apiKey)
            .maxRetries(maxRetries)
            .sleeper(sleeper)
            .telemetry(telemetry)
            .build()

    private fun client(
        telemetry: Boolean = true,
        maxRetries: Int = 0,
        httpClient: HttpClient = OkHttpClient.builder().build(),
    ): TurbopufferClient = TurbopufferClientImpl(clientOptions(telemetry, maxRetries, httpClient))

    private fun queryParams() = NamespaceQueryParams.builder().topK(1L).build()

    private fun accepted() {
        stubFor(
            post(urlPathEqualTo(WRITE_PATH))
                .willReturn(
                    status(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "$baseUrl$POLL_PATH")
                )
        )
    }

    private fun write(
        requestOptions: RequestOptions = RequestOptions.none(),
        sleeper: Sleeper = NoSleeper,
        async: Boolean = false,
    ) {
        val params = NamespaceWriteParams.builder().addDelete("1").build()
        val options = clientOptions(sleeper = sleeper)
        if (!async) {
            TurbopufferClientImpl(options).namespace("my-ns").write(params, requestOptions)
            return
        }
        try {
            TurbopufferClientAsyncImpl(options)
                .namespace("my-ns")
                .write(params, requestOptions)
                .get()
        } catch (e: ExecutionException) {
            throw e.cause!!.let { if (it is CompletionException) it.cause!! else it }
        }
    }

    /** The requests the server received, oldest first. */
    private fun loggedRequests(): List<LoggedRequest> = findAll(anyRequestedFor(anyUrl()))

    /** The records sent with each request the server received, in order. */
    private fun sentRecords(): List<List<JsonNode>?> =
        findAll(postRequestedFor(urlPathEqualTo(QUERY_PATH))).map { request ->
            request.getHeader(TELEMETRY_HEADER)?.let { header ->
                val payload = jsonMapper().readTree(header)
                assertThat(payload["version"].asInt()).isEqualTo(1)
                payload["records"].toList()
            }
        }

    /** The `X-Request-Id` sent with each query the server received, in order. */
    private fun sentRequestIds(): List<String?> =
        findAll(postRequestedFor(urlPathEqualTo(QUERY_PATH))).map {
            it.getHeader(REQUEST_ID_HEADER)
        }

    /** The records sent on any request, followed by those still buffered. */
    private fun allRecords(): List<JsonNode> {
        val sent =
            loggedRequests().flatMap { request ->
                request.getHeader(TELEMETRY_HEADER)?.let {
                    jsonMapper().readTree(it)["records"].toList()
                } ?: emptyList()
            }
        return sent + takePayload(buffer)["records"].toList()
    }

    companion object {
        private const val WRITE_PATH = "/v2/namespaces/my-ns"
        private const val WRITE_ROUTE = "POST /v2/namespaces/{ns}"
        private const val POLL_PATH = "/v1/namespaces/my-ns/operations/op-abc"
        private const val POLL_ROUTE = "GET /v1/namespaces/{ns}/operations/{token}"
        private val OVERSLEEP = Duration.ofMillis(300)
    }
}
