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

internal class AttributeEmbedTest {

    @Test
    fun ofString() {
        val string = "string"

        val attributeEmbed = AttributeEmbed.ofString(string)

        assertThat(attributeEmbed.string()).contains(string)
        assertThat(attributeEmbed.config()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeEmbed = AttributeEmbed.ofString("string")

        val roundtrippedAttributeEmbed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeEmbed),
                jacksonTypeRef<AttributeEmbed>(),
            )

        assertThat(roundtrippedAttributeEmbed).isEqualTo(attributeEmbed)
    }

    @Test
    fun ofConfig() {
        val config =
            AttributeEmbedConfig.builder().model("model").attribute("attribute").dims(0L).build()

        val attributeEmbed = AttributeEmbed.ofConfig(config)

        assertThat(attributeEmbed.string()).isEmpty
        assertThat(attributeEmbed.config()).contains(config)
    }

    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val attributeEmbed =
            AttributeEmbed.ofConfig(
                AttributeEmbedConfig.builder()
                    .model("model")
                    .attribute("attribute")
                    .dims(0L)
                    .build()
            )

        val roundtrippedAttributeEmbed =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeEmbed),
                jacksonTypeRef<AttributeEmbed>(),
            )

        assertThat(roundtrippedAttributeEmbed).isEqualTo(attributeEmbed)
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
        val attributeEmbed =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AttributeEmbed>())

        val e = assertThrows<TurbopufferInvalidDataException> { attributeEmbed.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
