// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AttributeSchemaTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val attributeSchema =
            AttributeSchema.builder()
                .filterable(true)
                .fullTextSearch(true)
                .type(AttributeSchema.Type.STRING)
                .build()

        assertThat(attributeSchema.filterable()).contains(true)
        assertThat(attributeSchema.fullTextSearch())
            .contains(AttributeSchema.FullTextSearch.ofBool(true))
        assertThat(attributeSchema.type()).contains(AttributeSchema.Type.STRING)
    }
}
