// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NamespaceUpdateSchemaParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceUpdateSchemaParams.builder()
            .namespace("namespace")
            .schema(
                NamespaceUpdateSchemaParams.Schema.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "filterable" to true,
                                "full_text_search" to
                                    mapOf(
                                        "case_sensitive" to true,
                                        "language" to "arabic",
                                        "remove_stopwords" to true,
                                        "stemming" to true,
                                    ),
                                "type" to "string",
                            )
                        ),
                    )
                    .build()
            )
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params = NamespaceUpdateSchemaParams.builder().build()

        assertThat(params._pathParam(0)).isEqualTo("")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            NamespaceUpdateSchemaParams.builder()
                .namespace("namespace")
                .schema(
                    NamespaceUpdateSchemaParams.Schema.builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "filterable" to true,
                                    "full_text_search" to
                                        mapOf(
                                            "case_sensitive" to true,
                                            "language" to "arabic",
                                            "remove_stopwords" to true,
                                            "stemming" to true,
                                        ),
                                    "type" to "string",
                                )
                            ),
                        )
                        .build()
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                NamespaceUpdateSchemaParams.Schema.builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "filterable" to true,
                                "full_text_search" to
                                    mapOf(
                                        "case_sensitive" to true,
                                        "language" to "arabic",
                                        "remove_stopwords" to true,
                                        "stemming" to true,
                                    ),
                                "type" to "string",
                            )
                        ),
                    )
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceUpdateSchemaParams.builder().build()

        val body = params._body().getOrNull()
    }
}
