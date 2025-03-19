// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
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
                .attributes(
                    DocumentRow.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addVector(0.0)
                .dist(0.0)
                .build()

        assertThat(documentRowWithScore.id())
            .contains(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(documentRowWithScore.attributes())
            .contains(
                DocumentRow.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(documentRowWithScore.vector().getOrNull()).containsExactly(0.0)
        assertThat(documentRowWithScore.dist()).contains(0.0)
    }
}
