// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceQueryParamsTest {

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
            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
            .filters(JsonValue.from(mapOf<String, Any>()))
            .includeAttributes(true)
            .includeVectors(true)
            .rankBy(JsonValue.from(mapOf<String, Any>()))
            .topK(0L)
            .addVector(0.0)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceQueryParams.builder().namespace("namespace").build()

        assertThat(params._pathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
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
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .filters(JsonValue.from(mapOf<String, Any>()))
                .includeAttributes(true)
                .includeVectors(true)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .addVector(0.0)
                .build()

        val body = params._body()

        assertThat(body.consistency())
            .contains(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(body._filters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.includeAttributes())
            .contains(NamespaceQueryParams.IncludeAttributes.ofBool(true))
        assertThat(body.includeVectors()).contains(true)
        assertThat(body._rankBy()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.topK()).contains(0L)
        assertThat(body.vector().getOrNull()).containsExactly(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceQueryParams.builder().namespace("namespace").build()

        val body = params._body()
    }
}
