// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class FilterTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValues() {
        val jsonValues = listOf(JsonValue.from(mapOf<String, Any>()))

        val filter = Filter.ofJsonValues(jsonValues)

        assertThat(filter.jsonValues()).contains(jsonValues)
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValuesRoundtrip() {
        val jsonMapper = jsonMapper()
        val filter = Filter.ofJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))

        val roundtrippedFilter =
            jsonMapper.readValue(jsonMapper.writeValueAsString(filter), jacksonTypeRef<Filter>())

        assertThat(roundtrippedFilter).isEqualTo(filter)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValues() {
        val jsonValues = listOf(JsonValue.from(mapOf<String, Any>()))

        val filter = Filter.ofJsonValues(jsonValues)

        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).contains(jsonValues)
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValuesRoundtrip() {
        val jsonMapper = jsonMapper()
        val filter = Filter.ofJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))

        val roundtrippedFilter =
            jsonMapper.readValue(jsonMapper.writeValueAsString(filter), jacksonTypeRef<Filter>())

        assertThat(roundtrippedFilter).isEqualTo(filter)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValues() {
        val jsonValues = listOf(JsonValue.from(mapOf<String, Any>()))

        val filter = Filter.ofJsonValues(jsonValues)

        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).contains(jsonValues)
        assertThat(filter.jsonValues()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValuesRoundtrip() {
        val jsonMapper = jsonMapper()
        val filter = Filter.ofJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))

        val roundtrippedFilter =
            jsonMapper.readValue(jsonMapper.writeValueAsString(filter), jacksonTypeRef<Filter>())

        assertThat(roundtrippedFilter).isEqualTo(filter)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValues() {
        val jsonValues = listOf(JsonValue.from(mapOf<String, Any>()))

        val filter = Filter.ofJsonValues(jsonValues)

        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).isEmpty
        assertThat(filter.jsonValues()).contains(jsonValues)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofJsonValuesRoundtrip() {
        val jsonMapper = jsonMapper()
        val filter = Filter.ofJsonValues(listOf(JsonValue.from(mapOf<String, Any>())))

        val roundtrippedFilter =
            jsonMapper.readValue(jsonMapper.writeValueAsString(filter), jacksonTypeRef<Filter>())

        assertThat(roundtrippedFilter).isEqualTo(filter)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @Disabled("skipped: tests are disabled for the time being")
    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val filter = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Filter>())

        val e = assertThrows<TurbopufferInvalidDataException> { filter.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
