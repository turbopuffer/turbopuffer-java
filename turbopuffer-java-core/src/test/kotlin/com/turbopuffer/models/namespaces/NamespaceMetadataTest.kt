// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceMetadataTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceMetadata =
            NamespaceMetadata.builder()
                .approxLogicalBytes(0L)
                .approxRowCount(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .schema(
                    NamespaceMetadata.Schema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "ann" to true,
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "type" to "string",
                                )
                            ),
                        )
                        .build()
                )
                .build()

        assertThat(namespaceMetadata.approxLogicalBytes()).isEqualTo(0L)
        assertThat(namespaceMetadata.approxRowCount()).isEqualTo(0L)
        assertThat(namespaceMetadata.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(namespaceMetadata.schema())
            .isEqualTo(
                NamespaceMetadata.Schema.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "ann" to true,
                                "filterable" to true,
                                "full_text_search" to true,
                                "type" to "string",
                            )
                        ),
                    )
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceMetadata =
            NamespaceMetadata.builder()
                .approxLogicalBytes(0L)
                .approxRowCount(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .schema(
                    NamespaceMetadata.Schema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "ann" to true,
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "type" to "string",
                                )
                            ),
                        )
                        .build()
                )
                .build()

        val roundtrippedNamespaceMetadata =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceMetadata),
                jacksonTypeRef<NamespaceMetadata>(),
            )

        assertThat(roundtrippedNamespaceMetadata).isEqualTo(namespaceMetadata)
    }
}
