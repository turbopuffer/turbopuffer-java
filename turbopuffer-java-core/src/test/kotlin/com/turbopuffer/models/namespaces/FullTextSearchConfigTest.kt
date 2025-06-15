// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FullTextSearchConfigTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fullTextSearchConfig =
            FullTextSearchConfig.builder()
                .b(0.0)
                .caseSensitive(true)
                .k1(0.0)
                .language(Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .tokenizer(Tokenizer.PRE_TOKENIZED_ARRAY)
                .build()

        assertThat(fullTextSearchConfig.b()).contains(0.0)
        assertThat(fullTextSearchConfig.caseSensitive()).contains(true)
        assertThat(fullTextSearchConfig.k1()).contains(0.0)
        assertThat(fullTextSearchConfig.language()).contains(Language.ARABIC)
        assertThat(fullTextSearchConfig.removeStopwords()).contains(true)
        assertThat(fullTextSearchConfig.stemming()).contains(true)
        assertThat(fullTextSearchConfig.tokenizer()).contains(Tokenizer.PRE_TOKENIZED_ARRAY)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearchConfig =
            FullTextSearchConfig.builder()
                .b(0.0)
                .caseSensitive(true)
                .k1(0.0)
                .language(Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .tokenizer(Tokenizer.PRE_TOKENIZED_ARRAY)
                .build()

        val roundtrippedFullTextSearchConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearchConfig),
                jacksonTypeRef<FullTextSearchConfig>(),
            )

        assertThat(roundtrippedFullTextSearchConfig).isEqualTo(fullTextSearchConfig)
    }
}
