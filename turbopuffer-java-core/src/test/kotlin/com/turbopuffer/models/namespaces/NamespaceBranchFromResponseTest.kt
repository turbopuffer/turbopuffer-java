// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceBranchFromResponseTest {

    @Test
    fun create() {
        val namespaceBranchFromResponse =
            NamespaceBranchFromResponse.builder()
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

        assertThat(namespaceBranchFromResponse.billing())
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
        assertThat(namespaceBranchFromResponse.message()).isEqualTo("message")
        assertThat(namespaceBranchFromResponse.rowsAffected()).isEqualTo(0L)
        assertThat(namespaceBranchFromResponse.deletedIds().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(namespaceBranchFromResponse.patchedIds().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(namespaceBranchFromResponse.performance())
            .contains(WritePerformance.builder().serverTotalMs(0L).build())
        assertThat(namespaceBranchFromResponse.rowsDeleted()).contains(0L)
        assertThat(namespaceBranchFromResponse.rowsPatched()).contains(0L)
        assertThat(namespaceBranchFromResponse.rowsRemaining()).contains(true)
        assertThat(namespaceBranchFromResponse.rowsUpserted()).contains(0L)
        assertThat(namespaceBranchFromResponse.upsertedIds().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceBranchFromResponse =
            NamespaceBranchFromResponse.builder()
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

        val roundtrippedNamespaceBranchFromResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceBranchFromResponse),
                jacksonTypeRef<NamespaceBranchFromResponse>(),
            )

        assertThat(roundtrippedNamespaceBranchFromResponse).isEqualTo(namespaceBranchFromResponse)
    }
}
