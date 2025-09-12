// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.AttributeSchemaConfig
import com.turbopuffer.models.namespaces.Columns
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
import com.turbopuffer.models.namespaces.NamespaceExplainQueryParams
import com.turbopuffer.models.namespaces.NamespaceHintCacheWarmParams
import com.turbopuffer.models.namespaces.NamespaceMetadataParams
import com.turbopuffer.models.namespaces.NamespaceMultiQueryParams
import com.turbopuffer.models.namespaces.NamespaceQueryParams
import com.turbopuffer.models.namespaces.NamespaceRecallParams
import com.turbopuffer.models.namespaces.NamespaceSchemaParams
import com.turbopuffer.models.namespaces.NamespaceUpdateSchemaParams
import com.turbopuffer.models.namespaces.NamespaceWriteParams
import com.turbopuffer.models.namespaces.Query
import com.turbopuffer.models.namespaces.Row
import com.turbopuffer.models.namespaces.Schema
import com.turbopuffer.models.namespaces.VectorEncoding
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun explainQuery() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.explainQuery(
                NamespaceExplainQueryParams.builder()
                    .namespace("namespace")
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .addExcludeAttribute("string")
                    .includeAttributes(true)
                    .topK(0L)
                    .consistency(
                        NamespaceExplainQueryParams.Consistency.builder()
                            .level(NamespaceExplainQueryParams.Consistency.Level.STRONG)
                            .build()
                    )
                    .vectorEncoding(VectorEncoding.FLOAT)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun hintCacheWarm() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.hintCacheWarm(
                NamespaceHintCacheWarmParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun metadata() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val namespaceMetadataFuture =
            namespaceServiceAsync.metadata(NamespaceMetadataParams.builder().build())

        val namespaceMetadata = namespaceMetadataFuture.get()
        namespaceMetadata.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun multiQuery() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.multiQuery(
                NamespaceMultiQueryParams.builder()
                    .namespace("namespace")
                    .addQuery(
                        Query.builder()
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .addExcludeAttribute("string")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .addExcludeAttribute("string")
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

    @Disabled("Prism tests are disabled")
    @Test
    fun recall() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.recall(
                NamespaceRecallParams.builder()
                    .namespace("namespace")
                    .num(0L)
                    .includeGroundTruth(true)
                    .addQuery(0.0)
                    .topK(0L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun schema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.schema(
                NamespaceSchemaParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespace("ns")

        val responseFuture =
            namespaceServiceAsync.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(
                        Schema.builder()
                            .put("foo", AttributeSchemaConfig.builder().type("string").build())
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
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
                    .patchCondition(JsonValue.from(mapOf<String, Any>()))
                    .addPatchRow(
                        Row.builder()
                            .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .put("vectorOfNumber", listOf(0.0))
                            .build()
                    )
                    .schema(
                        Schema.builder()
                            .put("id", AttributeSchemaConfig.builder().type("uuid").build())
                            .put(
                                "name",
                                AttributeSchemaConfig.builder()
                                    .type("string")
                                    .filterable(false)
                                    .build(),
                            )
                            .put("age", AttributeSchemaConfig.builder().type("uint").build())
                            .build()
                    )
                    .upsertColumns(
                        Columns.builder()
                            .put("id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .put("vector", listOf(listOf(0.0)))
                            .build()
                    )
                    .upsertCondition(JsonValue.from(mapOf<String, Any>()))
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
