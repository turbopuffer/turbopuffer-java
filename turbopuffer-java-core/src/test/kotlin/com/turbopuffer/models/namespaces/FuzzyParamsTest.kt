// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FuzzyParamsTest {

    @Test
    fun create() {
        val fuzzyParams =
            FuzzyParams.builder()
                .addMaxEditDistance(
                    FuzzyMaxEditDistance.builder().distance(0L).minQueryChars(0L).build()
                )
                .build()

        assertThat(fuzzyParams.maxEditDistance())
            .containsExactly(FuzzyMaxEditDistance.builder().distance(0L).minQueryChars(0L).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fuzzyParams =
            FuzzyParams.builder()
                .addMaxEditDistance(
                    FuzzyMaxEditDistance.builder().distance(0L).minQueryChars(0L).build()
                )
                .build()

        val roundtrippedFuzzyParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fuzzyParams),
                jacksonTypeRef<FuzzyParams>(),
            )

        assertThat(roundtrippedFuzzyParams).isEqualTo(fuzzyParams)
    }
}
