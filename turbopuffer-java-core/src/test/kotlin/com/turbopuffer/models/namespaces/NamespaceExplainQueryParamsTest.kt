// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceExplainQueryParamsTest {

    @Test
    fun create() {
        NamespaceExplainQueryParams.builder()
            .namespace("namespace")
            .aggregateBy(
                Query.AggregateBy.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
            .distanceMetric(DistanceMetric.COSINE_DISTANCE)
            .addExcludeAttribute("string")
            .filters(JsonValue.from(mapOf<String, Any>()))
            .addGroupBy("string")
            .includeAttributes(true)
            .limit(0L)
            .rankBy(JsonValue.from(mapOf<String, Any>()))
            .topK(0L)
            .consistency(
                NamespaceExplainQueryParams.Consistency.builder()
                    .level(NamespaceExplainQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .vectorEncoding(VectorEncoding.FLOAT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceExplainQueryParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceExplainQueryParams.builder()
                .namespace("namespace")
                .aggregateBy(
                    Query.AggregateBy.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                .addExcludeAttribute("string")
                .filters(JsonValue.from(mapOf<String, Any>()))
                .addGroupBy("string")
                .includeAttributes(true)
                .limit(0L)
                .rankBy(JsonValue.from(mapOf<String, Any>()))
                .topK(0L)
                .consistency(
                    NamespaceExplainQueryParams.Consistency.builder()
                        .level(NamespaceExplainQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .vectorEncoding(VectorEncoding.FLOAT)
                .build()

        val body = params._body()

        assertThat(body.aggregateBy())
            .contains(
                Query.AggregateBy.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.distanceMetric()).contains(DistanceMetric.COSINE_DISTANCE)
        assertThat(body.excludeAttributes().getOrNull()).containsExactly("string")
        assertThat(body._filters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.groupBy().getOrNull()).containsExactly("string")
        assertThat(body.includeAttributes()).contains(IncludeAttributes.ofBool(true))
        assertThat(body.limit()).contains(Query.Limit.ofInteger(0L))
        assertThat(body._rankBy()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.topK()).contains(0L)
        assertThat(body.consistency())
            .contains(
                NamespaceExplainQueryParams.Consistency.builder()
                    .level(NamespaceExplainQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.vectorEncoding()).contains(VectorEncoding.FLOAT)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceExplainQueryParams.builder().build()

        val body = params._body()
    }
}
