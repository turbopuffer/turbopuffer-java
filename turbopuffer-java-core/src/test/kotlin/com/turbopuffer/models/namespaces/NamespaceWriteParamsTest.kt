// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceWriteParamsTest {

    @Test
    fun create() {
        NamespaceWriteParams.builder()
            .namespace("namespace")
            .copyFromNamespace("string")
            .deleteByFilter(JsonValue.from(mapOf<String, Any>()))
            .deleteCondition(JsonValue.from(mapOf<String, Any>()))
            .addDelete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .disableBackpressure(true)
            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
            .encryption(
                NamespaceWriteParams.Encryption.builder()
                    .cmek(
                        NamespaceWriteParams.Encryption.Cmek.builder().keyName("key_name").build()
                    )
                    .build()
            )
            .patchByFilter(
                NamespaceWriteParams.PatchByFilter.builder()
                    .filters(Filter.eq("attr", "value"))
                    .patch(
                        NamespaceWriteParams.PatchByFilter.Patch.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
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
    }

    @Test
    fun pathParams() {
        val params = NamespaceWriteParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceWriteParams.builder()
                .namespace("namespace")
                .copyFromNamespace("string")
                .deleteByFilter(JsonValue.from(mapOf<String, Any>()))
                .deleteCondition(JsonValue.from(mapOf<String, Any>()))
                .addDelete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .disableBackpressure(true)
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
                .patchByFilter(
                    NamespaceWriteParams.PatchByFilter.builder()
                        .filters(Filter.eq("attr", "value"))
                        .patch(
                            NamespaceWriteParams.PatchByFilter.Patch.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
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

        val body = params._body()

        assertThat(body.copyFromNamespace())
            .contains(NamespaceWriteParams.CopyFromNamespace.ofString("string"))
        assertThat(body._deleteByFilter()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body._deleteCondition()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.deletes().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(body.disableBackpressure()).contains(true)
        assertThat(body.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(body.encryption())
            .contains(
                NamespaceWriteParams.Encryption.builder()
                    .cmek(
                        NamespaceWriteParams.Encryption.Cmek.builder().keyName("key_name").build()
                    )
                    .build()
            )
        assertThat(body.patchByFilter())
            .contains(
                NamespaceWriteParams.PatchByFilter.builder()
                    .filters(Filter.eq("attr", "value"))
                    .patch(
                        NamespaceWriteParams.PatchByFilter.Patch.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(body.patchColumns())
            .contains(
                Columns.builder()
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                    .build()
            )
        assertThat(body._patchCondition()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.patchRows().getOrNull())
            .containsExactly(
                Row.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfNumber(listOf(0.0))
                    .build()
            )
        assertThat(body.schema())
            .contains(
                NamespaceWriteParams.Schema.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.upsertColumns())
            .contains(
                Columns.builder()
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                    .build()
            )
        assertThat(body._upsertCondition()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.upsertRows().getOrNull())
            .containsExactly(
                Row.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfNumber(listOf(0.0))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceWriteParams.builder().build()

        val body = params._body()
    }
}
