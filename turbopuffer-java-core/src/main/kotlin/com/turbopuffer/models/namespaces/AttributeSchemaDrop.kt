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

/** Drops the attribute from the namespace. Cannot be combined with other schema settings. */
class AttributeSchemaDrop
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val drop: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("drop") @ExcludeMissing drop: JsonField<Boolean> = JsonMissing.of()
    ) : this(drop, mutableMapOf())

    /**
     * Must be `true`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun drop(): Boolean = drop.getRequired("drop")

    /**
     * Returns the raw JSON value of [drop].
     *
     * Unlike [drop], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("drop") @ExcludeMissing fun _drop(): JsonField<Boolean> = drop

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
         * Returns a mutable builder for constructing an instance of [AttributeSchemaDrop].
         *
         * The following fields are required:
         * ```java
         * .drop()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AttributeSchemaDrop]. */
    class Builder internal constructor() {

        private var drop: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attributeSchemaDrop: AttributeSchemaDrop) = apply {
            drop = attributeSchemaDrop.drop
            additionalProperties = attributeSchemaDrop.additionalProperties.toMutableMap()
        }

        /** Must be `true`. */
        fun drop(drop: Boolean) = drop(JsonField.of(drop))

        /**
         * Sets [Builder.drop] to an arbitrary JSON value.
         *
         * You should usually call [Builder.drop] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun drop(drop: JsonField<Boolean>) = apply { this.drop = drop }

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
         * Returns an immutable instance of [AttributeSchemaDrop].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .drop()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AttributeSchemaDrop =
            AttributeSchemaDrop(checkRequired("drop", drop), additionalProperties.toMutableMap())
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
    fun validate(): AttributeSchemaDrop = apply {
        if (validated) {
            return@apply
        }

        drop()
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
    @JvmSynthetic internal fun validity(): Int = (if (drop.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AttributeSchemaDrop &&
            drop == other.drop &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(drop, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AttributeSchemaDrop{drop=$drop, additionalProperties=$additionalProperties}"
}
