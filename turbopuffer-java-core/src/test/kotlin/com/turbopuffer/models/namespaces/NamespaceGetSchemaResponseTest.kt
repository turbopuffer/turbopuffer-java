// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceGetSchemaResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceGetSchemaResponse =
            NamespaceGetSchemaResponse.builder()
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceGetSchemaResponse =
            NamespaceGetSchemaResponse.builder()
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

        val roundtrippedNamespaceGetSchemaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(namespaceGetSchemaResponse),
                jacksonTypeRef<NamespaceGetSchemaResponse>(),
            )

        assertThat(roundtrippedNamespaceGetSchemaResponse).isEqualTo(namespaceGetSchemaResponse)
    }
}
