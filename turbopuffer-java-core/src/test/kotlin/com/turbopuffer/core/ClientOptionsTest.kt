// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.core

import com.turbopuffer.core.http.HttpClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
internal class ClientOptionsTest {

    private val httpClient = mock<HttpClient>()

    @Test
    fun baseUrl_production_substitutesTemplateVariables() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("tpuf_A1...")
                .region("my-cool-region")
                .build()

        val baseUrl = clientOptions.baseUrl()

        assertThat(baseUrl).isEqualTo("https://my-cool-region.turbopuffer.com")
    }

    @Test
    fun baseUrl_production_requiresRegion() {
        val e =
            assertThrows<IllegalStateException> {
                val clientOptions =
                    ClientOptions.builder().httpClient(httpClient).apiKey("tpuf_A1...").build()
            }

        assertThat(e.message)
            .isEqualTo(
                "region is required, but not set (baseUrl has a {region} placeholder: https://{region}.turbopuffer.com)"
            )
    }

    @Test
    fun baseUrl_withCompleteOverriddenUrl_doesNotRequireRegion() {
        val clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("tpuf_A1...")
                .baseUrl("https://tpuf.example.com")
                // Note: region is not provided
                .build()

        val baseUrl = clientOptions.baseUrl()

        assertThat(baseUrl).isEqualTo("https://tpuf.example.com")
    }

    @Test
    fun baseUrl_withIncompleteOverriddenUrl_requiresRegion() {
        val e =
            assertThrows<IllegalStateException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .apiKey("tpuf_A1...")
                    .baseUrl("https://tpuf-{region}.example.com")
                    // Note: region is not provided - should throw exception
                    .build()
            }

        assertThat(e.message)
            .isEqualTo(
                "region is required, but not set (baseUrl has a {region} placeholder: https://tpuf-{region}.example.com)"
            )
    }

    @Test
    fun baseUrl_withCompleteOverriddenUrlAndRegion_throwsException() {
        val e =
            assertThrows<IllegalStateException> {
                ClientOptions.builder()
                    .httpClient(httpClient)
                    .apiKey("tpuf_A1...")
                    .baseUrl("https://tpuf.example.com")
                    .region("gcp-us-central1") // Region provided but baseUrl doesn't have {region}
                    .build()
            }

        assertThat(e.message)
            .isEqualTo(
                "region is set, but would be ignored (baseUrl does not contain {region} placeholder: https://tpuf.example.com)"
            )
    }

    @Test
    fun toBuilder_whenOriginalClientOptionsGarbageCollected_doesNotCloseOriginalClient() {
        var clientOptions =
            ClientOptions.builder()
                .httpClient(httpClient)
                .apiKey("tpuf_A1...")
                .region("my-cool-region")
                .build()
        verify(httpClient, never()).close()

        // Overwrite the `clientOptions` variable so that the original `ClientOptions` is GC'd.
        clientOptions = clientOptions.toBuilder().build()
        System.gc()
        Thread.sleep(100)

        verify(httpClient, never()).close()
        // This exists so that `clientOptions` is still reachable.
        assertThat(clientOptions).isEqualTo(clientOptions)
    }
}
