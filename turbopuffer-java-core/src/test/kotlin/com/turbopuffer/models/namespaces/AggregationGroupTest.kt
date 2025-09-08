// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AggregationGroupTest {

    @Test
    fun create() {
        val aggregationGroup =
            AggregationGroup.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val aggregationGroup =
            AggregationGroup.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val roundtrippedAggregationGroup =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(aggregationGroup),
                jacksonTypeRef<AggregationGroup>(),
            )

        assertThat(roundtrippedAggregationGroup).isEqualTo(aggregationGroup)
    }
}
