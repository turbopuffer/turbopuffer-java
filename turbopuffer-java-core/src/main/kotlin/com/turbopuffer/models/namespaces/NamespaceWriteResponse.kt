// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.turbopuffer.core.Enum
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
private constructor(
    private val billing: JsonField<WriteBilling>,
    private val message: JsonField<String>,
    private val rowsAffected: JsonField<Long>,
    private val status: JsonField<Status>,
    private val rowsDeleted: JsonField<Long>,
    private val rowsPatched: JsonField<Long>,
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
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("rows_deleted")
        @ExcludeMissing
        rowsDeleted: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("rows_patched")
        @ExcludeMissing
        rowsPatched: JsonField<Long> = JsonMissing.of(),
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
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

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
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceWriteResponse]. */
    class Builder internal constructor() {

        private var billing: JsonField<WriteBilling>? = null
        private var message: JsonField<String>? = null
        private var rowsAffected: JsonField<Long>? = null
        private var status: JsonField<Status>? = null
        private var rowsDeleted: JsonField<Long> = JsonMissing.of()
        private var rowsPatched: JsonField<Long> = JsonMissing.of()
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

        /** The status of the request. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceWriteResponse =
            NamespaceWriteResponse(
                checkRequired("billing", billing),
                checkRequired("message", message),
                checkRequired("rowsAffected", rowsAffected),
                checkRequired("status", status),
                rowsDeleted,
                rowsPatched,
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
        status().validate()
        rowsDeleted()
        rowsPatched()
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
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (rowsDeleted.asKnown().isPresent) 1 else 0) +
            (if (rowsPatched.asKnown().isPresent) 1 else 0) +
            (if (rowsUpserted.asKnown().isPresent) 1 else 0)

    /** The status of the request. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val OK = of("OK")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            OK
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            OK,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                OK -> Value.OK
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                OK -> Known.OK
                else -> throw TurbopufferInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws TurbopufferInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                TurbopufferInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceWriteResponse && billing == other.billing && message == other.message && rowsAffected == other.rowsAffected && status == other.status && rowsDeleted == other.rowsDeleted && rowsPatched == other.rowsPatched && rowsUpserted == other.rowsUpserted && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(billing, message, rowsAffected, status, rowsDeleted, rowsPatched, rowsUpserted, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceWriteResponse{billing=$billing, message=$message, rowsAffected=$rowsAffected, status=$status, rowsDeleted=$rowsDeleted, rowsPatched=$rowsPatched, rowsUpserted=$rowsUpserted, additionalProperties=$additionalProperties}"
}
