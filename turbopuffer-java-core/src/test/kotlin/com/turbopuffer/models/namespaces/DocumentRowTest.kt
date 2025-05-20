// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DocumentRowTest {

    @Test
    fun create() {
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .build()

        assertThat(documentRow.id()).contains(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRow.vector()).contains(DocumentRow.Vector.ofNumber(listOf(0.0)))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .build()

        val roundtrippedDocumentRow =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(documentRow),
                jacksonTypeRef<DocumentRow>(),
            )

        assertThat(roundtrippedDocumentRow).isEqualTo(documentRow)
    }
}
