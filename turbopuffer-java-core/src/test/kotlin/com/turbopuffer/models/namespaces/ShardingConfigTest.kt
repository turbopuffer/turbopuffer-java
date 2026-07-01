// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShardingConfigTest {

    @Test
    fun create() {
        val shardingConfig = ShardingConfig.builder().numShards(1).build()

        assertThat(shardingConfig.numShards()).isEqualTo(1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val shardingConfig = ShardingConfig.builder().numShards(1).build()

        val roundtrippedShardingConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(shardingConfig),
                jacksonTypeRef<ShardingConfig>(),
            )

        assertThat(roundtrippedShardingConfig).isEqualTo(shardingConfig)
    }
}
