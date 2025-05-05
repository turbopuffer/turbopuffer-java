// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
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
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.DocumentColumns
import com.turbopuffer.models.namespaces.DocumentRow
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
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
                .apiKey("My API Key")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val namespaceService = client.namespaces()
        stubFor(post(anyUrl()).willReturn(ok("[]")))

        namespaceService.query(
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .filters(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(true)
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun write() {
        val namespaceService = client.namespaces()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        namespaceService.write(
            NamespaceWriteParams.builder()
                .namespace("namespace")
                .operation(
                    NamespaceWriteParams.Operation.WriteDocuments.builder()
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .patchColumns(
                            DocumentColumns.builder()
                                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .build()
                        )
                        .addPatchRow(
                            DocumentRow.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .vectorOfNumber(listOf(0.0))
                                .build()
                        )
                        .schema(
                            NamespaceWriteParams.Operation.WriteDocuments.Schema.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        listOf(
                                            mapOf(
                                                "filterable" to true,
                                                "full_text_search" to true,
                                                "type" to "string",
                                            )
                                        )
                                    ),
                                )
                                .build()
                        )
                        .upsertColumns(
                            DocumentColumns.builder()
                                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .build()
                        )
                        .addUpsertRow(
                            DocumentRow.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .vectorOfNumber(listOf(0.0))
                                .build()
                        )
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
