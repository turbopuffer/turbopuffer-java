// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceUpdateMetadataParamsTest {

    @Test
    fun create() {
        NamespaceUpdateMetadataParams.builder()
            .namespace("namespace")
            .namespaceMetadataPatch(NamespaceMetadataPatch.builder().pinning(true).build())
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceUpdateMetadataParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceUpdateMetadataParams.builder()
                .namespace("namespace")
                .namespaceMetadataPatch(NamespaceMetadataPatch.builder().pinning(true).build())
                .build()

        val body = params._body().getOrNull()

        assertThat(body).isEqualTo(NamespaceMetadataPatch.builder().pinning(true).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceUpdateMetadataParams.builder().build()

        val body = params._body().getOrNull()
    }
}
