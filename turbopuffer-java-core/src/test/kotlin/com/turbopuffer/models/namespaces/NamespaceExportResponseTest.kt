// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceExportResponseTest {

    @Test
    fun create() {
        val namespaceExportResponse =
            NamespaceExportResponse.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .nextCursor("next_cursor")
                .build()

        assertThat(namespaceExportResponse.id().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(namespaceExportResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceExportResponse =
            NamespaceExportResponse.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .nextCursor("next_cursor")
                .build()

        val roundtrippedNamespaceExportResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceExportResponse),
                jacksonTypeRef<NamespaceExportResponse>(),
            )

        assertThat(roundtrippedNamespaceExportResponse).isEqualTo(namespaceExportResponse)
    }
}
