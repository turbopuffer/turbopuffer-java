// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.jsonMapper
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class CopyFromNamespaceOperationTest {

    @Test
    fun ofRunning() {
        val running =
            CopyFromNamespaceOperation.Running.builder()
                .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .progress("progress")
                .build()

        val copyFromNamespaceOperation = CopyFromNamespaceOperation.ofRunning(running)

        assertThat(copyFromNamespaceOperation.running()).contains(running)
        assertThat(copyFromNamespaceOperation.finished()).isEmpty
    }

    @Test
    fun ofRunningRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceOperation =
            CopyFromNamespaceOperation.ofRunning(
                CopyFromNamespaceOperation.Running.builder()
                    .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .progress("progress")
                    .build()
            )

        val roundtrippedCopyFromNamespaceOperation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceOperation),
                jacksonTypeRef<CopyFromNamespaceOperation>(),
            )

        assertThat(roundtrippedCopyFromNamespaceOperation).isEqualTo(copyFromNamespaceOperation)
    }

    @Test
    fun ofFinished() {
        val finished =
            CopyFromNamespaceOperation.Finished.builder()
                .finishTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .result(
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
                .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val copyFromNamespaceOperation = CopyFromNamespaceOperation.ofFinished(finished)

        assertThat(copyFromNamespaceOperation.running()).isEmpty
        assertThat(copyFromNamespaceOperation.finished()).contains(finished)
    }

    @Test
    fun ofFinishedRoundtrip() {
        val jsonMapper = jsonMapper()
        val copyFromNamespaceOperation =
            CopyFromNamespaceOperation.ofFinished(
                CopyFromNamespaceOperation.Finished.builder()
                    .finishTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .result(
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
                                    .performance(
                                        WritePerformance.builder().serverTotalMs(0L).build()
                                    )
                                    .rowsDeleted(0L)
                                    .rowsPatched(0L)
                                    .rowsRemaining(true)
                                    .rowsUpserted(0L)
                                    .addUpsertedId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    .build()
                            )
                            .build()
                    )
                    .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val roundtrippedCopyFromNamespaceOperation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(copyFromNamespaceOperation),
                jacksonTypeRef<CopyFromNamespaceOperation>(),
            )

        assertThat(roundtrippedCopyFromNamespaceOperation).isEqualTo(copyFromNamespaceOperation)
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
        val copyFromNamespaceOperation =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CopyFromNamespaceOperation>())

        val e =
            assertThrows<TurbopufferInvalidDataException> { copyFromNamespaceOperation.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
