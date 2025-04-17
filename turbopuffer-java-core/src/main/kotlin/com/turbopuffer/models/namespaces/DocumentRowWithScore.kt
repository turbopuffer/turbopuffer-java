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

/** A single document, in a row-based format. */
class DocumentRowWithScore
private constructor(
    private val id: JsonField<Id>,
    private val additionalProperties: JsonValue,
    private val vector: JsonField<DocumentRow.Vector>,
    private val dist: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Id> = JsonMissing.of(),
        @JsonProperty("additionalProperties")
        @ExcludeMissing
        additionalProperties: JsonValue = JsonMissing.of(),
        @JsonProperty("vector")
        @ExcludeMissing
        vector: JsonField<DocumentRow.Vector> = JsonMissing.of(),
        @JsonProperty("dist") @ExcludeMissing dist: JsonField<Double> = JsonMissing.of(),
    ) : this(id, additionalProperties, vector, dist, mutableMapOf())

    fun toDocumentRow(): DocumentRow =
        DocumentRow.builder()
            .id(id)
            .additionalProperties(additionalProperties)
            .vector(vector)
            .build()

    /**
     * An identifier for a document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<Id> = id.getOptional("id")

    /** The attributes attached to the document. */
    @JsonProperty("additionalProperties")
    @ExcludeMissing
    fun _additionalProperties(): JsonValue = additionalProperties

    /**
     * A vector describing the document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vector(): Optional<DocumentRow.Vector> = vector.getOptional("vector")

    /**
     * For vector search, the distance between the query vector and the document vector. For BM25
     * full-text search, the score of the document. Not present for other types of queries.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dist(): Optional<Double> = dist.getOptional("dist")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /**
     * Returns the raw JSON value of [vector].
     *
     * Unlike [vector], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<DocumentRow.Vector> = vector

    /**
     * Returns the raw JSON value of [dist].
     *
     * Unlike [dist], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dist") @ExcludeMissing fun _dist(): JsonField<Double> = dist

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

        /** Returns a mutable builder for constructing an instance of [DocumentRowWithScore]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentRowWithScore]. */
    class Builder internal constructor() {

        private var id: JsonField<Id> = JsonMissing.of()
        private var additionalProperties: JsonValue = JsonMissing.of()
        private var vector: JsonField<DocumentRow.Vector> = JsonMissing.of()
        private var dist: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentRowWithScore: DocumentRowWithScore) = apply {
            id = documentRowWithScore.id
            additionalProperties = documentRowWithScore.additionalProperties
            vector = documentRowWithScore.vector
            dist = documentRowWithScore.dist
            additionalProperties = documentRowWithScore.additionalProperties.toMutableMap()
        }

        /** An identifier for a document. */
        fun id(id: Id) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Id] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Id>) = apply { this.id = id }

        /** Alias for calling [id] with `Id.ofString(string)`. */
        fun id(string: String) = id(Id.ofString(string))

        /** Alias for calling [id] with `Id.ofInteger(integer)`. */
        fun id(integer: Long) = id(Id.ofInteger(integer))

        /** The attributes attached to the document. */
        fun additionalProperties(additionalProperties: JsonValue) = apply {
            this.additionalProperties = additionalProperties
        }

        /** A vector describing the document. */
        fun vector(vector: DocumentRow.Vector?) = vector(JsonField.ofNullable(vector))

        /** Alias for calling [Builder.vector] with `vector.orElse(null)`. */
        fun vector(vector: Optional<DocumentRow.Vector>) = vector(vector.getOrNull())

        /**
         * Sets [Builder.vector] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vector] with a well-typed [DocumentRow.Vector] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun vector(vector: JsonField<DocumentRow.Vector>) = apply { this.vector = vector }

        /** Alias for calling [vector] with `DocumentRow.Vector.ofNumber(number)`. */
        fun vectorOfNumber(number: List<Double>) = vector(DocumentRow.Vector.ofNumber(number))

        /** Alias for calling [vector] with `DocumentRow.Vector.ofString(string)`. */
        fun vector(string: String) = vector(DocumentRow.Vector.ofString(string))

        /**
         * For vector search, the distance between the query vector and the document vector. For
         * BM25 full-text search, the score of the document. Not present for other types of queries.
         */
        fun dist(dist: Double) = dist(JsonField.of(dist))

        /**
         * Sets [Builder.dist] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dist] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun dist(dist: JsonField<Double>) = apply { this.dist = dist }

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
         * Returns an immutable instance of [DocumentRowWithScore].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DocumentRowWithScore =
            DocumentRowWithScore(
                id,
                additionalProperties,
                vector,
                dist,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DocumentRowWithScore = apply {
        if (validated) {
            return@apply
        }

        id().ifPresent { it.validate() }
        vector().ifPresent { it.validate() }
        dist()
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
        (id.asKnown().getOrNull()?.validity() ?: 0) +
            (vector.asKnown().getOrNull()?.validity() ?: 0) +
            (if (dist.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DocumentRowWithScore && id == other.id && additionalProperties == other.additionalProperties && vector == other.vector && dist == other.dist && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, additionalProperties, vector, dist, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRowWithScore{id=$id, additionalProperties=$additionalProperties, vector=$vector, dist=$dist, additionalProperties=$additionalProperties}"
}
