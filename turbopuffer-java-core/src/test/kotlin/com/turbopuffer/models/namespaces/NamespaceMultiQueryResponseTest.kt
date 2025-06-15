// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceMultiQueryResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceMultiQueryResponse =
            NamespaceMultiQueryResponse.builder()
                .billing(
                    QueryBilling.builder()
                        .billableLogicalBytesQueried(0L)
                        .billableLogicalBytesReturned(0L)
                        .build()
                )
                .performance(
                    QueryPerformance.builder()
                        .approxNamespaceSize(0L)
                        .cacheHitRatio(0.0)
                        .cacheTemperature("cache_temperature")
                        .exhaustiveSearchCount(0L)
                        .queryExecutionMs(0L)
                        .serverTotalMs(0L)
                        .build()
                )
                .addResult(
                    NamespaceMultiQueryResponse.Result.builder()
                        .aggregations(
                            NamespaceMultiQueryResponse.Result.Aggregations.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addRow(
                            Row.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .vectorOfNumber(listOf(0.0))
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(namespaceMultiQueryResponse.billing())
            .isEqualTo(
                QueryBilling.builder()
                    .billableLogicalBytesQueried(0L)
                    .billableLogicalBytesReturned(0L)
                    .build()
            )
        assertThat(namespaceMultiQueryResponse.performance())
            .isEqualTo(
                QueryPerformance.builder()
                    .approxNamespaceSize(0L)
                    .cacheHitRatio(0.0)
                    .cacheTemperature("cache_temperature")
                    .exhaustiveSearchCount(0L)
                    .queryExecutionMs(0L)
                    .serverTotalMs(0L)
                    .build()
            )
        assertThat(namespaceMultiQueryResponse.results())
            .containsExactly(
                NamespaceMultiQueryResponse.Result.builder()
                    .aggregations(
                        NamespaceMultiQueryResponse.Result.Aggregations.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .addRow(
                        Row.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .vectorOfNumber(listOf(0.0))
                            .build()
                    )
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceMultiQueryResponse =
            NamespaceMultiQueryResponse.builder()
                .billing(
                    QueryBilling.builder()
                        .billableLogicalBytesQueried(0L)
                        .billableLogicalBytesReturned(0L)
                        .build()
                )
                .performance(
                    QueryPerformance.builder()
                        .approxNamespaceSize(0L)
                        .cacheHitRatio(0.0)
                        .cacheTemperature("cache_temperature")
                        .exhaustiveSearchCount(0L)
                        .queryExecutionMs(0L)
                        .serverTotalMs(0L)
                        .build()
                )
                .addResult(
                    NamespaceMultiQueryResponse.Result.builder()
                        .aggregations(
                            NamespaceMultiQueryResponse.Result.Aggregations.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addRow(
                            Row.builder()
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
