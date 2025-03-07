// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.turbopuffer.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceUpsertParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceUpsertParams.builder()
            .namespace("namespace")
            .documents(
                NamespaceUpsertParams.Documents.UpsertColumnar.builder()
                    .attributes(
                        DocumentColumns.Attributes.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(listOf(mapOf("foo" to "bar"))),
                            )
                            .build()
                    )
                    .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addVector(listOf(0.0))
                    .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                    .schema(
                        NamespaceUpsertParams.Documents.UpsertColumnar.Schema.builder()
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            NamespaceUpsertParams.builder()
                .namespace("namespace")
                .documents(
                    NamespaceUpsertParams.Documents.UpsertColumnar.builder()
                        .attributes(
                            DocumentColumns.Attributes.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(listOf(mapOf("foo" to "bar"))),
                                )
                                .build()
                        )
                        .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addVector(listOf(0.0))
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .schema(
                            NamespaceUpsertParams.Documents.UpsertColumnar.Schema.builder()
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

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                NamespaceUpsertParams.Documents.ofUpsertColumnar(
                    NamespaceUpsertParams.Documents.UpsertColumnar.builder()
                        .attributes(
                            DocumentColumns.Attributes.builder()
                                .putAdditionalProperty(
                                    "foo",
                                    JsonValue.from(listOf(mapOf("foo" to "bar"))),
                                )
                                .build()
                        )
                        .addId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addVector(listOf(0.0))
                        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
                        .schema(
                            NamespaceUpsertParams.Documents.UpsertColumnar.Schema.builder()
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = NamespaceUpsertParams.builder().namespace("namespace").build()

        val body = params._body().getOrNull()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getPathParam() {
        val params = NamespaceUpsertParams.builder().namespace("namespace").build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
