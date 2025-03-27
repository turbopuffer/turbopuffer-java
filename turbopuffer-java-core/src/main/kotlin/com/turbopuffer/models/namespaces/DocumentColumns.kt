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
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A list of documents in columnar format. */
class DocumentColumns
private constructor(
    private val attributes: JsonField<Attributes>,
    private val ids: JsonField<List<Id>>,
    private val vectors: JsonField<List<List<Double>?>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("attributes")
        @ExcludeMissing
        attributes: JsonField<Attributes> = JsonMissing.of(),
        @JsonProperty("ids") @ExcludeMissing ids: JsonField<List<Id>> = JsonMissing.of(),
        @JsonProperty("vectors")
        @ExcludeMissing
        vectors: JsonField<List<List<Double>?>> = JsonMissing.of(),
    ) : this(attributes, ids, vectors, mutableMapOf())

    /**
     * The attributes attached to each of the documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /**
     * The IDs of the documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ids(): Optional<List<Id>> = Optional.ofNullable(ids.getNullable("ids"))

    /**
     * Vectors describing each of the documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vectors(): Optional<List<List<Double>?>> =
        Optional.ofNullable(vectors.getNullable("vectors"))

    /**
     * Returns the raw JSON value of [attributes].
     *
     * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /**
     * Returns the raw JSON value of [ids].
     *
     * Unlike [ids], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

    /**
     * Returns the raw JSON value of [vectors].
     *
     * Unlike [vectors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vectors")
    @ExcludeMissing
    fun _vectors(): JsonField<List<List<Double>?>> = vectors

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

        /** Returns a mutable builder for constructing an instance of [DocumentColumns]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentColumns]. */
    class Builder internal constructor() {

        private var attributes: JsonField<Attributes> = JsonMissing.of()
        private var ids: JsonField<MutableList<Id>>? = null
        private var vectors: JsonField<MutableList<List<Double>?>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentColumns: DocumentColumns) = apply {
            attributes = documentColumns.attributes
            ids = documentColumns.ids.map { it.toMutableList() }
            vectors = documentColumns.vectors.map { it.toMutableList() }
            additionalProperties = documentColumns.additionalProperties.toMutableMap()
        }

        /** The attributes attached to each of the documents. */
        fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

        /**
         * Sets [Builder.attributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attributes] with a well-typed [Attributes] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** The IDs of the documents. */
        fun ids(ids: List<Id>) = ids(JsonField.of(ids))

        /**
         * Sets [Builder.ids] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ids] with a well-typed `List<Id>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ids(ids: JsonField<List<Id>>) = apply { this.ids = ids.map { it.toMutableList() } }

        /**
         * Adds a single [Id] to [ids].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addId(id: Id) = apply {
            ids = (ids ?: JsonField.of(mutableListOf())).also { checkKnown("ids", it).add(id) }
        }

        /** Alias for calling [addId] with `Id.ofString(string)`. */
        fun addId(string: String) = addId(Id.ofString(string))

        /** Alias for calling [addId] with `Id.ofInteger(integer)`. */
        fun addId(integer: Long) = addId(Id.ofInteger(integer))

        /** Vectors describing each of the documents. */
        fun vectors(vectors: List<List<Double>?>) = vectors(JsonField.of(vectors))

        /**
         * Sets [Builder.vectors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vectors] with a well-typed `List<List<Double>?>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun vectors(vectors: JsonField<List<List<Double>?>>) = apply {
            this.vectors = vectors.map { it.toMutableList() }
        }

        /**
         * Adds a single [List<Double>] to [vectors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVector(vector: List<Double>) = apply {
            vectors =
                (vectors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("vectors", it).add(vector)
                }
        }

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
         * Returns an immutable instance of [DocumentColumns].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DocumentColumns =
            DocumentColumns(
                attributes,
                (ids ?: JsonMissing.of()).map { it.toImmutable() },
                (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DocumentColumns = apply {
        if (validated) {
            return@apply
        }

        attributes().ifPresent { it.validate() }
        ids().ifPresent { it.forEach { it.validate() } }
        vectors()
        validated = true
    }

    /** The attributes attached to each of the documents. */
    class Attributes
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Attributes]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Attributes]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(attributes: Attributes) = apply {
                additionalProperties = attributes.additionalProperties.toMutableMap()
            }

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
             * Returns an immutable instance of [Attributes].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Attributes = Attributes(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Attributes = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Attributes && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Attributes{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DocumentColumns && attributes == other.attributes && ids == other.ids && vectors == other.vectors && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(attributes, ids, vectors, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentColumns{attributes=$attributes, ids=$ids, vectors=$vectors, additionalProperties=$additionalProperties}"
}
