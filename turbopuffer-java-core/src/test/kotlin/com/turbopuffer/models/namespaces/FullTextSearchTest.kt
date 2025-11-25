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

internal class FullTextSearchTest {

    @Test
    fun ofBool() {
        val bool = true

        val fullTextSearch = FullTextSearch.ofBool(bool)

        assertThat(fullTextSearch.bool()).contains(bool)
        assertThat(fullTextSearch.config()).isEmpty
    }

    @Test
    fun ofBoolRoundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearch = FullTextSearch.ofBool(true)

        val roundtrippedFullTextSearch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearch),
                jacksonTypeRef<FullTextSearch>(),
            )

        assertThat(roundtrippedFullTextSearch).isEqualTo(fullTextSearch)
    }

    @Test
    fun ofConfig() {
        val config =
            FullTextSearchConfig.builder()
                .asciiFolding(true)
                .b(0.0)
                .caseSensitive(true)
                .k1(0.0)
                .language(Language.ARABIC)
                .maxTokenLength(0L)
                .removeStopwords(true)
                .stemming(true)
                .tokenizer(Tokenizer.PRE_TOKENIZED_ARRAY)
                .build()

        val fullTextSearch = FullTextSearch.ofConfig(config)

        assertThat(fullTextSearch.bool()).isEmpty
        assertThat(fullTextSearch.config()).contains(config)
    }

    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val fullTextSearch =
            FullTextSearch.ofConfig(
                FullTextSearchConfig.builder()
                    .asciiFolding(true)
                    .b(0.0)
                    .caseSensitive(true)
                    .k1(0.0)
                    .language(Language.ARABIC)
                    .maxTokenLength(0L)
                    .removeStopwords(true)
                    .stemming(true)
                    .tokenizer(Tokenizer.PRE_TOKENIZED_ARRAY)
                    .build()
            )

        val roundtrippedFullTextSearch =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fullTextSearch),
                jacksonTypeRef<FullTextSearch>(),
            )

        assertThat(roundtrippedFullTextSearch).isEqualTo(fullTextSearch)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val fullTextSearch =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<FullTextSearch>())

        val e = assertThrows<TurbopufferInvalidDataException> { fullTextSearch.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
