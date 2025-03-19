// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class IdTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofString() {
        val string = "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"

        val id = Id.ofString(string)

        assertThat(id.string()).contains(string)
        assertThat(id.integer()).isEmpty
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun ofInteger() {
        val integer = 0L

        val id = Id.ofInteger(integer)

        assertThat(id.string()).isEmpty
        assertThat(id.integer()).contains(integer)
    }
}
