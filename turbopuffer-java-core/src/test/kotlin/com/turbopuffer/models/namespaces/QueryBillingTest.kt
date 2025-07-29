// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryBillingTest {

    @Test
    fun create() {
        val queryBilling =
            QueryBilling.builder()
                .billableLogicalBytesQueried(0L)
                .billableLogicalBytesReturned(0L)
                .build()

        assertThat(queryBilling.billableLogicalBytesQueried()).isEqualTo(0L)
        assertThat(queryBilling.billableLogicalBytesReturned()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val queryBilling =
            QueryBilling.builder()
                .billableLogicalBytesQueried(0L)
                .billableLogicalBytesReturned(0L)
                .build()

        val roundtrippedQueryBilling =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(queryBilling),
                jacksonTypeRef<QueryBilling>(),
            )

        assertThat(roundtrippedQueryBilling).isEqualTo(queryBilling)
    }
}
