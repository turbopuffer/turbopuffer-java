// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AttributeSchemaTest {

    @Test
    fun ofType() {
        val type = "string"

        val attributeSchema = AttributeSchema.ofType(type)

        assertThat(attributeSchema.type()).contains(type)
        assertThat(attributeSchema.config()).isEmpty
    }

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

    @Test
    fun ofConfig() {
        val config =
            AttributeSchemaConfig.builder()
                .type("string")
                .ann(true)
                .filterable(true)
                .fullTextSearch(true)
                .regex(true)
                .build()

        val attributeSchema = AttributeSchema.ofConfig(config)

        assertThat(attributeSchema.type()).isEmpty
        assertThat(attributeSchema.config()).contains(config)
    }

    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchema =
            AttributeSchema.ofConfig(
                AttributeSchemaConfig.builder()
                    .type("string")
                    .ann(true)
                    .filterable(true)
                    .fullTextSearch(true)
                    .regex(true)
                    .build()
            )

        val roundtrippedAttributeSchema =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchema),
                jacksonTypeRef<AttributeSchema>(),
            )

        assertThat(roundtrippedAttributeSchema).isEqualTo(attributeSchema)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val attributeSchema =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AttributeSchema>())

        val e = assertThrows<TurbopufferInvalidDataException> { attributeSchema.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
