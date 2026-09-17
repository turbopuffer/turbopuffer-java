// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WriteResultTest {

    @Test
    fun create() {
        val writeResult =
            WriteResult.builder()
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
                .addDeletedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addPatchedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .performance(WritePerformance.builder().serverTotalMs(0L).build())
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsRemaining(true)
                .rowsUpserted(0L)
                .addUpsertedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(writeResult.billing())
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
        assertThat(writeResult.message()).isEqualTo("message")
        assertThat(writeResult.rowsAffected()).isEqualTo(0L)
        assertThat(writeResult.deletedIds().getOrNull())
            .containsExactly(Id.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(writeResult.patchedIds().getOrNull())
            .containsExactly(Id.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(writeResult.performance())
            .contains(WritePerformance.builder().serverTotalMs(0L).build())
        assertThat(writeResult.rowsDeleted()).contains(0L)
        assertThat(writeResult.rowsPatched()).contains(0L)
        assertThat(writeResult.rowsRemaining()).contains(true)
        assertThat(writeResult.rowsUpserted()).contains(0L)
        assertThat(writeResult.upsertedIds().getOrNull())
            .containsExactly(Id.from("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val writeResult =
            WriteResult.builder()
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
                .addDeletedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addPatchedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .performance(WritePerformance.builder().serverTotalMs(0L).build())
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsRemaining(true)
                .rowsUpserted(0L)
                .addUpsertedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val roundtrippedWriteResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(writeResult),
                jacksonTypeRef<WriteResult>(),
            )

        assertThat(roundtrippedWriteResult).isEqualTo(writeResult)
    }
}
