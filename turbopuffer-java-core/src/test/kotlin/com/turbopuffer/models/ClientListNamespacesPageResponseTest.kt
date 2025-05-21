// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ClientListNamespacesPageResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val clientListNamespacesPageResponse =
            ClientListNamespacesPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        assertThat(clientListNamespacesPageResponse.namespaces().getOrNull())
            .containsExactly(NamespaceSummary.builder().id("id").build())
        assertThat(clientListNamespacesPageResponse.nextCursor()).contains("next_cursor")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val clientListNamespacesPageResponse =
            ClientListNamespacesPageResponse.builder()
                .addNamespace(NamespaceSummary.builder().id("id").build())
                .nextCursor("next_cursor")
                .build()

        val roundtrippedClientListNamespacesPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(clientListNamespacesPageResponse),
                jacksonTypeRef<ClientListNamespacesPageResponse>(),
            )

        assertThat(roundtrippedClientListNamespacesPageResponse)
            .isEqualTo(clientListNamespacesPageResponse)
    }
}
