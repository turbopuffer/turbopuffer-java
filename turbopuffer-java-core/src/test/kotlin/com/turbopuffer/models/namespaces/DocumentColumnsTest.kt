// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentColumnsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val documentColumns =
            DocumentColumns.builder()
                .attributes(
                    DocumentColumns.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf(mapOf("foo" to "bar"))))
                        .build()
                )
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addVector(listOf(0.0))
                .build()

        assertThat(documentColumns.attributes())
            .contains(
                DocumentColumns.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf(mapOf("foo" to "bar"))))
                    .build()
            )
        assertThat(documentColumns.ids().getOrNull())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentColumns.vectors().getOrNull()).containsExactly(listOf(0.0))
    }
}
