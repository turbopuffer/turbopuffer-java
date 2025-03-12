// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceDeleteAllResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createNamespaceDeleteAllResponse() {
      val namespaceDeleteAllResponse = NamespaceDeleteAllResponse.builder()
          .status(NamespaceDeleteAllResponse.Status.OK)
          .build()
      assertThat(namespaceDeleteAllResponse).isNotNull
      assertThat(namespaceDeleteAllResponse.status()).isEqualTo(NamespaceDeleteAllResponse.Status.OK)
    }
}
