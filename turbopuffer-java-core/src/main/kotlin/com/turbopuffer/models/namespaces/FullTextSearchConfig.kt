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
import kotlin.jvm.optionals.getOrNull

/** Configuration options for full-text search. */
class FullTextSearchConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val b: JsonField<Double>,
    private val caseSensitive: JsonField<Boolean>,
    private val k1: JsonField<Double>,
    private val language: JsonField<Language>,
    private val maxTokenLength: JsonField<Long>,
    private val removeStopwords: JsonField<Boolean>,
    private val stemming: JsonField<Boolean>,
    private val tokenizer: JsonField<Tokenizer>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("b") @ExcludeMissing b: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("case_sensitive")
        @ExcludeMissing
        caseSensitive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("k1") @ExcludeMissing k1: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("language") @ExcludeMissing language: JsonField<Language> = JsonMissing.of(),
        @JsonProperty("max_token_length")
        @ExcludeMissing
        maxTokenLength: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("remove_stopwords")
        @ExcludeMissing
        removeStopwords: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("stemming") @ExcludeMissing stemming: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("tokenizer")
        @ExcludeMissing
        tokenizer: JsonField<Tokenizer> = JsonMissing.of(),
    ) : this(
        b,
        caseSensitive,
        k1,
        language,
        maxTokenLength,
        removeStopwords,
        stemming,
        tokenizer,
        mutableMapOf(),
    )

    /**
     * The `b` document length normalization parameter for BM25. Defaults to `0.75`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun b(): Optional<Double> = b.getOptional("b")

    /**
     * Whether searching is case-sensitive. Defaults to `false` (i.e. case-insensitive).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun caseSensitive(): Optional<Boolean> = caseSensitive.getOptional("case_sensitive")

    /**
     * The `k1` term saturation parameter for BM25. Defaults to `1.2`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun k1(): Optional<Double> = k1.getOptional("k1")

    /**
     * Describes the language of a text attribute. Defaults to `english`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<Language> = language.getOptional("language")

    /**
     * Maximum length of a token in bytes. Tokens larger than this value during tokenization will be
     * filtered out. Has to be between `1` and `254` (inclusive). Defaults to `39`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maxTokenLength(): Optional<Long> = maxTokenLength.getOptional("max_token_length")

    /**
     * Removes common words from the text based on language. Defaults to `true` (i.e. remove common
     * words).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun removeStopwords(): Optional<Boolean> = removeStopwords.getOptional("remove_stopwords")

    /**
     * Language-specific stemming for the text. Defaults to `false` (i.e., do not stem).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun stemming(): Optional<Boolean> = stemming.getOptional("stemming")

    /**
     * The tokenizer to use for full-text search on an attribute. Defaults to `word_v2`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tokenizer(): Optional<Tokenizer> = tokenizer.getOptional("tokenizer")

    /**
     * Returns the raw JSON value of [b].
     *
     * Unlike [b], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("b") @ExcludeMissing fun _b(): JsonField<Double> = b

    /**
     * Returns the raw JSON value of [caseSensitive].
     *
     * Unlike [caseSensitive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("case_sensitive")
    @ExcludeMissing
    fun _caseSensitive(): JsonField<Boolean> = caseSensitive

    /**
     * Returns the raw JSON value of [k1].
     *
     * Unlike [k1], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("k1") @ExcludeMissing fun _k1(): JsonField<Double> = k1

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<Language> = language

    /**
     * Returns the raw JSON value of [maxTokenLength].
     *
     * Unlike [maxTokenLength], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_token_length")
    @ExcludeMissing
    fun _maxTokenLength(): JsonField<Long> = maxTokenLength

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

    /**
     * Returns the raw JSON value of [tokenizer].
     *
     * Unlike [tokenizer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tokenizer") @ExcludeMissing fun _tokenizer(): JsonField<Tokenizer> = tokenizer

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

        /** Returns a mutable builder for constructing an instance of [FullTextSearchConfig]. */
        @JvmStatic fun builder() = Builder()

        /** Returns an instance of [FullTextSearchConfig] with default values. */
        @JvmStatic fun defaults() = Builder().build()
    }

    /** A builder for [FullTextSearchConfig]. */
    class Builder internal constructor() {

        private var b: JsonField<Double> = JsonMissing.of()
        private var caseSensitive: JsonField<Boolean> = JsonMissing.of()
        private var k1: JsonField<Double> = JsonMissing.of()
        private var language: JsonField<Language> = JsonMissing.of()
        private var maxTokenLength: JsonField<Long> = JsonMissing.of()
        private var removeStopwords: JsonField<Boolean> = JsonMissing.of()
        private var stemming: JsonField<Boolean> = JsonMissing.of()
        private var tokenizer: JsonField<Tokenizer> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fullTextSearchConfig: FullTextSearchConfig) = apply {
            b = fullTextSearchConfig.b
            caseSensitive = fullTextSearchConfig.caseSensitive
            k1 = fullTextSearchConfig.k1
            language = fullTextSearchConfig.language
            maxTokenLength = fullTextSearchConfig.maxTokenLength
            removeStopwords = fullTextSearchConfig.removeStopwords
            stemming = fullTextSearchConfig.stemming
            tokenizer = fullTextSearchConfig.tokenizer
            additionalProperties = fullTextSearchConfig.additionalProperties.toMutableMap()
        }

        /** The `b` document length normalization parameter for BM25. Defaults to `0.75`. */
        fun b(b: Double) = b(JsonField.of(b))

        /**
         * Sets [Builder.b] to an arbitrary JSON value.
         *
         * You should usually call [Builder.b] with a well-typed [Double] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun b(b: JsonField<Double>) = apply { this.b = b }

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

        /** The `k1` term saturation parameter for BM25. Defaults to `1.2`. */
        fun k1(k1: Double) = k1(JsonField.of(k1))

        /**
         * Sets [Builder.k1] to an arbitrary JSON value.
         *
         * You should usually call [Builder.k1] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun k1(k1: JsonField<Double>) = apply { this.k1 = k1 }

        /** Describes the language of a text attribute. Defaults to `english`. */
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
         * Maximum length of a token in bytes. Tokens larger than this value during tokenization
         * will be filtered out. Has to be between `1` and `254` (inclusive). Defaults to `39`.
         */
        fun maxTokenLength(maxTokenLength: Long) = maxTokenLength(JsonField.of(maxTokenLength))

        /**
         * Sets [Builder.maxTokenLength] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxTokenLength] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxTokenLength(maxTokenLength: JsonField<Long>) = apply {
            this.maxTokenLength = maxTokenLength
        }

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

        /** The tokenizer to use for full-text search on an attribute. Defaults to `word_v2`. */
        fun tokenizer(tokenizer: Tokenizer) = tokenizer(JsonField.of(tokenizer))

        /**
         * Sets [Builder.tokenizer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tokenizer] with a well-typed [Tokenizer] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tokenizer(tokenizer: JsonField<Tokenizer>) = apply { this.tokenizer = tokenizer }

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
         * Returns an immutable instance of [FullTextSearchConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FullTextSearchConfig =
            FullTextSearchConfig(
                b,
                caseSensitive,
                k1,
                language,
                maxTokenLength,
                removeStopwords,
                stemming,
                tokenizer,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FullTextSearchConfig = apply {
        if (validated) {
            return@apply
        }

        b()
        caseSensitive()
        k1()
        language().ifPresent { it.validate() }
        maxTokenLength()
        removeStopwords()
        stemming()
        tokenizer().ifPresent { it.validate() }
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
    @JvmSynthetic
    internal fun validity(): Int =
        (if (b.asKnown().isPresent) 1 else 0) +
            (if (caseSensitive.asKnown().isPresent) 1 else 0) +
            (if (k1.asKnown().isPresent) 1 else 0) +
            (language.asKnown().getOrNull()?.validity() ?: 0) +
            (if (maxTokenLength.asKnown().isPresent) 1 else 0) +
            (if (removeStopwords.asKnown().isPresent) 1 else 0) +
            (if (stemming.asKnown().isPresent) 1 else 0) +
            (tokenizer.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FullTextSearchConfig &&
            b == other.b &&
            caseSensitive == other.caseSensitive &&
            k1 == other.k1 &&
            language == other.language &&
            maxTokenLength == other.maxTokenLength &&
            removeStopwords == other.removeStopwords &&
            stemming == other.stemming &&
            tokenizer == other.tokenizer &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            b,
            caseSensitive,
            k1,
            language,
            maxTokenLength,
            removeStopwords,
            stemming,
            tokenizer,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FullTextSearchConfig{b=$b, caseSensitive=$caseSensitive, k1=$k1, language=$language, maxTokenLength=$maxTokenLength, removeStopwords=$removeStopwords, stemming=$stemming, tokenizer=$tokenizer, additionalProperties=$additionalProperties}"
}
