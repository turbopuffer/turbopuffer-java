// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceListParamsTest {

    @Test
    fun create() {
        NamespaceListParams.builder().cursor("cursor").pageSize(1L).prefix("prefix").build()
    }

    @Test
    fun queryParams() {
        val params =
            NamespaceListParams.builder().cursor("cursor").pageSize(1L).prefix("prefix").build()
        val expected = QueryParams.builder()
        expected.put("cursor", "cursor")
        expected.put("page_size", "1")
        expected.put("prefix", "prefix")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = NamespaceListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
