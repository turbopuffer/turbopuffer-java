// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
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
import com.turbopuffer.api.models.NamespaceListParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
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
                .bearerToken("My Bearer Token")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList200() {
        val params = NamespaceListParams.builder().build()

        val expected =
            listOf(
                UnnamedSchemaWithArrayParent0.builder()
                    .approxCount(0L)
                    .dimensions(0L)
                    .name("name")
                    .build()
            )

        stubFor(get(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.namespaces().list(params)).isEqualTo(expected)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList400() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertBadRequest(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList401() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertUnauthorized(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList403() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertPermissionDenied(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList404() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertNotFound(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList422() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList429() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertRateLimit(e, Headers.builder().put("Foo", "Bar").build(), TURBOPUFFER_ERROR)
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun namespacesList500() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertInternalServer(
                    e,
                    Headers.builder().put("Foo", "Bar").build(),
                    TURBOPUFFER_ERROR
                )
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun unexpectedStatusCode() {
        val params = NamespaceListParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader("Foo", "Bar").withBody(toJson(TURBOPUFFER_ERROR))
                )
        )

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    Headers.builder().put("Foo", "Bar").build(),
                    toJson(TURBOPUFFER_ERROR)
                )
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun invalidBody() {
        val params = NamespaceListParams.builder().build()

        stubFor(get(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.namespaces().list(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(TurbopufferException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun invalidErrorBody() {
        val params = NamespaceListParams.builder().build()

        stubFor(get(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.namespaces().list(params) })
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
