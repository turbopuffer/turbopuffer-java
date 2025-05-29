// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceUpdateSchemaResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val namespaceUpdateSchemaResponse =
            NamespaceUpdateSchemaResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from("string"))
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val namespaceUpdateSchemaResponse =
            NamespaceUpdateSchemaResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from("string"))
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
