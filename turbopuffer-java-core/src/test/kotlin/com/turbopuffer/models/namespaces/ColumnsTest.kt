// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ColumnsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val columns =
            Columns.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                .build()

        assertThat(columns.id())
            .containsExactly(Id.ofString("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
        assertThat(columns.vector())
            .contains(Columns.Vector.ofVectors(listOf(Vector.ofNumber(listOf(0.0)))))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val columns =
            Columns.builder()
                .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .vectorOfVectors(listOf(Vector.ofNumber(listOf(0.0))))
                .build()

        val roundtrippedColumns =
            jsonMapper.readValue(jsonMapper.writeValueAsString(columns), jacksonTypeRef<Columns>())

        assertThat(roundtrippedColumns).isEqualTo(columns)
    }
}
