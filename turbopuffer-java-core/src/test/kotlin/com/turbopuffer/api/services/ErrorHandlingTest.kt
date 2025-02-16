// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.turbopuffer.api.client.TurbopufferClient
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.http.Headers
import com.turbopuffer.api.core.jsonMapper
import com.turbopuffer.api.errors.BadRequestException
import com.turbopuffer.api.errors.InternalServerException
import com.turbopuffer.api.errors.NotFoundException
import com.turbopuffer.api.errors.PermissionDeniedException
import com.turbopuffer.api.errors.RateLimitException
import com.turbopuffer.api.errors.TurbopufferError
import com.turbopuffer.api.errors.TurbopufferException
import com.turbopuffer.api.errors.UnauthorizedException
import com.turbopuffer.api.errors.UnexpectedStatusCodeException
import com.turbopuffer.api.errors.UnprocessableEntityException
import com.turbopuffer.api.models.DocumentRow
import com.turbopuffer.api.models.NamespaceQueryParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val TURBOPUFFER_ERROR: TurbopufferError =
        TurbopufferError.builder().putAdditionalProperty("key", JsonValue.from("value")).build()

    private lateinit var client: TurbopufferClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun namespacesQuery200() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        val expected =
            listOf(
                DocumentRow.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .attributes(
                        DocumentRow.Attributes.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    mapOf(
                                        "filterable" to true,
                                        "full_text_search" to true,
                                        "type" to "string",
                                    )
                                )
                            )
                            .build()
                    )
                    .addVector(0.0)
                    .build()
            )

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.namespaces().query(params)).isEqualTo(expected)
    }

    @Test
    fun namespacesQuery400() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Test
    fun namespacesQuery401() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertUnauthorized(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Test
    fun namespacesQuery403() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertPermissionDenied(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Test
    fun namespacesQuery404() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertNotFound(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Test
    fun namespacesQuery422() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Test
    fun namespacesQuery429() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertRateLimit(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Test
    fun namespacesQuery500() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertInternalServer(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    Headers.builder().put("Foo", "Bar").build(),
                    toJson(TURBOPUFFER_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(TurbopufferException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.namespaces().query(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().build(), TurbopufferError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: Headers,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertBadRequest(throwable: Throwable, headers: Headers, error: TurbopufferError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: Headers,
        error: TurbopufferError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: Headers,
        error: TurbopufferError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertNotFound(throwable: Throwable, headers: Headers, error: TurbopufferError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: Headers,
        error: TurbopufferError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertRateLimit(throwable: Throwable, headers: Headers, error: TurbopufferError) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: Headers,
        error: TurbopufferError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers().toMap()).containsAllEntriesOf(headers.toMap())
            })
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
