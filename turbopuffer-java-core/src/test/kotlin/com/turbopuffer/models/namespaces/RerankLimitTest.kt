// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RerankLimitTest {

    @Test
    fun create() {
        val rerankLimit = RerankLimit.builder().total(0L).build()

        assertThat(rerankLimit.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rerankLimit = RerankLimit.builder().total(0L).build()

        val roundtrippedRerankLimit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rerankLimit),
                jacksonTypeRef<RerankLimit>(),
            )

        assertThat(roundtrippedRerankLimit).isEqualTo(rerankLimit)
    }
}
