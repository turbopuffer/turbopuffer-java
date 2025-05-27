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
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class FullTextSearchConfigTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofBool() {
        val bool = true

        val fullTextSearchConfig = FullTextSearchConfig.ofBool(bool)

        assertThat(fullTextSearchConfig.bool()).contains(bool)
        assertThat(fullTextSearchConfig.unionMember1()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearchConfig = FullTextSearchConfig.ofBool(true)

        val roundtrippedFullTextSearchConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearchConfig),
                jacksonTypeRef<FullTextSearchConfig>(),
            )

        assertThat(roundtrippedFullTextSearchConfig).isEqualTo(fullTextSearchConfig)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUnionMember1() {
        val unionMember1 =
            FullTextSearchConfig.UnionMember1.builder()
                .caseSensitive(true)
                .language(FullTextSearchConfig.UnionMember1.Language.ARABIC)
                .removeStopwords(true)
                .stemming(true)
                .build()

        val fullTextSearchConfig = FullTextSearchConfig.ofUnionMember1(unionMember1)

        assertThat(fullTextSearchConfig.bool()).isEmpty
        assertThat(fullTextSearchConfig.unionMember1()).contains(unionMember1)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofUnionMember1Roundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearchConfig =
            FullTextSearchConfig.ofUnionMember1(
                FullTextSearchConfig.UnionMember1.builder()
                    .caseSensitive(true)
                    .language(FullTextSearchConfig.UnionMember1.Language.ARABIC)
                    .removeStopwords(true)
                    .stemming(true)
                    .build()
            )

        val roundtrippedFullTextSearchConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearchConfig),
                jacksonTypeRef<FullTextSearchConfig>(),
            )

        assertThat(roundtrippedFullTextSearchConfig).isEqualTo(fullTextSearchConfig)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @Disabled("skipped: tests are disabled for the time being")
    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val fullTextSearchConfig =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<FullTextSearchConfig>())

        val e = assertThrows<TurbopufferInvalidDataException> { fullTextSearchConfig.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
