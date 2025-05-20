// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceQueryResponseTest {

    @Test
    fun create() {
        val namespaceQueryResponse =
            NamespaceQueryResponse.builder()
                .addAggregation(
                    NamespaceQueryResponse.Aggregation.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addRow(
                    DocumentRow.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .vectorOfNumber(listOf(0.0))
                        .build()
                )
                .build()

        assertThat(namespaceQueryResponse.aggregations().getOrNull())
            .containsExactly(
                NamespaceQueryResponse.Aggregation.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(namespaceQueryResponse.rows().getOrNull())
            .containsExactly(
                DocumentRow.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .vectorOfNumber(listOf(0.0))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceQueryResponse =
            NamespaceQueryResponse.builder()
                .addAggregation(
                    NamespaceQueryResponse.Aggregation.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addRow(
                    DocumentRow.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .vectorOfNumber(listOf(0.0))
                        .build()
                )
                .build()

        val roundtrippedNamespaceQueryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceQueryResponse),
                jacksonTypeRef<NamespaceQueryResponse>(),
            )

        assertThat(roundtrippedNamespaceQueryResponse).isEqualTo(namespaceQueryResponse)
    }
}
