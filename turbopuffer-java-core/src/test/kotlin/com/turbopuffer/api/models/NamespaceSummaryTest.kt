// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceSummaryTest {

    @Test
    fun createNamespaceSummary() {
        val namespaceSummary = NamespaceSummary.builder().id("id").build()
        assertThat(namespaceSummary).isNotNull
        assertThat(namespaceSummary.id()).contains("id")
    }
}
