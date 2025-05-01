// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentRowWithScoreTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val documentRowWithScore =
            DocumentRowWithScore.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .dist(0.0)
                .build()

        assertThat(documentRowWithScore.id())
            .contains(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRowWithScore.vector()).contains(DocumentRow.Vector.ofNumber(listOf(0.0)))
        assertThat(documentRowWithScore.dist()).contains(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val documentRowWithScore =
            DocumentRowWithScore.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .dist(0.0)
                .build()

        val roundtrippedDocumentRowWithScore =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(documentRowWithScore),
                jacksonTypeRef<DocumentRowWithScore>(),
            )

        assertThat(roundtrippedDocumentRowWithScore).isEqualTo(documentRowWithScore)
    }
}
