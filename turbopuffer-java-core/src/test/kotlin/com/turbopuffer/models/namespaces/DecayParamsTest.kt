// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DecayParamsTest {

    @Test
    fun create() {
        val decayParams =
            DecayParams.builder()
                .exponent(0.0)
                .midpoint(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(decayParams.exponent()).contains(0.0)
        assertThat(decayParams._midpoint()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val decayParams =
            DecayParams.builder()
                .exponent(0.0)
                .midpoint(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedDecayParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(decayParams),
                jacksonTypeRef<DecayParams>(),
            )

        assertThat(roundtrippedDecayParams).isEqualTo(decayParams)
    }
}
