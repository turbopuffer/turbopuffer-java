// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DocumentRowTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createDocumentRow() {
        val documentRow =
            DocumentRow.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .attributes(
                    DocumentRow.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addVector(0.0)
                .build()
        assertThat(documentRow).isNotNull
        assertThat(documentRow.id()).contains(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRow.attributes())
            .contains(
                DocumentRow.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(documentRow.vector().get()).containsExactly(0.0)
    }
}
