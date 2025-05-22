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
    private val billing: JsonField<Billing>,
    private val message: JsonField<String>,
    private val rowsAffected: JsonField<Long>,
    private val status: JsonField<Status>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billing") @ExcludeMissing billing: JsonField<Billing> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rows_affected")
        @ExcludeMissing
        rowsAffected: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(billing, message, rowsAffected, status, mutableMapOf())

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): Billing = billing.getRequired("billing")

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
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<Billing> = billing

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

        private var billing: JsonField<Billing>? = null
        private var message: JsonField<String>? = null
        private var rowsAffected: JsonField<Long>? = null
        private var status: JsonField<Status>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceWriteResponse: NamespaceWriteResponse) = apply {
            billing = namespaceWriteResponse.billing
            message = namespaceWriteResponse.message
            rowsAffected = namespaceWriteResponse.rowsAffected
            status = namespaceWriteResponse.status
            additionalProperties = namespaceWriteResponse.additionalProperties.toMutableMap()
        }

        fun billing(billing: Billing) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [Billing] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun billing(billing: JsonField<Billing>) = apply { this.billing = billing }

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
            (status.asKnown().getOrNull()?.validity() ?: 0)

    class Billing
    private constructor(
        private val billableLogicalBytesWritten: JsonField<Long>,
        private val query: JsonField<Query>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("billable_logical_bytes_written")
            @ExcludeMissing
            billableLogicalBytesWritten: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<Query> = JsonMissing.of(),
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
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun query(): Optional<Query> = query.getOptional("query")

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
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<Query> = query

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
             * Returns a mutable builder for constructing an instance of [Billing].
             *
             * The following fields are required:
             * ```java
             * .billableLogicalBytesWritten()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Billing]. */
        class Builder internal constructor() {

            private var billableLogicalBytesWritten: JsonField<Long>? = null
            private var query: JsonField<Query> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(billing: Billing) = apply {
                billableLogicalBytesWritten = billing.billableLogicalBytesWritten
                query = billing.query
                additionalProperties = billing.additionalProperties.toMutableMap()
            }

            /** The number of billable logical bytes written to the namespace. */
            fun billableLogicalBytesWritten(billableLogicalBytesWritten: Long) =
                billableLogicalBytesWritten(JsonField.of(billableLogicalBytesWritten))

            /**
             * Sets [Builder.billableLogicalBytesWritten] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billableLogicalBytesWritten] with a well-typed
             * [Long] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun billableLogicalBytesWritten(billableLogicalBytesWritten: JsonField<Long>) = apply {
                this.billableLogicalBytesWritten = billableLogicalBytesWritten
            }

            /** The billing information for a query. */
            fun query(query: Query) = query(JsonField.of(query))

            /**
             * Sets [Builder.query] to an arbitrary JSON value.
             *
             * You should usually call [Builder.query] with a well-typed [Query] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun query(query: JsonField<Query>) = apply { this.query = query }

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
             * Returns an immutable instance of [Billing].
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
            fun build(): Billing =
                Billing(
                    checkRequired("billableLogicalBytesWritten", billableLogicalBytesWritten),
                    query,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Billing = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (billableLogicalBytesWritten.asKnown().isPresent) 1 else 0) +
                (query.asKnown().getOrNull()?.validity() ?: 0)

        /** The billing information for a query. */
        class Query
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
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun billableLogicalBytesQueried(): Long =
                billableLogicalBytesQueried.getRequired("billable_logical_bytes_queried")

            /**
             * The number of billable logical bytes returned from the query.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun billableLogicalBytesReturned(): Long =
                billableLogicalBytesReturned.getRequired("billable_logical_bytes_returned")

            /**
             * Returns the raw JSON value of [billableLogicalBytesQueried].
             *
             * Unlike [billableLogicalBytesQueried], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("billable_logical_bytes_queried")
            @ExcludeMissing
            fun _billableLogicalBytesQueried(): JsonField<Long> = billableLogicalBytesQueried

            /**
             * Returns the raw JSON value of [billableLogicalBytesReturned].
             *
             * Unlike [billableLogicalBytesReturned], this method doesn't throw if the JSON field
             * has an unexpected type.
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
                 * Returns a mutable builder for constructing an instance of [Query].
                 *
                 * The following fields are required:
                 * ```java
                 * .billableLogicalBytesQueried()
                 * .billableLogicalBytesReturned()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Query]. */
            class Builder internal constructor() {

                private var billableLogicalBytesQueried: JsonField<Long>? = null
                private var billableLogicalBytesReturned: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(query: Query) = apply {
                    billableLogicalBytesQueried = query.billableLogicalBytesQueried
                    billableLogicalBytesReturned = query.billableLogicalBytesReturned
                    additionalProperties = query.additionalProperties.toMutableMap()
                }

                /** The number of billable logical bytes queried from the namespace. */
                fun billableLogicalBytesQueried(billableLogicalBytesQueried: Long) =
                    billableLogicalBytesQueried(JsonField.of(billableLogicalBytesQueried))

                /**
                 * Sets [Builder.billableLogicalBytesQueried] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.billableLogicalBytesQueried] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun billableLogicalBytesQueried(billableLogicalBytesQueried: JsonField<Long>) =
                    apply {
                        this.billableLogicalBytesQueried = billableLogicalBytesQueried
                    }

                /** The number of billable logical bytes returned from the query. */
                fun billableLogicalBytesReturned(billableLogicalBytesReturned: Long) =
                    billableLogicalBytesReturned(JsonField.of(billableLogicalBytesReturned))

                /**
                 * Sets [Builder.billableLogicalBytesReturned] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.billableLogicalBytesReturned] with a well-typed
                 * [Long] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun billableLogicalBytesReturned(billableLogicalBytesReturned: JsonField<Long>) =
                    apply {
                        this.billableLogicalBytesReturned = billableLogicalBytesReturned
                    }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Query].
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
                fun build(): Query =
                    Query(
                        checkRequired("billableLogicalBytesQueried", billableLogicalBytesQueried),
                        checkRequired("billableLogicalBytesReturned", billableLogicalBytesReturned),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Query = apply {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
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

                return /* spotless:off */ other is Query && billableLogicalBytesQueried == other.billableLogicalBytesQueried && billableLogicalBytesReturned == other.billableLogicalBytesReturned && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(billableLogicalBytesQueried, billableLogicalBytesReturned, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Query{billableLogicalBytesQueried=$billableLogicalBytesQueried, billableLogicalBytesReturned=$billableLogicalBytesReturned, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Billing && billableLogicalBytesWritten == other.billableLogicalBytesWritten && query == other.query && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(billableLogicalBytesWritten, query, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Billing{billableLogicalBytesWritten=$billableLogicalBytesWritten, query=$query, additionalProperties=$additionalProperties}"
    }

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

        return /* spotless:off */ other is NamespaceWriteResponse && billing == other.billing && message == other.message && rowsAffected == other.rowsAffected && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(billing, message, rowsAffected, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceWriteResponse{billing=$billing, message=$message, rowsAffected=$rowsAffected, status=$status, additionalProperties=$additionalProperties}"
}
