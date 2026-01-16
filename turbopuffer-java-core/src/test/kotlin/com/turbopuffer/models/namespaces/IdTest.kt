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

internal class IdTest {

    @Test
    fun ofString() {
        val string = "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"

        val id = Id.ofString(string)

        assertThat(id.string()).contains(string)
        assertThat(id.integer()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val id = Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val roundtrippedId =
            jsonMapper.readValue(jsonMapper.writeValueAsString(id), jacksonTypeRef<Id>())

        assertThat(roundtrippedId).isEqualTo(id)
    }

    @Test
    fun ofInteger() {
        val integer = 0L

        val id = Id.ofInteger(integer)

        assertThat(id.string()).isEmpty
        assertThat(id.integer()).contains(integer)
    }

    @Test
    fun ofIntegerRoundtrip() {
        val jsonMapper = jsonMapper()
        val id = Id.ofInteger(0L)

        val roundtrippedId =
            jsonMapper.readValue(jsonMapper.writeValueAsString(id), jacksonTypeRef<Id>())

        assertThat(roundtrippedId).isEqualTo(id)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val id = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Id>())

        val e = assertThrows<TurbopufferInvalidDataException> { id.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
