// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.errors.TurbopufferInvalidDataException

/** A function used to calculate vector similarity. */
class DistanceMetric @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
        @JvmField val COSINE_DISTANCE = of("cosine_distance")

        /** Defined as `sum((x - y)^2)`. Lower is better. */
        @JvmField val EUCLIDEAN_SQUARED = of("euclidean_squared")

        @JvmStatic fun of(value: String) = DistanceMetric(JsonField.of(value))
    }

    /** An enum containing [DistanceMetric]'s known values. */
    enum class Known {
        /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
        COSINE_DISTANCE,
        /** Defined as `sum((x - y)^2)`. Lower is better. */
        EUCLIDEAN_SQUARED,
    }

    /**
     * An enum containing [DistanceMetric]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [DistanceMetric] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
        COSINE_DISTANCE,
        /** Defined as `sum((x - y)^2)`. Lower is better. */
        EUCLIDEAN_SQUARED,
        /**
         * An enum member indicating that [DistanceMetric] was instantiated with an unknown value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            COSINE_DISTANCE -> Value.COSINE_DISTANCE
            EUCLIDEAN_SQUARED -> Value.EUCLIDEAN_SQUARED
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
     *   member.
     */
    fun known(): Known =
        when (this) {
            COSINE_DISTANCE -> Known.COSINE_DISTANCE
            EUCLIDEAN_SQUARED -> Known.EUCLIDEAN_SQUARED
            else -> throw TurbopufferInvalidDataException("Unknown DistanceMetric: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws TurbopufferInvalidDataException if this class instance's value does not have the
     *   expected primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { TurbopufferInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): DistanceMetric = apply {
        if (validated) {
            return@apply
        }

        known()
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
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DistanceMetric && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
