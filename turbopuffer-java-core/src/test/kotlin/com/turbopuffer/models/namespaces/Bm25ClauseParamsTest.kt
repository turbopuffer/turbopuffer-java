// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Bm25ClauseParamsTest {

    @Test
    fun create() {
        val bm25ClauseParams = Bm25ClauseParams.builder().lastAsPrefix(true).build()

        assertThat(bm25ClauseParams.lastAsPrefix()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bm25ClauseParams = Bm25ClauseParams.builder().lastAsPrefix(true).build()

        val roundtrippedBm25ClauseParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bm25ClauseParams),
                jacksonTypeRef<Bm25ClauseParams>(),
            )

        assertThat(roundtrippedBm25ClauseParams).isEqualTo(bm25ClauseParams)
    }
}
