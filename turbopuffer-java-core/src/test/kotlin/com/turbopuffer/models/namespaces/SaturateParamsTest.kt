// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SaturateParamsTest {

    @Test
    fun create() {
        val saturateParams =
            SaturateParams.builder()
                .exponent(0.0)
                .midpoint(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(saturateParams.exponent()).contains(0.0)
        assertThat(saturateParams._midpoint()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val saturateParams =
            SaturateParams.builder()
                .exponent(0.0)
                .midpoint(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedSaturateParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(saturateParams),
                jacksonTypeRef<SaturateParams>(),
            )

        assertThat(roundtrippedSaturateParams).isEqualTo(saturateParams)
    }
}
