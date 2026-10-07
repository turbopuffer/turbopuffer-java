// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryPerformanceTest {

    @Test
    fun create() {
        val queryPerformance =
            QueryPerformance.builder()
                .approxNamespaceSize(0L)
                .cacheHitRatio(0.0)
                .cacheTemperature("cache_temperature")
                .exhaustiveSearchCount(0L)
                .queryExecutionMs(0L)
                .serverTotalMs(0L)
                .embeddingMs(0L)
                .embeddingTokens(0L)
                .lastIncludedWriteAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(queryPerformance.approxNamespaceSize()).isEqualTo(0L)
        assertThat(queryPerformance.cacheHitRatio()).isEqualTo(0.0)
        assertThat(queryPerformance.cacheTemperature()).isEqualTo("cache_temperature")
        assertThat(queryPerformance.exhaustiveSearchCount()).isEqualTo(0L)
        assertThat(queryPerformance.queryExecutionMs()).isEqualTo(0L)
        assertThat(queryPerformance.serverTotalMs()).isEqualTo(0L)
        assertThat(queryPerformance.embeddingMs()).contains(0L)
        assertThat(queryPerformance.embeddingTokens()).contains(0L)
        assertThat(queryPerformance.lastIncludedWriteAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val queryPerformance =
            QueryPerformance.builder()
                .approxNamespaceSize(0L)
                .cacheHitRatio(0.0)
                .cacheTemperature("cache_temperature")
                .exhaustiveSearchCount(0L)
                .queryExecutionMs(0L)
                .serverTotalMs(0L)
                .embeddingMs(0L)
                .embeddingTokens(0L)
                .lastIncludedWriteAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedQueryPerformance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(queryPerformance),
                jacksonTypeRef<QueryPerformance>(),
            )

        assertThat(roundtrippedQueryPerformance).isEqualTo(queryPerformance)
    }
}
