// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FuzzyMaxEditDistanceTest {

    @Test
    fun create() {
        val fuzzyMaxEditDistance =
            FuzzyMaxEditDistance.builder().distance(0L).minQueryChars(0L).build()

        assertThat(fuzzyMaxEditDistance.distance()).isEqualTo(0L)
        assertThat(fuzzyMaxEditDistance.minQueryChars()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fuzzyMaxEditDistance =
            FuzzyMaxEditDistance.builder().distance(0L).minQueryChars(0L).build()

        val roundtrippedFuzzyMaxEditDistance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fuzzyMaxEditDistance),
                jacksonTypeRef<FuzzyMaxEditDistance>(),
            )

        assertThat(roundtrippedFuzzyMaxEditDistance).isEqualTo(fuzzyMaxEditDistance)
    }
}
