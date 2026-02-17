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

/** Additional parameters for the Saturate operator. */
class SaturateParams
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val exponent: JsonField<Double>,
    private val midpoint: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("exponent") @ExcludeMissing exponent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("midpoint") @ExcludeMissing midpoint: JsonValue = JsonMissing.of(),
    ) : this(exponent, midpoint, mutableMapOf())

    /**
     * An exponent that helps further control the shape of the Saturate function.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exponent(): Optional<Double> = exponent.getOptional("exponent")

    /**
     * The midpoint of the Saturate operator.
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = saturateParams.midpoint().convert(MyClass.class);
     * ```
     */
    @JsonProperty("midpoint") @ExcludeMissing fun _midpoint(): JsonValue = midpoint

    /**
     * Returns the raw JSON value of [exponent].
     *
     * Unlike [exponent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("exponent") @ExcludeMissing fun _exponent(): JsonField<Double> = exponent

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

        /** Returns a mutable builder for constructing an instance of [SaturateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SaturateParams]. */
    class Builder internal constructor() {

        private var exponent: JsonField<Double> = JsonMissing.of()
        private var midpoint: JsonValue = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(saturateParams: SaturateParams) = apply {
            exponent = saturateParams.exponent
            midpoint = saturateParams.midpoint
            additionalProperties = saturateParams.additionalProperties.toMutableMap()
        }

        /** An exponent that helps further control the shape of the Saturate function. */
        fun exponent(exponent: Double) = exponent(JsonField.of(exponent))

        /**
         * Sets [Builder.exponent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exponent] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun exponent(exponent: JsonField<Double>) = apply { this.exponent = exponent }

        /** The midpoint of the Saturate operator. */
        fun midpoint(midpoint: JsonValue) = apply { this.midpoint = midpoint }

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
         * Returns an immutable instance of [SaturateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SaturateParams =
            SaturateParams(exponent, midpoint, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): SaturateParams = apply {
        if (validated) {
            return@apply
        }

        exponent()
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
    @JvmSynthetic internal fun validity(): Int = (if (exponent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SaturateParams &&
            exponent == other.exponent &&
            midpoint == other.midpoint &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(exponent, midpoint, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SaturateParams{exponent=$exponent, midpoint=$midpoint, additionalProperties=$additionalProperties}"
}
