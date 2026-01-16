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

internal class VectorTest {

    @Test
    fun ofNumber() {
        val number = listOf(0.0)

        val vector = Vector.ofNumber(number)

        assertThat(vector.number()).contains(number)
        assertThat(vector.string()).isEmpty
    }

    @Test
    fun ofNumberRoundtrip() {
        val jsonMapper = jsonMapper()
        val vector = Vector.ofNumber(listOf(0.0))

        val roundtrippedVector =
            jsonMapper.readValue(jsonMapper.writeValueAsString(vector), jacksonTypeRef<Vector>())

        assertThat(roundtrippedVector).isEqualTo(vector)
    }

    @Test
    fun ofString() {
        val string = "string"

        val vector = Vector.ofString(string)

        assertThat(vector.number()).isEmpty
        assertThat(vector.string()).contains(string)
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val vector = Vector.ofString("string")

        val roundtrippedVector =
            jsonMapper.readValue(jsonMapper.writeValueAsString(vector), jacksonTypeRef<Vector>())

        assertThat(roundtrippedVector).isEqualTo(vector)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val vector = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Vector>())

        val e = assertThrows<TurbopufferInvalidDataException> { vector.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
