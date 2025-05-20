// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceQueryParamsTest {

    @Test
    fun create() {
        NamespaceQueryParams.builder()
            .namespace("namespace")
            .consistency(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
            .filtersOfJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))
            .includeAttributes(true)
            .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
            .topK(0L)
            .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceQueryParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

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
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .filtersOfJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))
                .includeAttributes(true)
                .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                .topK(0L)
                .vectorEncoding(NamespaceQueryParams.VectorEncoding.FLOAT)
                .build()

        val body = params._body()

        assertThat(body.consistency())
            .contains(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(body.filters())
            .contains(
                NamespaceQueryParams.Filters.ofJsonValues(
                    listOf(JsonValue.from(mapOf<String, Any>()))
                )
            )
        assertThat(body.includeAttributes())
            .contains(NamespaceQueryParams.IncludeAttributes.ofBool(true))
        assertThat(body.rankBy())
            .contains(
                NamespaceQueryParams.RankBy.ofVector(listOf(JsonValue.from(mapOf<String, Any>())))
            )
        assertThat(body.topK()).contains(0L)
        assertThat(body.vectorEncoding()).contains(NamespaceQueryParams.VectorEncoding.FLOAT)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceQueryParams.builder().build()

        val body = params._body()
    }
}
