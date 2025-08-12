// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.turbopuffer.client.TurbopufferClient
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.ClientNamespacesParams
import com.turbopuffer.models.namespaces.AttributeSchemaConfig
import com.turbopuffer.models.namespaces.Columns
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.Row
import com.turbopuffer.models.namespaces.Schema
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: TurbopufferClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("tpuf_A1...")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun namespaces() {
        val turbopufferClient = client
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        turbopufferClient.namespaces(
            ClientNamespacesParams.builder()
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun write() {
        val namespaceService = client.namespace("ns")
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        namespaceService.write(
            NamespaceWriteParams.builder()
                .copyFromNamespace("copy_from_namespace")
                .addDelete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .encryption(
                    NamespaceWriteParams.Encryption.builder()
                        .cmek(
                            NamespaceWriteParams.Encryption.Cmek.builder()
                                .keyName("key_name")
                                .build()
                        )
                        .build()
                )
                .patchColumns(
                    Columns.builder()
                        .put("id", listOf(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")))
                        .put("vector", listOf(JsonValue.from(listOf(0.0))))
                        .build()
                )
                .patchCondition(JsonValue.from(mapOf<String, Any>()))
                .addPatchRow(
                    Row.builder()
                        .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .put("vectorOfNumber", listOf(0.0))
                        .build()
                )
                .schema(
                    Schema.builder()
                        .put("id", AttributeSchemaConfig.builder().type("uuid").build())
                        .put(
                            "name",
                            AttributeSchemaConfig.builder().type("string").filterable(false).build(),
                        )
                        .put("age", AttributeSchemaConfig.builder().type("uint").build())
                        .build()
                )
                .upsertColumns(
                    Columns.builder()
                        .put("id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .put("vector", listOf(listOf(0.0)))
                        .build()
                )
                .upsertCondition(JsonValue.from(mapOf<String, Any>()))
                .addUpsertRow(
                    Row.builder()
                        .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .put("vectorOfNumber", listOf(0.0))
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
