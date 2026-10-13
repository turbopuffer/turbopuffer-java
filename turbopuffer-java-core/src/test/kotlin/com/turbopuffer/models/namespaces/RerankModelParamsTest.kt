// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RerankModelParamsTest {

    @Test
    fun create() {
        val rerankModelParams =
            RerankModelParams.builder().attribute("attribute").model("model").query("query").build()

        assertThat(rerankModelParams.attribute()).isEqualTo("attribute")
        assertThat(rerankModelParams.model()).isEqualTo("model")
        assertThat(rerankModelParams.query()).isEqualTo("query")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rerankModelParams =
            RerankModelParams.builder().attribute("attribute").model("model").query("query").build()

        val roundtrippedRerankModelParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rerankModelParams),
                jacksonTypeRef<RerankModelParams>(),
            )

        assertThat(roundtrippedRerankModelParams).isEqualTo(rerankModelParams)
    }
}
