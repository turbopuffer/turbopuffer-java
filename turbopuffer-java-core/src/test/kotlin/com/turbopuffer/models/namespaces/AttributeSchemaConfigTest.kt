// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AttributeSchemaConfigTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val attributeSchemaConfig =
            AttributeSchemaConfig.builder()
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .type("string")
                .build()

        assertThat(attributeSchemaConfig.ann()).contains(true)
        assertThat(attributeSchemaConfig.filterable()).contains(true)
        assertThat(attributeSchemaConfig.fullTextSearch()).contains(FullTextSearch.ofBool(true))
        assertThat(attributeSchemaConfig.type()).contains("string")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchemaConfig =
            AttributeSchemaConfig.builder()
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .type("string")
                .build()

        val roundtrippedAttributeSchemaConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchemaConfig),
                jacksonTypeRef<AttributeSchemaConfig>(),
            )

        assertThat(roundtrippedAttributeSchemaConfig).isEqualTo(attributeSchemaConfig)
    }
}
