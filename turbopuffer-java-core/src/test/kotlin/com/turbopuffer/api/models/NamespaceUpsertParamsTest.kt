// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceUpsertParamsTest {

    @Test
    fun create() {
        NamespaceUpsertParams.builder()
            .forUpsertColumnar(
                NamespaceUpsertParams.UpsertColumnar.builder()
                    .allOf(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
            .namespace("namespace")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            NamespaceUpsertParams.builder()
                .forUpsertColumnar(NamespaceUpsertParams.UpsertColumnar.builder().build())
                .namespace("namespace")
                .build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
