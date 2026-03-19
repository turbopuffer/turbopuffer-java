// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WritePerformanceTest {

    @Test
    fun create() {
        val writePerformance = WritePerformance.builder().serverTotalMs(0L).build()

        assertThat(writePerformance.serverTotalMs()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val writePerformance = WritePerformance.builder().serverTotalMs(0L).build()

        val roundtrippedWritePerformance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(writePerformance),
                jacksonTypeRef<WritePerformance>(),
            )

        assertThat(roundtrippedWritePerformance).isEqualTo(writePerformance)
    }
}
