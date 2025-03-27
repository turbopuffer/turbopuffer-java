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
import kotlin.jvm.optionals.getOrNull

/** A single document, in a row-based format. */
class DocumentRow
private constructor(
    private val id: JsonField<Id>,
    private val attributes: JsonField<Attributes>,
    private val vector: JsonField<List<Double>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Id> = JsonMissing.of(),
        @JsonProperty("attributes")
        @ExcludeMissing
        attributes: JsonField<Attributes> = JsonMissing.of(),
        @JsonProperty("vector") @ExcludeMissing vector: JsonField<List<Double>> = JsonMissing.of(),
    ) : this(id, attributes, vector, mutableMapOf())

    /**
     * An identifier for a document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<Id> = Optional.ofNullable(id.getNullable("id"))

    /**
     * The attributes attached to the document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attributes(): Optional<Attributes> =
        Optional.ofNullable(attributes.getNullable("attributes"))

    /**
     * A vector describing the document.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vector(): Optional<List<Double>> = Optional.ofNullable(vector.getNullable("vector"))

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Id> = id

    /**
     * Returns the raw JSON value of [attributes].
     *
     * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attributes")
    @ExcludeMissing
    fun _attributes(): JsonField<Attributes> = attributes

    /**
     * Returns the raw JSON value of [vector].
     *
     * Unlike [vector], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vector") @ExcludeMissing fun _vector(): JsonField<List<Double>> = vector

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
        fun attributes(attributes: Attributes) = attributes(JsonField.of(attributes))

        /**
         * Sets [Builder.attributes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attributes] with a well-typed [Attributes] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun attributes(attributes: JsonField<Attributes>) = apply { this.attributes = attributes }

        /** A vector describing the document. */
        fun vector(vector: List<Double>?) = vector(JsonField.ofNullable(vector))

        /** Alias for calling [Builder.vector] with `vector.orElse(null)`. */
        fun vector(vector: Optional<List<Double>>) = vector(vector.getOrNull())

        /**
         * Sets [Builder.vector] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vector] with a well-typed `List<Double>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun vector(vector: JsonField<List<Double>>) = apply {
            this.vector = vector.map { it.toMutableList() }
        }

        /**
         * Adds a single [Double] to [Builder.vector].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
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

        /**
         * Returns an immutable instance of [DocumentRow].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DocumentRow =
            DocumentRow(
                id,
                attributes,
                (vector ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

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

    /** The attributes attached to the document. */
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

        return /* spotless:off */ other is DocumentRow && id == other.id && attributes == other.attributes && vector == other.vector && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, attributes, vector, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DocumentRow{id=$id, attributes=$attributes, vector=$vector, additionalProperties=$additionalProperties}"
}
