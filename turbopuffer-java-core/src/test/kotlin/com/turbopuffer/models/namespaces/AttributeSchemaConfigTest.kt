// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttributeSchemaConfigTest {

    @Test
    fun create() {
        val attributeSchemaConfig =
            AttributeSchemaConfig.builder()
                .type("string")
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .regex(true)
                .build()

        assertThat(attributeSchemaConfig.type()).isEqualTo("string")
        assertThat(attributeSchemaConfig.ann()).contains(AttributeSchemaConfig.Ann.ofBool(true))
        assertThat(attributeSchemaConfig.filterable()).contains(true)
        assertThat(attributeSchemaConfig.fullTextSearch()).contains(FullTextSearch.ofBool(true))
        assertThat(attributeSchemaConfig.regex()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchemaConfig =
            AttributeSchemaConfig.builder()
                .type("string")
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .regex(true)
                .build()

        val roundtrippedAttributeSchemaConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchemaConfig),
                jacksonTypeRef<AttributeSchemaConfig>(),
            )

        assertThat(roundtrippedAttributeSchemaConfig).isEqualTo(attributeSchemaConfig)
    }
}
