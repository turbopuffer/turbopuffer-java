// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AttributeSchemaTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofType() {
        val type = "string"

        val attributeSchema = AttributeSchema.ofType(type)

        assertThat(attributeSchema.type()).contains(type)
        assertThat(attributeSchema.config()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema = AttributeSchema.ofType("string")

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofConfig() {
        val config =
            AttributeSchemaConfig.builder()
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .type("string")
                .build()

        val attributeSchema = AttributeSchema.ofConfig(config)

        assertThat(attributeSchema.type()).isEmpty
        assertThat(attributeSchema.config()).contains(config)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema =
            AttributeSchema.ofConfig(
                AttributeSchemaConfig.builder()
                    .ann(true)
                    .filterable(true)
                    .fullTextSearch(true)
                    .type("string")
                    .build()
            )

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(listOf("invalid", "array"))
        val attributeSchema = jsonMapper().convertValue(value, jacksonTypeRef<AttributeSchema>())

        val e = assertThrows<TurbopufferInvalidDataException> { attributeSchema.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
