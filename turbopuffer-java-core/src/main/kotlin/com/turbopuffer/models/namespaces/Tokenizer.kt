// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.errors.TurbopufferInvalidDataException

/** The tokenizer to use for full-text search on an attribute. */
class Tokenizer @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val PRE_TOKENIZED_ARRAY = of("pre_tokenized_array")

        @JvmField val WORD_V0 = of("word_v0")

        @JvmField val WORD_V1 = of("word_v1")

        @JvmStatic fun of(value: String) = Tokenizer(JsonField.of(value))
    }

    /** An enum containing [Tokenizer]'s known values. */
    enum class Known {
        PRE_TOKENIZED_ARRAY,
        WORD_V0,
        WORD_V1,
    }

    /**
     * An enum containing [Tokenizer]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [Tokenizer] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        PRE_TOKENIZED_ARRAY,
        WORD_V0,
        WORD_V1,
        /** An enum member indicating that [Tokenizer] was instantiated with an unknown value. */
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
            PRE_TOKENIZED_ARRAY -> Value.PRE_TOKENIZED_ARRAY
            WORD_V0 -> Value.WORD_V0
            WORD_V1 -> Value.WORD_V1
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
            PRE_TOKENIZED_ARRAY -> Known.PRE_TOKENIZED_ARRAY
            WORD_V0 -> Known.WORD_V0
            WORD_V1 -> Known.WORD_V1
            else -> throw TurbopufferInvalidDataException("Unknown Tokenizer: $value")
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

    fun validate(): Tokenizer = apply {
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

        return other is Tokenizer && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
