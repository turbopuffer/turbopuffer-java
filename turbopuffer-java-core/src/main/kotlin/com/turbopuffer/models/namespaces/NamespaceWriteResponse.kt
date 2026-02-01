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

/** The response to a successful write request. */
class NamespaceWriteResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val billing: JsonField<WriteBilling>,
    private val message: JsonField<String>,
    private val rowsAffected: JsonField<Long>,
    private val status: JsonValue,
    private val deletedIds: JsonField<List<Id>>,
    private val patchedIds: JsonField<List<Id>>,
    private val rowsDeleted: JsonField<Long>,
    private val rowsPatched: JsonField<Long>,
    private val rowsRemaining: JsonField<Boolean>,
    private val rowsUpserted: JsonField<Long>,
    private val upsertedIds: JsonField<List<Id>>,
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
        @JsonProperty("deleted_ids")
        @ExcludeMissing
        deletedIds: JsonField<List<Id>> = JsonMissing.of(),
        @JsonProperty("patched_ids")
        @ExcludeMissing
        patchedIds: JsonField<List<Id>> = JsonMissing.of(),
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
        @JsonProperty("upserted_ids")
        @ExcludeMissing
        upsertedIds: JsonField<List<Id>> = JsonMissing.of(),
    ) : this(
        billing,
        message,
        rowsAffected,
        status,
        deletedIds,
        patchedIds,
        rowsDeleted,
        rowsPatched,
        rowsRemaining,
        rowsUpserted,
        upsertedIds,
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
     * The IDs of documents that were deleted. Only included when `return_affected_ids` is true and
     * at least one document was deleted.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun deletedIds(): Optional<List<Id>> = deletedIds.getOptional("deleted_ids")

    /**
     * The IDs of documents that were patched. Only included when `return_affected_ids` is true and
     * at least one document was patched.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun patchedIds(): Optional<List<Id>> = patchedIds.getOptional("patched_ids")

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
     * The IDs of documents that were upserted. Only included when `return_affected_ids` is true and
     * at least one document was upserted.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun upsertedIds(): Optional<List<Id>> = upsertedIds.getOptional("upserted_ids")

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
     * Returns the raw JSON value of [deletedIds].
     *
     * Unlike [deletedIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deleted_ids") @ExcludeMissing fun _deletedIds(): JsonField<List<Id>> = deletedIds

    /**
     * Returns the raw JSON value of [patchedIds].
     *
     * Unlike [patchedIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("patched_ids") @ExcludeMissing fun _patchedIds(): JsonField<List<Id>> = patchedIds

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

    /**
     * Returns the raw JSON value of [upsertedIds].
     *
     * Unlike [upsertedIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("upserted_ids")
    @ExcludeMissing
    fun _upsertedIds(): JsonField<List<Id>> = upsertedIds

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
        private var deletedIds: JsonField<MutableList<Id>>? = null
        private var patchedIds: JsonField<MutableList<Id>>? = null
        private var rowsDeleted: JsonField<Long> = JsonMissing.of()
        private var rowsPatched: JsonField<Long> = JsonMissing.of()
        private var rowsRemaining: JsonField<Boolean> = JsonMissing.of()
        private var rowsUpserted: JsonField<Long> = JsonMissing.of()
        private var upsertedIds: JsonField<MutableList<Id>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceWriteResponse: NamespaceWriteResponse) = apply {
            billing = namespaceWriteResponse.billing
            message = namespaceWriteResponse.message
            rowsAffected = namespaceWriteResponse.rowsAffected
            status = namespaceWriteResponse.status
            deletedIds = namespaceWriteResponse.deletedIds.map { it.toMutableList() }
            patchedIds = namespaceWriteResponse.patchedIds.map { it.toMutableList() }
            rowsDeleted = namespaceWriteResponse.rowsDeleted
            rowsPatched = namespaceWriteResponse.rowsPatched
            rowsRemaining = namespaceWriteResponse.rowsRemaining
            rowsUpserted = namespaceWriteResponse.rowsUpserted
            upsertedIds = namespaceWriteResponse.upsertedIds.map { it.toMutableList() }
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

        /**
         * The IDs of documents that were deleted. Only included when `return_affected_ids` is true
         * and at least one document was deleted.
         */
        fun deletedIds(deletedIds: List<Id>) = deletedIds(JsonField.of(deletedIds))

        /**
         * Sets [Builder.deletedIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deletedIds] with a well-typed `List<Id>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deletedIds(deletedIds: JsonField<List<Id>>) = apply {
            this.deletedIds = deletedIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [Id] to [deletedIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDeletedId(deletedId: Id) = apply {
            deletedIds =
                (deletedIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("deletedIds", it).add(deletedId)
                }
        }

        /** Alias for calling [addDeletedId] with `Id.ofString(string)`. */
        fun addDeletedId(string: String) = addDeletedId(Id.ofString(string))

        /** Alias for calling [addDeletedId] with `Id.ofInteger(integer)`. */
        fun addDeletedId(integer: Long) = addDeletedId(Id.ofInteger(integer))

        /**
         * The IDs of documents that were patched. Only included when `return_affected_ids` is true
         * and at least one document was patched.
         */
        fun patchedIds(patchedIds: List<Id>) = patchedIds(JsonField.of(patchedIds))

        /**
         * Sets [Builder.patchedIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchedIds] with a well-typed `List<Id>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun patchedIds(patchedIds: JsonField<List<Id>>) = apply {
            this.patchedIds = patchedIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [Id] to [patchedIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPatchedId(patchedId: Id) = apply {
            patchedIds =
                (patchedIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("patchedIds", it).add(patchedId)
                }
        }

        /** Alias for calling [addPatchedId] with `Id.ofString(string)`. */
        fun addPatchedId(string: String) = addPatchedId(Id.ofString(string))

        /** Alias for calling [addPatchedId] with `Id.ofInteger(integer)`. */
        fun addPatchedId(integer: Long) = addPatchedId(Id.ofInteger(integer))

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

        /**
         * The IDs of documents that were upserted. Only included when `return_affected_ids` is true
         * and at least one document was upserted.
         */
        fun upsertedIds(upsertedIds: List<Id>) = upsertedIds(JsonField.of(upsertedIds))

        /**
         * Sets [Builder.upsertedIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.upsertedIds] with a well-typed `List<Id>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun upsertedIds(upsertedIds: JsonField<List<Id>>) = apply {
            this.upsertedIds = upsertedIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [Id] to [upsertedIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUpsertedId(upsertedId: Id) = apply {
            upsertedIds =
                (upsertedIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("upsertedIds", it).add(upsertedId)
                }
        }

        /** Alias for calling [addUpsertedId] with `Id.ofString(string)`. */
        fun addUpsertedId(string: String) = addUpsertedId(Id.ofString(string))

        /** Alias for calling [addUpsertedId] with `Id.ofInteger(integer)`. */
        fun addUpsertedId(integer: Long) = addUpsertedId(Id.ofInteger(integer))

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
                (deletedIds ?: JsonMissing.of()).map { it.toImmutable() },
                (patchedIds ?: JsonMissing.of()).map { it.toImmutable() },
                rowsDeleted,
                rowsPatched,
                rowsRemaining,
                rowsUpserted,
                (upsertedIds ?: JsonMissing.of()).map { it.toImmutable() },
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
        deletedIds().ifPresent { it.forEach { it.validate() } }
        patchedIds().ifPresent { it.forEach { it.validate() } }
        rowsDeleted()
        rowsPatched()
        rowsRemaining()
        rowsUpserted()
        upsertedIds().ifPresent { it.forEach { it.validate() } }
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
            (deletedIds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (patchedIds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (rowsDeleted.asKnown().isPresent) 1 else 0) +
            (if (rowsPatched.asKnown().isPresent) 1 else 0) +
            (if (rowsRemaining.asKnown().isPresent) 1 else 0) +
            (if (rowsUpserted.asKnown().isPresent) 1 else 0) +
            (upsertedIds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceWriteResponse &&
            billing == other.billing &&
            message == other.message &&
            rowsAffected == other.rowsAffected &&
            status == other.status &&
            deletedIds == other.deletedIds &&
            patchedIds == other.patchedIds &&
            rowsDeleted == other.rowsDeleted &&
            rowsPatched == other.rowsPatched &&
            rowsRemaining == other.rowsRemaining &&
            rowsUpserted == other.rowsUpserted &&
            upsertedIds == other.upsertedIds &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            billing,
            message,
            rowsAffected,
            status,
            deletedIds,
            patchedIds,
            rowsDeleted,
            rowsPatched,
            rowsRemaining,
            rowsUpserted,
            upsertedIds,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceWriteResponse{billing=$billing, message=$message, rowsAffected=$rowsAffected, status=$status, deletedIds=$deletedIds, patchedIds=$patchedIds, rowsDeleted=$rowsDeleted, rowsPatched=$rowsPatched, rowsRemaining=$rowsRemaining, rowsUpserted=$rowsUpserted, upsertedIds=$upsertedIds, additionalProperties=$additionalProperties}"
}
