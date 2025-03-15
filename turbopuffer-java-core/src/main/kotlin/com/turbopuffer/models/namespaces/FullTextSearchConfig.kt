// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.Enum
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** Detailed configuration options for BM25 full-text search. */
@NoAutoDetect
class FullTextSearchConfig
@JsonCreator
private constructor(
    @JsonProperty("case_sensitive")
    @ExcludeMissing
    private val caseSensitive: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("language")
    @ExcludeMissing
    private val language: JsonField<Language> = JsonMissing.of(),
    @JsonProperty("remove_stopwords")
    @ExcludeMissing
    private val removeStopwords: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("stemming")
    @ExcludeMissing
    private val stemming: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Whether searching is case-sensitive. Defaults to `false` (i.e. case-insensitive).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun caseSensitive(): Optional<Boolean> =
        Optional.ofNullable(caseSensitive.getNullable("case_sensitive"))

    /**
     * The language of the text. Defaults to `english`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<Language> = Optional.ofNullable(language.getNullable("language"))

    /**
     * Removes common words from the text based on language. Defaults to `true` (i.e. remove common
     * words).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun removeStopwords(): Optional<Boolean> =
        Optional.ofNullable(removeStopwords.getNullable("remove_stopwords"))

    /**
     * Language-specific stemming for the text. Defaults to `false` (i.e., do not stem).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stemming(): Optional<Boolean> = Optional.ofNullable(stemming.getNullable("stemming"))

    /**
     * Returns the raw JSON value of [caseSensitive].
     *
     * Unlike [caseSensitive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("case_sensitive")
    @ExcludeMissing
    fun _caseSensitive(): JsonField<Boolean> = caseSensitive

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<Language> = language

    /**
     * Returns the raw JSON value of [removeStopwords].
     *
     * Unlike [removeStopwords], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("remove_stopwords")
    @ExcludeMissing
    fun _removeStopwords(): JsonField<Boolean> = removeStopwords

    /**
     * Returns the raw JSON value of [stemming].
     *
     * Unlike [stemming], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stemming") @ExcludeMissing fun _stemming(): JsonField<Boolean> = stemming

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): FullTextSearchConfig = apply {
        if (validated) {
            return@apply
        }

        caseSensitive()
        language()
        removeStopwords()
        stemming()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [FullTextSearchConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FullTextSearchConfig]. */
    class Builder internal constructor() {

        private var caseSensitive: JsonField<Boolean> = JsonMissing.of()
        private var language: JsonField<Language> = JsonMissing.of()
        private var removeStopwords: JsonField<Boolean> = JsonMissing.of()
        private var stemming: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fullTextSearchConfig: FullTextSearchConfig) = apply {
            caseSensitive = fullTextSearchConfig.caseSensitive
            language = fullTextSearchConfig.language
            removeStopwords = fullTextSearchConfig.removeStopwords
            stemming = fullTextSearchConfig.stemming
            additionalProperties = fullTextSearchConfig.additionalProperties.toMutableMap()
        }

        /** Whether searching is case-sensitive. Defaults to `false` (i.e. case-insensitive). */
        fun caseSensitive(caseSensitive: Boolean) = caseSensitive(JsonField.of(caseSensitive))

        /**
         * Sets [Builder.caseSensitive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.caseSensitive] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun caseSensitive(caseSensitive: JsonField<Boolean>) = apply {
            this.caseSensitive = caseSensitive
        }

        /** The language of the text. Defaults to `english`. */
        fun language(language: Language) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [Language] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun language(language: JsonField<Language>) = apply { this.language = language }

        /**
         * Removes common words from the text based on language. Defaults to `true` (i.e. remove
         * common words).
         */
        fun removeStopwords(removeStopwords: Boolean) =
            removeStopwords(JsonField.of(removeStopwords))

        /**
         * Sets [Builder.removeStopwords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.removeStopwords] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun removeStopwords(removeStopwords: JsonField<Boolean>) = apply {
            this.removeStopwords = removeStopwords
        }

        /** Language-specific stemming for the text. Defaults to `false` (i.e., do not stem). */
        fun stemming(stemming: Boolean) = stemming(JsonField.of(stemming))

        /**
         * Sets [Builder.stemming] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stemming] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun stemming(stemming: JsonField<Boolean>) = apply { this.stemming = stemming }

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

        fun build(): FullTextSearchConfig =
            FullTextSearchConfig(
                caseSensitive,
                language,
                removeStopwords,
                stemming,
                additionalProperties.toImmutable(),
            )
    }

    /** The language of the text. Defaults to `english`. */
    class Language @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Language && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FullTextSearchConfig && caseSensitive == other.caseSensitive && language == other.language && removeStopwords == other.removeStopwords && stemming == other.stemming && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(caseSensitive, language, removeStopwords, stemming, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FullTextSearchConfig{caseSensitive=$caseSensitive, language=$language, removeStopwords=$removeStopwords, stemming=$stemming, additionalProperties=$additionalProperties}"
}
