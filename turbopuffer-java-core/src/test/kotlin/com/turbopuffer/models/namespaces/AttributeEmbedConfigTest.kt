// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttributeEmbedConfigTest {

    @Test
    fun create() {
        val attributeEmbedConfig =
            AttributeEmbedConfig.builder().model("model").attribute("attribute").dims(0L).build()

        assertThat(attributeEmbedConfig.model()).isEqualTo("model")
        assertThat(attributeEmbedConfig.attribute()).contains("attribute")
        assertThat(attributeEmbedConfig.dims()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val attributeEmbedConfig =
            AttributeEmbedConfig.builder().model("model").attribute("attribute").dims(0L).build()

        val roundtrippedAttributeEmbedConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeEmbedConfig),
                jacksonTypeRef<AttributeEmbedConfig>(),
            )

        assertThat(roundtrippedAttributeEmbedConfig).isEqualTo(attributeEmbedConfig)
    }
}
