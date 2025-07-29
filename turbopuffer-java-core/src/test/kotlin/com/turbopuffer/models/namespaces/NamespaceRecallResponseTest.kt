// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceRecallResponseTest {

    @Test
    fun create() {
        val namespaceRecallResponse =
            NamespaceRecallResponse.builder()
                .avgAnnCount(0.0)
                .avgExhaustiveCount(0.0)
                .avgRecall(0.0)
                .build()

        assertThat(namespaceRecallResponse.avgAnnCount()).isEqualTo(0.0)
        assertThat(namespaceRecallResponse.avgExhaustiveCount()).isEqualTo(0.0)
        assertThat(namespaceRecallResponse.avgRecall()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceRecallResponse =
            NamespaceRecallResponse.builder()
                .avgAnnCount(0.0)
                .avgExhaustiveCount(0.0)
                .avgRecall(0.0)
                .build()

        val roundtrippedNamespaceRecallResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceRecallResponse),
                jacksonTypeRef<NamespaceRecallResponse>(),
            )

        assertThat(roundtrippedNamespaceRecallResponse).isEqualTo(namespaceRecallResponse)
    }
}
