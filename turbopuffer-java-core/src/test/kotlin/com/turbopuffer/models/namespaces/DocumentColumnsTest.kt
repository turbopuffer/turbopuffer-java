// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DocumentColumnsTest {

    @Test
    fun create() {
        val documentColumns =
            DocumentColumns.builder().addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        assertThat(documentColumns.id().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val documentColumns =
            DocumentColumns.builder().addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        val roundtrippedDocumentColumns =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(documentColumns),
                jacksonTypeRef<DocumentColumns>(),
            )

        assertThat(roundtrippedDocumentColumns).isEqualTo(documentColumns)
    }
}
