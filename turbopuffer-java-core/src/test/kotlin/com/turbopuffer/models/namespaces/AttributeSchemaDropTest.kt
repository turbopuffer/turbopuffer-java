// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AttributeSchemaDropTest {

    @Test
    fun create() {
        val attributeSchemaDrop = AttributeSchemaDrop.builder().drop(true).build()

        assertThat(attributeSchemaDrop.drop()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val attributeSchemaDrop = AttributeSchemaDrop.builder().drop(true).build()

        val roundtrippedAttributeSchemaDrop =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(attributeSchemaDrop),
                jacksonTypeRef<AttributeSchemaDrop>(),
            )

        assertThat(roundtrippedAttributeSchemaDrop).isEqualTo(attributeSchemaDrop)
    }
}
