// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceSummaryTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceSummary = NamespaceSummary.builder().id("id").build()

        assertThat(namespaceSummary.id()).isEqualTo("id")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceSummary = NamespaceSummary.builder().id("id").build()

        val roundtrippedNamespaceSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceSummary),
                jacksonTypeRef<NamespaceSummary>(),
            )

        assertThat(roundtrippedNamespaceSummary).isEqualTo(namespaceSummary)
    }
}
