// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DocumentRowTest {

    @Test
    fun createDocumentRow() {
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .attributes(
                    DocumentRow.Attributes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "type" to "string",
                                )
                            ),
                        )
                        .build()
                )
                .addVector(0.0)
                .build()
        assertThat(documentRow).isNotNull
        assertThat(documentRow.id())
            .contains(DocumentRow.Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRow.attributes())
            .contains(
                DocumentRow.Attributes.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "filterable" to true,
                                "full_text_search" to true,
                                "type" to "string",
                            )
                        ),
                    )
                    .build()
            )
        assertThat(documentRow.vector().get()).containsExactly(0.0)
    }
}
