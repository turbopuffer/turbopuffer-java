// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.DocumentColumns
import com.turbopuffer.models.namespaces.DocumentRow
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceExportParams
import com.turbopuffer.models.namespaces.NamespaceGetSchemaParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceAsyncTest {

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

    @Test
    fun export() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.export(
                NamespaceExportParams.builder().namespace("namespace").cursor("cursor").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

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

    @Test
    fun multiQuery() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.multiQuery(
                NamespaceMultiQueryParams.builder()
                    .namespace("namespace")
                    .consistency(
                        NamespaceMultiQueryParams.Consistency.builder()
                            .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .addQuery(
                        NamespaceMultiQueryParams.Query.builder()
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .filtersOfJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))
                            .includeAttributes(true)
                            .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                            .topK(0L)
                            .build()
                    )
                    .vectorEncoding(NamespaceMultiQueryParams.VectorEncoding.FLOAT)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .consistency(
                        NamespaceQueryParams.Consistency.builder()
                            .level(NamespaceQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .filtersOfJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))
                    .includeAttributes(true)
                    .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                    .topK(0L)
                    .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .body(
                        NamespaceUpdateSchemaParams.Body.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    mapOf(
                                        "filterable" to true,
                                        "full_text_search" to true,
                                        "type" to "string",
                                    )
                                ),
                            )
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.write(
                NamespaceWriteParams.builder()
                    .namespace("namespace")
                    .copyFromNamespace("copy_from_namespace")
                    .deleteByFilter(JsonValue.from(mapOf<String, Any>()))
                    .addDelete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                        NamespaceWriteParams.Schema.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    mapOf(
                                        "filterable" to true,
                                        "full_text_search" to true,
                                        "type" to "string",
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

        val response = responseFuture.get()
        response.validate()
    }
}
