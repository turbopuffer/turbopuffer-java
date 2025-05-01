// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceListPageResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceListPageResponse =
            NamespaceListPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        assertThat(namespaceListPageResponse.namespaces().getOrNull())
            .containsExactly(NamespaceSummary.builder().id("id").build())
        assertThat(namespaceListPageResponse.nextCursor()).contains("next_cursor")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceListPageResponse =
            NamespaceListPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        val roundtrippedNamespaceListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceListPageResponse),
                jacksonTypeRef<NamespaceListPageResponse>(),
            )

        assertThat(roundtrippedNamespaceListPageResponse).isEqualTo(namespaceListPageResponse)
    }
}
