// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HighlightConfigParamsTest {

    @Test
    fun create() {
        val highlightConfigParams =
            HighlightConfigParams.builder()
                .fragmentBy(HighlightFragmentBy.NONE)
                .fragmentLimit(0L)
                .includeOffsets(HighlightOffsetUnits.UTF_8)
                .rankFragmentsBy(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(highlightConfigParams.fragmentBy()).contains(HighlightFragmentBy.NONE)
        assertThat(highlightConfigParams.fragmentLimit()).contains(0L)
        assertThat(highlightConfigParams.includeOffsets()).contains(HighlightOffsetUnits.UTF_8)
        assertThat(highlightConfigParams._rankFragmentsBy())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val highlightConfigParams =
            HighlightConfigParams.builder()
                .fragmentBy(HighlightFragmentBy.NONE)
                .fragmentLimit(0L)
                .includeOffsets(HighlightOffsetUnits.UTF_8)
                .rankFragmentsBy(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedHighlightConfigParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(highlightConfigParams),
                jacksonTypeRef<HighlightConfigParams>(),
            )

        assertThat(roundtrippedHighlightConfigParams).isEqualTo(highlightConfigParams)
    }
}
