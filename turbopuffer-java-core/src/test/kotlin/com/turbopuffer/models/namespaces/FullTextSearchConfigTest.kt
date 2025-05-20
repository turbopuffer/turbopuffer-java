// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FullTextSearchConfigTest {

    @Test
    fun create() {
        val fullTextSearchConfig =
            FullTextSearchConfig.builder()
                .caseSensitive(true)
                .language(FullTextSearchConfig.Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .build()

        assertThat(fullTextSearchConfig.caseSensitive()).contains(true)
        assertThat(fullTextSearchConfig.language()).contains(FullTextSearchConfig.Language.ARABIC)
        assertThat(fullTextSearchConfig.removeStopwords()).contains(true)
        assertThat(fullTextSearchConfig.stemming()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearchConfig =
            FullTextSearchConfig.builder()
                .caseSensitive(true)
                .language(FullTextSearchConfig.Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .build()

        val roundtrippedFullTextSearchConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearchConfig),
                jacksonTypeRef<FullTextSearchConfig>(),
            )

        assertThat(roundtrippedFullTextSearchConfig).isEqualTo(fullTextSearchConfig)
    }
}
