// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PinningConfigTest {

    @Test
    fun create() {
        val pinningConfig = PinningConfig.builder().replicas(1L).build()

        assertThat(pinningConfig.replicas()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pinningConfig = PinningConfig.builder().replicas(1L).build()

        val roundtrippedPinningConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(pinningConfig),
                jacksonTypeRef<PinningConfig>(),
            )

        assertThat(roundtrippedPinningConfig).isEqualTo(pinningConfig)
    }
}
