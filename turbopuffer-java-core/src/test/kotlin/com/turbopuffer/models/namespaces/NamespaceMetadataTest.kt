// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceMetadataTest {

    @Test
    fun create() {
        val namespaceMetadata =
            NamespaceMetadata.builder()
                .approxLogicalBytes(0L)
                .approxRowCount(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .encryption(NamespaceMetadata.Encryption.Sse.builder().sse(true).build())
                .indexObject()
                .schema(
                    NamespaceMetadata.Schema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "type" to "string",
                                    "ann" to true,
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "regex" to true,
                                )
                            ),
                        )
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(namespaceMetadata.approxLogicalBytes()).isEqualTo(0L)
        assertThat(namespaceMetadata.approxRowCount()).isEqualTo(0L)
        assertThat(namespaceMetadata.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(namespaceMetadata.encryption())
            .isEqualTo(
                NamespaceMetadata.Encryption.ofSse(
                    NamespaceMetadata.Encryption.Sse.builder().sse(true).build()
                )
            )
        assertThat(namespaceMetadata.index()).isEqualTo(NamespaceMetadata.Index.ofObject())
        assertThat(namespaceMetadata.schema())
            .isEqualTo(
                NamespaceMetadata.Schema.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "type" to "string",
                                "ann" to true,
                                "filterable" to true,
                                "full_text_search" to true,
                                "regex" to true,
                            )
                        ),
                    )
                    .build()
            )
        assertThat(namespaceMetadata.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceMetadata =
            NamespaceMetadata.builder()
                .approxLogicalBytes(0L)
                .approxRowCount(0L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .encryption(NamespaceMetadata.Encryption.Sse.builder().sse(true).build())
                .indexObject()
                .schema(
                    NamespaceMetadata.Schema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "type" to "string",
                                    "ann" to true,
                                    "filterable" to true,
                                    "full_text_search" to true,
                                    "regex" to true,
                                )
                            ),
                        )
                        .build()
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedNamespaceMetadata =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceMetadata),
                jacksonTypeRef<NamespaceMetadata>(),
            )

        assertThat(roundtrippedNamespaceMetadata).isEqualTo(namespaceMetadata)
    }
}
