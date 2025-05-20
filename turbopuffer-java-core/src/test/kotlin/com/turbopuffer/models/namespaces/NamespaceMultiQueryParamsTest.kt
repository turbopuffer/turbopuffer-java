// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceMultiQueryParamsTest {

    @Test
    fun create() {
        NamespaceMultiQueryParams.builder()
            .namespace("namespace")
            .consistency(
                NamespaceMultiQueryParams.Consistency.builder()
                    .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                    .build()
            )
            .addQuery(
                NamespaceMultiQueryParams.Query.builder()
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .includeAttributes(true)
                    .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                    .topK(0L)
                    .build()
            )
            .vectorEncoding(NamespaceMultiQueryParams.VectorEncoding.FLOAT)
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceMultiQueryParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceMultiQueryParams.builder()
                .namespace("namespace")
                .consistency(
                    NamespaceMultiQueryParams.Consistency.builder()
                        .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                        .build()
                )
                .addQuery(
                    NamespaceMultiQueryParams.Query.builder()
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .filters(JsonValue.from(mapOf<String, Any>()))
                        .includeAttributes(true)
                        .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                        .topK(0L)
                        .build()
                )
                .vectorEncoding(NamespaceMultiQueryParams.VectorEncoding.FLOAT)
                .build()

        val body = params._body()

        assertThat(body.consistency())
            .contains(
                NamespaceMultiQueryParams.Consistency.builder()
                    .level(NamespaceMultiQueryParams.Consistency.Level.STRONG)
                    .build()
            )
        assertThat(body.queries().getOrNull())
            .containsExactly(
                NamespaceMultiQueryParams.Query.builder()
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .filters(JsonValue.from(mapOf<String, Any>()))
                    .includeAttributes(true)
                    .rankByOfVector(listOf(JsonValue.from(mapOf<String, Any>())))
                    .topK(0L)
                    .build()
            )
        assertThat(body.vectorEncoding()).contains(NamespaceMultiQueryParams.VectorEncoding.FLOAT)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceMultiQueryParams.builder().build()

        val body = params._body()
    }
}
