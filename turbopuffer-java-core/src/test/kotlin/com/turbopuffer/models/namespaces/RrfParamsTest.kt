// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RrfParamsTest {

    @Test
    fun create() {
        val rrfParams = RrfParams.builder().rankConstant(0L).build()

        assertThat(rrfParams.rankConstant()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rrfParams = RrfParams.builder().rankConstant(0L).build()

        val roundtrippedRrfParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rrfParams),
                jacksonTypeRef<RrfParams>(),
            )

        assertThat(roundtrippedRrfParams).isEqualTo(rrfParams)
    }
}
