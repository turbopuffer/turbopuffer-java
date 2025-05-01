// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceUpsertParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceUpsertParams.builder().namespace("namespace").build()

        assertThat(params._pathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
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

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                NamespaceUpsertParams.Documents.ofWrite(
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
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceUpsertParams.builder().namespace("namespace").build()

        val body = params._body().getOrNull()
    }
}
