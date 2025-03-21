// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceGetSchemaResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceGetSchemaResponse() {
        val namespaceGetSchemaResponse =
            NamespaceGetSchemaResponse.builder()
                .putAdditionalProperty(
                    "foo",
                    JsonValue.from(
                        listOf(
                            mapOf(
                                "filterable" to true,
                                "full_text_search" to true,
                                "type" to "string",
                            )
                        )
                    ),
                )
                .build()
        assertThat(namespaceGetSchemaResponse).isNotNull
    }
}
