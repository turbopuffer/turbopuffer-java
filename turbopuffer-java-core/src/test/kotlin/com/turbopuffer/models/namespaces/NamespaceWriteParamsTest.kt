// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceWriteParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceWriteParams.builder()
            .namespace("namespace")
            .copyFromNamespace("copy_from_namespace")
            .deleteByFilter(JsonValue.from(mapOf<String, Any>()))
            .addDelete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
            .encryption(
                NamespaceWriteParams.Encryption.builder()
                    .cmek(
                        NamespaceWriteParams.Encryption.Cmek.builder().keyName("key_name").build()
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceWriteParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.copyFromNamespace()).contains("copy_from_namespace")
        assertThat(body._deleteByFilter()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.deletes().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(body.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(body.encryption())
            .contains(
                NamespaceWriteParams.Encryption.builder()
                    .cmek(
                        NamespaceWriteParams.Encryption.Cmek.builder().keyName("key_name").build()
                    )
                    .build()
            )
        assertThat(body.patchColumns())
            .contains(
                DocumentColumns.builder()
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                    .build()
            )
        assertThat(body.patchRows().getOrNull())
            .containsExactly(
                DocumentRow.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfNumber(listOf(0.0))
                    .build()
            )
        assertThat(body.schema())
            .contains(
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
        assertThat(body.upsertColumns())
            .contains(
                DocumentColumns.builder()
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                    .build()
            )
        assertThat(body.upsertRows().getOrNull())
            .containsExactly(
                DocumentRow.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfNumber(listOf(0.0))
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceWriteParams.builder().build()

        val body = params._body()
    }
}
