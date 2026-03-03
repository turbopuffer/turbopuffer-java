// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceRecallParamsTest {

    @Test
    fun create() {
        NamespaceRecallParams.builder()
            .namespace("namespace")
            .filters(JsonValue.from(mapOf<String, Any>()))
            .includeGroundTruth(true)
            .num(0L)
            .topK(0L)
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceRecallParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceRecallParams.builder()
                .namespace("namespace")
                .filters(JsonValue.from(mapOf<String, Any>()))
                .includeGroundTruth(true)
                .num(0L)
                .topK(0L)
                .build()

        val body = params._body()

        assertThat(body._filters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(body.includeGroundTruth()).contains(true)
        assertThat(body.num()).contains(0L)
        assertThat(body.topK()).contains(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceRecallParams.builder().build()

        val body = params._body()
    }
}
