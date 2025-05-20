// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttributeSchemaTest {

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

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema =
            AttributeSchema.builder()
                .filterable(true)
                .fullTextSearch(true)
                .type(AttributeSchema.Type.STRING)
                .build()

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }
}
