// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.errors.TurbopufferInvalidDataException

/** The data type of the attribute. */
class AttributeType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        /** A string. */
        @JvmField val STRING = of("string")

        /** An unsigned integer. */
        @JvmField val UINT = of("uint")

        /** A UUID. */
        @JvmField val UUID = of("uuid")

        /** A boolean. */
        @JvmField val BOOL = of("bool")

        /** A date and time. */
        @JvmField val DATETIME = of("datetime")

        /** An array of strings. */
        @JvmField val STRING_ARRAY = of("[]string")

        /** An array of unsigned integers. */
        @JvmField val UINT_ARRAY = of("[]uint")

        /** An array of UUIDs. */
        @JvmField val UUID_ARRAY = of("[]uuid")

        /** An array of date and time values. */
        @JvmField val DATETIME_ARRAY = of("[]datetime")

        @JvmStatic fun of(value: String) = AttributeType(JsonField.of(value))
    }

    /** An enum containing [AttributeType]'s known values. */
    enum class Known {
        /** A string. */
        STRING,
        /** An unsigned integer. */
        UINT,
        /** A UUID. */
        UUID,
        /** A boolean. */
        BOOL,
        /** A date and time. */
        DATETIME,
        /** An array of strings. */
        STRING_ARRAY,
        /** An array of unsigned integers. */
        UINT_ARRAY,
        /** An array of UUIDs. */
        UUID_ARRAY,
        /** An array of date and time values. */
        DATETIME_ARRAY,
    }

    /**
     * An enum containing [AttributeType]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [AttributeType] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        /** A string. */
        STRING,
        /** An unsigned integer. */
        UINT,
        /** A UUID. */
        UUID,
        /** A boolean. */
        BOOL,
        /** A date and time. */
        DATETIME,
        /** An array of strings. */
        STRING_ARRAY,
        /** An array of unsigned integers. */
        UINT_ARRAY,
        /** An array of UUIDs. */
        UUID_ARRAY,
        /** An array of date and time values. */
        DATETIME_ARRAY,
        /**
         * An enum member indicating that [AttributeType] was instantiated with an unknown value.
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
            STRING -> Value.STRING
            UINT -> Value.UINT
            UUID -> Value.UUID
            BOOL -> Value.BOOL
            DATETIME -> Value.DATETIME
            STRING_ARRAY -> Value.STRING_ARRAY
            UINT_ARRAY -> Value.UINT_ARRAY
            UUID_ARRAY -> Value.UUID_ARRAY
            DATETIME_ARRAY -> Value.DATETIME_ARRAY
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
            STRING -> Known.STRING
            UINT -> Known.UINT
            UUID -> Known.UUID
            BOOL -> Known.BOOL
            DATETIME -> Known.DATETIME
            STRING_ARRAY -> Known.STRING_ARRAY
            UINT_ARRAY -> Known.UINT_ARRAY
            UUID_ARRAY -> Known.UUID_ARRAY
            DATETIME_ARRAY -> Known.DATETIME_ARRAY
            else -> throw TurbopufferInvalidDataException("Unknown AttributeType: $value")
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

    fun validate(): AttributeType = apply {
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

        return /* spotless:off */ other is AttributeType && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
