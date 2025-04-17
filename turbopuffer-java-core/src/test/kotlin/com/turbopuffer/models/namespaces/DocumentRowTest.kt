// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentRowTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .additionalProperties(JsonValue.from(mapOf<String, Any>()))
                .vectorOfNumber(listOf(0.0))
                .build()

        assertThat(documentRow.id()).contains(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRow._additionalProperties())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(documentRow.vector()).contains(DocumentRow.Vector.ofNumber(listOf(0.0)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .additionalProperties(JsonValue.from(mapOf<String, Any>()))
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
