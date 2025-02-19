// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceSummaryTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceSummary() {
        val namespaceSummary = NamespaceSummary.builder().id("id").build()
        assertThat(namespaceSummary).isNotNull
        assertThat(namespaceSummary.id()).contains("id")
    }
}
