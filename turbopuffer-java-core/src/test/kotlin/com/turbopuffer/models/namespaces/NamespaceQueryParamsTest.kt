// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceQueryParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceQueryParams.builder()
            .namespace("namespace")
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
            .consistency(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .vectorEncoding(VectorEncoding.FLOAT)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceQueryParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            NamespaceQueryParams.builder()
                .namespace("namespace")
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
                .consistency(
                    NamespaceQueryParams.Consistency.builder()
                        .level(NamespaceQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .vectorEncoding(VectorEncoding.FLOAT)
                .build()

        val body = params._body()

        assertThat(body.consistency())
            .contains(
                NamespaceQueryParams.Consistency.builder()
                    .level(NamespaceQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.vectorEncoding()).contains(VectorEncoding.FLOAT)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceQueryParams.builder().build()

        val body = params._body()
    }
}
