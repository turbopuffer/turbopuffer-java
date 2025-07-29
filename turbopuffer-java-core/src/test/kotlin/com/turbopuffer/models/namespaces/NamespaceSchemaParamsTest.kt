// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceSchemaParamsTest {

    @Test
    fun create() {
        NamespaceSchemaParams.builder().namespace("namespace").build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceSchemaParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
