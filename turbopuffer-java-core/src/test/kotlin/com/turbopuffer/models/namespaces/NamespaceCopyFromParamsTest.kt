// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceCopyFromParamsTest {

    @Test
    fun create() {
        NamespaceCopyFromParams.builder()
            .namespace("namespace")
            .sourceNamespace("source_namespace")
            .sourceApiKey("source_api_key")
            .sourceRegion("source_region")
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceCopyFromParams.builder().sourceNamespace("source_namespace").build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceCopyFromParams.builder()
                .namespace("namespace")
                .sourceNamespace("source_namespace")
                .sourceApiKey("source_api_key")
                .sourceRegion("source_region")
                .build()

        val body = params._body()

        assertThat(body.sourceNamespace()).isEqualTo("source_namespace")
        assertThat(body.sourceApiKey()).contains("source_api_key")
        assertThat(body.sourceRegion()).contains("source_region")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceCopyFromParams.builder().sourceNamespace("source_namespace").build()

        val body = params._body()

        assertThat(body.sourceNamespace()).isEqualTo("source_namespace")
    }
}
