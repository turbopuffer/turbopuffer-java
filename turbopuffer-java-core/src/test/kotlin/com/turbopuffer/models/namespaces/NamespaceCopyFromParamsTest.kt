// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NamespaceCopyFromParamsTest {

    @Test
    fun create() {
        NamespaceCopyFromParams.builder()
            .namespace("namespace")
            .sourceNamespace("source_namespace")
            .sourceApiKey("source_api_key")
            .sourceRegion("source_region")
            .encryption(Encryption.CustomerManaged.builder().keyName("key_name").build())
            .build()
    }

    @Test
    fun pathParams() {
        val params = NamespaceCopyFromParams.builder().sourceNamespace("source_namespace").build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            NamespaceCopyFromParams.builder()
                .namespace("namespace")
                .sourceNamespace("source_namespace")
                .sourceApiKey("source_api_key")
                .sourceRegion("source_region")
                .encryption(Encryption.CustomerManaged.builder().keyName("key_name").build())
                .build()

        val body = params._body()

        assertThat(body.sourceNamespace()).isEqualTo("source_namespace")
        assertThat(body.sourceApiKey()).contains("source_api_key")
        assertThat(body.sourceRegion()).contains("source_region")
        assertThat(body.encryption())
            .contains(
                Encryption.ofCustomerManaged(
                    Encryption.CustomerManaged.builder().keyName("key_name").build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceCopyFromParams.builder().sourceNamespace("source_namespace").build()

        val body = params._body()

        assertThat(body.sourceNamespace()).isEqualTo("source_namespace")
    }

    @Test
    fun bodyWithDefaultEncryptionSerializes() {
        val params =
            NamespaceCopyFromParams.builder()
                .sourceNamespace("source_namespace")
                .encryptionDefault()
                .build()

        val json = jsonMapper().writeValueAsString(params._body())

        assertThat(jsonMapper().readTree(json))
            .isEqualTo(
                jsonMapper()
                    .readTree(
                        """
                        {
                          "source_namespace": "source_namespace",
                          "encryption": {
                            "mode": "default"
                          }
                        }
                        """
                            .trimIndent()
                    )
            )
    }
}
