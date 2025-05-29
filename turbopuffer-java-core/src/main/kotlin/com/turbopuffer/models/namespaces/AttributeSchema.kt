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

/** The schema for an attribute attached to a document. */
class AttributeSchema
private constructor(
    private val ann: JsonField<Boolean>,
    private val filterable: JsonField<Boolean>,
    private val fullTextSearch: JsonField<FullTextSearch>,
    private val type: JsonField<AttributeType>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("ann") @ExcludeMissing ann: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("filterable")
        @ExcludeMissing
        filterable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("full_text_search")
        @ExcludeMissing
        fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<AttributeType> = JsonMissing.of(),
    ) : this(ann, filterable, fullTextSearch, type, mutableMapOf())

    /**
     * Whether to create an approximate nearest neighbor index for the attribute.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ann(): Optional<Boolean> = ann.getOptional("ann")

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
     * The data type of the attribute.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<AttributeType> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [ann].
     *
     * Unlike [ann], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ann") @ExcludeMissing fun _ann(): JsonField<Boolean> = ann

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
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<AttributeType> = type

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

        private var ann: JsonField<Boolean> = JsonMissing.of()
        private var filterable: JsonField<Boolean> = JsonMissing.of()
        private var fullTextSearch: JsonField<FullTextSearch> = JsonMissing.of()
        private var type: JsonField<AttributeType> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(attributeSchema: AttributeSchema) = apply {
            ann = attributeSchema.ann
            filterable = attributeSchema.filterable
            fullTextSearch = attributeSchema.fullTextSearch
            type = attributeSchema.type
            additionalProperties = attributeSchema.additionalProperties.toMutableMap()
        }

        /** Whether to create an approximate nearest neighbor index for the attribute. */
        fun ann(ann: Boolean) = ann(JsonField.of(ann))

        /**
         * Sets [Builder.ann] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ann] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ann(ann: JsonField<Boolean>) = apply { this.ann = ann }

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

        /** The data type of the attribute. */
        fun type(type: AttributeType) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [AttributeType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonField<AttributeType>) = apply { this.type = type }

        /**
         * Sets [type] to an arbitrary [String].
         *
         * You should usually call [type] with a well-typed [AttributeType] constant instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(value: String) = type(AttributeType.of(value))

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
            AttributeSchema(
                ann,
                filterable,
                fullTextSearch,
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AttributeSchema = apply {
        if (validated) {
            return@apply
        }

        ann()
        filterable()
        fullTextSearch().ifPresent { it.validate() }
        type()
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
        (if (ann.asKnown().isPresent) 1 else 0) +
            (if (filterable.asKnown().isPresent) 1 else 0) +
            (fullTextSearch.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AttributeSchema && ann == other.ann && filterable == other.filterable && fullTextSearch == other.fullTextSearch && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(ann, filterable, fullTextSearch, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AttributeSchema{ann=$ann, filterable=$filterable, fullTextSearch=$fullTextSearch, type=$type, additionalProperties=$additionalProperties}"
}
