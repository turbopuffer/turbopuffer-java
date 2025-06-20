// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class QueryTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val query =
            Query.builder()
                .aggregateBy(
                    Query.AggregateBy.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .filters(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .build()

        assertThat(query.aggregateBy())
            .contains(
                Query.AggregateBy.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(query.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(query._filters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(query.includeAttributes()).contains(IncludeAttributes.ofBool(true))
        assertThat(query._rankBy()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(query.topK()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val query =
            Query.builder()
                .aggregateBy(
                    Query.AggregateBy.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .filters(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .build()

        val roundtrippedQuery =
            jsonMapper.readValue(jsonMapper.writeValueAsString(query), jacksonTypeRef<Query>())

        assertThat(roundtrippedQuery).isEqualTo(query)
    }
}
