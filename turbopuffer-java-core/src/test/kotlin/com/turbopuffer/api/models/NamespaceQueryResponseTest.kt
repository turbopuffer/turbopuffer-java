// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceQueryResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceQueryResponse() {
        val namespaceQueryResponse =
            NamespaceQueryResponse.builder()
                .addVector(
                    NamespaceQueryResponse.Vector.builder()
                        .id("string")
                        .attributes(JsonValue.from(mapOf<String, Any>()))
                        .dist(0.0)
                        .addVector(0.0)
                        .build()
                )
                .build()
        assertThat(namespaceQueryResponse).isNotNull
        assertThat(namespaceQueryResponse.vectors().get())
            .containsExactly(
                NamespaceQueryResponse.Vector.builder()
                    .id("string")
                    .attributes(JsonValue.from(mapOf<String, Any>()))
                    .dist(0.0)
                    .addVector(0.0)
                    .build()
            )
    }
}
