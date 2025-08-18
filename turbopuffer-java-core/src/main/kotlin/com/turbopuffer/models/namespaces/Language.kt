// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.Enum
import com.turbopuffer.core.JsonField
import com.turbopuffer.errors.TurbopufferInvalidDataException

/** Describes the language of a text attribute. Defaults to `english`. */
class Language @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val ARABIC = of("arabic")

        @JvmField val DANISH = of("danish")

        @JvmField val DUTCH = of("dutch")

        @JvmField val ENGLISH = of("english")

        @JvmField val FINNISH = of("finnish")

        @JvmField val FRENCH = of("french")

        @JvmField val GERMAN = of("german")

        @JvmField val GREEK = of("greek")

        @JvmField val HUNGARIAN = of("hungarian")

        @JvmField val ITALIAN = of("italian")

        @JvmField val NORWEGIAN = of("norwegian")

        @JvmField val PORTUGUESE = of("portuguese")

        @JvmField val ROMANIAN = of("romanian")

        @JvmField val RUSSIAN = of("russian")

        @JvmField val SPANISH = of("spanish")

        @JvmField val SWEDISH = of("swedish")

        @JvmField val TAMIL = of("tamil")

        @JvmField val TURKISH = of("turkish")

        @JvmStatic fun of(value: String) = Language(JsonField.of(value))
    }

    /** An enum containing [Language]'s known values. */
    enum class Known {
        ARABIC,
        DANISH,
        DUTCH,
        ENGLISH,
        FINNISH,
        FRENCH,
        GERMAN,
        GREEK,
        HUNGARIAN,
        ITALIAN,
        NORWEGIAN,
        PORTUGUESE,
        ROMANIAN,
        RUSSIAN,
        SPANISH,
        SWEDISH,
        TAMIL,
        TURKISH,
    }

    /**
     * An enum containing [Language]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [Language] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        ARABIC,
        DANISH,
        DUTCH,
        ENGLISH,
        FINNISH,
        FRENCH,
        GERMAN,
        GREEK,
        HUNGARIAN,
        ITALIAN,
        NORWEGIAN,
        PORTUGUESE,
        ROMANIAN,
        RUSSIAN,
        SPANISH,
        SWEDISH,
        TAMIL,
        TURKISH,
        /** An enum member indicating that [Language] was instantiated with an unknown value. */
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
            ARABIC -> Value.ARABIC
            DANISH -> Value.DANISH
            DUTCH -> Value.DUTCH
            ENGLISH -> Value.ENGLISH
            FINNISH -> Value.FINNISH
            FRENCH -> Value.FRENCH
            GERMAN -> Value.GERMAN
            GREEK -> Value.GREEK
            HUNGARIAN -> Value.HUNGARIAN
            ITALIAN -> Value.ITALIAN
            NORWEGIAN -> Value.NORWEGIAN
            PORTUGUESE -> Value.PORTUGUESE
            ROMANIAN -> Value.ROMANIAN
            RUSSIAN -> Value.RUSSIAN
            SPANISH -> Value.SPANISH
            SWEDISH -> Value.SWEDISH
            TAMIL -> Value.TAMIL
            TURKISH -> Value.TURKISH
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
            ARABIC -> Known.ARABIC
            DANISH -> Known.DANISH
            DUTCH -> Known.DUTCH
            ENGLISH -> Known.ENGLISH
            FINNISH -> Known.FINNISH
            FRENCH -> Known.FRENCH
            GERMAN -> Known.GERMAN
            GREEK -> Known.GREEK
            HUNGARIAN -> Known.HUNGARIAN
            ITALIAN -> Known.ITALIAN
            NORWEGIAN -> Known.NORWEGIAN
            PORTUGUESE -> Known.PORTUGUESE
            ROMANIAN -> Known.ROMANIAN
            RUSSIAN -> Known.RUSSIAN
            SPANISH -> Known.SPANISH
            SWEDISH -> Known.SWEDISH
            TAMIL -> Known.TAMIL
            TURKISH -> Known.TURKISH
            else -> throw TurbopufferInvalidDataException("Unknown Language: $value")
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

    fun validate(): Language = apply {
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

        return other is Language && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
