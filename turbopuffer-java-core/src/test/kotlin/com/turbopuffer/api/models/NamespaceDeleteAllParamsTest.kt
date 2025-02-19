// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceDeleteAllParamsTest {

    @Test
    fun create() {
        NamespaceDeleteAllParams.builder().namespace("namespace").build()
    }

    @Test
    fun getPathParam() {
        val params = NamespaceDeleteAllParams.builder().namespace("namespace").build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
