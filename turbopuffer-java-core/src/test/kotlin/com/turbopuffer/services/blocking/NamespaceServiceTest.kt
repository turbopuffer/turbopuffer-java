// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.services.blocking

import com.turbopuffer.TestServerExtension
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient
import com.turbopuffer.core.JsonValue
import com.turbopuffer.models.namespaces.Columns
import com.turbopuffer.models.namespaces.DistanceMetric
import com.turbopuffer.models.namespaces.NamespaceDeleteAllParams
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
internal class NamespaceServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun deleteAll() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
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
    fun hintCacheWarm() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.hintCacheWarm(
                NamespaceHintCacheWarmParams.builder().namespace("namespace").build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun metadata() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val namespaceMetadata =
            namespaceService.metadata(
                NamespaceMetadataParams.builder().namespace("namespace").build()
            )

        namespaceMetadata.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun multiQuery() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.multiQuery(
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

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun query() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.query(
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

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun recall() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

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
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.schema(NamespaceSchemaParams.builder().namespace("namespace").build())

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun updateSchema() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.updateSchema(
                NamespaceUpdateSchemaParams.builder()
                    .namespace("namespace")
                    .schema(
                        NamespaceUpdateSchemaParams.Schema.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun write() {
        val client =
            TurbopufferOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("tpuf_A1...")
                .build()
        val namespaceService = client.namespaces()

        val response =
            namespaceService.write(
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

        response.validate()
    }
}
