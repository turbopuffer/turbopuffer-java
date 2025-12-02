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

/** The response to a successful write request. */
class NamespaceWriteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val billing: JsonField<WriteBilling>,
    private val message: JsonField<String>,
    private val rowsAffected: JsonField<Long>,
    private val status: JsonValue,
    private val rowsDeleted: JsonField<Long>,
    private val rowsPatched: JsonField<Long>,
    private val rowsRemaining: JsonField<Boolean>,
    private val rowsUpserted: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billing")
        @ExcludeMissing
        billing: JsonField<WriteBilling> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rows_affected")
        @ExcludeMissing
        rowsAffected: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
        @JsonProperty("rows_deleted")
        @ExcludeMissing
        rowsDeleted: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("rows_patched")
        @ExcludeMissing
        rowsPatched: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("rows_remaining")
        @ExcludeMissing
        rowsRemaining: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("rows_upserted")
        @ExcludeMissing
        rowsUpserted: JsonField<Long> = JsonMissing.of(),
    ) : this(
        billing,
        message,
        rowsAffected,
        status,
        rowsDeleted,
        rowsPatched,
        rowsRemaining,
        rowsUpserted,
        mutableMapOf(),
    )

    /**
     * The billing information for a write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): WriteBilling = billing.getRequired("billing")

    /**
     * A message describing the result of the write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun message(): String = message.getRequired("message")

    /**
     * The number of rows affected by the write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun rowsAffected(): Long = rowsAffected.getRequired("rows_affected")

    /**
     * The status of the request.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("OK")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

    /**
     * The number of rows deleted by the write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rowsDeleted(): Optional<Long> = rowsDeleted.getOptional("rows_deleted")

    /**
     * The number of rows patched by the write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rowsPatched(): Optional<Long> = rowsPatched.getOptional("rows_patched")

    /**
     * Whether more documents match the filter for partial operations.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rowsRemaining(): Optional<Boolean> = rowsRemaining.getOptional("rows_remaining")

    /**
     * The number of rows upserted by the write request.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rowsUpserted(): Optional<Long> = rowsUpserted.getOptional("rows_upserted")

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<WriteBilling> = billing

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [rowsAffected].
     *
     * Unlike [rowsAffected], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows_affected")
    @ExcludeMissing
    fun _rowsAffected(): JsonField<Long> = rowsAffected

    /**
     * Returns the raw JSON value of [rowsDeleted].
     *
     * Unlike [rowsDeleted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows_deleted") @ExcludeMissing fun _rowsDeleted(): JsonField<Long> = rowsDeleted

    /**
     * Returns the raw JSON value of [rowsPatched].
     *
     * Unlike [rowsPatched], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows_patched") @ExcludeMissing fun _rowsPatched(): JsonField<Long> = rowsPatched

    /**
     * Returns the raw JSON value of [rowsRemaining].
     *
     * Unlike [rowsRemaining], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows_remaining")
    @ExcludeMissing
    fun _rowsRemaining(): JsonField<Boolean> = rowsRemaining

    /**
     * Returns the raw JSON value of [rowsUpserted].
     *
     * Unlike [rowsUpserted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows_upserted")
    @ExcludeMissing
    fun _rowsUpserted(): JsonField<Long> = rowsUpserted

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
         * Returns a mutable builder for constructing an instance of [NamespaceWriteResponse].
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .message()
         * .rowsAffected()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceWriteResponse]. */
    class Builder internal constructor() {

        private var billing: JsonField<WriteBilling>? = null
        private var message: JsonField<String>? = null
        private var rowsAffected: JsonField<Long>? = null
        private var status: JsonValue = JsonValue.from("OK")
        private var rowsDeleted: JsonField<Long> = JsonMissing.of()
        private var rowsPatched: JsonField<Long> = JsonMissing.of()
        private var rowsRemaining: JsonField<Boolean> = JsonMissing.of()
        private var rowsUpserted: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceWriteResponse: NamespaceWriteResponse) = apply {
            billing = namespaceWriteResponse.billing
            message = namespaceWriteResponse.message
            rowsAffected = namespaceWriteResponse.rowsAffected
            status = namespaceWriteResponse.status
            rowsDeleted = namespaceWriteResponse.rowsDeleted
            rowsPatched = namespaceWriteResponse.rowsPatched
            rowsRemaining = namespaceWriteResponse.rowsRemaining
            rowsUpserted = namespaceWriteResponse.rowsUpserted
            additionalProperties = namespaceWriteResponse.additionalProperties.toMutableMap()
        }

        /** The billing information for a write request. */
        fun billing(billing: WriteBilling) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [WriteBilling] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billing(billing: JsonField<WriteBilling>) = apply { this.billing = billing }

        /** A message describing the result of the write request. */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** The number of rows affected by the write request. */
        fun rowsAffected(rowsAffected: Long) = rowsAffected(JsonField.of(rowsAffected))

        /**
         * Sets [Builder.rowsAffected] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rowsAffected] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rowsAffected(rowsAffected: JsonField<Long>) = apply { this.rowsAffected = rowsAffected }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("OK")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun status(status: JsonValue) = apply { this.status = status }

        /** The number of rows deleted by the write request. */
        fun rowsDeleted(rowsDeleted: Long) = rowsDeleted(JsonField.of(rowsDeleted))

        /**
         * Sets [Builder.rowsDeleted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rowsDeleted] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rowsDeleted(rowsDeleted: JsonField<Long>) = apply { this.rowsDeleted = rowsDeleted }

        /** The number of rows patched by the write request. */
        fun rowsPatched(rowsPatched: Long) = rowsPatched(JsonField.of(rowsPatched))

        /**
         * Sets [Builder.rowsPatched] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rowsPatched] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rowsPatched(rowsPatched: JsonField<Long>) = apply { this.rowsPatched = rowsPatched }

        /** Whether more documents match the filter for partial operations. */
        fun rowsRemaining(rowsRemaining: Boolean) = rowsRemaining(JsonField.of(rowsRemaining))

        /**
         * Sets [Builder.rowsRemaining] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rowsRemaining] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rowsRemaining(rowsRemaining: JsonField<Boolean>) = apply {
            this.rowsRemaining = rowsRemaining
        }

        /** The number of rows upserted by the write request. */
        fun rowsUpserted(rowsUpserted: Long) = rowsUpserted(JsonField.of(rowsUpserted))

        /**
         * Sets [Builder.rowsUpserted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rowsUpserted] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun rowsUpserted(rowsUpserted: JsonField<Long>) = apply { this.rowsUpserted = rowsUpserted }

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
         * Returns an immutable instance of [NamespaceWriteResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .message()
         * .rowsAffected()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceWriteResponse =
            NamespaceWriteResponse(
                checkRequired("billing", billing),
                checkRequired("message", message),
                checkRequired("rowsAffected", rowsAffected),
                status,
                rowsDeleted,
                rowsPatched,
                rowsRemaining,
                rowsUpserted,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceWriteResponse = apply {
        if (validated) {
            return@apply
        }

        billing().validate()
        message()
        rowsAffected()
        _status().let {
            if (it != JsonValue.from("OK")) {
                throw TurbopufferInvalidDataException("'status' is invalid, received $it")
            }
        }
        rowsDeleted()
        rowsPatched()
        rowsRemaining()
        rowsUpserted()
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
        (billing.asKnown().getOrNull()?.validity() ?: 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (rowsAffected.asKnown().isPresent) 1 else 0) +
            status.let { if (it == JsonValue.from("OK")) 1 else 0 } +
            (if (rowsDeleted.asKnown().isPresent) 1 else 0) +
            (if (rowsPatched.asKnown().isPresent) 1 else 0) +
            (if (rowsRemaining.asKnown().isPresent) 1 else 0) +
            (if (rowsUpserted.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceWriteResponse &&
            billing == other.billing &&
            message == other.message &&
            rowsAffected == other.rowsAffected &&
            status == other.status &&
            rowsDeleted == other.rowsDeleted &&
            rowsPatched == other.rowsPatched &&
            rowsRemaining == other.rowsRemaining &&
            rowsUpserted == other.rowsUpserted &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            billing,
            message,
            rowsAffected,
            status,
            rowsDeleted,
            rowsPatched,
            rowsRemaining,
            rowsUpserted,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceWriteResponse{billing=$billing, message=$message, rowsAffected=$rowsAffected, status=$status, rowsDeleted=$rowsDeleted, rowsPatched=$rowsPatched, rowsRemaining=$rowsRemaining, rowsUpserted=$rowsUpserted, additionalProperties=$additionalProperties}"
}
