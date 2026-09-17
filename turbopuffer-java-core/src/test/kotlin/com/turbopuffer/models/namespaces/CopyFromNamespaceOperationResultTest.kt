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

internal class CopyFromNamespaceOperationResultTest {

    @Test
    fun ofSuccess() {
        val success =
            CopyFromNamespaceOperationResult.Success.builder()
                .success(
                    WriteResult.builder()
                        .billing(
                            WriteBilling.builder()
                                .billableLogicalBytesWritten(0L)
                                .query(
                                    QueryBilling.builder()
                                        .billableLogicalBytesQueried(0L)
                                        .billableLogicalBytesReturned(0L)
                                        .build()
                                )
                                .build()
                        )
                        .message("message")
                        .rowsAffected(0L)
                        .addDeletedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addPatchedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .performance(WritePerformance.builder().serverTotalMs(0L).build())
                        .rowsDeleted(0L)
                        .rowsPatched(0L)
                        .rowsRemaining(true)
                        .rowsUpserted(0L)
                        .addUpsertedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .build()

        val copyFromNamespaceOperationResult = CopyFromNamespaceOperationResult.ofSuccess(success)

        assertThat(copyFromNamespaceOperationResult.success()).contains(success)
        assertThat(copyFromNamespaceOperationResult.error()).isEmpty
    }

    @Test
    fun ofSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceOperationResult =
            CopyFromNamespaceOperationResult.ofSuccess(
                CopyFromNamespaceOperationResult.Success.builder()
                    .success(
                        WriteResult.builder()
                            .billing(
                                WriteBilling.builder()
                                    .billableLogicalBytesWritten(0L)
                                    .query(
                                        QueryBilling.builder()
                                            .billableLogicalBytesQueried(0L)
                                            .billableLogicalBytesReturned(0L)
                                            .build()
                                    )
                                    .build()
                            )
                            .message("message")
                            .rowsAffected(0L)
                            .addDeletedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .addPatchedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .performance(WritePerformance.builder().serverTotalMs(0L).build())
                            .rowsDeleted(0L)
                            .rowsPatched(0L)
                            .rowsRemaining(true)
                            .rowsUpserted(0L)
                            .addUpsertedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        val roundtrippedCopyFromNamespaceOperationResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceOperationResult),
                jacksonTypeRef<CopyFromNamespaceOperationResult>(),
            )

        assertThat(roundtrippedCopyFromNamespaceOperationResult)
            .isEqualTo(copyFromNamespaceOperationResult)
    }

    @Test
    fun ofError() {
        val error =
            CopyFromNamespaceOperationResult.Error.builder()
                .error(
                    OperationError.builder()
                        .detail(OperationError.Detail.builder().error("error").build())
                        .statusCode(0L)
                        .build()
                )
                .build()

        val copyFromNamespaceOperationResult = CopyFromNamespaceOperationResult.ofError(error)

        assertThat(copyFromNamespaceOperationResult.success()).isEmpty
        assertThat(copyFromNamespaceOperationResult.error()).contains(error)
    }

    @Test
    fun ofErrorRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceOperationResult =
            CopyFromNamespaceOperationResult.ofError(
                CopyFromNamespaceOperationResult.Error.builder()
                    .error(
                        OperationError.builder()
                            .detail(OperationError.Detail.builder().error("error").build())
                            .statusCode(0L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedCopyFromNamespaceOperationResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceOperationResult),
                jacksonTypeRef<CopyFromNamespaceOperationResult>(),
            )

        assertThat(roundtrippedCopyFromNamespaceOperationResult)
            .isEqualTo(copyFromNamespaceOperationResult)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val copyFromNamespaceOperationResult =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<CopyFromNamespaceOperationResult>())

        val e =
            assertThrows<TurbopufferInvalidDataException> {
                copyFromNamespaceOperationResult.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
