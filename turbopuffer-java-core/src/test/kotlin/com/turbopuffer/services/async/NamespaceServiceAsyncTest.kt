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
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceRecallParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.Vector
import com.turbopuffer.models.namespaces.VectorEncoding
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
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
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
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
    fun hintCacheWarm() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.hintCacheWarm(
                NamespaceHintCacheWarmParams.builder().namespace("namespace").build()
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
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .rankBy(JsonValue.from(mapOf<String, Any>()))
                    .topK(0L)
                    .aggregateBy(JsonValue.from(mapOf<String, Any>()))
                    .consistency(
                        NamespaceQueryParams.Consistency.builder()
                            .level(NamespaceQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .includeAttributes(true)
                    .vectorEncoding(VectorEncoding.FLOAT)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun recall() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.recall(
                NamespaceRecallParams.builder()
                    .namespace("namespace")
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .num(0L)
                    .addQuery(0.0)
                    .topK(0L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(
                        NamespaceUpdateSchemaParams.Schema.builder()
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
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
                        DocumentColumns.builder()
                            .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
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
                            .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
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
