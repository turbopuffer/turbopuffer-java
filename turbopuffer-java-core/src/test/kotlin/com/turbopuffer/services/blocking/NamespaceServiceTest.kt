// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.DistanceMetric
import com.turbopuffer.models.DocumentColumns
import com.turbopuffer.models.NamespaceDeleteAllParams
import com.turbopuffer.models.NamespaceGetSchemaParams
import com.turbopuffer.models.NamespaceQueryParams
import com.turbopuffer.models.NamespaceUpsertParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class NamespaceServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun callList() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()
        val response = namespaceService.list()
        println(response)
        response.namespaces().forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
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

    @Disabled("skipped: tests are disabled for the time being")
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

    @Disabled("skipped: tests are disabled for the time being")
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
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .filter(JsonValue.from(mapOf<String, Any>()))
                    .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                    .includeVectors(true)
                    .rankBy(JsonValue.from(mapOf<String, Any>()))
                    .topK(0L)
                    .addVector(0.0)
                    .build()
            )
        println(namespaceQueryResponse)
    }

    @Disabled("skipped: tests are disabled for the time being")
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
                    .documents(
                        NamespaceUpsertParams.Documents.UpsertColumnar.builder()
                            .attributes(
                                DocumentColumns.Attributes.builder()
                                    .putAdditionalProperty(
                                        "foo",
                                        JsonValue.from(listOf(mapOf("foo" to "bar"))),
                                    )
                                    .build()
                            )
                            .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .addVector(listOf(0.0))
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .schema(
                                NamespaceUpsertParams.Documents.UpsertColumnar.Schema.builder()
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
