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

internal class BranchFromNamespaceParamsTest {

    @Test
    fun ofString() {
        val string = "string"

        val branchFromNamespaceParams = BranchFromNamespaceParams.ofString(string)

        assertThat(branchFromNamespaceParams.string()).contains(string)
        assertThat(branchFromNamespaceParams.config()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val branchFromNamespaceParams = BranchFromNamespaceParams.ofString("string")

        val roundtrippedBranchFromNamespaceParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(branchFromNamespaceParams),
                jacksonTypeRef<BranchFromNamespaceParams>(),
            )

        assertThat(roundtrippedBranchFromNamespaceParams).isEqualTo(branchFromNamespaceParams)
    }

    @Test
    fun ofConfig() {
        val config =
            BranchFromNamespaceParams.BranchFromNamespaceConfig.builder()
                .sourceNamespace("source_namespace")
                .build()

        val branchFromNamespaceParams = BranchFromNamespaceParams.ofConfig(config)

        assertThat(branchFromNamespaceParams.string()).isEmpty
        assertThat(branchFromNamespaceParams.config()).contains(config)
    }

    @Test
    fun ofConfigRoundtrip() {
        val jsonMapper = jsonMapper()
        val branchFromNamespaceParams =
            BranchFromNamespaceParams.ofConfig(
                BranchFromNamespaceParams.BranchFromNamespaceConfig.builder()
                    .sourceNamespace("source_namespace")
                    .build()
            )

        val roundtrippedBranchFromNamespaceParams =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(branchFromNamespaceParams),
                jacksonTypeRef<BranchFromNamespaceParams>(),
            )

        assertThat(roundtrippedBranchFromNamespaceParams).isEqualTo(branchFromNamespaceParams)
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
        val branchFromNamespaceParams =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BranchFromNamespaceParams>())

        val e =
            assertThrows<TurbopufferInvalidDataException> { branchFromNamespaceParams.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
