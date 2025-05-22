// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.turbopuffer.client.TurbopufferClient
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.BadRequestException
import com.turbopuffer.errors.InternalServerException
import com.turbopuffer.errors.NotFoundException
import com.turbopuffer.errors.PermissionDeniedException
import com.turbopuffer.errors.RateLimitException
import com.turbopuffer.errors.TurbopufferException
import com.turbopuffer.errors.UnauthorizedException
import com.turbopuffer.errors.UnexpectedStatusCodeException
import com.turbopuffer.errors.UnprocessableEntityException
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: TurbopufferClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery400() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery401() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery403() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery404() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery422() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery429() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery500() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQuery999() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesQueryInvalidJsonBody() {
        val namespaceService = client.namespaces()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<TurbopufferException> {
                namespaceService.query(
                    NamespaceQueryParams.builder()
                        .namespace("namespace")
                        .rankBy(JsonValue.from(mapOf<String, Any>()))
                        .topK(0L)
                        .consistency(
                            NamespaceQueryParams.Consistency.builder()
                                .level(NamespaceQueryParams.Consistency.Level.STRONG)
                                .build()
                        )
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
