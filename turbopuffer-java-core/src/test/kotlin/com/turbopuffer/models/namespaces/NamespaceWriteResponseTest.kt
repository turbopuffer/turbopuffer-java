// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
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
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsUpserted(0L)
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
        assertThat(namespaceWriteResponse.rowsDeleted()).contains(0L)
        assertThat(namespaceWriteResponse.rowsPatched()).contains(0L)
        assertThat(namespaceWriteResponse.rowsUpserted()).contains(0L)
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
                .rowsDeleted(0L)
                .rowsPatched(0L)
                .rowsUpserted(0L)
                .build()

        val roundtrippedNamespaceWriteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceWriteResponse),
                jacksonTypeRef<NamespaceWriteResponse>(),
            )

        assertThat(roundtrippedNamespaceWriteResponse).isEqualTo(namespaceWriteResponse)
    }
}
