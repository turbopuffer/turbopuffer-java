// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FullTextSearchConfigTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createFullTextSearchConfig() {
        val fullTextSearchConfig =
            FullTextSearchConfig.builder()
                .caseSensitive(true)
                .language(FullTextSearchConfig.Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .build()
        assertThat(fullTextSearchConfig).isNotNull
        assertThat(fullTextSearchConfig.caseSensitive()).contains(true)
        assertThat(fullTextSearchConfig.language()).contains(FullTextSearchConfig.Language.ARABIC)
        assertThat(fullTextSearchConfig.removeStopwords()).contains(true)
        assertThat(fullTextSearchConfig.stemming()).contains(true)
    }
}
