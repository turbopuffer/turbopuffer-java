// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceMetadataPatchTest {

    @Test
    fun create() {
        val namespaceMetadataPatch = NamespaceMetadataPatch.builder().pinning(true).build()

        assertThat(namespaceMetadataPatch.pinning())
            .contains(NamespaceMetadataPatch.Pinning.ofBool(true))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceMetadataPatch = NamespaceMetadataPatch.builder().pinning(true).build()

        val roundtrippedNamespaceMetadataPatch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceMetadataPatch),
                jacksonTypeRef<NamespaceMetadataPatch>(),
            )

        assertThat(roundtrippedNamespaceMetadataPatch).isEqualTo(namespaceMetadataPatch)
    }
}
