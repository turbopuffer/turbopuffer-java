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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The billing information for a write request. */
class WriteBilling
private constructor(
    private val billableLogicalBytesWritten: JsonField<Long>,
    private val query: JsonField<QueryBilling>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billable_logical_bytes_written")
        @ExcludeMissing
        billableLogicalBytesWritten: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("query") @ExcludeMissing query: JsonField<QueryBilling> = JsonMissing.of(),
    ) : this(billableLogicalBytesWritten, query, mutableMapOf())

    /**
     * The number of billable logical bytes written to the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billableLogicalBytesWritten(): Long =
        billableLogicalBytesWritten.getRequired("billable_logical_bytes_written")

    /**
     * The billing information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun query(): Optional<QueryBilling> = query.getOptional("query")

    /**
     * Returns the raw JSON value of [billableLogicalBytesWritten].
     *
     * Unlike [billableLogicalBytesWritten], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("billable_logical_bytes_written")
    @ExcludeMissing
    fun _billableLogicalBytesWritten(): JsonField<Long> = billableLogicalBytesWritten

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<QueryBilling> = query

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
         * Returns a mutable builder for constructing an instance of [WriteBilling].
         *
         * The following fields are required:
         * ```java
         * .billableLogicalBytesWritten()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WriteBilling]. */
    class Builder internal constructor() {

        private var billableLogicalBytesWritten: JsonField<Long>? = null
        private var query: JsonField<QueryBilling> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(writeBilling: WriteBilling) = apply {
            billableLogicalBytesWritten = writeBilling.billableLogicalBytesWritten
            query = writeBilling.query
            additionalProperties = writeBilling.additionalProperties.toMutableMap()
        }

        /** The number of billable logical bytes written to the namespace. */
        fun billableLogicalBytesWritten(billableLogicalBytesWritten: Long) =
            billableLogicalBytesWritten(JsonField.of(billableLogicalBytesWritten))

        /**
         * Sets [Builder.billableLogicalBytesWritten] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billableLogicalBytesWritten] with a well-typed [Long]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun billableLogicalBytesWritten(billableLogicalBytesWritten: JsonField<Long>) = apply {
            this.billableLogicalBytesWritten = billableLogicalBytesWritten
        }

        /** The billing information for a query. */
        fun query(query: QueryBilling) = query(JsonField.of(query))

        /**
         * Sets [Builder.query] to an arbitrary JSON value.
         *
         * You should usually call [Builder.query] with a well-typed [QueryBilling] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun query(query: JsonField<QueryBilling>) = apply { this.query = query }

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
         * Returns an immutable instance of [WriteBilling].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billableLogicalBytesWritten()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WriteBilling =
            WriteBilling(
                checkRequired("billableLogicalBytesWritten", billableLogicalBytesWritten),
                query,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WriteBilling = apply {
        if (validated) {
            return@apply
        }

        billableLogicalBytesWritten()
        query().ifPresent { it.validate() }
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
        (if (billableLogicalBytesWritten.asKnown().isPresent) 1 else 0) +
            (query.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WriteBilling &&
            billableLogicalBytesWritten == other.billableLogicalBytesWritten &&
            query == other.query &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(billableLogicalBytesWritten, query, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WriteBilling{billableLogicalBytesWritten=$billableLogicalBytesWritten, query=$query, additionalProperties=$additionalProperties}"
}
