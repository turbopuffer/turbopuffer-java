// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.services.blocking

import com.turbopuffer.api.TestServerExtension
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.models.DocumentColumns
import com.turbopuffer.api.models.DocumentRow
import com.turbopuffer.api.models.NamespaceDeleteAllParams
import com.turbopuffer.api.models.NamespaceGetSchemaParams
import com.turbopuffer.api.models.NamespaceListParams
import com.turbopuffer.api.models.NamespaceQueryParams
import com.turbopuffer.api.models.NamespaceUpsertParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class NamespaceServiceTest {

    @Test
    fun callList() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()
        val response = namespaceService.list(NamespaceListParams.builder().build())
        println(response)
        response.namespaces().forEach { it.validate() }
    }

    @Test
    fun callDeleteAll() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()
        val namespaceDeleteAllResponse =
            namespaceService.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
            )
        println(namespaceDeleteAllResponse)
        namespaceDeleteAllResponse.validate()
    }

    @Test
    fun callGetSchema() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()
        val namespaceGetSchemaResponse =
            namespaceService.getSchema(
                NamespaceGetSchemaParams.builder().namespace("namespace").build()
            )
        println(namespaceGetSchemaResponse)
        namespaceGetSchemaResponse.validate()
    }

    @Test
    fun callQuery() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
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
                    .filter(JsonValue.from(mapOf<String, Any>()))
                    .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                    .includeVectors(true)
                    .rankBy(JsonValue.from(mapOf<String, Any>()))
                    .topK(0L)
                    .addVector(0.0)
                    .build()
            )
        println(namespaceQueryResponse)
        for (documentRow: DocumentRow in namespaceQueryResponse) {
            documentRow.validate()
        }
    }

    @Test
    fun callUpsert() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()
        val namespaceUpsertResponse =
            namespaceService.upsert(
                NamespaceUpsertParams.builder()
                    .namespace("namespace")
                    .body(
                        NamespaceUpsertParams.Body.UpsertColumnar.builder()
                            .attributes(
                                DocumentColumns.Attributes.builder()
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
                            .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .addVector(listOf(0.0))
                            .distanceMetric(
                                NamespaceUpsertParams.Body.UpsertColumnar.DistanceMetric
                                    .COSINE_DISTANCE
                            )
                            .schema(
                                NamespaceUpsertParams.Body.UpsertColumnar.Schema.builder()
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
                            .build()
                    )
                    .build()
            )
        println(namespaceUpsertResponse)
        namespaceUpsertResponse.validate()
    }
}
