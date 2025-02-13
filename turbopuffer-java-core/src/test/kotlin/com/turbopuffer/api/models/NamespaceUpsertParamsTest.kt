// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

import com.turbopuffer.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NamespaceUpsertParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        NamespaceUpsertParams.builder()
            .forVariant0(
                NamespaceUpsertParams.UnionMember0.builder()
                    .distanceMetric(
                        NamespaceUpsertParams.UnionMember0.DistanceMetric.COSINE_DISTANCE
                    )
                    .ids(listOf(NamespaceUpsertParams.UnionMember0.Id.ofInteger(0L)))
                    .vectors(listOf(listOf(0.0)))
                    .attributes(
                        NamespaceUpsertParams.UnionMember0.Attributes.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(listOf(mapOf<String, Any>()))
                            )
                            .build()
                    )
                    .copyFromNamespace("copy_from_namespace")
                    .schema(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
            .namespace("namespace")
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun getPathParam() {
        val params =
            NamespaceUpsertParams.builder()
                .forVariant0(
                    NamespaceUpsertParams.UnionMember0.builder()
                        .distanceMetric(
                            NamespaceUpsertParams.UnionMember0.DistanceMetric.COSINE_DISTANCE
                        )
                        .ids(listOf(NamespaceUpsertParams.UnionMember0.Id.ofInteger(0L)))
                        .vectors(listOf(listOf(0.0)))
                        .build()
                )
                .namespace("namespace")
                .build()
        assertThat(params).isNotNull
        // path param "namespace"
        assertThat(params.getPathParam(0)).isEqualTo("namespace")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
