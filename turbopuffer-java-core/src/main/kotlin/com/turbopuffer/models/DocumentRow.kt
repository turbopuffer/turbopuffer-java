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

/** A single document, in a row-based format. */
@NoAutoDetect
class DocumentRow
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Id> = JsonMissing.of(),
    @JsonProperty("attributes")
    @ExcludeMissing
    private val attributes: JsonField<Attributes> = JsonMissing.of(),
    @JsonProperty("vector")
    @ExcludeMissing
    private val vector: JsonField<List<Double>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** An identifier for a document. */
    fun id(): Optional<Id> = Optional.ofNullable(id.getNullable("id"))

    /** The attributes attached to the document. */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /** A vector describing the document. */
    fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

    /** An identifier for a document. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /** The attributes attached to the document. */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /** A vector describing the document. */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): DocumentRow = apply {
        if (validated) {
            return@apply
        }

        id().ifPresent { it.validate() }
        attributes().ifPresent { it.validate() }
        vector()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [DocumentRow]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DocumentRow]. */
    class Builder internal constructor() {

        private var id: JsonField<Id> = JsonMissing.of()
        private var attributes: JsonField<Attributes> = JsonMissing.of()
        private var vector: JsonField<MutableList<Double>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(documentRow: DocumentRow) = apply {
            id = documentRow.id
            attributes = documentRow.attributes
            vector = documentRow.vector.map { it.toMutableList() }
            additionalProperties = documentRow.additionalProperties.toMutableMap()
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
        fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

        /** The attributes attached to the document. */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** A vector describing the document. */
        fun vector(vector: List<Double>?) = vector(JsonField.ofNullable(vector))

        /** A vector describing the document. */
        fun vector(vector: Optional<List<Double>>) = vector(vector.orElse(null))

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

        fun build(): DocumentRow =
            DocumentRow(
                id,
                attributes,
                (vector ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    /** The attributes attached to the document. */
    @NoAutoDetect
    class Attributes
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Attributes = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

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

            fun build(): Attributes = Attributes(additionalProperties.toImmutable())
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

        return /* spotless:off */ other is DocumentRow && id == other.id && attributes == other.attributes && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, attributes, vector, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRow{id=$id, attributes=$attributes, vector=$vector, additionalProperties=$additionalProperties}"
}
