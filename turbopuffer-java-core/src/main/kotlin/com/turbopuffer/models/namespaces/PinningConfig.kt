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
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Configuration for namespace pinning. */
class PinningConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val replicas: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("replicas") @ExcludeMissing replicas: JsonField<Long> = JsonMissing.of()
    ) : this(replicas, mutableMapOf())

    /**
     * The number of read replicas to provision. Defaults to 1 if not specified.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun replicas(): Optional<Long> = replicas.getOptional("replicas")

    /**
     * Returns the raw JSON value of [replicas].
     *
     * Unlike [replicas], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("replicas") @ExcludeMissing fun _replicas(): JsonField<Long> = replicas

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

        /** Returns a mutable builder for constructing an instance of [PinningConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PinningConfig]. */
    class Builder internal constructor() {

        private var replicas: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(pinningConfig: PinningConfig) = apply {
            replicas = pinningConfig.replicas
            additionalProperties = pinningConfig.additionalProperties.toMutableMap()
        }

        /** The number of read replicas to provision. Defaults to 1 if not specified. */
        fun replicas(replicas: Long) = replicas(JsonField.of(replicas))

        /**
         * Sets [Builder.replicas] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replicas] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replicas(replicas: JsonField<Long>) = apply { this.replicas = replicas }

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
         * Returns an immutable instance of [PinningConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PinningConfig = PinningConfig(replicas, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): PinningConfig = apply {
        if (validated) {
            return@apply
        }

        replicas()
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
    @JvmSynthetic internal fun validity(): Int = (if (replicas.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PinningConfig &&
            replicas == other.replicas &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(replicas, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PinningConfig{replicas=$replicas, additionalProperties=$additionalProperties}"
}
