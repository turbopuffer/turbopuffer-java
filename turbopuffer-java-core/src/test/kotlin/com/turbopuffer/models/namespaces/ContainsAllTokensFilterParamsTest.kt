// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainsAllTokensFilterParamsTest {

    @Test
    fun create() {
        val containsAllTokensFilterParams =
            ContainsAllTokensFilterParams.builder().lastAsPrefix(true).build()

        assertThat(containsAllTokensFilterParams.lastAsPrefix()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containsAllTokensFilterParams =
            ContainsAllTokensFilterParams.builder().lastAsPrefix(true).build()

        val roundtrippedContainsAllTokensFilterParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containsAllTokensFilterParams),
                jacksonTypeRef<ContainsAllTokensFilterParams>(),
            )

        assertThat(roundtrippedContainsAllTokensFilterParams)
            .isEqualTo(containsAllTokensFilterParams)
    }
}
