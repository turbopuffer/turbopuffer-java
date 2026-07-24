// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.errors.TurbopufferInvalidDataException

/** How to split a text attribute into fragments for highlighting. */
class HighlightFragmentBy @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        /** Treat the whole attribute as a single fragment. */
        @JvmField val NONE = of("none")

        /** Split the attribute into sentences. This is the default. */
        @JvmField val SENTENCE = of("sentence")

        /** Split the attribute into paragraphs. */
        @JvmField val PARAGRAPH = of("paragraph")

        /** Split the attribute into individual words. */
        @JvmField val WORD = of("word")

        @JvmStatic fun of(value: String) = HighlightFragmentBy(JsonField.of(value))
    }

    /** An enum containing [HighlightFragmentBy]'s known values. */
    enum class Known {
        /** Treat the whole attribute as a single fragment. */
        NONE,
        /** Split the attribute into sentences. This is the default. */
        SENTENCE,
        /** Split the attribute into paragraphs. */
        PARAGRAPH,
        /** Split the attribute into individual words. */
        WORD,
    }

    /**
     * An enum containing [HighlightFragmentBy]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [HighlightFragmentBy] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        /** Treat the whole attribute as a single fragment. */
        NONE,
        /** Split the attribute into sentences. This is the default. */
        SENTENCE,
        /** Split the attribute into paragraphs. */
        PARAGRAPH,
        /** Split the attribute into individual words. */
        WORD,
        /**
         * An enum member indicating that [HighlightFragmentBy] was instantiated with an unknown
         * value.
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
            NONE -> Value.NONE
            SENTENCE -> Value.SENTENCE
            PARAGRAPH -> Value.PARAGRAPH
            WORD -> Value.WORD
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
            NONE -> Known.NONE
            SENTENCE -> Known.SENTENCE
            PARAGRAPH -> Known.PARAGRAPH
            WORD -> Known.WORD
            else -> throw TurbopufferInvalidDataException("Unknown HighlightFragmentBy: $value")
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws TurbopufferInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): HighlightFragmentBy = apply {
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

        return other is HighlightFragmentBy && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
