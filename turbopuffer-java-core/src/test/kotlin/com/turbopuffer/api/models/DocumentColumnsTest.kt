// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DocumentColumnsTest {

    @Test
    fun createDocumentColumns() {
        val documentColumns =
            DocumentColumns.builder()
                .attributes(
                    DocumentColumns.Attributes.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                listOf(
                                    mapOf(
                                        "filterable" to true,
                                        "full_text_search" to true,
                                        "type" to "string",
                                    )
                                )
                            ),
                        )
                        .build()
                )
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addVector(0.0)
                .build()
        assertThat(documentColumns).isNotNull
        assertThat(documentColumns.attributes())
            .contains(
                DocumentColumns.Attributes.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            listOf(
                                mapOf(
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "type" to "string",
                                )
                            )
                        ),
                    )
                    .build()
            )
        assertThat(documentColumns.ids().get())
            .containsExactly(DocumentColumns.Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentColumns.vectors().get())
            .containsExactly(DocumentColumns.Vector.ofNumber(0.0))
    }
}
