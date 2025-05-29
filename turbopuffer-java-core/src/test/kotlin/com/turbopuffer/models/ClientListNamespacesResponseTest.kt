// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ClientListNamespacesResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val clientListNamespacesResponse =
            ClientListNamespacesResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        assertThat(clientListNamespacesResponse.namespaces().getOrNull())
            .containsExactly(NamespaceSummary.builder().id("id").build())
        assertThat(clientListNamespacesResponse.nextCursor()).contains("next_cursor")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientListNamespacesResponse =
            ClientListNamespacesResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        val roundtrippedClientListNamespacesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientListNamespacesResponse),
                jacksonTypeRef<ClientListNamespacesResponse>(),
            )

        assertThat(roundtrippedClientListNamespacesResponse).isEqualTo(clientListNamespacesResponse)
    }
}
