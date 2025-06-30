// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.AttributeSchemaConfig
import com.turbopuffer.models.namespaces.Columns
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceRecallParams
import com.turbopuffer.models.namespaces.NamespaceSchemaParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.Query
import com.turbopuffer.models.namespaces.Row
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.hintCacheWarm(
                NamespaceHintCacheWarmParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun multiQuery() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.multiQuery(
                NamespaceMultiQueryParams.builder()
                    .namespace("namespace")
                    .addQuery(
                        Query.builder()
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .includeAttributes(true)
                            .topK(0L)
                            .build()
                    )
                    .consistency(
                        NamespaceMultiQueryParams.Consistency.builder()
                            .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .vectorEncoding(VectorEncoding.FLOAT)
                    .build()
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .includeAttributes(true)
                    .topK(0L)
                    .consistency(
                        NamespaceQueryParams.Consistency.builder()
                            .level(NamespaceQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.recall(
                NamespaceRecallParams.builder()
                    .namespace("namespace")
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
    fun schema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.schema(
                NamespaceSchemaParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(mapOf("foo" to AttributeSchemaConfig.builder().type("string").build()))
                    .build()
            )

        val response = responseFuture.get()
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
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.write(
                NamespaceWriteParams.builder()
                    .namespace("namespace")
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
                            .put(
                                "id",
                                listOf(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")),
                            )
                            .put("vector", listOf(JsonValue.from(listOf(0.0))))
                            .build()
                    )
                    .addPatchRow(
                        Row.builder()
                            .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .put("vectorOfNumber", listOf(0.0))
                            .build()
                    )
                    .schema(
                        mapOf(
                            "id" to AttributeSchemaConfig.builder().type("uuid").build(),
                            "name" to
                                AttributeSchemaConfig.builder()
                                    .type("string")
                                    .filterable(false)
                                    .build(),
                            "age" to AttributeSchemaConfig.builder().type("uint").build(),
                        )
                    )
                    .upsertColumns(
                        Columns.builder()
                            .put("id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .put("vector", listOf(listOf(0.0)))
                            .build()
                    )
                    .addUpsertRow(
                        Row.builder()
                            .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .put("vector", listOf(0.0))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
