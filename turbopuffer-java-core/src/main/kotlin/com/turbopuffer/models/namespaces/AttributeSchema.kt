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

/** The schema for an attribute attached to a document. */
class AttributeSchema
private constructor(
    private val filterable: JsonField<Boolean>,
    private val fullTextSearch: JsonField<FullTextSearch>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("filterable")
        @ExcludeMissing
        filterable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("full_text_search")
        @ExcludeMissing
        fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(filterable, fullTextSearch, type, mutableMapOf())

    /**
     * Whether or not the attributes can be used in filters/WHERE clauses.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filterable(): Optional<Boolean> = Optional.ofNullable(filterable.getNullable("filterable"))

    /**
     * Whether this attribute can be used as part of a BM25 full-text search. Requires the `string`
     * or `[]string` type, and by default, BM25-enabled attributes are not filterable. You can
     * override this by setting `filterable: true`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fullTextSearch(): Optional<FullTextSearch> =
        Optional.ofNullable(fullTextSearch.getNullable("full_text_search"))

    /**
     * The data type of the attribute.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = Optional.ofNullable(type.getNullable("type"))

    /**
     * Returns the raw JSON value of [filterable].
     *
     * Unlike [filterable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filterable") @ExcludeMissing fun _filterable(): JsonField<Boolean> = filterable

    /**
     * Returns the raw JSON value of [fullTextSearch].
     *
     * Unlike [fullTextSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("full_text_search")
    @ExcludeMissing
    fun _fullTextSearch(): JsonField<FullTextSearch> = fullTextSearch

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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

        /** Returns a mutable builder for constructing an instance of [AttributeSchema]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AttributeSchema]. */
    class Builder internal constructor() {

        private var filterable: JsonField<Boolean> = JsonMissing.of()
        private var fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attributeSchema: AttributeSchema) = apply {
            filterable = attributeSchema.filterable
            fullTextSearch = attributeSchema.fullTextSearch
            type = attributeSchema.type
            additionalProperties = attributeSchema.additionalProperties.toMutableMap()
        }

        /** Whether or not the attributes can be used in filters/WHERE clauses. */
        fun filterable(filterable: Boolean) = filterable(JsonField.of(filterable))

        /**
         * Sets [Builder.filterable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filterable] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun filterable(filterable: JsonField<Boolean>) = apply { this.filterable = filterable }

        /**
         * Whether this attribute can be used as part of a BM25 full-text search. Requires the
         * `string` or `[]string` type, and by default, BM25-enabled attributes are not filterable.
         * You can override this by setting `filterable: true`.
         */
        fun fullTextSearch(fullTextSearch: FullTextSearch) =
            fullTextSearch(JsonField.of(fullTextSearch))

        /**
         * Sets [Builder.fullTextSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fullTextSearch] with a well-typed [FullTextSearch] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fullTextSearch(fullTextSearch: JsonField<FullTextSearch>) = apply {
            this.fullTextSearch = fullTextSearch
        }

        /** Alias for calling [fullTextSearch] with `FullTextSearch.ofBool(bool)`. */
        fun fullTextSearch(bool: Boolean) = fullTextSearch(FullTextSearch.ofBool(bool))

        /** Alias for calling [fullTextSearch] with `FullTextSearch.ofConfig(config)`. */
        fun fullTextSearch(config: FullTextSearchConfig) =
            fullTextSearch(FullTextSearch.ofConfig(config))

        /** The data type of the attribute. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [AttributeSchema].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AttributeSchema =
            AttributeSchema(filterable, fullTextSearch, type, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): AttributeSchema = apply {
        if (validated) {
            return@apply
        }

        filterable()
        fullTextSearch().ifPresent { it.validate() }
        type().ifPresent { it.validate() }
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
        (if (filterable.asKnown().isPresent) 1 else 0) +
            (fullTextSearch.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Whether this attribute can be used as part of a BM25 full-text search. Requires the `string`
     * or `[]string` type, and by default, BM25-enabled attributes are not filterable. You can
     * override this by setting `filterable: true`.
     */
    @JsonDeserialize(using = FullTextSearch.Deserializer::class)
    @JsonSerialize(using = FullTextSearch.Serializer::class)
    class FullTextSearch
    private constructor(
        private val bool: Boolean? = null,
        private val config: FullTextSearchConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /** Detailed configuration options for BM25 full-text search. */
        fun config(): Optional<FullTextSearchConfig> = Optional.ofNullable(config)

        fun isBool(): Boolean = bool != null

        fun isConfig(): Boolean = config != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /** Detailed configuration options for BM25 full-text search. */
        fun asConfig(): FullTextSearchConfig = config.getOrThrow("config")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                bool != null -> visitor.visitBool(bool)
                config != null -> visitor.visitConfig(config)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): FullTextSearch = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitConfig(config: FullTextSearchConfig) {
                        config.validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitBool(bool: Boolean) = 1

                    override fun visitConfig(config: FullTextSearchConfig) = config.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is FullTextSearch && bool == other.bool && config == other.config /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, config) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "FullTextSearch{bool=$bool}"
                config != null -> "FullTextSearch{config=$config}"
                _json != null -> "FullTextSearch{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FullTextSearch")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = FullTextSearch(bool = bool)

            /** Detailed configuration options for BM25 full-text search. */
            @JvmStatic fun ofConfig(config: FullTextSearchConfig) = FullTextSearch(config = config)
        }

        /**
         * An interface that defines how to map each variant of [FullTextSearch] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /** Detailed configuration options for BM25 full-text search. */
            fun visitConfig(config: FullTextSearchConfig): T

            /**
             * Maps an unknown variant of [FullTextSearch] to a value of type [T].
             *
             * An instance of [FullTextSearch] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown FullTextSearch: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<FullTextSearch>(FullTextSearch::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FullTextSearch {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<FullTextSearchConfig>())?.let {
                                FullTextSearch(config = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                FullTextSearch(bool = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from string).
                    0 -> FullTextSearch(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<FullTextSearch>(FullTextSearch::class) {

            override fun serialize(
                value: FullTextSearch,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.config != null -> generator.writeObject(value.config)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FullTextSearch")
                }
            }
        }
    }

    /** The data type of the attribute. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            /** A string. */
            @JvmField val STRING = of("string")

            /** An unsigned integer. */
            @JvmField val UINT = of("uint")

            /** A UUID. */
            @JvmField val UUID = of("uuid")

            /** A boolean. */
            @JvmField val BOOL = of("bool")

            /** An array of strings. */
            @JvmField val STRING_ARRAY = of("[]string")

            /** An array of unsigned integers. */
            @JvmField val UINT_ARRAY = of("[]uint")

            /** An array of UUIDs. */
            @JvmField val UUID_ARRAY = of("[]uuid")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            /** A string. */
            STRING,
            /** An unsigned integer. */
            UINT,
            /** A UUID. */
            UUID,
            /** A boolean. */
            BOOL,
            /** An array of strings. */
            STRING_ARRAY,
            /** An array of unsigned integers. */
            UINT_ARRAY,
            /** An array of UUIDs. */
            UUID_ARRAY,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
            /** An array of strings. */
            STRING_ARRAY,
            /** An array of unsigned integers. */
            UINT_ARRAY,
            /** An array of UUIDs. */
            UUID_ARRAY,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                STRING -> Value.STRING
                UINT -> Value.UINT
                UUID -> Value.UUID
                BOOL -> Value.BOOL
                STRING_ARRAY -> Value.STRING_ARRAY
                UINT_ARRAY -> Value.UINT_ARRAY
                UUID_ARRAY -> Value.UUID_ARRAY
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
                STRING -> Known.STRING
                UINT -> Known.UINT
                UUID -> Known.UUID
                BOOL -> Known.BOOL
                STRING_ARRAY -> Known.STRING_ARRAY
                UINT_ARRAY -> Known.UINT_ARRAY
                UUID_ARRAY -> Known.UUID_ARRAY
                else -> throw TurbopufferInvalidDataException("Unknown Type: $value")
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

        private var validated: Boolean = false

        fun validate(): Type = apply {
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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AttributeSchema && filterable == other.filterable && fullTextSearch == other.fullTextSearch && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(filterable, fullTextSearch, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AttributeSchema{filterable=$filterable, fullTextSearch=$fullTextSearch, type=$type, additionalProperties=$additionalProperties}"
}
