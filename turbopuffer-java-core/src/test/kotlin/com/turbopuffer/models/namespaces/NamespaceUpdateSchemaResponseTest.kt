// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceUpdateSchemaResponseTest {

    @Test
    fun create() {
        val namespaceUpdateSchemaResponse =
            NamespaceUpdateSchemaResponse.builder()
                .putAdditionalProperty(
                    "foo",
                    JsonValue.from(
                        mapOf(
                            "type" to "string",
                            "ann" to true,
                            "filterable" to true,
                            "full_text_search" to true,
                            "fuzzy" to true,
                            "glob" to true,
                            "regex" to true,
                            "sparse_knn" to mapOf("distance_metric" to "dot_product"),
                        )
                    ),
                )
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceUpdateSchemaResponse =
            NamespaceUpdateSchemaResponse.builder()
                .putAdditionalProperty(
                    "foo",
                    JsonValue.from(
                        mapOf(
                            "type" to "string",
                            "ann" to true,
                            "filterable" to true,
                            "full_text_search" to true,
                            "fuzzy" to true,
                            "glob" to true,
                            "regex" to true,
                            "sparse_knn" to mapOf("distance_metric" to "dot_product"),
                        )
                    ),
                )
                .build()

        val roundtrippedNamespaceUpdateSchemaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceUpdateSchemaResponse),
                jacksonTypeRef<NamespaceUpdateSchemaResponse>(),
            )

        assertThat(roundtrippedNamespaceUpdateSchemaResponse)
            .isEqualTo(namespaceUpdateSchemaResponse)
    }
}
