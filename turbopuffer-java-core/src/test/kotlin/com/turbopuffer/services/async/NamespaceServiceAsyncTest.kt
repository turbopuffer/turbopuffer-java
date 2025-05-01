// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.DocumentColumns
import com.turbopuffer.models.namespaces.DocumentRow
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceUpsertParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun list() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val pageFuture = namespaceServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getSchema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.getSchema(
                NamespaceGetSchemaParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val documentRowWithScoresFuture =
            namespaceServiceAsync.query(
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

        val documentRowWithScores = documentRowWithScoresFuture.get()
        documentRowWithScores.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun upsert() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.upsert(
                NamespaceUpsertParams.builder()
                    .namespace("namespace")
                    .documents(
                        NamespaceUpsertParams.Documents.Write.builder()
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
                                NamespaceUpsertParams.Documents.Write.Schema.builder()
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

        val response = responseFuture.get()
        response.validate()
    }
}
