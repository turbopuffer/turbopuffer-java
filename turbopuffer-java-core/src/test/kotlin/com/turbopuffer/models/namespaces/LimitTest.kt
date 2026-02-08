// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LimitTest {

    @Test
    fun create() {
        val limit =
            Limit.builder()
                .total(0L)
                .per(Limit.Per.builder().addAttribute("string").limit(0L).build())
                .build()

        assertThat(limit.total()).isEqualTo(0L)
        assertThat(limit.per())
            .contains(Limit.Per.builder().addAttribute("string").limit(0L).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val limit =
            Limit.builder()
                .total(0L)
                .per(Limit.Per.builder().addAttribute("string").limit(0L).build())
                .build()

        val roundtrippedLimit =
            jsonMapper.readValue(jsonMapper.writeValueAsString(limit), jacksonTypeRef<Limit>())

        assertThat(roundtrippedLimit).isEqualTo(limit)
    }
}
