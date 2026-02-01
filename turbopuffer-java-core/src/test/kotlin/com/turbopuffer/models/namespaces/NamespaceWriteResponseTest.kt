// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceWriteResponseTest {

    @Test
    fun create() {
        val namespaceWriteResponse =
            NamespaceWriteResponse.builder()
                .billing(
                    WriteBilling.builder()
                        .billableLogicalBytesWritten(0L)
                        .query(
                            QueryBilling.builder()
                                .billableLogicalBytesQueried(0L)
                                .billableLogicalBytesReturned(0L)
                                .build()
                        )
                        .build()
                )
                .message("message")
                .rowsAffected(0L)
                .addDeletedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .addPatchedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsRemaining(true)
                .rowsUpserted(0L)
                .addUpsertedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .build()

        assertThat(namespaceWriteResponse.billing())
            .isEqualTo(
                WriteBilling.builder()
                    .billableLogicalBytesWritten(0L)
                    .query(
                        QueryBilling.builder()
                            .billableLogicalBytesQueried(0L)
                            .billableLogicalBytesReturned(0L)
                            .build()
                    )
                    .build()
            )
        assertThat(namespaceWriteResponse.message()).isEqualTo("message")
        assertThat(namespaceWriteResponse.rowsAffected()).isEqualTo(0L)
        assertThat(namespaceWriteResponse.deletedIds().getOrNull())
            .containsExactly(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(namespaceWriteResponse.patchedIds().getOrNull())
            .containsExactly(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(namespaceWriteResponse.rowsDeleted()).contains(0L)
        assertThat(namespaceWriteResponse.rowsPatched()).contains(0L)
        assertThat(namespaceWriteResponse.rowsRemaining()).contains(true)
        assertThat(namespaceWriteResponse.rowsUpserted()).contains(0L)
        assertThat(namespaceWriteResponse.upsertedIds().getOrNull())
            .containsExactly(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceWriteResponse =
            NamespaceWriteResponse.builder()
                .billing(
                    WriteBilling.builder()
                        .billableLogicalBytesWritten(0L)
                        .query(
                            QueryBilling.builder()
                                .billableLogicalBytesQueried(0L)
                                .billableLogicalBytesReturned(0L)
                                .build()
                        )
                        .build()
                )
                .message("message")
                .rowsAffected(0L)
                .addDeletedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .addPatchedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsRemaining(true)
                .rowsUpserted(0L)
                .addUpsertedId(JsonValue.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .build()

        val roundtrippedNamespaceWriteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceWriteResponse),
                jacksonTypeRef<NamespaceWriteResponse>(),
            )

        assertThat(roundtrippedNamespaceWriteResponse).isEqualTo(namespaceWriteResponse)
    }
}
