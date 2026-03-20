// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class CopyFromNamespaceParamsTest {

    @Test
    fun ofString() {
        val string = "string"

        val copyFromNamespaceParams = CopyFromNamespaceParams.ofString(string)

        assertThat(copyFromNamespaceParams.string()).contains(string)
        assertThat(copyFromNamespaceParams.config()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceParams = CopyFromNamespaceParams.ofString("string")

        val roundtrippedCopyFromNamespaceParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceParams),
                jacksonTypeRef<CopyFromNamespaceParams>(),
            )

        assertThat(roundtrippedCopyFromNamespaceParams).isEqualTo(copyFromNamespaceParams)
    }

    @Test
    fun ofConfig() {
        val config =
            CopyFromNamespaceParams.CopyFromNamespaceConfig.builder()
                .sourceNamespace("source_namespace")
                .sourceApiKey("source_api_key")
                .sourceRegion("source_region")
                .build()

        val copyFromNamespaceParams = CopyFromNamespaceParams.ofConfig(config)

        assertThat(copyFromNamespaceParams.string()).isEmpty
        assertThat(copyFromNamespaceParams.config()).contains(config)
    }

    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceParams =
            CopyFromNamespaceParams.ofConfig(
                CopyFromNamespaceParams.CopyFromNamespaceConfig.builder()
                    .sourceNamespace("source_namespace")
                    .sourceApiKey("source_api_key")
                    .sourceRegion("source_region")
                    .build()
            )

        val roundtrippedCopyFromNamespaceParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceParams),
                jacksonTypeRef<CopyFromNamespaceParams>(),
            )

        assertThat(roundtrippedCopyFromNamespaceParams).isEqualTo(copyFromNamespaceParams)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val copyFromNamespaceParams =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CopyFromNamespaceParams>())

        val e = assertThrows<TurbopufferInvalidDataException> { copyFromNamespaceParams.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
