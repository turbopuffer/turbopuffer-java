// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RrfParamsTest {

    @Test
    fun create() {
        val rrfParams = RrfParams.builder().rankConstant(0L).addWeight(1.0f).build()

        assertThat(rrfParams.rankConstant()).contains(0L)
        assertThat(rrfParams.weights().getOrNull()).containsExactly(1.0f)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rrfParams = RrfParams.builder().rankConstant(0L).addWeight(1.0f).build()

        val roundtrippedRrfParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rrfParams),
                jacksonTypeRef<RrfParams>(),
            )

        assertThat(roundtrippedRrfParams).isEqualTo(rrfParams)
    }
}
