// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceDeleteAllResponseTest {

    @Test
    fun createNamespaceDeleteAllResponse() {
        val namespaceDeleteAllResponse =
            NamespaceDeleteAllResponse.builder()
                .status(NamespaceDeleteAllResponse.Status.OK)
                .build()
        assertThat(namespaceDeleteAllResponse).isNotNull
        assertThat(namespaceDeleteAllResponse.status())
            .contains(NamespaceDeleteAllResponse.Status.OK)
    }
}
