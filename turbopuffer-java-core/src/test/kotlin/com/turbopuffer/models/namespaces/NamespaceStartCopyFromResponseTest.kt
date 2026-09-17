// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceStartCopyFromResponseTest {

    @Test
    fun create() {
        val namespaceStartCopyFromResponse =
            NamespaceStartCopyFromResponse.builder().token("token").build()

        assertThat(namespaceStartCopyFromResponse.token()).isEqualTo("token")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceStartCopyFromResponse =
            NamespaceStartCopyFromResponse.builder().token("token").build()

        val roundtrippedNamespaceStartCopyFromResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceStartCopyFromResponse),
                jacksonTypeRef<NamespaceStartCopyFromResponse>(),
            )

        assertThat(roundtrippedNamespaceStartCopyFromResponse)
            .isEqualTo(namespaceStartCopyFromResponse)
    }
}
