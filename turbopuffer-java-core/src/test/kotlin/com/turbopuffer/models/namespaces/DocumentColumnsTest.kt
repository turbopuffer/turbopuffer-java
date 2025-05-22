// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentColumnsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val documentColumns =
            DocumentColumns.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                .build()

        assertThat(documentColumns.id())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentColumns.vector())
            .contains(DocumentColumns.Vector.ofVectors(listOf(Vector.ofNumber(listOf(0.0)))))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val documentColumns =
            DocumentColumns.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                .build()

        val roundtrippedDocumentColumns =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(documentColumns),
                jacksonTypeRef<DocumentColumns>(),
            )

        assertThat(roundtrippedDocumentColumns).isEqualTo(documentColumns)
    }
}
