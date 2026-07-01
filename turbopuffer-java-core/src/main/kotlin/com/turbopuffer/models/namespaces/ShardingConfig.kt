// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.checkRequired
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Configuration for namespace sharding, which partitions a namespace's documents across multiple
 * internal shards to scale indexing and query throughput beyond a single machine. Sharding can only
 * be configured on a namespace's inaugural write, and cannot be added to or changed on an existing
 * namespace.
 */
class ShardingConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val numShards: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("num_shards") @ExcludeMissing numShards: JsonField<Int> = JsonMissing.of()
    ) : this(numShards, mutableMapOf())

    /**
     * The number of shards to partition the namespace into.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun numShards(): Int = numShards.getRequired("num_shards")

    /**
     * Returns the raw JSON value of [numShards].
     *
     * Unlike [numShards], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("num_shards") @ExcludeMissing fun _numShards(): JsonField<Int> = numShards

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ShardingConfig].
         *
         * The following fields are required:
         * ```java
         * .numShards()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ShardingConfig]. */
    class Builder internal constructor() {

        private var numShards: JsonField<Int>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(shardingConfig: ShardingConfig) = apply {
            numShards = shardingConfig.numShards
            additionalProperties = shardingConfig.additionalProperties.toMutableMap()
        }

        /** The number of shards to partition the namespace into. */
        fun numShards(numShards: Int) = numShards(JsonField.of(numShards))

        /**
         * Sets [Builder.numShards] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numShards] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun numShards(numShards: JsonField<Int>) = apply { this.numShards = numShards }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ShardingConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .numShards()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ShardingConfig =
            ShardingConfig(
                checkRequired("numShards", numShards),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws TurbopufferInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ShardingConfig = apply {
        if (validated) {
            return@apply
        }

        numShards()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: TurbopufferInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = (if (numShards.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ShardingConfig &&
            numShards == other.numShards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(numShards, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ShardingConfig{numShards=$numShards, additionalProperties=$additionalProperties}"
}
