// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.DocumentColumns
import com.turbopuffer.models.namespaces.DocumentRow
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val page = namespaceService.list()

        page.response().validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getSchema() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.getSchema(
                NamespaceGetSchemaParams.builder().namespace("namespace").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val documentRowWithScores =
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
                    .build()
            )

        documentRowWithScores.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.write(
                NamespaceWriteParams.builder()
                    .namespace("namespace")
                    .write(
                        NamespaceWriteParams.Write.InnerWrite.builder()
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
                                NamespaceWriteParams.Write.InnerWrite.Schema.builder()
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
                    .build()
            )

        response.validate()
    }
}
