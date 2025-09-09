// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.async

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync
import com.turbopuffer.core.JsonValue
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
import com.turbopuffer.models.namespaces.Vector
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
        val namespaceServiceAsync = client.namespaces()

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
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.explainQuery(
                NamespaceExplainQueryParams.builder()
                    .namespace("namespace")
                    .aggregateBy(
                        Query.AggregateBy.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .addExcludeAttribute("string")
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .addGroupBy("string")
                    .includeAttributes(true)
                    .rankBy(JsonValue.from(mapOf<String, Any>()))
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
        val namespaceServiceAsync = client.namespaces()

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
        val namespaceServiceAsync = client.namespaces()

        val namespaceMetadataFuture =
            namespaceServiceAsync.metadata(
                NamespaceMetadataParams.builder().namespace("namespace").build()
            )

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
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.multiQuery(
                NamespaceMultiQueryParams.builder()
                    .namespace("namespace")
                    .addQuery(
                        Query.builder()
                            .aggregateBy(
                                Query.AggregateBy.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                            .addExcludeAttribute("string")
                            .filters(JsonValue.from(mapOf<String, Any>()))
                            .addGroupBy("string")
                            .includeAttributes(true)
                            .rankBy(JsonValue.from(mapOf<String, Any>()))
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
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.query(
                NamespaceQueryParams.builder()
                    .namespace("namespace")
                    .aggregateBy(
                        Query.AggregateBy.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .addExcludeAttribute("string")
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .addGroupBy("string")
                    .includeAttributes(true)
                    .rankBy(JsonValue.from(mapOf<String, Any>()))
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
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.recall(
                NamespaceRecallParams.builder()
                    .namespace("namespace")
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .includeGroundTruth(true)
                    .num(0L)
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
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.schema(
                NamespaceSchemaParams.builder().namespace("namespace").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(
                        NamespaceUpdateSchemaParams.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceServiceAsync = client.namespaces()

        val responseFuture =
            namespaceServiceAsync.write(
                NamespaceWriteParams.builder()
                    .namespace("namespace")
                    .copyFromNamespace("copy_from_namespace")
                    .deleteByFilter(JsonValue.from(mapOf<String, Any>()))
                    .deleteCondition(JsonValue.from(mapOf<String, Any>()))
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
                            .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                            .build()
                    )
                    .patchCondition(JsonValue.from(mapOf<String, Any>()))
                    .addPatchRow(
                        Row.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vectorOfNumber(listOf(0.0))
                            .build()
                    )
                    .schema(
                        NamespaceWriteParams.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .upsertColumns(
                        Columns.builder()
                            .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                            .build()
                    )
                    .upsertCondition(JsonValue.from(mapOf<String, Any>()))
                    .addUpsertRow(
                        Row.builder()
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
