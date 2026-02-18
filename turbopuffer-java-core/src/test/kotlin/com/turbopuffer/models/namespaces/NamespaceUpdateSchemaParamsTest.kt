// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceUpdateSchemaParamsTest {

    @Test
    fun create() {
        NamespaceUpdateSchemaParams.builder()
            .namespace("namespace")
            .schema(
                Schema.builder()
                    .put("foo", AttributeSchemaConfig.builder().type("string").build())
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceUpdateSchemaParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceUpdateSchemaParams.builder()
                .namespace("namespace")
                .schema(
                    Schema.builder()
                        .put("foo", AttributeSchemaConfig.builder().type("string").build())
                        .build()
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                Schema.builder()
                    .put("foo", AttributeSchemaConfig.builder().type("string").build())
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceUpdateSchemaParams.builder().build()

        val body = params._body().getOrNull()
    }
}
