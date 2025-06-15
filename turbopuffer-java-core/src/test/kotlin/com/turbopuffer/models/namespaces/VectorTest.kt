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

internal class VectorTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofNumber() {
        val number = listOf(0.0)

        val vector = Vector.ofNumber(number)

        assertThat(vector.number()).contains(number)
        assertThat(vector.string()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofNumberRoundtrip() {
        val jsonMapper = jsonMapper()
        val vector = Vector.ofNumber(listOf(0.0))

        val roundtrippedVector =
            jsonMapper.readValue(jsonMapper.writeValueAsString(vector), jacksonTypeRef<Vector>())

        assertThat(roundtrippedVector).isEqualTo(vector)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofString() {
        val string = "string"

        val vector = Vector.ofString(string)

        assertThat(vector.number()).isEmpty
        assertThat(vector.string()).contains(string)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val vector = Vector.ofString("string")

        val roundtrippedVector =
            jsonMapper.readValue(jsonMapper.writeValueAsString(vector), jacksonTypeRef<Vector>())

        assertThat(roundtrippedVector).isEqualTo(vector)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun incompatibleJsonShapeDeserializesToUnknown() {
        val value = JsonValue.from(mapOf("invalid" to "object"))
        val vector = jsonMapper().convertValue(value, jacksonTypeRef<Vector>())

        val e = assertThrows<TurbopufferInvalidDataException> { vector.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
