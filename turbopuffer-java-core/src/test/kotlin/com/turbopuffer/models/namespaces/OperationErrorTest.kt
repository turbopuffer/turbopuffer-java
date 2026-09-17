// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperationErrorTest {

    @Test
    fun create() {
        val operationError =
            OperationError.builder()
                .detail(OperationError.Detail.builder().error("error").build())
                .statusCode(0L)
                .build()

        assertThat(operationError.detail())
            .isEqualTo(OperationError.Detail.builder().error("error").build())
        assertThat(operationError.statusCode()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val operationError =
            OperationError.builder()
                .detail(OperationError.Detail.builder().error("error").build())
                .statusCode(0L)
                .build()

        val roundtrippedOperationError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(operationError),
                jacksonTypeRef<OperationError>(),
            )

        assertThat(roundtrippedOperationError).isEqualTo(operationError)
    }
}
