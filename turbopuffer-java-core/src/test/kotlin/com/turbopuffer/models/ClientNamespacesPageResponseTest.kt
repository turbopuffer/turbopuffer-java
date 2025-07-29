// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClientNamespacesPageResponseTest {

    @Test
    fun create() {
        val clientNamespacesPageResponse =
            ClientNamespacesPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        assertThat(clientNamespacesPageResponse.namespaces().getOrNull())
            .containsExactly(NamespaceSummary.builder().id("id").build())
        assertThat(clientNamespacesPageResponse.nextCursor()).contains("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientNamespacesPageResponse =
            ClientNamespacesPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        val roundtrippedClientNamespacesPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientNamespacesPageResponse),
                jacksonTypeRef<ClientNamespacesPageResponse>(),
            )

        assertThat(roundtrippedClientNamespacesPageResponse).isEqualTo(clientNamespacesPageResponse)
    }
}
