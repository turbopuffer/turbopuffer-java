// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WriteBillingTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val writeBilling =
            WriteBilling.builder()
                .billableLogicalBytesWritten(0L)
                .query(
                    QueryBilling.builder()
                        .billableLogicalBytesQueried(0L)
                        .billableLogicalBytesReturned(0L)
                        .build()
                )
                .build()

        assertThat(writeBilling.billableLogicalBytesWritten()).isEqualTo(0L)
        assertThat(writeBilling.query())
            .contains(
                QueryBilling.builder()
                    .billableLogicalBytesQueried(0L)
                    .billableLogicalBytesReturned(0L)
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val writeBilling =
            WriteBilling.builder()
                .billableLogicalBytesWritten(0L)
                .query(
                    QueryBilling.builder()
                        .billableLogicalBytesQueried(0L)
                        .billableLogicalBytesReturned(0L)
                        .build()
                )
                .build()

        val roundtrippedWriteBilling =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(writeBilling),
                jacksonTypeRef<WriteBilling>(),
            )

        assertThat(roundtrippedWriteBilling).isEqualTo(writeBilling)
    }
}
