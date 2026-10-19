package com.turbopuffer.core.http

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.resetAllScenarios
import com.github.tomakehurst.wiremock.client.WireMock.serverError
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.stubbing.Scenario
import com.turbopuffer.client.okhttp.OkHttpClient
import com.turbopuffer.core.RequestOptions
import com.turbopuffer.core.Sleeper
import com.turbopuffer.core.Timeout
import com.turbopuffer.core.handlers.errorBodyHandler
import com.turbopuffer.core.handlers.errorHandler
import com.turbopuffer.core.handlers.jsonHandler
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferIoException
import com.turbopuffer.errors.TurbopufferServiceException
import java.io.InterruptedIOException
import java.net.ServerSocket
import java.time.Duration
import java.util.Collections
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.TimeUnit
import java.util.logging.Handler
import java.util.logging.LogRecord
import java.util.logging.Logger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RequestObserverTest {

    private lateinit var baseUrl: String

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        resetAllScenarios()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observesRequest(async: Boolean) {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        val recorder = Recorder()

        val parsed = execute(client(recorder), async)

        assertThat(parsed).isEqualTo(mapOf("name" to "thing"))
        assertThat(recorder.events).containsExactly("start", "before 0", "after 0", "finish")
        assertThat(recorder.infos.single().method).isEqualTo(HttpMethod.POST)
        assertThat(recorder.infos.single().url).isEqualTo("/v1/things?overload=thing")
        verify(
            postRequestedFor(urlPathEqualTo("/v1/things")).withHeader(ATTEMPT_HEADER, equalTo("0"))
        )

        val attempt = recorder.attempts.single()
        assertThat(attempt.response?.statusCode()).isEqualTo(200)
        assertThat(attempt.error).isNull()
        assertThat(attempt.errorKind).isNull()
        assertThat(attempt.reachedServer).isTrue()

        val result = recorder.results.single()
        assertThat(result.retries).isEqualTo(0)
        assertThat(result.error).isNull()
        assertThat(result.errorKind).isNull()
        assertThat(result.response).isSameAs(attempt.response)
        assertThat(result.parsed).isSameAs(parsed)
        assertThat(result.timings).isSameAs(attempt.timings)

        val timings = result.timings
        assertThat(timings.reused).isFalse()
        assertOrdered(
            "attemptBegin" to timings.attemptBegin,
            "serializeBegin" to timings.serializeBegin,
            "serializeEnd" to timings.serializeEnd,
            "requestReady" to timings.requestReady,
            "connectBegin" to timings.connectBegin,
            "connectEnd" to timings.connectEnd,
            "sendBegin" to timings.sendBegin,
            "sendEnd" to timings.sendEnd,
            "responseHeaders" to timings.responseHeaders,
            "bodyEnd" to timings.bodyEnd,
            "deserializeBegin" to timings.deserializeBegin,
            "deserializeEnd" to timings.deserializeEnd,
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observesRetries(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/v1/things"))
                .inScenario("retry")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(serverError())
                .willSetStateTo("RETRIED")
        )
        stubFor(
            post(urlPathEqualTo("/v1/things"))
                .inScenario("retry")
                .whenScenarioStateIs("RETRIED")
                .willReturn(okJson("""{"name":"thing"}"""))
        )
        val recorder = Recorder()

        execute(client(recorder, maxRetries = 1), async)

        assertThat(recorder.events)
            .containsExactly("start", "before 0", "after 0", "before 1", "after 1", "finish")
        verify(
            postRequestedFor(urlPathEqualTo("/v1/things")).withHeader(ATTEMPT_HEADER, equalTo("1"))
        )

        val (first, second) = recorder.attempts
        assertThat(first.response?.statusCode()).isEqualTo(500)
        assertThat(first.reachedServer).isTrue()
        assertThat(first.timings.reused).isFalse()
        assertThat(first.timings.connectBegin).isNotNull()
        assertThat(second.timings.reused).isTrue()
        assertThat(second.timings.connectBegin).isNull()
        assertThat(second.timings.connectEnd).isNull()
        assertThat(second.timings.serializeBegin).isNull()
        assertOrdered(
            "first responseHeaders" to first.timings.responseHeaders,
            "second attemptBegin" to second.timings.attemptBegin,
            "second requestReady" to second.timings.requestReady,
            "second sendBegin" to second.timings.sendBegin,
            "second responseHeaders" to second.timings.responseHeaders,
        )

        val result = recorder.results.single()
        assertThat(result.retries).isEqualTo(1)
        assertThat(result.timings).isSameAs(second.timings)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observesErrorResponse(async: Boolean) {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(status(404).withBody("{}")))
        val recorder = Recorder()

        val error = catchThrowable { execute(client(recorder), async) }

        assertThat(error).isInstanceOf(TurbopufferServiceException::class.java)
        assertThat(recorder.events).containsExactly("start", "before 0", "after 0", "finish")
        assertThat(recorder.attempts.single().error).isNull()
        val result = recorder.results.single()
        assertThat(result.error).isSameAs(error)
        assertThat(result.errorKind).isNull()
        assertThat(result.response?.statusCode()).isEqualTo(404)
        assertThat(result.parsed).isNull()
        assertThat(result.timings.bodyEnd).isNotNull()
        assertThat(result.timings.deserializeBegin).isNull()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observesConnectError(async: Boolean) {
        val closedPort = ServerSocket(0).use { it.localPort }
        baseUrl = "http://127.0.0.1:$closedPort"
        val recorder = Recorder()

        val error = catchThrowable { execute(client(recorder), async) }

        assertThat(error).isNotNull()
        assertThat(recorder.events).containsExactly("start", "before 0", "after 0", "finish")
        val attempt = recorder.attempts.single()
        assertThat(attempt.error).isNotNull()
        assertThat(attempt.errorKind).isEqualTo(ErrorKind.CONNECT_ERROR)
        assertThat(attempt.reachedServer).isFalse()
        val result = recorder.results.single()
        assertThat(result.errorKind).isEqualTo(ErrorKind.CONNECT_ERROR)
        assertThat(result.response).isNull()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun observesTimeout(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/v1/things"))
                .willReturn(okJson("""{"name":"thing"}""").withFixedDelay(2000))
        )
        val recorder = Recorder()
        val requestOptions =
            RequestOptions.builder()
                .timeout(Timeout.builder().request(Duration.ofMillis(200)).build())
                .build()

        val error = catchThrowable { execute(client(recorder), async, requestOptions) }

        assertThat(error).isNotNull()
        assertThat(recorder.events).containsExactly("start", "before 0", "after 0", "finish")
        val attempt = recorder.attempts.single()
        assertThat(attempt.errorKind).isEqualTo(ErrorKind.READ_TIMEOUT)
        assertThat(attempt.reachedServer).isNull()
        assertThat(recorder.results.single().errorKind).isEqualTo(ErrorKind.READ_TIMEOUT)
    }

    @Test
    fun observesCanceledFuture() {
        stubFor(
            post(urlPathEqualTo("/v1/things"))
                .willReturn(okJson("""{"name":"thing"}""").withFixedDelay(2000))
        )
        val recorder = Recorder()

        client(recorder).executeAsync(request()).cancel(false)

        assertThat(recorder.events).containsExactly("start", "before 0", "finish")
        assertThat(recorder.results.single().errorKind).isEqualTo(ErrorKind.CANCELED)
    }

    @Test
    fun observesInterruptedThread() {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        val recorder = Recorder()

        Thread.currentThread().interrupt()
        val error =
            try {
                catchThrowable { execute(client(recorder), async = false) }
            } finally {
                Thread.interrupted()
            }

        assertThat(error).isNotNull()
        assertThat(recorder.attempts.single().errorKind).isEqualTo(ErrorKind.CANCELED)
        assertThat(recorder.results.single().errorKind).isEqualTo(ErrorKind.CANCELED)
    }

    @Test
    fun replacedResponseFinishesWithReplacement() {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        val recorder = Recorder()

        // Like custom code that polls for the result of an accepted request and returns that.
        val original = client(recorder).execute(request())
        val observation = original.observation()!!
        original.use { it.body().readBytes() }
        val drained = System.nanoTime()
        observation.timings.bodyEnd = drained
        Thread.sleep(10)
        val replacement = jsonResponse("""{"name":"replaced"}""")
        val parsed = parse(observation.respond(replacement))

        assertThat(parsed).isEqualTo(mapOf("name" to "replaced"))
        val result = recorder.results.single()
        assertThat(result.response).isSameAs(replacement)
        assertThat(result.timings.bodyEnd).isEqualTo(drained)
        assertOrdered(
            "bodyEnd" to result.timings.bodyEnd,
            "deserializeBegin" to result.timings.deserializeBegin,
            "deserializeEnd" to result.timings.deserializeEnd,
        )

        // Failing after the response arrived isn't a read error.
        val failing = Recorder()
        client(failing).execute(request()).use { response ->
            response
                .observation()!!
                .fail(TurbopufferIoException("Request failed", InterruptedIOException("timeout")))
        }
        assertThat(failing.results.single().errorKind).isEqualTo(ErrorKind.TIMEOUT)
    }

    @Test
    fun finishesOnlyWhenParsed() {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        val recorder = Recorder()
        val client = client(recorder)

        // Parsing the same response twice finishes once.
        val parseable = handle(client.execute(request()))
        parseable.parse()
        parseable.parse()
        assertThat(recorder.results).hasSize(1)

        // Responses whose body the caller reads itself don't finish.
        client.execute(request()).use { it.body().readBytes() }
        val streamed = client.execute(request())
        streamed.streamParseable { streamed.use { it.body().readBytes() } }.parse()
        assertThat(recorder.results).hasSize(1)
    }

    @Test
    fun observerExceptionsAreIgnored() {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        val warnings = Collections.synchronizedList(mutableListOf<LogRecord>())
        val handler =
            object : Handler() {
                override fun publish(record: LogRecord) {
                    warnings.add(record)
                }

                override fun flush() {}

                override fun close() {}
            }
        val logger = Logger.getLogger(RequestObservation::class.java.name)
        logger.addHandler(handler)
        try {
            val throwingScope =
                object : RequestScope {
                    override fun attemptBegin(attempt: Int, request: HttpRequest.Builder) {
                        request.putHeader(ATTEMPT_HEADER, "partial")
                        throw IllegalStateException("attemptBegin")
                    }

                    override fun attemptEnd(result: AttemptResult) =
                        throw IllegalStateException("attemptEnd")

                    override fun finish(result: RequestResult) =
                        throw IllegalStateException("finish")
                }

            assertThat(
                    execute(
                        client(RequestObserver { throw IllegalStateException("start") }),
                        async = false,
                    )
                )
                .isEqualTo(mapOf("name" to "thing"))
            assertThat(execute(client(RequestObserver { throwingScope }), async = false))
                .isEqualTo(mapOf("name" to "thing"))
        } finally {
            logger.removeHandler(handler)
        }

        // Other tests may log concurrently, so only count this one's warnings.
        assertThat(warnings.map { it.thrown?.message })
            .filteredOn { it in setOf("start", "attemptBegin", "attemptEnd", "finish") }
            .hasSize(4)
        // A scope that fails to change the request doesn't change it at all.
        verify(
            0,
            postRequestedFor(urlPathEqualTo("/v1/things"))
                .withHeader(ATTEMPT_HEADER, equalTo("partial")),
        )
    }

    @Test
    fun unobservedRequestsAreUntouched() {
        stubFor(post(urlPathEqualTo("/v1/things")).willReturn(okJson("""{"name":"thing"}""")))
        var starts = 0
        val unobserving = RequestObserver {
            starts++
            null
        }

        for (observer in listOf(null, unobserving)) {
            val response = client(observer).execute(request())
            assertThat(response.observation()).isNull()
            assertThat(parse(response)).isEqualTo(mapOf("name" to "thing"))
        }
        assertThat(starts).isEqualTo(1)
    }

    private class Recorder : RequestObserver, RequestScope {
        val events: MutableList<String> = Collections.synchronizedList(mutableListOf())
        val infos: MutableList<RequestInfo> = Collections.synchronizedList(mutableListOf())
        val attempts: MutableList<AttemptResult> = Collections.synchronizedList(mutableListOf())
        val results: MutableList<RequestResult> = Collections.synchronizedList(mutableListOf())

        override fun start(info: RequestInfo): RequestScope {
            events.add("start")
            infos.add(info)
            return this
        }

        override fun attemptBegin(attempt: Int, request: HttpRequest.Builder) {
            events.add("before $attempt")
            request.putHeader(ATTEMPT_HEADER, attempt.toString())
        }

        override fun attemptEnd(result: AttemptResult) {
            events.add("after ${result.attempt}")
            attempts.add(result)
        }

        override fun finish(result: RequestResult) {
            events.add("finish")
            results.add(result)
        }
    }

    private object NoSleeper : Sleeper {
        override fun sleep(duration: Duration) {}

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
            CompletableFuture.completedFuture(null)

        override fun close() {}
    }

    private fun client(observer: RequestObserver?, maxRetries: Int = 0): HttpClient =
        RetryingHttpClient.builder()
            .httpClient(OkHttpClient.builder().build())
            .sleeper(NoSleeper)
            .maxRetries(maxRetries)
            .requestObserver(observer)
            .build()

    private fun request(): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(baseUrl)
            .addPathSegments("v1", "things")
            .putQueryParam("overload", "thing")
            .pathQuery("overload=thing")
            .body(json(jsonMapper(), mapOf("name" to "thing")))
            .build()

    /** Handles a response like generated services do. */
    private fun handle(response: HttpResponse): HttpResponseFor<Map<String, String>> =
        errorHandler(errorBodyHandler(jsonMapper())).handle(response).parseable {
            response.use { jsonHandler<Map<String, String>>(jsonMapper()).handle(it) }
        }

    private fun parse(response: HttpResponse): Map<String, String> = handle(response).parse()

    private fun execute(
        client: HttpClient,
        async: Boolean,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Map<String, String> {
        if (!async) {
            return parse(client.execute(request(), requestOptions))
        }
        return try {
            client
                .executeAsync(request(), requestOptions)
                .thenApply(::handle)
                .thenApply { it.parse() }
                .get(10, TimeUnit.SECONDS)
        } catch (e: java.util.concurrent.ExecutionException) {
            throw e.cause!!.let { if (it is CompletionException) it.cause!! else it }
        }
    }

    private fun jsonResponse(body: String): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = 200

            override fun headers(): Headers =
                Headers.builder().put("Content-Type", "application/json").build()

            override fun body() = body.byteInputStream()

            override fun close() {}
        }

    /** Asserts every mark is set and none is before the one preceding it. */
    private fun assertOrdered(vararg marks: Pair<String, Long?>) {
        marks.forEachIndexed { i, (name, at) ->
            assertThat(at).describedAs(name).isNotNull()
            if (i > 0) {
                assertThat(at!!).describedAs(name).isGreaterThanOrEqualTo(marks[i - 1].second!!)
            }
        }
    }

    companion object {
        private const val ATTEMPT_HEADER = "X-Observed-Attempt"
    }
}
