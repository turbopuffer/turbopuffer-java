// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceRetrieveResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceRetrieveResponse() {
        val namespaceRetrieveResponse =
            NamespaceRetrieveResponse.builder().approxCount(0L).dimensions(0L).name("name").build()
        assertThat(namespaceRetrieveResponse).isNotNull
        assertThat(namespaceRetrieveResponse.approxCount()).contains(0L)
        assertThat(namespaceRetrieveResponse.dimensions()).contains(0L)
        assertThat(namespaceRetrieveResponse.name()).contains("name")
    }
}
