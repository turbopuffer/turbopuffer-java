// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
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
import com.turbopuffer.models.namespaces.Schema
import com.turbopuffer.models.namespaces.VectorEncoding
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NamespaceServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.deleteAll(
                NamespaceDeleteAllParams.builder().namespace("namespace").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun hintCacheWarm() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.hintCacheWarm(
                NamespaceHintCacheWarmParams.builder().namespace("namespace").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun multiQuery() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.multiQuery(
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

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.query(
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

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun recall() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.recall(
                NamespaceRecallParams.builder()
                    .namespace("namespace")
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .num(0L)
                    .addQuery(0.0)
                    .topK(0L)
                    .build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun schema() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.schema(NamespaceSchemaParams.builder().namespace("namespace").build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(
                        Schema.builder()
                            .put("foo", AttributeSchemaConfig.builder().type("string").build())
                            .build()
                    )
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .region("gcp-us-central1")
                .build()
        val namespaceService = client.namespace("ns")

        val response =
            namespaceService.write(
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
                            .put("id", listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .put("vector", listOf(listOf(0.0)))
                            .build()
                    )
                    .patchCondition(JsonValue.from(mapOf<String, Any>()))
                    .addPatchRow(
                        Row.builder()
                            .put("id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .put("vector", listOf(0.0))
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

        response.validate()
    }
}
