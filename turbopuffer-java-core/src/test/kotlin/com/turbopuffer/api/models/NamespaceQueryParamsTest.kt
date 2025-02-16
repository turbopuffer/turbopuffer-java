// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceQueryParamsTest {

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
            .filter(JsonValue.from(mapOf<String, Any>()))
            .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
            .includeVectors(true)
            .rankBy(JsonValue.from(mapOf<String, Any>()))
            .topK(0L)
            .addVector(0.0)
            .build()
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
                .distanceMetric(NamespaceQueryParams.DistanceMetric.COSINE_DISTANCE)
                .filter(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(NamespaceQueryParams.IncludeAttributes.ofBool(true))
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
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
        assertThat(body._filter()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.includeAttributes())
            .contains(NamespaceQueryParams.IncludeAttributes.ofBool(true))
        assertThat(body.includeVectors()).contains(true)
        assertThat(body._rankBy()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.topK()).contains(0L)
        assertThat(body.vector()).contains(listOf(0.0))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceQueryParams.builder().namespace("namespace").build()
        val body = params._body()
        assertThat(body).isNotNull
    }

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
