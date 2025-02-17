// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamespaceUpsertParamsTest {

    @Test
    fun create() {
        NamespaceUpsertParams.builder()
            .forUpsertColumnar(
                NamespaceUpsertParams.UpsertColumnar.builder()
                    .attributes(
                        NamespaceUpsertParams.UpsertColumnar.Attributes.builder()
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
                                )
                            )
                            .build()
                    )
                    .distanceMetric(
                        NamespaceUpsertParams.UpsertColumnar.DistanceMetric.COSINE_DISTANCE
                    )
                    .ids(
                        listOf(
                            NamespaceUpsertParams.UpsertColumnar.Id.ofString(
                                "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                            )
                        )
                    )
                    .schema(
                        NamespaceUpsertParams.UpsertColumnar.Schema.builder()
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
                                )
                            )
                            .build()
                    )
                    .vectors(listOf(NamespaceUpsertParams.UpsertColumnar.Vector.ofNumber(0.0)))
                    .build()
            )
            .namespace("namespace")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            NamespaceUpsertParams.builder()
                .forUpsertColumnar(NamespaceUpsertParams.UpsertColumnar.builder().build())
                .namespace("namespace")
                .build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
