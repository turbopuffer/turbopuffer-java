// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceMultiQueryResponseTest {

    @Test
    fun create() {
        val namespaceMultiQueryResponse =
            NamespaceMultiQueryResponse.builder()
                .addResult(
                    NamespaceMultiQueryResponse.Result.builder()
                        .addAggregation(
                            NamespaceMultiQueryResponse.Result.Aggregation.builder()
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
                )
                .build()

        assertThat(namespaceMultiQueryResponse.results())
            .containsExactly(
                NamespaceMultiQueryResponse.Result.builder()
                    .addAggregation(
                        NamespaceMultiQueryResponse.Result.Aggregation.builder()
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceMultiQueryResponse =
            NamespaceMultiQueryResponse.builder()
                .addResult(
                    NamespaceMultiQueryResponse.Result.builder()
                        .addAggregation(
                            NamespaceMultiQueryResponse.Result.Aggregation.builder()
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
                )
                .build()

        val roundtrippedNamespaceMultiQueryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceMultiQueryResponse),
                jacksonTypeRef<NamespaceMultiQueryResponse>(),
            )

        assertThat(roundtrippedNamespaceMultiQueryResponse).isEqualTo(namespaceMultiQueryResponse)
    }
}
