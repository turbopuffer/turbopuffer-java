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

internal class IncludeAttributesTest {

    @Test
    fun ofBool() {
        val bool = true

        val includeAttributes = IncludeAttributes.ofBool(bool)

        assertThat(includeAttributes.bool()).contains(bool)
        assertThat(includeAttributes.strings()).isEmpty
    }

    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val includeAttributes = IncludeAttributes.ofBool(true)

        val roundtrippedIncludeAttributes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(includeAttributes),
                jacksonTypeRef<IncludeAttributes>(),
            )

        assertThat(roundtrippedIncludeAttributes).isEqualTo(includeAttributes)
    }

    @Test
    fun ofStrings() {
        val strings = listOf("string")

        val includeAttributes = IncludeAttributes.ofStrings(strings)

        assertThat(includeAttributes.bool()).isEmpty
        assertThat(includeAttributes.strings()).contains(strings)
    }

    @Test
    fun ofStringsRoundtrip() {
        val jsonMapper = jsonMapper()
        val includeAttributes = IncludeAttributes.ofStrings(listOf("string"))

        val roundtrippedIncludeAttributes =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(includeAttributes),
                jacksonTypeRef<IncludeAttributes>(),
            )

        assertThat(roundtrippedIncludeAttributes).isEqualTo(includeAttributes)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val includeAttributes =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<IncludeAttributes>())

        val e = assertThrows<TurbopufferInvalidDataException> { includeAttributes.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
