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
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Detailed configuration for an attribute attached to a document. */
class AttributeSchemaConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonField<String>,
    private val ann: JsonField<Ann>,
    private val filterable: JsonField<Boolean>,
    private val fullTextSearch: JsonField<FullTextSearch>,
    private val regex: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ann") @ExcludeMissing ann: JsonField<Ann> = JsonMissing.of(),
        @JsonProperty("filterable")
        @ExcludeMissing
        filterable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("full_text_search")
        @ExcludeMissing
        fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of(),
        @JsonProperty("regex") @ExcludeMissing regex: JsonField<Boolean> = JsonMissing.of(),
    ) : this(type, ann, filterable, fullTextSearch, regex, mutableMapOf())

    /**
     * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime, bool,
     * []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * Whether to create an approximate nearest neighbor index for the attribute. Can be a boolean
     * or a detailed configuration object.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ann(): Optional<Ann> = ann.getOptional("ann")

    /**
     * Whether or not the attributes can be used in filters.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filterable(): Optional<Boolean> = filterable.getOptional("filterable")

    /**
     * Whether this attribute can be used as part of a BM25 full-text search. Requires the `string`
     * or `[]string` type, and by default, BM25-enabled attributes are not filterable. You can
     * override this by setting `filterable: true`.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fullTextSearch(): Optional<FullTextSearch> = fullTextSearch.getOptional("full_text_search")

    /**
     * Whether to enable Regex filters on this attribute.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun regex(): Optional<Boolean> = regex.getOptional("regex")

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [ann].
     *
     * Unlike [ann], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ann") @ExcludeMissing fun _ann(): JsonField<Ann> = ann

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
     * Returns the raw JSON value of [regex].
     *
     * Unlike [regex], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("regex") @ExcludeMissing fun _regex(): JsonField<Boolean> = regex

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

        /**
         * Returns a mutable builder for constructing an instance of [AttributeSchemaConfig].
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AttributeSchemaConfig]. */
    class Builder internal constructor() {

        private var type: JsonField<String>? = null
        private var ann: JsonField<Ann> = JsonMissing.of()
        private var filterable: JsonField<Boolean> = JsonMissing.of()
        private var fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of()
        private var regex: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attributeSchemaConfig: AttributeSchemaConfig) = apply {
            type = attributeSchemaConfig.type
            ann = attributeSchemaConfig.ann
            filterable = attributeSchemaConfig.filterable
            fullTextSearch = attributeSchemaConfig.fullTextSearch
            regex = attributeSchemaConfig.regex
            additionalProperties = attributeSchemaConfig.additionalProperties.toMutableMap()
        }

        /**
         * The data type of the attribute. Valid values: string, int, uint, float, uuid, datetime,
         * bool, []string, []int, []uint, []float, []uuid, []datetime, []bool, [DIMS]f16, [DIMS]f32.
         */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /**
         * Whether to create an approximate nearest neighbor index for the attribute. Can be a
         * boolean or a detailed configuration object.
         */
        fun ann(ann: Ann) = ann(JsonField.of(ann))

        /**
         * Sets [Builder.ann] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ann] with a well-typed [Ann] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ann(ann: JsonField<Ann>) = apply { this.ann = ann }

        /** Alias for calling [ann] with `Ann.ofBool(bool)`. */
        fun ann(bool: Boolean) = ann(Ann.ofBool(bool))

        /** Alias for calling [ann] with `Ann.ofConfig(config)`. */
        fun ann(config: Ann.AnnConfig) = ann(Ann.ofConfig(config))

        /** Whether or not the attributes can be used in filters. */
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

        /** Whether to enable Regex filters on this attribute. */
        fun regex(regex: Boolean) = regex(JsonField.of(regex))

        /**
         * Sets [Builder.regex] to an arbitrary JSON value.
         *
         * You should usually call [Builder.regex] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun regex(regex: JsonField<Boolean>) = apply { this.regex = regex }

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
         * Returns an immutable instance of [AttributeSchemaConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AttributeSchemaConfig =
            AttributeSchemaConfig(
                checkRequired("type", type),
                ann,
                filterable,
                fullTextSearch,
                regex,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AttributeSchemaConfig = apply {
        if (validated) {
            return@apply
        }

        type()
        ann().ifPresent { it.validate() }
        filterable()
        fullTextSearch().ifPresent { it.validate() }
        regex()
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
        (if (type.asKnown().isPresent) 1 else 0) +
            (ann.asKnown().getOrNull()?.validity() ?: 0) +
            (if (filterable.asKnown().isPresent) 1 else 0) +
            (fullTextSearch.asKnown().getOrNull()?.validity() ?: 0) +
            (if (regex.asKnown().isPresent) 1 else 0)

    /**
     * Whether to create an approximate nearest neighbor index for the attribute. Can be a boolean
     * or a detailed configuration object.
     */
    @JsonDeserialize(using = Ann.Deserializer::class)
    @JsonSerialize(using = Ann.Serializer::class)
    class Ann
    private constructor(
        private val bool: Boolean? = null,
        private val config: AnnConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /** Configuration options for ANN (Approximate Nearest Neighbor) indexing. */
        fun config(): Optional<AnnConfig> = Optional.ofNullable(config)

        fun isBool(): Boolean = bool != null

        fun isConfig(): Boolean = config != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /** Configuration options for ANN (Approximate Nearest Neighbor) indexing. */
        fun asConfig(): AnnConfig = config.getOrThrow("config")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                bool != null -> visitor.visitBool(bool)
                config != null -> visitor.visitConfig(config)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Ann = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitConfig(config: AnnConfig) {
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

                    override fun visitConfig(config: AnnConfig) = config.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Ann && bool == other.bool && config == other.config
        }

        override fun hashCode(): Int = Objects.hash(bool, config)

        override fun toString(): String =
            when {
                bool != null -> "Ann{bool=$bool}"
                config != null -> "Ann{config=$config}"
                _json != null -> "Ann{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Ann")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Ann(bool = bool)

            /** Configuration options for ANN (Approximate Nearest Neighbor) indexing. */
            @JvmStatic fun ofConfig(config: AnnConfig) = Ann(config = config)
        }

        /** An interface that defines how to map each variant of [Ann] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /** Configuration options for ANN (Approximate Nearest Neighbor) indexing. */
            fun visitConfig(config: AnnConfig): T

            /**
             * Maps an unknown variant of [Ann] to a value of type [T].
             *
             * An instance of [Ann] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Ann: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Ann>(Ann::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Ann {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<AnnConfig>())?.let {
                                Ann(config = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                Ann(bool = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from string).
                    0 -> Ann(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Ann>(Ann::class) {

            override fun serialize(
                value: Ann,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.config != null -> generator.writeObject(value.config)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Ann")
                }
            }
        }

        /** Configuration options for ANN (Approximate Nearest Neighbor) indexing. */
        class AnnConfig
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val distanceMetric: JsonField<DistanceMetric>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("distance_metric")
                @ExcludeMissing
                distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            ) : this(distanceMetric, mutableMapOf())

            /**
             * A function used to calculate vector similarity.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun distanceMetric(): Optional<DistanceMetric> =
                distanceMetric.getOptional("distance_metric")

            /**
             * Returns the raw JSON value of [distanceMetric].
             *
             * Unlike [distanceMetric], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("distance_metric")
            @ExcludeMissing
            fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

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

                /** Returns a mutable builder for constructing an instance of [AnnConfig]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AnnConfig]. */
            class Builder internal constructor() {

                private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(annConfig: AnnConfig) = apply {
                    distanceMetric = annConfig.distanceMetric
                    additionalProperties = annConfig.additionalProperties.toMutableMap()
                }

                /** A function used to calculate vector similarity. */
                fun distanceMetric(distanceMetric: DistanceMetric) =
                    distanceMetric(JsonField.of(distanceMetric))

                /**
                 * Sets [Builder.distanceMetric] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.distanceMetric] with a well-typed
                 * [DistanceMetric] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                    this.distanceMetric = distanceMetric
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [AnnConfig].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): AnnConfig =
                    AnnConfig(distanceMetric, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): AnnConfig = apply {
                if (validated) {
                    return@apply
                }

                distanceMetric().ifPresent { it.validate() }
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
            internal fun validity(): Int = (distanceMetric.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AnnConfig &&
                    distanceMetric == other.distanceMetric &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(distanceMetric, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AnnConfig{distanceMetric=$distanceMetric, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AttributeSchemaConfig &&
            type == other.type &&
            ann == other.ann &&
            filterable == other.filterable &&
            fullTextSearch == other.fullTextSearch &&
            regex == other.regex &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, ann, filterable, fullTextSearch, regex, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AttributeSchemaConfig{type=$type, ann=$ann, filterable=$filterable, fullTextSearch=$fullTextSearch, regex=$regex, additionalProperties=$additionalProperties}"
}
