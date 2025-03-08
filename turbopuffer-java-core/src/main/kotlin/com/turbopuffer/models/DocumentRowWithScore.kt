// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A single document, in a row-based format. */
@NoAutoDetect
class DocumentRowWithScore
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Id> = JsonMissing.of(),
    @JsonProperty("attributes")
    @ExcludeMissing
    private val attributes: JsonField<DocumentRow.Attributes> = JsonMissing.of(),
    @JsonProperty("vector")
    @ExcludeMissing
    private val vector: JsonField<List<Double>> = JsonMissing.of(),
    @JsonProperty("dist") @ExcludeMissing private val dist: JsonField<Double> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** An identifier for a document. */
    fun id(): Optional<Id> = Optional.ofNullable(id.getNullable("id"))

    /** The attributes attached to the document. */
    fun attributes(): Optional<DocumentRow.Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** A vector describing the document. */
    fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

    /**
     * For vector search, the distance between the query vector and the document vector. For BM25
     * full-text search, the score of the document. Not present for other types of queries.
     */
    fun dist(): Optional<Double> = Optional.ofNullable(dist.getNullable("dist"))

    /** An identifier for a document. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /** The attributes attached to the document. */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<DocumentRow.Attributes> = attributes

    /** A vector describing the document. */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

    /**
     * For vector search, the distance between the query vector and the document vector. For BM25
     * full-text search, the score of the document. Not present for other types of queries.
     */
    @JsonProperty("dist") @ExcludeMissing fun _dist(): JsonField<Double> = dist

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toDocumentRow(): DocumentRow =
        DocumentRow.builder().id(id).attributes(attributes).vector(vector).build()

    private var validated: Boolean = false

    fun validate(): DocumentRowWithScore = apply {
        if (validated) {
            return@apply
        }

        id().ifPresent { it.validate() }
        attributes().ifPresent { it.validate() }
        vector()
        dist()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [DocumentRowWithScore]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentRowWithScore]. */
    class Builder internal constructor() {

        private var id: JsonField<Id> = JsonMissing.of()
        private var attributes: JsonField<DocumentRow.Attributes> = JsonMissing.of()
        private var vector: JsonField<MutableList<Double>>? = null
        private var dist: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentRowWithScore: DocumentRowWithScore) = apply {
            id = documentRowWithScore.id
            attributes = documentRowWithScore.attributes
            vector = documentRowWithScore.vector.map { it.toMutableList() }
            dist = documentRowWithScore.dist
            additionalProperties = documentRowWithScore.additionalProperties.toMutableMap()
        }

        /** An identifier for a document. */
        fun id(id: Id) = id(JsonField.of(id))

        /** An identifier for a document. */
        fun id(id: JsonField<Id>) = apply { this.id = id }

        /** A UUID. */
        fun id(string: String) = id(Id.ofString(string))

        /** An integer ID. */
        fun id(integer: Long) = id(Id.ofInteger(integer))

        /** The attributes attached to the document. */
        fun attributes(attributes: DocumentRow.Attributes) = attributes(JsonField.of(attributes))

        /** The attributes attached to the document. */
        fun attributes(attributes: JsonField<DocumentRow.Attributes>) = apply {
            this.attributes = attributes
        }

        /** A vector describing the document. */
        fun vector(vector: List<Double>?) = vector(JsonField.ofNullable(vector))

        /** A vector describing the document. */
        fun vector(vector: Optional<List<Double>>) = vector(vector.getOrNull())

        /** A vector describing the document. */
        fun vector(vector: JsonField<List<Double>>) = apply {
            this.vector = vector.map { it.toMutableList() }
        }

        /** A vector describing the document. */
        fun addVector(vector: Double) = apply {
            this.vector =
                (this.vector ?: JsonField.of(mutableListOf())).also {
                    checkKnown("vector", it).add(vector)
                }
        }

        /**
         * For vector search, the distance between the query vector and the document vector. For
         * BM25 full-text search, the score of the document. Not present for other types of queries.
         */
        fun dist(dist: Double) = dist(JsonField.of(dist))

        /**
         * For vector search, the distance between the query vector and the document vector. For
         * BM25 full-text search, the score of the document. Not present for other types of queries.
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

        fun build(): DocumentRowWithScore =
            DocumentRowWithScore(
                id,
                attributes,
                (vector ?: JsonMissing.of()).map { it.toImmutable() },
                dist,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is DocumentRowWithScore && id == other.id && attributes == other.attributes && vector == other.vector && dist == other.dist && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, attributes, vector, dist, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRowWithScore{id=$id, attributes=$attributes, vector=$vector, dist=$dist, additionalProperties=$additionalProperties}"
}
