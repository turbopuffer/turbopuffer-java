// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.Enum
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Whether this attribute can be used as part of a BM25 full-text search. Requires the `string` or
 * `[]string` type, and by default, BM25-enabled attributes are not filterable. You can override
 * this by setting `filterable: true`.
 */
@JsonDeserialize(using = FullTextSearchConfig.Deserializer::class)
@JsonSerialize(using = FullTextSearchConfig.Serializer::class)
class FullTextSearchConfig
private constructor(
    private val bool: Boolean? = null,
    private val detailed: Detailed? = null,
    private val _json: JsonValue? = null,
) {

    fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

    fun detailed(): Optional<Detailed> = Optional.ofNullable(detailed)

    fun isBool(): Boolean = bool != null

    fun isDetailed(): Boolean = detailed != null

    fun asBool(): Boolean = bool.getOrThrow("bool")

    fun asDetailed(): Detailed = detailed.getOrThrow("detailed")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            bool != null -> visitor.visitBool(bool)
            detailed != null -> visitor.visitDetailed(detailed)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): FullTextSearchConfig = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitBool(bool: Boolean) {}

                override fun visitDetailed(detailed: Detailed) {
                    detailed.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitBool(bool: Boolean) = 1

                override fun visitDetailed(detailed: Detailed) = detailed.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FullTextSearchConfig && bool == other.bool && detailed == other.detailed /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, detailed) /* spotless:on */

    override fun toString(): String =
        when {
            bool != null -> "FullTextSearchConfig{bool=$bool}"
            detailed != null -> "FullTextSearchConfig{detailed=$detailed}"
            _json != null -> "FullTextSearchConfig{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FullTextSearchConfig")
        }

    companion object {

        @JvmStatic fun ofBool(bool: Boolean) = FullTextSearchConfig(bool = bool)

        @JvmStatic fun ofDetailed(detailed: Detailed) = FullTextSearchConfig(detailed = detailed)
    }

    /**
     * An interface that defines how to map each variant of [FullTextSearchConfig] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitBool(bool: Boolean): T

        fun visitDetailed(detailed: Detailed): T

        /**
         * Maps an unknown variant of [FullTextSearchConfig] to a value of type [T].
         *
         * An instance of [FullTextSearchConfig] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws TurbopufferInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw TurbopufferInvalidDataException("Unknown FullTextSearchConfig: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<FullTextSearchConfig>(FullTextSearchConfig::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): FullTextSearchConfig {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<Detailed>())?.let {
                            FullTextSearchConfig(detailed = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                            FullTextSearchConfig(bool = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from string).
                0 -> FullTextSearchConfig(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<FullTextSearchConfig>(FullTextSearchConfig::class) {

        override fun serialize(
            value: FullTextSearchConfig,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.bool != null -> generator.writeObject(value.bool)
                value.detailed != null -> generator.writeObject(value.detailed)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FullTextSearchConfig")
            }
        }
    }

    class Detailed
    private constructor(
        private val caseSensitive: JsonField<Boolean>,
        private val language: JsonField<Language>,
        private val removeStopwords: JsonField<Boolean>,
        private val stemming: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("case_sensitive")
            @ExcludeMissing
            caseSensitive: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<Language> = JsonMissing.of(),
            @JsonProperty("remove_stopwords")
            @ExcludeMissing
            removeStopwords: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("stemming")
            @ExcludeMissing
            stemming: JsonField<Boolean> = JsonMissing.of(),
        ) : this(caseSensitive, language, removeStopwords, stemming, mutableMapOf())

        /**
         * Whether searching is case-sensitive. Defaults to `false` (i.e. case-insensitive).
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun caseSensitive(): Optional<Boolean> = caseSensitive.getOptional("case_sensitive")

        /**
         * The language of the text. Defaults to `english`.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun language(): Optional<Language> = language.getOptional("language")

        /**
         * Removes common words from the text based on language. Defaults to `true` (i.e. remove
         * common words).
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun removeStopwords(): Optional<Boolean> = removeStopwords.getOptional("remove_stopwords")

        /**
         * Language-specific stemming for the text. Defaults to `false` (i.e., do not stem).
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun stemming(): Optional<Boolean> = stemming.getOptional("stemming")

        /**
         * Returns the raw JSON value of [caseSensitive].
         *
         * Unlike [caseSensitive], this method doesn't throw if the JSON field has an unexpected
         * type.
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
         * Unlike [removeStopwords], this method doesn't throw if the JSON field has an unexpected
         * type.
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

            /** Returns a mutable builder for constructing an instance of [Detailed]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Detailed]. */
        class Builder internal constructor() {

            private var caseSensitive: JsonField<Boolean> = JsonMissing.of()
            private var language: JsonField<Language> = JsonMissing.of()
            private var removeStopwords: JsonField<Boolean> = JsonMissing.of()
            private var stemming: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(detailed: Detailed) = apply {
                caseSensitive = detailed.caseSensitive
                language = detailed.language
                removeStopwords = detailed.removeStopwords
                stemming = detailed.stemming
                additionalProperties = detailed.additionalProperties.toMutableMap()
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
             * You should usually call [Builder.language] with a well-typed [Language] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /**
             * Returns an immutable instance of [Detailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Detailed =
                Detailed(
                    caseSensitive,
                    language,
                    removeStopwords,
                    stemming,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Detailed = apply {
            if (validated) {
                return@apply
            }

            caseSensitive()
            language().ifPresent { it.validate() }
            removeStopwords()
            stemming()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (caseSensitive.asKnown().isPresent) 1 else 0) +
                (language.asKnown().getOrNull()?.validity() ?: 0) +
                (if (removeStopwords.asKnown().isPresent) 1 else 0) +
                (if (stemming.asKnown().isPresent) 1 else 0)

        /** The language of the text. Defaults to `english`. */
        class Language @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
                /**
                 * An enum member indicating that [Language] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value is a not a
             *   known member.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    TurbopufferInvalidDataException("Value is not a String")
                }

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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

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

            return /* spotless:off */ other is Detailed && caseSensitive == other.caseSensitive && language == other.language && removeStopwords == other.removeStopwords && stemming == other.stemming && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(caseSensitive, language, removeStopwords, stemming, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Detailed{caseSensitive=$caseSensitive, language=$language, removeStopwords=$removeStopwords, stemming=$stemming, additionalProperties=$additionalProperties}"
    }
}
