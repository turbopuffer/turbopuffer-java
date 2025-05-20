// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceDeleteAllResponseTest {

    @Test
    fun create() {
        val namespaceDeleteAllResponse =
            NamespaceDeleteAllResponse.builder()
                .status(NamespaceDeleteAllResponse.Status.OK)
                .build()

        assertThat(namespaceDeleteAllResponse.status())
            .isEqualTo(NamespaceDeleteAllResponse.Status.OK)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceDeleteAllResponse =
            NamespaceDeleteAllResponse.builder()
                .status(NamespaceDeleteAllResponse.Status.OK)
                .build()

        val roundtrippedNamespaceDeleteAllResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceDeleteAllResponse),
                jacksonTypeRef<NamespaceDeleteAllResponse>(),
            )

        assertThat(roundtrippedNamespaceDeleteAllResponse).isEqualTo(namespaceDeleteAllResponse)
    }
}
