// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ClientListNamespacesParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        ClientListNamespacesParams.builder().cursor("cursor").pageSize(1).prefix("prefix").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            ClientListNamespacesParams.builder()
                .cursor("cursor")
                .pageSize(1)
                .prefix("prefix")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("page_size", "1")
                    .put("prefix", "prefix")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ClientListNamespacesParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
