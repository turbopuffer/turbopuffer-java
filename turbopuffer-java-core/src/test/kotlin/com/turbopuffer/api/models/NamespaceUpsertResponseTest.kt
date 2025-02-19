// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceUpsertResponseTest {

    @Test
    fun createNamespaceUpsertResponse() {
        val namespaceUpsertResponse =
            NamespaceUpsertResponse.builder().status(NamespaceUpsertResponse.Status.OK).build()
        assertThat(namespaceUpsertResponse).isNotNull
        assertThat(namespaceUpsertResponse.status()).contains(NamespaceUpsertResponse.Status.OK)
    }
}
