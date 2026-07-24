// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HighlightConfigTest {

    @Test
    fun create() {
        val highlightConfig =
            HighlightConfig.builder()
                .fragmentBy(HighlightFragmentBy.NONE)
                .fragmentLimit(0L)
                .includeOffsets(HighlightOffsetUnits.UTF_8)
                .rankFragmentsBy(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(highlightConfig.fragmentBy()).contains(HighlightFragmentBy.NONE)
        assertThat(highlightConfig.fragmentLimit()).contains(0L)
        assertThat(highlightConfig.includeOffsets()).contains(HighlightOffsetUnits.UTF_8)
        assertThat(highlightConfig._rankFragmentsBy())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val highlightConfig =
            HighlightConfig.builder()
                .fragmentBy(HighlightFragmentBy.NONE)
                .fragmentLimit(0L)
                .includeOffsets(HighlightOffsetUnits.UTF_8)
                .rankFragmentsBy(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedHighlightConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(highlightConfig),
                jacksonTypeRef<HighlightConfig>(),
            )

        assertThat(roundtrippedHighlightConfig).isEqualTo(highlightConfig)
    }
}
