// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceBranchFromParamsTest {

    @Test
    fun create() {
        NamespaceBranchFromParams.builder()
            .namespace("namespace")
            .branchFromNamespace("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceBranchFromParams.builder().branchFromNamespace("string").build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceBranchFromParams.builder()
                .namespace("namespace")
                .branchFromNamespace("string")
                .build()

        val body = params._body()

        assertThat(body.branchFromNamespace())
            .isEqualTo(BranchFromNamespaceParams.ofString("string"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceBranchFromParams.builder().branchFromNamespace("string").build()

        val body = params._body()

        assertThat(body.branchFromNamespace())
            .isEqualTo(BranchFromNamespaceParams.ofString("string"))
    }
}
