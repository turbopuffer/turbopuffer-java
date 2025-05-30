// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceQueryResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceQueryResponse =
            NamespaceQueryResponse.builder()
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
                .aggregations(
                    NamespaceQueryResponse.Aggregations.builder()
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

        assertThat(namespaceQueryResponse.billing())
            .isEqualTo(
                QueryBilling.builder()
                    .billableLogicalBytesQueried(0L)
                    .billableLogicalBytesReturned(0L)
                    .build()
            )
        assertThat(namespaceQueryResponse.performance())
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
        assertThat(namespaceQueryResponse.aggregations())
            .contains(
                NamespaceQueryResponse.Aggregations.builder()
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceQueryResponse =
            NamespaceQueryResponse.builder()
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
                .aggregations(
                    NamespaceQueryResponse.Aggregations.builder()
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
