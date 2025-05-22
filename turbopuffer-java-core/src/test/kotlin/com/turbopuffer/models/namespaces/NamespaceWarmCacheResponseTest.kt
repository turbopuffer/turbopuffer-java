// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceWarmCacheResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceWarmCacheResponse =
            NamespaceWarmCacheResponse.builder()
                .status(NamespaceWarmCacheResponse.Status.OK)
                .message("message")
                .build()

        assertThat(namespaceWarmCacheResponse.status())
            .isEqualTo(NamespaceWarmCacheResponse.Status.OK)
        assertThat(namespaceWarmCacheResponse.message()).contains("message")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceWarmCacheResponse =
            NamespaceWarmCacheResponse.builder()
                .status(NamespaceWarmCacheResponse.Status.OK)
                .message("message")
                .build()

        val roundtrippedNamespaceWarmCacheResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceWarmCacheResponse),
                jacksonTypeRef<NamespaceWarmCacheResponse>(),
            )

        assertThat(roundtrippedNamespaceWarmCacheResponse).isEqualTo(namespaceWarmCacheResponse)
    }
}
