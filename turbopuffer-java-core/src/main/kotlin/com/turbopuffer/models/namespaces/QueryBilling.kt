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
import com.turbopuffer.core.checkRequired
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects

/** The billing information for a query. */
class QueryBilling
private constructor(
    private val billableLogicalBytesQueried: JsonField<Long>,
    private val billableLogicalBytesReturned: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billable_logical_bytes_queried")
        @ExcludeMissing
        billableLogicalBytesQueried: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("billable_logical_bytes_returned")
        @ExcludeMissing
        billableLogicalBytesReturned: JsonField<Long> = JsonMissing.of(),
    ) : this(billableLogicalBytesQueried, billableLogicalBytesReturned, mutableMapOf())

    /**
     * The number of billable logical bytes queried from the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billableLogicalBytesQueried(): Long =
        billableLogicalBytesQueried.getRequired("billable_logical_bytes_queried")

    /**
     * The number of billable logical bytes returned from the query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billableLogicalBytesReturned(): Long =
        billableLogicalBytesReturned.getRequired("billable_logical_bytes_returned")

    /**
     * Returns the raw JSON value of [billableLogicalBytesQueried].
     *
     * Unlike [billableLogicalBytesQueried], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("billable_logical_bytes_queried")
    @ExcludeMissing
    fun _billableLogicalBytesQueried(): JsonField<Long> = billableLogicalBytesQueried

    /**
     * Returns the raw JSON value of [billableLogicalBytesReturned].
     *
     * Unlike [billableLogicalBytesReturned], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("billable_logical_bytes_returned")
    @ExcludeMissing
    fun _billableLogicalBytesReturned(): JsonField<Long> = billableLogicalBytesReturned

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
         * Returns a mutable builder for constructing an instance of [QueryBilling].
         *
         * The following fields are required:
         * ```java
         * .billableLogicalBytesQueried()
         * .billableLogicalBytesReturned()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [QueryBilling]. */
    class Builder internal constructor() {

        private var billableLogicalBytesQueried: JsonField<Long>? = null
        private var billableLogicalBytesReturned: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(queryBilling: QueryBilling) = apply {
            billableLogicalBytesQueried = queryBilling.billableLogicalBytesQueried
            billableLogicalBytesReturned = queryBilling.billableLogicalBytesReturned
            additionalProperties = queryBilling.additionalProperties.toMutableMap()
        }

        /** The number of billable logical bytes queried from the namespace. */
        fun billableLogicalBytesQueried(billableLogicalBytesQueried: Long) =
            billableLogicalBytesQueried(JsonField.of(billableLogicalBytesQueried))

        /**
         * Sets [Builder.billableLogicalBytesQueried] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billableLogicalBytesQueried] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun billableLogicalBytesQueried(billableLogicalBytesQueried: JsonField<Long>) = apply {
            this.billableLogicalBytesQueried = billableLogicalBytesQueried
        }

        /** The number of billable logical bytes returned from the query. */
        fun billableLogicalBytesReturned(billableLogicalBytesReturned: Long) =
            billableLogicalBytesReturned(JsonField.of(billableLogicalBytesReturned))

        /**
         * Sets [Builder.billableLogicalBytesReturned] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billableLogicalBytesReturned] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun billableLogicalBytesReturned(billableLogicalBytesReturned: JsonField<Long>) = apply {
            this.billableLogicalBytesReturned = billableLogicalBytesReturned
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
         * Returns an immutable instance of [QueryBilling].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billableLogicalBytesQueried()
         * .billableLogicalBytesReturned()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): QueryBilling =
            QueryBilling(
                checkRequired("billableLogicalBytesQueried", billableLogicalBytesQueried),
                checkRequired("billableLogicalBytesReturned", billableLogicalBytesReturned),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): QueryBilling = apply {
        if (validated) {
            return@apply
        }

        billableLogicalBytesQueried()
        billableLogicalBytesReturned()
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
        (if (billableLogicalBytesQueried.asKnown().isPresent) 1 else 0) +
            (if (billableLogicalBytesReturned.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is QueryBilling && billableLogicalBytesQueried == other.billableLogicalBytesQueried && billableLogicalBytesReturned == other.billableLogicalBytesReturned && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(billableLogicalBytesQueried, billableLogicalBytesReturned, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "QueryBilling{billableLogicalBytesQueried=$billableLogicalBytesQueried, billableLogicalBytesReturned=$billableLogicalBytesReturned, additionalProperties=$additionalProperties}"
}
