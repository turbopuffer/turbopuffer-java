// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceSummaryTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceSummary() {
        val namespaceSummary =
            NamespaceSummary.builder()
                .id("id")
                .required(JsonValue.from(mapOf<String, Any>()))
                .build()
        assertThat(namespaceSummary).isNotNull
        assertThat(namespaceSummary.id()).contains("id")
        assertThat(namespaceSummary._required()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }
}
