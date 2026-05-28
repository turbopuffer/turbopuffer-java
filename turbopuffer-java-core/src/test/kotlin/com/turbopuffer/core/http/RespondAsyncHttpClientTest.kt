package com.turbopuffer.core.http

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.absent
import com.github.tomakehurst.wiremock.client.WireMock.containing
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.resetAllScenarios
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
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferException
import com.turbopuffer.errors.TurbopufferIoException
import java.io.InputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RespondAsyncHttpClientTest {

    private var openResponseCount = 0
    private lateinit var baseUrl: String
    private lateinit var delegate: HttpClient
    private val jsonMapper: JsonMapper = jsonMapper()

    private class RecordingSleeper : Sleeper {
        var sleeps = 0
            private set

        override fun sleep(duration: Duration) {
            sleeps++
        }

        override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
            sleeps++
            return CompletableFuture.completedFuture(null)
        }

        override fun close() {}
    }

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        POLL_INTERVAL = Duration.ZERO
        baseUrl = wmRuntimeInfo.httpBaseUrl

        val okHttpClient = OkHttpClient.builder().build()
        delegate =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = trackClose(okHttpClient.execute(request, requestOptions))

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> =
                    okHttpClient.executeAsync(request, requestOptions).thenApply { trackClose(it) }

                override fun close() = okHttpClient.close()

                private fun trackClose(response: HttpResponse): HttpResponse {
                    openResponseCount++
                    return object : HttpResponse {
                        private var isClosed = false

                        override fun statusCode(): Int = response.statusCode()

                        override fun headers(): Headers = response.headers()

                        override fun body(): InputStream = response.body()

                        override fun close() {
                            response.close()
                            if (isClosed) {
                                return
                            }
                            openResponseCount--
                            isClosed = true
                        }
                    }
                }
            }

        resetAllScenarios()
    }

    @AfterEach
    fun afterEach() {
        POLL_INTERVAL = Duration.ofSeconds(1)
        assertThat(openResponseCount).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun sendsPreferHeader(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        client.execute(simplePost(), async).use {}

        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something"))
                .withHeader("Prefer", equalTo("respond-async")),
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun passesThroughSyncResponse(async: Boolean) {
        stubFor(post(urlPathEqualTo("/something")).willReturn(ok()))
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        client.execute(simplePost(), async).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
        }

        assertThat(sleeper.sleeps).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun pollsUntilSuccess(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-abc")
                        .withBody("ignored")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-abc"))
                .inScenario("poll")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"running"}""")
                )
                .willSetStateTo("FINISHED")
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-abc"))
                .inScenario("poll")
                .whenScenarioStateIs("FINISHED")
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"finished","result":{"success":{"foo":1}}}""")
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        client.execute(simplePost(), async).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
            assertThat(response.bodyAsString()).isEqualTo("""{"foo":1}""")
        }

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/v1/namespaces/test/operations/op-abc"))
                .withHeader("Prefer", absent()),
        )
        assertThat(sleeper.sleeps).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun pollsUntilError(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-err")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-err"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                            """
                            {"status":"finished","result":{"error":{"status_code":404,"detail":{"message":"namespace not found"}}}}
                            """
                                .trimIndent()
                        )
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        client.execute(simplePost(), async).use { response ->
            assertThat(response.statusCode()).isEqualTo(404)
            assertThat(response.bodyAsString()).isEqualTo("""{"message":"namespace not found"}""")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun throwsOnMissingLocationHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse().withStatus(202).withHeader("Preference-Applied", "respond-async")
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        assertThatThrownBy { client.execute(simplePost(), async) }
            .matches { unwrap(it) is TurbopufferException }
            .hasMessageContaining("Location")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun throwsOnMalformedPollBody(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-bad")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-bad"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"finished"}""")
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        assertThatThrownBy { client.execute(simplePost(), async) }
            .matches { unwrap(it) is TurbopufferException }
            .hasMessageContaining("malformed poll response")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun passesThroughUnrelated202(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(aResponse().withStatus(202).withBody("not-our-business"))
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        client.execute(simplePost(), async).use { response ->
            assertThat(response.statusCode()).isEqualTo(202)
            assertThat(response.bodyAsString()).isEqualTo("not-our-business")
        }

        assertThat(sleeper.sleeps).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun throwsOnPollTimeout(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-slow")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-slow"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"running"}""")
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        val opts = RequestOptions.builder().timeout(Duration.ofSeconds(1)).build()

        assertThatThrownBy {
                if (async) client.executeAsync(simplePost(), opts).get()
                else client.execute(simplePost(), opts)
            }
            .matches { unwrap(it) is TurbopufferIoException }
            .hasMessageContaining("Request failed")
        assertThat(sleeper.sleeps).isGreaterThan(0)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun zeroRequestTimeoutMeansNoDeadline(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-zero")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-zero"))
                .inScenario("poll-zero")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"running"}""")
                )
                .willSetStateTo("FINISHED")
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-zero"))
                .inScenario("poll-zero")
                .whenScenarioStateIs("FINISHED")
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"finished","result":{"success":{"ok":true}}}""")
                )
        )
        val sleeper = RecordingSleeper()
        val client = respondAsyncClient(sleeper)

        val opts =
            RequestOptions.builder()
                .timeout(Timeout.builder().request(Duration.ZERO).build())
                .build()

        client.execute(simplePost(), opts, async).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
            assertThat(response.bodyAsString()).isEqualTo("""{"ok":true}""")
        }
        assertThat(sleeper.sleeps).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun retainsCallerSuppliedPreferHeader(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .withHeader("Prefer", containing("wait=10"))
                .willReturn(ok())
        )
        val client = respondAsyncClient(RecordingSleeper())

        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl(baseUrl)
                .addPathSegment("something")
                .putHeader("Prefer", "wait=10")
                .build()

        client.execute(request, async).use { response ->
            assertThat(response.statusCode()).isEqualTo(200)
        }

        verify(
            1,
            postRequestedFor(urlPathEqualTo("/something")).withHeader("Prefer", equalTo("wait=10")),
        )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun pollUsesClientHeadersNotRequestHeaders(async: Boolean) {
        stubFor(
            post(urlPathEqualTo("/something"))
                .willReturn(
                    aResponse()
                        .withStatus(202)
                        .withHeader("Preference-Applied", "respond-async")
                        .withHeader("Location", "/v1/namespaces/test/operations/op-headers")
                )
        )
        stubFor(
            get(urlPathEqualTo("/v1/namespaces/test/operations/op-headers"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""{"status":"finished","result":{"success":{}}}""")
                )
        )
        val sleeper = RecordingSleeper()
        val clientHeaders = Headers.builder().put("Authorization", "Bearer client-key").build()
        val client = RespondAsyncHttpClient(delegate, sleeper, jsonMapper, clientHeaders)

        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl(baseUrl)
                .addPathSegment("something")
                .putHeader("X-Per-Request", "hello")
                .build()

        client.execute(request, async).use {}

        verify(
            1,
            getRequestedFor(urlPathEqualTo("/v1/namespaces/test/operations/op-headers"))
                .withHeader("Authorization", equalTo("Bearer client-key"))
                .withHeader("X-Per-Request", absent()),
        )
    }

    private fun respondAsyncClient(sleeper: RecordingSleeper): RespondAsyncHttpClient =
        RespondAsyncHttpClient(delegate, sleeper, jsonMapper, Headers.builder().build())

    private fun simplePost(): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(baseUrl)
            .addPathSegment("something")
            .build()

    private fun HttpClient.execute(request: HttpRequest, async: Boolean): HttpResponse =
        if (async) executeAsync(request).get() else execute(request)

    private fun HttpClient.execute(
        request: HttpRequest,
        opts: RequestOptions,
        async: Boolean,
    ): HttpResponse = if (async) executeAsync(request, opts).get() else execute(request, opts)

    private fun HttpResponse.bodyAsString(): String =
        body().use { it.readBytes().toString(Charsets.UTF_8) }

    private fun unwrap(t: Throwable): Throwable =
        if ((t is CompletionException || t is ExecutionException) && t.cause != null) t.cause!!
        else t
}
