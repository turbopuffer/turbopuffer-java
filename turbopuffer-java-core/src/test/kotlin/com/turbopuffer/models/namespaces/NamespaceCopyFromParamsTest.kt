// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceCopyFromParamsTest {

    @Test
    fun create() {
        NamespaceCopyFromParams.builder().namespace("namespace").copyFromNamespace("string").build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceCopyFromParams.builder().copyFromNamespace("string").build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceCopyFromParams.builder()
                .namespace("namespace")
                .copyFromNamespace("string")
                .build()

        val body = params._body()

        assertThat(body.copyFromNamespace()).isEqualTo(CopyFromNamespaceParams.ofString("string"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceCopyFromParams.builder().copyFromNamespace("string").build()

        val body = params._body()

        assertThat(body.copyFromNamespace()).isEqualTo(CopyFromNamespaceParams.ofString("string"))
    }
}
