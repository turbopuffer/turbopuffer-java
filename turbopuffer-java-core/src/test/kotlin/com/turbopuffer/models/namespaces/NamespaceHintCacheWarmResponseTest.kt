// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceHintCacheWarmResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceHintCacheWarmResponse =
            NamespaceHintCacheWarmResponse.builder().message("message").build()

        assertThat(namespaceHintCacheWarmResponse.message()).contains("message")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceHintCacheWarmResponse =
            NamespaceHintCacheWarmResponse.builder().message("message").build()

        val roundtrippedNamespaceHintCacheWarmResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceHintCacheWarmResponse),
                jacksonTypeRef<NamespaceHintCacheWarmResponse>(),
            )

        assertThat(roundtrippedNamespaceHintCacheWarmResponse)
            .isEqualTo(namespaceHintCacheWarmResponse)
    }
}
