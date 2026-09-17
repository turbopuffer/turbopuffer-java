// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespacePollCopyFromParamsTest {

    @Test
    fun create() {
        NamespacePollCopyFromParams.builder().namespace("namespace").token("token").build()
    }

    @Test
    fun pathParams() {
        val params = NamespacePollCopyFromParams.builder().token("token").build()

        assertThat(params._pathParam(0)).isEqualTo("")
        assertThat(params._pathParam(1)).isEqualTo("token")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
