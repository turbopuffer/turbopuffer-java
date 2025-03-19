// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceUpsertResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceUpsertResponse =
            NamespaceUpsertResponse.builder().status(NamespaceUpsertResponse.Status.OK).build()

        assertThat(namespaceUpsertResponse.status()).isEqualTo(NamespaceUpsertResponse.Status.OK)
    }
}
