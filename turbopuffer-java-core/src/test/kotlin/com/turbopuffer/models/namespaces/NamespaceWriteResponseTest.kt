// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceWriteResponseTest {

    @Test
    fun create() {
        val namespaceWriteResponse =
            NamespaceWriteResponse.builder().status(NamespaceWriteResponse.Status.OK).build()

        assertThat(namespaceWriteResponse.status()).isEqualTo(NamespaceWriteResponse.Status.OK)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceWriteResponse =
            NamespaceWriteResponse.builder().status(NamespaceWriteResponse.Status.OK).build()

        val roundtrippedNamespaceWriteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceWriteResponse),
                jacksonTypeRef<NamespaceWriteResponse>(),
            )

        assertThat(roundtrippedNamespaceWriteResponse).isEqualTo(namespaceWriteResponse)
    }
}
