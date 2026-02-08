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
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Limits the documents returned by a query. */
class Limit
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val total: JsonField<Long>,
    private val per: JsonField<Per>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("per") @ExcludeMissing per: JsonField<Per> = JsonMissing.of(),
    ) : this(total, per, mutableMapOf())

    /**
     * Limits the total number of documents returned.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun total(): Long = total.getRequired("total")

    /**
     * Limits the number of documents with the same value for a set of attributes (the "limit key")
     * that can appear in the results.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun per(): Optional<Per> = per.getOptional("per")

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /**
     * Returns the raw JSON value of [per].
     *
     * Unlike [per], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("per") @ExcludeMissing fun _per(): JsonField<Per> = per

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
         * Returns a mutable builder for constructing an instance of [Limit].
         *
         * The following fields are required:
         * ```java
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Limit]. */
    class Builder internal constructor() {

        private var total: JsonField<Long>? = null
        private var per: JsonField<Per> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(limit: Limit) = apply {
            total = limit.total
            per = limit.per
            additionalProperties = limit.additionalProperties.toMutableMap()
        }

        /** Limits the total number of documents returned. */
        fun total(total: Long) = total(JsonField.of(total))

        /**
         * Sets [Builder.total] to an arbitrary JSON value.
         *
         * You should usually call [Builder.total] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /**
         * Limits the number of documents with the same value for a set of attributes (the "limit
         * key") that can appear in the results.
         */
        fun per(per: Per) = per(JsonField.of(per))

        /**
         * Sets [Builder.per] to an arbitrary JSON value.
         *
         * You should usually call [Builder.per] with a well-typed [Per] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun per(per: JsonField<Per>) = apply { this.per = per }

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
         * Returns an immutable instance of [Limit].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Limit =
            Limit(checkRequired("total", total), per, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): Limit = apply {
        if (validated) {
            return@apply
        }

        total()
        per().ifPresent { it.validate() }
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
        (if (total.asKnown().isPresent) 1 else 0) + (per.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Limits the number of documents with the same value for a set of attributes (the "limit key")
     * that can appear in the results.
     */
    class Per
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val attributes: JsonField<List<String>>,
        private val limit: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("attributes")
            @ExcludeMissing
            attributes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
        ) : this(attributes, limit, mutableMapOf())

        /**
         * The attributes to include in the limit key.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun attributes(): List<String> = attributes.getRequired("attributes")

        /**
         * The maximum number of documents to return for each value of the limit key.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun limit(): Long = limit.getRequired("limit")

        /**
         * Returns the raw JSON value of [attributes].
         *
         * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("attributes")
        @ExcludeMissing
        fun _attributes(): JsonField<List<String>> = attributes

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

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
             * Returns a mutable builder for constructing an instance of [Per].
             *
             * The following fields are required:
             * ```java
             * .attributes()
             * .limit()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Per]. */
        class Builder internal constructor() {

            private var attributes: JsonField<MutableList<String>>? = null
            private var limit: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(per: Per) = apply {
                attributes = per.attributes.map { it.toMutableList() }
                limit = per.limit
                additionalProperties = per.additionalProperties.toMutableMap()
            }

            /** The attributes to include in the limit key. */
            fun attributes(attributes: List<String>) = attributes(JsonField.of(attributes))

            /**
             * Sets [Builder.attributes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attributes] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun attributes(attributes: JsonField<List<String>>) = apply {
                this.attributes = attributes.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [attributes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAttribute(attribute: String) = apply {
                attributes =
                    (attributes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("attributes", it).add(attribute)
                    }
            }

            /** The maximum number of documents to return for each value of the limit key. */
            fun limit(limit: Long) = limit(JsonField.of(limit))

            /**
             * Sets [Builder.limit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

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
             * Returns an immutable instance of [Per].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .attributes()
             * .limit()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Per =
                Per(
                    checkRequired("attributes", attributes).map { it.toImmutable() },
                    checkRequired("limit", limit),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Per = apply {
            if (validated) {
                return@apply
            }

            attributes()
            limit()
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
            (attributes.asKnown().getOrNull()?.size ?: 0) +
                (if (limit.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Per &&
                attributes == other.attributes &&
                limit == other.limit &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(attributes, limit, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Per{attributes=$attributes, limit=$limit, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Limit &&
            total == other.total &&
            per == other.per &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(total, per, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Limit{total=$total, per=$per, additionalProperties=$additionalProperties}"
}
