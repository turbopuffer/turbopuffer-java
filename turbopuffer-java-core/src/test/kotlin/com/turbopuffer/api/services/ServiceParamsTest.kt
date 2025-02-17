// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
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
import com.turbopuffer.api.client.TurbopufferClient
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.jsonMapper
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceUpsertParams
import com.turbopuffer.api.models.NamespaceUpsertResponse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: TurbopufferClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            TurbopufferOkHttpClient.builder()
                .apiKey("My API Key")
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .build()
    }

    @Test
    fun namespacesQueryWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val additionalBodyProperties = mutableMapOf<String, JsonValue>()

        additionalBodyProperties.put("testBodyProperty", JsonValue.from("ghi890"))

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
                .additionalHeaders(additionalHeaders)
                .additionalBodyProperties(additionalBodyProperties)
                .additionalQueryParams(additionalQueryParams)
                .build()

        stubFor(
            post(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .withRequestBody(matchingJsonPath("$.testBodyProperty", equalTo("ghi890")))
                .willReturn(ok("[]"))
        )

        client.namespaces().query(params)

        verify(postRequestedFor(anyUrl()))
    }

    @Test
    fun namespacesUpsertWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val params =
            NamespaceUpsertParams.builder()
                .forUpsertColumnar(
                    NamespaceUpsertParams.UpsertColumnar.builder()
                        .attributes(
                            NamespaceUpsertParams.UpsertColumnar.Attributes.builder()
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
                                    )
                                )
                                .build()
                        )
                        .distanceMetric(
                            NamespaceUpsertParams.UpsertColumnar.DistanceMetric.COSINE_DISTANCE
                        )
                        .ids(
                            listOf(
                                NamespaceUpsertParams.UpsertColumnar.Id.ofString(
                                    "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                )
                            )
                        )
                        .schema(
                            NamespaceUpsertParams.UpsertColumnar.Schema.builder()
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
                                    )
                                )
                                .build()
                        )
                        .vectors(listOf(NamespaceUpsertParams.UpsertColumnar.Vector.ofNumber(0.0)))
                        .build()
                )
                .namespace("namespace")
                .additionalHeaders(additionalHeaders)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            NamespaceUpsertResponse.builder().status(NamespaceUpsertResponse.Status.OK).build()

        stubFor(
            post(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse)))
        )

        client.namespaces().upsert(params)

        verify(postRequestedFor(anyUrl()))
    }
}
