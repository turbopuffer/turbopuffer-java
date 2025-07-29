// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceExplainQueryResponseTest {

    @Test
    fun create() {
        val namespaceExplainQueryResponse =
            NamespaceExplainQueryResponse.builder().planText("plan_text").build()

        assertThat(namespaceExplainQueryResponse.planText()).contains("plan_text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceExplainQueryResponse =
            NamespaceExplainQueryResponse.builder().planText("plan_text").build()

        val roundtrippedNamespaceExplainQueryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceExplainQueryResponse),
                jacksonTypeRef<NamespaceExplainQueryResponse>(),
            )

        assertThat(roundtrippedNamespaceExplainQueryResponse)
            .isEqualTo(namespaceExplainQueryResponse)
    }
}
