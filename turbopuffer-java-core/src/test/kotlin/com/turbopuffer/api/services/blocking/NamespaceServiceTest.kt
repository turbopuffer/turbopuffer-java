// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services.blocking

import com.turbopuffer.api.TestServerExtension
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceRetrieveParams
import com.turbopuffer.api.models.NamespaceUpsertParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class NamespaceServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun callRetrieve() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val namespaceService = client.namespaces()
        val namespaceRetrieveResponse =
            namespaceService.retrieve(
                NamespaceRetrieveParams.builder().namespace("namespace").build()
            )
        println(namespaceRetrieveResponse)
        namespaceRetrieveResponse.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun callList() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val namespaceService = client.namespaces()
        val namespaceListResponse = namespaceService.list(NamespaceListParams.builder().build())
        println(namespaceListResponse)
        for (element: UnnamedSchemaWithArrayParent0 in namespaceListResponse) {
            element.validate()
        }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun callQuery() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val namespaceService = client.namespaces()
        val namespaceQueryResponse =
            namespaceService.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .consistency(
                        NamespaceQueryParams.Consistency.builder()
                            .level(NamespaceQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                    .filters(
                        NamespaceQueryParams.Filters.ofJsonValue(
                            JsonValue.from(mapOf<String, Any>())
                        )
                    )
                    .includeAttributesOfStrings(listOf("string"))
                    .includeVectors(true)
                    .addRankBy("string")
                    .topK(0L)
                    .addVector(0.0)
                    .build()
            )
        println(namespaceQueryResponse)
        namespaceQueryResponse.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun callUpsert() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val namespaceService = client.namespaces()
        val namespaceUpsertResponse =
            namespaceService.upsert(
                NamespaceUpsertParams.builder()
                    .forVariant0(
                        NamespaceUpsertParams.UnionMember0.builder()
                            .distanceMetric(
                                NamespaceUpsertParams.UnionMember0.DistanceMetric.COSINE_DISTANCE
                            )
                            .ids(listOf(NamespaceUpsertParams.UnionMember0.Id.ofInteger(0L)))
                            .vectors(listOf(listOf(0.0)))
                            .attributes(
                                NamespaceUpsertParams.UnionMember0.Attributes.builder()
                                    .putAdditionalProperty(
                                        "foo",
                                        JsonValue.from(listOf(mapOf<String, Any>()))
                                    )
                                    .build()
                            )
                            .copyFromNamespace("copy_from_namespace")
                            .schema(JsonValue.from(mapOf<String, Any>()))
                            .build()
                    )
                    .namespace("namespace")
                    .build()
            )
        println(namespaceUpsertResponse)
        namespaceUpsertResponse.validate()
    }
}
