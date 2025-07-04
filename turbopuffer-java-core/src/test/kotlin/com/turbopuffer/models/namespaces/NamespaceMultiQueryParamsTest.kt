// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceMultiQueryParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceMultiQueryParams.builder()
            .namespace("namespace")
            .addQuery(
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
            )
            .consistency(
                NamespaceMultiQueryParams.Consistency.builder()
                    .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .vectorEncoding(VectorEncoding.FLOAT)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceMultiQueryParams.builder().addQuery(Query.builder().build()).build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            NamespaceMultiQueryParams.builder()
                .namespace("namespace")
                .addQuery(
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
                )
                .consistency(
                    NamespaceMultiQueryParams.Consistency.builder()
                        .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .vectorEncoding(VectorEncoding.FLOAT)
                .build()

        val body = params._body()

        assertThat(body.queries())
            .containsExactly(
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
            )
        assertThat(body.consistency())
            .contains(
                NamespaceMultiQueryParams.Consistency.builder()
                    .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.vectorEncoding()).contains(VectorEncoding.FLOAT)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceMultiQueryParams.builder().addQuery(Query.builder().build()).build()

        val body = params._body()

        assertThat(body.queries()).containsExactly(Query.builder().build())
    }
}
