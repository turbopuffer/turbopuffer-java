// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbedParamsTest {

    @Test
    fun create() {
        val embedParams = EmbedParams.builder().model("model").build()

        assertThat(embedParams.model()).contains("model")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val embedParams = EmbedParams.builder().model("model").build()

        val roundtrippedEmbedParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(embedParams),
                jacksonTypeRef<EmbedParams>(),
            )

        assertThat(roundtrippedEmbedParams).isEqualTo(embedParams)
    }
}
