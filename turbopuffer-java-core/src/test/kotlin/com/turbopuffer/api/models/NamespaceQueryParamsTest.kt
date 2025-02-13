// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceQueryParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceQueryParams.builder()
            .namespace("namespace")
            .consistency(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
            .filters(NamespaceQueryParams.Filters.ofJsonValue(JsonValue.from(mapOf<String, Any>())))
            .includeAttributesOfStrings(listOf("string"))
            .includeVectors(true)
            .addRankBy("string")
            .topK(0L)
            .addVector(0.0)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filters(
                    NamespaceQueryParams.Filters.ofJsonValue(JsonValue.from(mapOf<String, Any>()))
                )
                .includeAttributesOfStrings(listOf("string"))
                .includeVectors(true)
                .addRankBy("string")
                .topK(0L)
                .addVector(0.0)
                .build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body.consistency())
            .contains(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.distanceMetric())
            .contains(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
        assertThat(body.filters())
            .contains(
                NamespaceQueryParams.Filters.ofJsonValue(JsonValue.from(mapOf<String, Any>()))
            )
        assertThat(body.includeAttributes())
            .contains(NamespaceQueryParams.IncludeAttributes.ofStrings(listOf("string")))
        assertThat(body.includeVectors()).contains(true)
        assertThat(body.rankBy()).contains(listOf("string"))
        assertThat(body.topK()).contains(0L)
        assertThat(body.vector()).contains(listOf(0.0))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceQueryParams.builder().namespace("namespace").build()
        val body = params._body()
        assertThat(body).isNotNull
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getPathParam() {
        val params = NamespaceQueryParams.builder().namespace("namespace").build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
