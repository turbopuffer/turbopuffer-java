// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RowTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val row =
            Row.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .build()

        assertThat(row.id()).isEqualTo(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(row.vector()).contains(Vector.ofNumber(listOf(0.0)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val row =
            Row.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfNumber(listOf(0.0))
                .build()

        val roundtrippedRow =
            jsonMapper.readValue(jsonMapper.writeValueAsString(row), jacksonTypeRef<Row>())

        assertThat(roundtrippedRow).isEqualTo(row)
    }
}
