// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainsAnyTokenFilterParamsTest {

    @Test
    fun create() {
        val containsAnyTokenFilterParams =
            ContainsAnyTokenFilterParams.builder().lastAsPrefix(true).build()

        assertThat(containsAnyTokenFilterParams.lastAsPrefix()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containsAnyTokenFilterParams =
            ContainsAnyTokenFilterParams.builder().lastAsPrefix(true).build()

        val roundtrippedContainsAnyTokenFilterParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containsAnyTokenFilterParams),
                jacksonTypeRef<ContainsAnyTokenFilterParams>(),
            )

        assertThat(roundtrippedContainsAnyTokenFilterParams).isEqualTo(containsAnyTokenFilterParams)
    }
}
