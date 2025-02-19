// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceUpsertParamsTest {

    @Test
    fun create() {
        NamespaceUpsertParams.builder()
            .namespace("namespace")
            .body(
                NamespaceUpsertParams.Body.UpsertColumnar.builder()
                    .attributes(
                        DocumentColumns.Attributes.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    listOf(
                                        mapOf(
                                            "filterable" to true,
                                            "full_text_search" to true,
                                            "type" to "string",
                                        )
                                    )
                                ),
                            )
                            .build()
                    )
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addVector(listOf(0.0))
                    .distanceMetric(
                        NamespaceUpsertParams.Body.UpsertColumnar.DistanceMetric.COSINE_DISTANCE
                    )
                    .schema(
                        NamespaceUpsertParams.Body.UpsertColumnar.Schema.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(
                                    listOf(
                                        mapOf(
                                            "filterable" to true,
                                            "full_text_search" to true,
                                            "type" to "string",
                                        )
                                    )
                                ),
                            )
                            .build()
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            NamespaceUpsertParams.builder()
                .namespace("namespace")
                .body(
                    NamespaceUpsertParams.Body.UpsertColumnar.builder()
                        .attributes(
                            DocumentColumns.Attributes.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        listOf(
                                            mapOf(
                                                "filterable" to true,
                                                "full_text_search" to true,
                                                "type" to "string",
                                            )
                                        )
                                    ),
                                )
                                .build()
                        )
                        .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addVector(listOf(0.0))
                        .distanceMetric(
                            NamespaceUpsertParams.Body.UpsertColumnar.DistanceMetric.COSINE_DISTANCE
                        )
                        .schema(
                            NamespaceUpsertParams.Body.UpsertColumnar.Schema.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        listOf(
                                            mapOf(
                                                "filterable" to true,
                                                "full_text_search" to true,
                                                "type" to "string",
                                            )
                                        )
                                    ),
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body)
            .isEqualTo(
                NamespaceUpsertParams.Body.ofUpsertColumnar(
                    NamespaceUpsertParams.Body.UpsertColumnar.builder()
                        .attributes(
                            DocumentColumns.Attributes.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        listOf(
                                            mapOf(
                                                "filterable" to true,
                                                "full_text_search" to true,
                                                "type" to "string",
                                            )
                                        )
                                    ),
                                )
                                .build()
                        )
                        .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addVector(listOf(0.0))
                        .distanceMetric(
                            NamespaceUpsertParams.Body.UpsertColumnar.DistanceMetric.COSINE_DISTANCE
                        )
                        .schema(
                            NamespaceUpsertParams.Body.UpsertColumnar.Schema.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(
                                        listOf(
                                            mapOf(
                                                "filterable" to true,
                                                "full_text_search" to true,
                                                "type" to "string",
                                            )
                                        )
                                    ),
                                )
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            NamespaceUpsertParams.builder()
                .namespace("namespace")
                .body(NamespaceUpsertParams.Body.UpsertColumnar.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body)
            .isEqualTo(
                NamespaceUpsertParams.Body.ofUpsertColumnar(
                    NamespaceUpsertParams.Body.UpsertColumnar.builder().build()
                )
            )
    }

    @Test
    fun getPathParam() {
        val params =
            NamespaceUpsertParams.builder()
                .namespace("namespace")
                .body(NamespaceUpsertParams.Body.UpsertColumnar.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
