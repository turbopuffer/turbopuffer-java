// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceGetSchemaResponseTest {

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
