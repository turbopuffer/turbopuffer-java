// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.BaseDeserializer
import com.turbopuffer.core.BaseSerializer
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonField
import com.turbopuffer.core.JsonMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.Params
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkKnown
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Create, update, or delete documents. */
class NamespaceWriteParams
private constructor(
    private val namespace: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /**
     * The namespace to copy documents from.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun copyFromNamespace(): Optional<CopyFromNamespace> = body.copyFromNamespace()

    /** The filter specifying which documents to delete. */
    fun deleteByFilter(): Optional<Filter> = body.deleteByFilter()

    /**
     * Allow partial completion when filter matches too many documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun deleteByFilterAllowPartial(): Optional<Boolean> = body.deleteByFilterAllowPartial()

    /**
     * A condition evaluated against the current value of each document targeted by a delete write.
     * Only documents that pass the condition are deleted.
     */
    fun deleteCondition(): Optional<Filter> = body.deleteCondition()

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun deletes(): Optional<List<Id>> = body.deletes()

    /**
     * Disables write throttling (HTTP 429 responses) during high-volume ingestion.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun disableBackpressure(): Optional<Boolean> = body.disableBackpressure()

    /**
     * A function used to calculate vector similarity.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distanceMetric(): Optional<DistanceMetric> = body.distanceMetric()

    /**
     * The encryption configuration for a namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun encryption(): Optional<Encryption> = body.encryption()

    /**
     * The patch and filter specifying which documents to patch.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun patchByFilter(): Optional<PatchByFilter> = body.patchByFilter()

    /**
     * Allow partial completion when filter matches too many documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun patchByFilterAllowPartial(): Optional<Boolean> = body.patchByFilterAllowPartial()

    /**
     * A list of documents in columnar format. Each key is a column name, mapped to an array of
     * values for that column.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun patchColumns(): Optional<Columns> = body.patchColumns()

    /**
     * A condition evaluated against the current value of each document targeted by a patch write.
     * Only documents that pass the condition are patched.
     */
    fun patchCondition(): Optional<Filter> = body.patchCondition()

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun patchRows(): Optional<List<Row>> = body.patchRows()

    /**
     * The schema of the attributes attached to the documents.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun schema(): Optional<Schema> = body.schema()

    /**
     * A list of documents in columnar format. Each key is a column name, mapped to an array of
     * values for that column.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun upsertColumns(): Optional<Columns> = body.upsertColumns()

    /**
     * A condition evaluated against the current value of each document targeted by an upsert write.
     * Only documents that pass the condition are upserted.
     */
    fun upsertCondition(): Optional<Filter> = body.upsertCondition()

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun upsertRows(): Optional<List<Row>> = body.upsertRows()

    /**
     * Returns the raw JSON value of [copyFromNamespace].
     *
     * Unlike [copyFromNamespace], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _copyFromNamespace(): JsonField<CopyFromNamespace> = body._copyFromNamespace()

    /**
     * Returns the raw JSON value of [deleteByFilter].
     *
     * Unlike [deleteByFilter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _deleteByFilter(): JsonField<Filter> = body._deleteByFilter()

    /**
     * Returns the raw JSON value of [deleteCondition].
     *
     * Unlike [deleteCondition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _deleteCondition(): JsonField<Filter> = body._deleteCondition()

    /**
     * Returns the raw JSON value of [deletes].
     *
     * Unlike [deletes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _deletes(): JsonField<List<Id>> = body._deletes()

    /**
     * Returns the raw JSON value of [disableBackpressure].
     *
     * Unlike [disableBackpressure], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _disableBackpressure(): JsonField<Boolean> = body._disableBackpressure()

    /**
     * Returns the raw JSON value of [distanceMetric].
     *
     * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _distanceMetric(): JsonField<DistanceMetric> = body._distanceMetric()

    /**
     * Returns the raw JSON value of [encryption].
     *
     * Unlike [encryption], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _encryption(): JsonField<Encryption> = body._encryption()

    /**
     * Returns the raw JSON value of [patchByFilter].
     *
     * Unlike [patchByFilter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _patchByFilter(): JsonField<PatchByFilter> = body._patchByFilter()

    /**
     * Returns the raw JSON value of [patchByFilterAllowPartial].
     *
     * Unlike [patchByFilterAllowPartial], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _patchByFilterAllowPartial(): JsonField<Boolean> = body._patchByFilterAllowPartial()

    /**
     * Returns the raw JSON value of [patchColumns].
     *
     * Unlike [patchColumns], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _patchColumns(): JsonField<Columns> = body._patchColumns()

    /**
     * Returns the raw JSON value of [patchCondition].
     *
     * Unlike [patchCondition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _patchCondition(): JsonField<Filter> = body._patchCondition()

    /**
     * Returns the raw JSON value of [patchRows].
     *
     * Unlike [patchRows], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _patchRows(): JsonField<List<Row>> = body._patchRows()

    /**
     * Returns the raw JSON value of [schema].
     *
     * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _schema(): JsonField<Schema> = body._schema()

    /**
     * Returns the raw JSON value of [upsertColumns].
     *
     * Unlike [upsertColumns], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _upsertColumns(): JsonField<Columns> = body._upsertColumns()

    /**
     * Returns the raw JSON value of [upsertCondition].
     *
     * Unlike [upsertCondition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _upsertCondition(): JsonField<Filter> = body._upsertCondition()

    /**
     * Returns the raw JSON value of [upsertRows].
     *
     * Unlike [upsertRows], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _upsertRows(): JsonField<List<Row>> = body._upsertRows()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceWriteParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [NamespaceWriteParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceWriteParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceWriteParams: NamespaceWriteParams) = apply {
            namespace = namespaceWriteParams.namespace
            body = namespaceWriteParams.body.toBuilder()
            additionalHeaders = namespaceWriteParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceWriteParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [copyFromNamespace]
         * - [deleteByFilter]
         * - [deleteByFilterAllowPartial]
         * - [deleteCondition]
         * - [deletes]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The namespace to copy documents from. */
        fun copyFromNamespace(copyFromNamespace: CopyFromNamespace) = apply {
            body.copyFromNamespace(copyFromNamespace)
        }

        /**
         * Sets [Builder.copyFromNamespace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.copyFromNamespace] with a well-typed [CopyFromNamespace]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun copyFromNamespace(copyFromNamespace: JsonField<CopyFromNamespace>) = apply {
            body.copyFromNamespace(copyFromNamespace)
        }

        /** Alias for calling [copyFromNamespace] with `CopyFromNamespace.ofString(string)`. */
        fun copyFromNamespace(string: String) = apply { body.copyFromNamespace(string) }

        /** Alias for calling [copyFromNamespace] with `CopyFromNamespace.ofConfig(config)`. */
        fun copyFromNamespace(config: CopyFromNamespace.CopyFromNamespaceConfig) = apply {
            body.copyFromNamespace(config)
        }

        /** The filter specifying which documents to delete. */
        fun deleteByFilter(deleteByFilter: Filter) = apply { body.deleteByFilter(deleteByFilter) }

        /** Allow partial completion when filter matches too many documents. */
        fun deleteByFilterAllowPartial(deleteByFilterAllowPartial: Boolean) = apply {
            body.deleteByFilterAllowPartial(deleteByFilterAllowPartial)
        }

        /**
         * Sets [Builder.deleteByFilterAllowPartial] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deleteByFilterAllowPartial] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun deleteByFilterAllowPartial(deleteByFilterAllowPartial: JsonField<Boolean>) = apply {
            body.deleteByFilterAllowPartial(deleteByFilterAllowPartial)
        }

        /**
         * A condition evaluated against the current value of each document targeted by a delete
         * write. Only documents that pass the condition are deleted.
         */
        fun deleteCondition(deleteCondition: Filter) = apply {
            body.deleteCondition(deleteCondition)
        }

        /**
         * Sets [Builder.deleteCondition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deleteCondition] with a well-typed [Filter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deleteCondition(deleteCondition: JsonField<Filter>) = apply {
            body.deleteCondition(deleteCondition)
        }

        fun deletes(deletes: List<Any>) = apply {
            deletes.forEach { body.addDelete(JsonValue.from(it)) }
        }

        /**
         * Sets [Builder.deletes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deletes] with a well-typed `List<Id>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deletes(deletes: JsonField<List<Id>>) = apply { body.deletes(deletes) }

        /**
         * Adds a single [Id] to [deletes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDelete(delete: Id) = apply { body.addDelete(delete) }

        /** Alias for calling [addDelete] with `JsonValue.from(string)`. */
        fun addDelete(string: String) = apply { body.addDelete(string) }

        /** Alias for calling [addDelete] with `JsonValue.from(integer)`. */
        fun addDelete(integer: Long) = apply { body.addDelete(integer) }

        /** Disables write throttling (HTTP 429 responses) during high-volume ingestion. */
        fun disableBackpressure(disableBackpressure: Boolean) = apply {
            body.disableBackpressure(disableBackpressure)
        }

        /**
         * Sets [Builder.disableBackpressure] to an arbitrary JSON value.
         *
         * You should usually call [Builder.disableBackpressure] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun disableBackpressure(disableBackpressure: JsonField<Boolean>) = apply {
            body.disableBackpressure(disableBackpressure)
        }

        /** A function used to calculate vector similarity. */
        fun distanceMetric(distanceMetric: DistanceMetric) = apply {
            body.distanceMetric(distanceMetric)
        }

        /**
         * Sets [Builder.distanceMetric] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distanceMetric] with a well-typed [DistanceMetric] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
            body.distanceMetric(distanceMetric)
        }

        /** The encryption configuration for a namespace. */
        fun encryption(encryption: Encryption) = apply { body.encryption(encryption) }

        /**
         * Sets [Builder.encryption] to an arbitrary JSON value.
         *
         * You should usually call [Builder.encryption] with a well-typed [Encryption] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun encryption(encryption: JsonField<Encryption>) = apply { body.encryption(encryption) }

        /** The patch and filter specifying which documents to patch. */
        fun patchByFilter(patchByFilter: PatchByFilter) = apply {
            body.patchByFilter(patchByFilter)
        }

        /**
         * Sets [Builder.patchByFilter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchByFilter] with a well-typed [PatchByFilter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun patchByFilter(patchByFilter: JsonField<PatchByFilter>) = apply {
            body.patchByFilter(patchByFilter)
        }

        /** Allow partial completion when filter matches too many documents. */
        fun patchByFilterAllowPartial(patchByFilterAllowPartial: Boolean) = apply {
            body.patchByFilterAllowPartial(patchByFilterAllowPartial)
        }

        /**
         * Sets [Builder.patchByFilterAllowPartial] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchByFilterAllowPartial] with a well-typed [Boolean]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun patchByFilterAllowPartial(patchByFilterAllowPartial: JsonField<Boolean>) = apply {
            body.patchByFilterAllowPartial(patchByFilterAllowPartial)
        }

        /**
         * A list of documents in columnar format. Each key is a column name, mapped to an array of
         * values for that column.
         */
        fun patchColumns(patchColumns: Columns) = apply { body.patchColumns(patchColumns) }

        /**
         * Sets [Builder.patchColumns] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchColumns] with a well-typed [Columns] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun patchColumns(patchColumns: JsonField<Columns>) = apply {
            body.patchColumns(patchColumns)
        }

        /**
         * A condition evaluated against the current value of each document targeted by a patch
         * write. Only documents that pass the condition are patched.
         */
        fun patchCondition(patchCondition: Filter) = apply { body.patchCondition(patchCondition) }

        /**
         * Sets [Builder.patchCondition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchCondition] with a well-typed [Filter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun patchCondition(patchCondition: JsonField<Filter>) = apply {
            body.patchCondition(patchCondition)
        }

        fun patchRows(patchRows: List<Row>) = apply { body.patchRows(patchRows) }

        /**
         * Sets [Builder.patchRows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.patchRows] with a well-typed `List<Row>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun patchRows(patchRows: JsonField<List<Row>>) = apply { body.patchRows(patchRows) }

        /**
         * Adds a single [Row] to [patchRows].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPatchRow(patchRow: Row) = apply { body.addPatchRow(patchRow) }

        /** The schema of the attributes attached to the documents. */
        fun schema(schema: Schema) = apply { body.schema(schema) }

        /**
         * Sets [Builder.schema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schema] with a well-typed [Schema] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun schema(schema: JsonField<Schema>) = apply { body.schema(schema) }

        /**
         * A list of documents in columnar format. Each key is a column name, mapped to an array of
         * values for that column.
         */
        fun upsertColumns(upsertColumns: Columns) = apply { body.upsertColumns(upsertColumns) }

        /**
         * Sets [Builder.upsertColumns] to an arbitrary JSON value.
         *
         * You should usually call [Builder.upsertColumns] with a well-typed [Columns] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun upsertColumns(upsertColumns: JsonField<Columns>) = apply {
            body.upsertColumns(upsertColumns)
        }

        /**
         * A condition evaluated against the current value of each document targeted by an upsert
         * write. Only documents that pass the condition are upserted.
         */
        fun upsertCondition(upsertCondition: Filter) = apply {
            body.upsertCondition(upsertCondition)
        }

        /**
         * Sets [Builder.upsertCondition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.upsertCondition] with a well-typed [Filter] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun upsertCondition(upsertCondition: JsonField<Filter>) = apply {
            body.upsertCondition(upsertCondition)
        }

        fun upsertRows(upsertRows: List<Row>) = apply { body.upsertRows(upsertRows) }

        /**
         * Sets [Builder.upsertRows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.upsertRows] with a well-typed `List<Row>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun upsertRows(upsertRows: JsonField<List<Row>>) = apply { body.upsertRows(upsertRows) }

        /**
         * Adds a single [Row] to [upsertRows].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUpsertRow(upsertRow: Row) = apply { body.addUpsertRow(upsertRow) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [NamespaceWriteParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceWriteParams =
            NamespaceWriteParams(
                namespace,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Create, update, or delete documents. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val copyFromNamespace: JsonField<CopyFromNamespace>,
        private val deleteByFilter: JsonField<Filter>,
        private val deleteByFilterAllowPartial: JsonField<Boolean>,
        private val deleteCondition: JsonField<Filter>,
        private val deletes: JsonField<List<Id>>,
        private val disableBackpressure: JsonField<Boolean>,
        private val distanceMetric: JsonField<DistanceMetric>,
        private val encryption: JsonField<Encryption>,
        private val patchByFilter: JsonField<PatchByFilter>,
        private val patchByFilterAllowPartial: JsonField<Boolean>,
        private val patchColumns: JsonField<Columns>,
        private val patchCondition: JsonField<Filter>,
        private val patchRows: JsonField<List<Row>>,
        private val schema: JsonField<Schema>,
        private val upsertColumns: JsonField<Columns>,
        private val upsertCondition: JsonField<Filter>,
        private val upsertRows: JsonField<List<Row>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("copy_from_namespace")
            @ExcludeMissing
            copyFromNamespace: JsonField<CopyFromNamespace> = JsonMissing.of(),
            @JsonProperty("delete_by_filter")
            @ExcludeMissing
            deleteByFilter: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("delete_by_filter_allow_partial")
            @ExcludeMissing
            deleteByFilterAllowPartial: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("delete_condition")
            @ExcludeMissing
            deleteCondition: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("deletes")
            @ExcludeMissing
            deletes: JsonField<List<Id>> = JsonMissing.of(),
            @JsonProperty("disable_backpressure")
            @ExcludeMissing
            disableBackpressure: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("distance_metric")
            @ExcludeMissing
            distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
            @JsonProperty("encryption")
            @ExcludeMissing
            encryption: JsonField<Encryption> = JsonMissing.of(),
            @JsonProperty("patch_by_filter")
            @ExcludeMissing
            patchByFilter: JsonField<PatchByFilter> = JsonMissing.of(),
            @JsonProperty("patch_by_filter_allow_partial")
            @ExcludeMissing
            patchByFilterAllowPartial: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("patch_columns")
            @ExcludeMissing
            patchColumns: JsonField<Columns> = JsonMissing.of(),
            @JsonProperty("patch_condition")
            @ExcludeMissing
            patchCondition: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("patch_rows")
            @ExcludeMissing
            patchRows: JsonField<List<Row>> = JsonMissing.of(),
            @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
            @JsonProperty("upsert_columns")
            @ExcludeMissing
            upsertColumns: JsonField<Columns> = JsonMissing.of(),
            @JsonProperty("upsert_condition")
            @ExcludeMissing
            upsertCondition: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("upsert_rows")
            @ExcludeMissing
            upsertRows: JsonField<List<Row>> = JsonMissing.of(),
        ) : this(
            copyFromNamespace,
            deleteByFilter,
            deleteByFilterAllowPartial,
            deleteCondition,
            deletes,
            disableBackpressure,
            distanceMetric,
            encryption,
            patchByFilter,
            patchByFilterAllowPartial,
            patchColumns,
            patchCondition,
            patchRows,
            schema,
            upsertColumns,
            upsertCondition,
            upsertRows,
            mutableMapOf(),
        )

        /**
         * The namespace to copy documents from.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun copyFromNamespace(): Optional<CopyFromNamespace> =
            copyFromNamespace.getOptional("copy_from_namespace")

        /**
         * The filter specifying which documents to delete.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deleteByFilter(): Optional<Filter> = deleteByFilter.getOptional("delete_by_filter")

        /**
         * Allow partial completion when filter matches too many documents.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deleteByFilterAllowPartial(): Optional<Boolean> =
            deleteByFilterAllowPartial.getOptional("delete_by_filter_allow_partial")

        /**
         * A condition evaluated against the current value of each document targeted by a delete
         * write. Only documents that pass the condition are deleted.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deleteCondition(): Optional<Filter> = deleteCondition.getOptional("delete_condition")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deletes(): Optional<List<Id>> = deletes.getOptional("deletes")

        /**
         * Disables write throttling (HTTP 429 responses) during high-volume ingestion.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun disableBackpressure(): Optional<Boolean> =
            disableBackpressure.getOptional("disable_backpressure")

        /**
         * A function used to calculate vector similarity.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun distanceMetric(): Optional<DistanceMetric> =
            distanceMetric.getOptional("distance_metric")

        /**
         * The encryption configuration for a namespace.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun encryption(): Optional<Encryption> = encryption.getOptional("encryption")

        /**
         * The patch and filter specifying which documents to patch.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun patchByFilter(): Optional<PatchByFilter> = patchByFilter.getOptional("patch_by_filter")

        /**
         * Allow partial completion when filter matches too many documents.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun patchByFilterAllowPartial(): Optional<Boolean> =
            patchByFilterAllowPartial.getOptional("patch_by_filter_allow_partial")

        /**
         * A list of documents in columnar format. Each key is a column name, mapped to an array of
         * values for that column.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun patchColumns(): Optional<Columns> = patchColumns.getOptional("patch_columns")

        /**
         * A condition evaluated against the current value of each document targeted by a patch
         * write. Only documents that pass the condition are patched.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun patchCondition(): Optional<Filter> = patchCondition.getOptional("patch_condition")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun patchRows(): Optional<List<Row>> = patchRows.getOptional("patch_rows")

        /**
         * The schema of the attributes attached to the documents.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun schema(): Optional<Schema> = schema.getOptional("schema")

        /**
         * A list of documents in columnar format. Each key is a column name, mapped to an array of
         * values for that column.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun upsertColumns(): Optional<Columns> = upsertColumns.getOptional("upsert_columns")

        /**
         * A condition evaluated against the current value of each document targeted by an upsert
         * write. Only documents that pass the condition are upserted.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun upsertCondition(): Optional<Filter> = upsertCondition.getOptional("upsert_condition")

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun upsertRows(): Optional<List<Row>> = upsertRows.getOptional("upsert_rows")

        /**
         * Returns the raw JSON value of [copyFromNamespace].
         *
         * Unlike [copyFromNamespace], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("copy_from_namespace")
        @ExcludeMissing
        fun _copyFromNamespace(): JsonField<CopyFromNamespace> = copyFromNamespace

        /**
         * Returns the raw JSON value of [deleteByFilterAllowPartial].
         *
         * Unlike [deleteByFilterAllowPartial], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("delete_by_filter_allow_partial")
        @ExcludeMissing
        fun _deleteByFilterAllowPartial(): JsonField<Boolean> = deleteByFilterAllowPartial

        /**
         * Returns the raw JSON value of [deletes].
         *
         * Unlike [deletes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("deletes") @ExcludeMissing fun _deletes(): JsonField<List<Id>> = deletes

        /**
         * Returns the raw JSON value of [deleteByFilter].
         *
         * Unlike [deleteByFilter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("delete_by_filter")
        @ExcludeMissing
        fun _deleteByFilter(): JsonField<Filter> = deleteByFilter

        @JsonProperty("delete_condition")
        @ExcludeMissing
        fun _deleteCondition(): JsonField<Filter> = deleteCondition

        /**
         * Returns the raw JSON value of [disableBackpressure].
         *
         * Unlike [disableBackpressure], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("disable_backpressure")
        @ExcludeMissing
        fun _disableBackpressure(): JsonField<Boolean> = disableBackpressure

        /**
         * Returns the raw JSON value of [distanceMetric].
         *
         * Unlike [distanceMetric], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /**
         * Returns the raw JSON value of [encryption].
         *
         * Unlike [encryption], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("encryption")
        @ExcludeMissing
        fun _encryption(): JsonField<Encryption> = encryption

        /**
         * Returns the raw JSON value of [patchByFilter].
         *
         * Unlike [patchByFilter], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("patch_by_filter")
        @ExcludeMissing
        fun _patchByFilter(): JsonField<PatchByFilter> = patchByFilter

        /**
         * Returns the raw JSON value of [patchByFilterAllowPartial].
         *
         * Unlike [patchByFilterAllowPartial], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("patch_by_filter_allow_partial")
        @ExcludeMissing
        fun _patchByFilterAllowPartial(): JsonField<Boolean> = patchByFilterAllowPartial

        /**
         * Returns the raw JSON value of [patchColumns].
         *
         * Unlike [patchColumns], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("patch_columns")
        @ExcludeMissing
        fun _patchColumns(): JsonField<Columns> = patchColumns

        /**
         * Returns the raw JSON value of [patchCondition].
         *
         * Unlike [patchCondition], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("patch_condition")
        @ExcludeMissing
        fun _patchCondition(): JsonField<Filter> = patchCondition

        /**
         * Returns the raw JSON value of [patchRows].
         *
         * Unlike [patchRows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("patch_rows")
        @ExcludeMissing
        fun _patchRows(): JsonField<List<Row>> = patchRows

        /**
         * Returns the raw JSON value of [schema].
         *
         * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

        /**
         * Returns the raw JSON value of [upsertColumns].
         *
         * Unlike [upsertColumns], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("upsert_columns")
        @ExcludeMissing
        fun _upsertColumns(): JsonField<Columns> = upsertColumns

        /**
         * Returns the raw JSON value of [upsertCondition].
         *
         * Unlike [upsertCondition], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("upsert_condition")
        @ExcludeMissing
        fun _upsertCondition(): JsonField<Filter> = upsertCondition

        /**
         * Returns the raw JSON value of [upsertRows].
         *
         * Unlike [upsertRows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("upsert_rows")
        @ExcludeMissing
        fun _upsertRows(): JsonField<List<Row>> = upsertRows

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {
            private var copyFromNamespace: JsonField<CopyFromNamespace> = JsonMissing.of()
            private var deleteByFilter: JsonField<Filter> = JsonMissing.of()
            private var deleteByFilterAllowPartial: JsonField<Boolean> = JsonMissing.of()
            private var deleteCondition: JsonField<Filter> = JsonMissing.of()
            private var deletes: JsonField<MutableList<Id>>? = null
            private var disableBackpressure: JsonField<Boolean> = JsonMissing.of()
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var encryption: JsonField<Encryption> = JsonMissing.of()
            private var patchByFilter: JsonField<PatchByFilter> = JsonMissing.of()
            private var patchByFilterAllowPartial: JsonField<Boolean> = JsonMissing.of()
            private var patchColumns: JsonField<Columns> = JsonMissing.of()
            private var patchCondition: JsonField<Filter> = JsonMissing.of()
            private var patchRows: JsonField<MutableList<Row>>? = null
            private var schema: JsonField<Schema> = JsonMissing.of()
            private var upsertColumns: JsonField<Columns> = JsonMissing.of()
            private var upsertCondition: JsonField<Filter> = JsonMissing.of()
            private var upsertRows: JsonField<MutableList<Row>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                copyFromNamespace = body.copyFromNamespace
                deleteByFilter = body.deleteByFilter
                deleteByFilterAllowPartial = body.deleteByFilterAllowPartial
                deleteCondition = body.deleteCondition
                deletes = body.deletes.map { it.toMutableList() }
                disableBackpressure = body.disableBackpressure
                distanceMetric = body.distanceMetric
                encryption = body.encryption
                patchByFilter = body.patchByFilter
                patchByFilterAllowPartial = body.patchByFilterAllowPartial
                patchColumns = body.patchColumns
                patchCondition = body.patchCondition
                patchRows = body.patchRows.map { it.toMutableList() }
                schema = body.schema
                upsertColumns = body.upsertColumns
                upsertCondition = body.upsertCondition
                upsertRows = body.upsertRows.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The namespace to copy documents from. */
            fun copyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                copyFromNamespace(JsonField.of(copyFromNamespace))

            /**
             * Sets [Builder.copyFromNamespace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.copyFromNamespace] with a well-typed
             * [CopyFromNamespace] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun copyFromNamespace(copyFromNamespace: JsonField<CopyFromNamespace>) = apply {
                this.copyFromNamespace = copyFromNamespace
            }

            /** Alias for calling [copyFromNamespace] with `CopyFromNamespace.ofString(string)`. */
            fun copyFromNamespace(string: String) =
                copyFromNamespace(CopyFromNamespace.ofString(string))

            /** Alias for calling [copyFromNamespace] with `CopyFromNamespace.ofConfig(config)`. */
            fun copyFromNamespace(config: CopyFromNamespace.CopyFromNamespaceConfig) =
                copyFromNamespace(CopyFromNamespace.ofConfig(config))

            /** The filter specifying which documents to delete. */
            fun deleteByFilter(deleteByFilter: Filter) = apply {
                deleteByFilter(JsonField.of(deleteByFilter))
            }

            /**
             * Sets [Builder.deleteByFilter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deleteByFilter] with a well-typed [Filter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deleteByFilter(deleteByFilter: JsonField<Filter>) = apply {
                this.deleteByFilter = deleteByFilter
            }

            /** Allow partial completion when filter matches too many documents. */
            fun deleteByFilterAllowPartial(deleteByFilterAllowPartial: Boolean) =
                deleteByFilterAllowPartial(JsonField.of(deleteByFilterAllowPartial))

            /**
             * Sets [Builder.deleteByFilterAllowPartial] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deleteByFilterAllowPartial] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun deleteByFilterAllowPartial(deleteByFilterAllowPartial: JsonField<Boolean>) = apply {
                this.deleteByFilterAllowPartial = deleteByFilterAllowPartial
            }

            /**
             * A condition evaluated against the current value of each document targeted by a delete
             * write. Only documents that pass the condition are deleted.
             */
            fun deleteCondition(deleteCondition: Filter) =
                deleteCondition(JsonField.of(deleteCondition))

            /**
             * Sets [Builder.deleteCondition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deleteCondition] with a well-typed [Filter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deleteCondition(deleteCondition: JsonField<Filter>) = apply {
                this.deleteCondition = deleteCondition
            }

            fun deletes(deletes: List<Id>) = deletes(JsonField.of(deletes))

            /**
             * Sets [Builder.deletes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deletes] with a well-typed `List<Id>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deletes(deletes: JsonField<List<Id>>) = apply {
                this.deletes = deletes.map { it.toMutableList() }
            }

            /**
             * Adds a single [Id] to [deletes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDelete(delete: Id) = apply {
                deletes =
                    (deletes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("deletes", it).add(delete)
                    }
            }

            /** Alias for calling [addDelete] with `JsonValue.from(string)`. */
            fun addDelete(string: String) = addDelete(JsonValue.from(string))

            /** Alias for calling [addDelete] with `JsonValue.from(integer)`. */
            fun addDelete(integer: Long) = addDelete(JsonValue.from(integer))

            /** Disables write throttling (HTTP 429 responses) during high-volume ingestion. */
            fun disableBackpressure(disableBackpressure: Boolean) =
                disableBackpressure(JsonField.of(disableBackpressure))

            /**
             * Sets [Builder.disableBackpressure] to an arbitrary JSON value.
             *
             * You should usually call [Builder.disableBackpressure] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun disableBackpressure(disableBackpressure: JsonField<Boolean>) = apply {
                this.disableBackpressure = disableBackpressure
            }

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /**
             * Sets [Builder.distanceMetric] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceMetric] with a well-typed [DistanceMetric]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                this.distanceMetric = distanceMetric
            }

            /** The encryption configuration for a namespace. */
            fun encryption(encryption: Encryption) = encryption(JsonField.of(encryption))

            /**
             * Sets [Builder.encryption] to an arbitrary JSON value.
             *
             * You should usually call [Builder.encryption] with a well-typed [Encryption] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun encryption(encryption: JsonField<Encryption>) = apply {
                this.encryption = encryption
            }

            /** The patch and filter specifying which documents to patch. */
            fun patchByFilter(patchByFilter: PatchByFilter) =
                patchByFilter(JsonField.of(patchByFilter))

            /**
             * Sets [Builder.patchByFilter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patchByFilter] with a well-typed [PatchByFilter]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun patchByFilter(patchByFilter: JsonField<PatchByFilter>) = apply {
                this.patchByFilter = patchByFilter
            }

            /** Allow partial completion when filter matches too many documents. */
            fun patchByFilterAllowPartial(patchByFilterAllowPartial: Boolean) =
                patchByFilterAllowPartial(JsonField.of(patchByFilterAllowPartial))

            /**
             * Sets [Builder.patchByFilterAllowPartial] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patchByFilterAllowPartial] with a well-typed
             * [Boolean] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun patchByFilterAllowPartial(patchByFilterAllowPartial: JsonField<Boolean>) = apply {
                this.patchByFilterAllowPartial = patchByFilterAllowPartial
            }

            /**
             * A list of documents in columnar format. Each key is a column name, mapped to an array
             * of values for that column.
             */
            fun patchColumns(patchColumns: Columns) = patchColumns(JsonField.of(patchColumns))

            /**
             * Sets [Builder.patchColumns] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patchColumns] with a well-typed [Columns] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun patchColumns(patchColumns: JsonField<Columns>) = apply {
                this.patchColumns = patchColumns
            }

            /**
             * A condition evaluated against the current value of each document targeted by a patch
             * write. Only documents that pass the condition are patched.
             */
            fun patchCondition(patchCondition: Filter) =
                patchCondition(JsonField.of(patchCondition))

            /**
             * Sets [Builder.patchCondition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patchCondition] with a well-typed [Filter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun patchCondition(patchCondition: JsonField<Filter>) = apply {
                this.patchCondition = patchCondition
            }

            fun patchRows(patchRows: List<Row>) = patchRows(JsonField.of(patchRows))

            /**
             * Sets [Builder.patchRows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patchRows] with a well-typed `List<Row>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun patchRows(patchRows: JsonField<List<Row>>) = apply {
                this.patchRows = patchRows.map { it.toMutableList() }
            }

            /**
             * Adds a single [Row] to [patchRows].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPatchRow(patchRow: Row) = apply {
                patchRows =
                    (patchRows ?: JsonField.of(mutableListOf())).also {
                        checkKnown("patchRows", it).add(patchRow)
                    }
            }

            /** The schema of the attributes attached to the documents. */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /**
             * Sets [Builder.schema] to an arbitrary JSON value.
             *
             * You should usually call [Builder.schema] with a well-typed [Schema] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

            /**
             * A list of documents in columnar format. Each key is a column name, mapped to an array
             * of values for that column.
             */
            fun upsertColumns(upsertColumns: Columns) = upsertColumns(JsonField.of(upsertColumns))

            /**
             * Sets [Builder.upsertColumns] to an arbitrary JSON value.
             *
             * You should usually call [Builder.upsertColumns] with a well-typed [Columns] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun upsertColumns(upsertColumns: JsonField<Columns>) = apply {
                this.upsertColumns = upsertColumns
            }

            /**
             * A condition evaluated against the current value of each document targeted by an
             * upsert write. Only documents that pass the condition are upserted.
             */
            fun upsertCondition(upsertCondition: Filter) =
                upsertCondition(JsonField.of(upsertCondition))

            /**
             * Sets [Builder.upsertCondition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.upsertCondition] with a well-typed [Filter] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun upsertCondition(upsertCondition: JsonField<Filter>) = apply {
                this.upsertCondition = upsertCondition
            }

            fun upsertRows(upsertRows: List<Row>) = upsertRows(JsonField.of(upsertRows))

            /**
             * Sets [Builder.upsertRows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.upsertRows] with a well-typed `List<Row>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun upsertRows(upsertRows: JsonField<List<Row>>) = apply {
                this.upsertRows = upsertRows.map { it.toMutableList() }
            }

            /**
             * Adds a single [Row] to [upsertRows].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUpsertRow(upsertRow: Row) = apply {
                upsertRows =
                    (upsertRows ?: JsonField.of(mutableListOf())).also {
                        checkKnown("upsertRows", it).add(upsertRow)
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    copyFromNamespace,
                    deleteByFilter,
                    deleteByFilterAllowPartial,
                    deleteCondition,
                    (deletes ?: JsonMissing.of()).map { it.toImmutable() },
                    disableBackpressure,
                    distanceMetric,
                    encryption,
                    patchByFilter,
                    patchByFilterAllowPartial,
                    patchColumns,
                    patchCondition,
                    (patchRows ?: JsonMissing.of()).map { it.toImmutable() },
                    schema,
                    upsertColumns,
                    upsertCondition,
                    (upsertRows ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            copyFromNamespace().ifPresent { it.validate() }
            deleteByFilterAllowPartial()
            deletes()
            disableBackpressure()
            distanceMetric().ifPresent { it.validate() }
            encryption().ifPresent { it.validate() }
            patchByFilter().ifPresent { it.validate() }
            patchByFilterAllowPartial()
            patchColumns()
            patchRows()
            schema().ifPresent { it.values.forEach { it.validate() } }
            upsertColumns()
            upsertRows()
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
            (copyFromNamespace.asKnown().getOrNull()?.validity() ?: 0) +
                (if (deleteByFilterAllowPartial.asKnown().isPresent) 1 else 0) +
                (deletes.asKnown().getOrNull()?.size ?: 0) +
                (if (disableBackpressure.asKnown().isPresent) 1 else 0) +
                (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
                (encryption.asKnown().getOrNull()?.validity() ?: 0) +
                (patchByFilter.asKnown().getOrNull()?.validity() ?: 0) +
                (if (patchByFilterAllowPartial.asKnown().isPresent) 1 else 0) +
                (patchColumns.asKnown().getOrNull()?.values?.sumOf { it.size } ?: 0) +
                (patchRows.asKnown().getOrNull()?.size ?: 0) +
                (schema.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0) +
                (upsertColumns.asKnown().getOrNull()?.values?.sumOf { it.size } ?: 0) +
                (upsertRows.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                copyFromNamespace == other.copyFromNamespace &&
                deleteByFilter == other.deleteByFilter &&
                deleteByFilterAllowPartial == other.deleteByFilterAllowPartial &&
                deleteCondition == other.deleteCondition &&
                deletes == other.deletes &&
                disableBackpressure == other.disableBackpressure &&
                distanceMetric == other.distanceMetric &&
                encryption == other.encryption &&
                patchByFilter == other.patchByFilter &&
                patchByFilterAllowPartial == other.patchByFilterAllowPartial &&
                patchColumns == other.patchColumns &&
                patchCondition == other.patchCondition &&
                patchRows == other.patchRows &&
                schema == other.schema &&
                upsertColumns == other.upsertColumns &&
                upsertCondition == other.upsertCondition &&
                upsertRows == other.upsertRows &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                copyFromNamespace,
                deleteByFilter,
                deleteByFilterAllowPartial,
                deleteCondition,
                deletes,
                disableBackpressure,
                distanceMetric,
                encryption,
                patchByFilter,
                patchByFilterAllowPartial,
                patchColumns,
                patchCondition,
                patchRows,
                schema,
                upsertColumns,
                upsertCondition,
                upsertRows,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{copyFromNamespace=$copyFromNamespace, deleteByFilter=$deleteByFilter, deleteByFilterAllowPartial=$deleteByFilterAllowPartial, deleteCondition=$deleteCondition, deletes=$deletes, disableBackpressure=$disableBackpressure, distanceMetric=$distanceMetric, encryption=$encryption, patchByFilter=$patchByFilter, patchByFilterAllowPartial=$patchByFilterAllowPartial, patchColumns=$patchColumns, patchCondition=$patchCondition, patchRows=$patchRows, schema=$schema, upsertColumns=$upsertColumns, upsertCondition=$upsertCondition, upsertRows=$upsertRows, additionalProperties=$additionalProperties}"
    }

    /** The namespace to copy documents from. */
    @JsonDeserialize(using = CopyFromNamespace.Deserializer::class)
    @JsonSerialize(using = CopyFromNamespace.Serializer::class)
    class CopyFromNamespace
    private constructor(
        private val string: String? = null,
        private val config: CopyFromNamespaceConfig? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The namespace to copy documents from. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        fun config(): Optional<CopyFromNamespaceConfig> = Optional.ofNullable(config)

        fun isString(): Boolean = string != null

        fun isConfig(): Boolean = config != null

        /** The namespace to copy documents from. */
        fun asString(): String = string.getOrThrow("string")

        fun asConfig(): CopyFromNamespaceConfig = config.getOrThrow("config")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                config != null -> visitor.visitConfig(config)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): CopyFromNamespace = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitConfig(config: CopyFromNamespaceConfig) {
                        config.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitConfig(config: CopyFromNamespaceConfig) = config.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CopyFromNamespace && string == other.string && config == other.config
        }

        override fun hashCode(): Int = Objects.hash(string, config)

        override fun toString(): String =
            when {
                string != null -> "CopyFromNamespace{string=$string}"
                config != null -> "CopyFromNamespace{config=$config}"
                _json != null -> "CopyFromNamespace{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid CopyFromNamespace")
            }

        companion object {

            /** The namespace to copy documents from. */
            @JvmStatic fun ofString(string: String) = CopyFromNamespace(string = string)

            @JvmStatic
            fun ofConfig(config: CopyFromNamespaceConfig) = CopyFromNamespace(config = config)
        }

        /**
         * An interface that defines how to map each variant of [CopyFromNamespace] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /** The namespace to copy documents from. */
            fun visitString(string: String): T

            fun visitConfig(config: CopyFromNamespaceConfig): T

            /**
             * Maps an unknown variant of [CopyFromNamespace] to a value of type [T].
             *
             * An instance of [CopyFromNamespace] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown CopyFromNamespace: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<CopyFromNamespace>(CopyFromNamespace::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): CopyFromNamespace {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<CopyFromNamespaceConfig>())?.let {
                                CopyFromNamespace(config = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                CopyFromNamespace(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> CopyFromNamespace(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<CopyFromNamespace>(CopyFromNamespace::class) {

            override fun serialize(
                value: CopyFromNamespace,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.config != null -> generator.writeObject(value.config)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid CopyFromNamespace")
                }
            }
        }

        class CopyFromNamespaceConfig
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val sourceNamespace: JsonField<String>,
            private val sourceApiKey: JsonField<String>,
            private val sourceRegion: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("source_namespace")
                @ExcludeMissing
                sourceNamespace: JsonField<String> = JsonMissing.of(),
                @JsonProperty("source_api_key")
                @ExcludeMissing
                sourceApiKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("source_region")
                @ExcludeMissing
                sourceRegion: JsonField<String> = JsonMissing.of(),
            ) : this(sourceNamespace, sourceApiKey, sourceRegion, mutableMapOf())

            /**
             * The namespace to copy documents from.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sourceNamespace(): String = sourceNamespace.getRequired("source_namespace")

            /**
             * An API key for the organization containing the source namespace
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun sourceApiKey(): Optional<String> = sourceApiKey.getOptional("source_api_key")

            /**
             * The region of the source namespace.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun sourceRegion(): Optional<String> = sourceRegion.getOptional("source_region")

            /**
             * Returns the raw JSON value of [sourceNamespace].
             *
             * Unlike [sourceNamespace], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("source_namespace")
            @ExcludeMissing
            fun _sourceNamespace(): JsonField<String> = sourceNamespace

            /**
             * Returns the raw JSON value of [sourceApiKey].
             *
             * Unlike [sourceApiKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("source_api_key")
            @ExcludeMissing
            fun _sourceApiKey(): JsonField<String> = sourceApiKey

            /**
             * Returns the raw JSON value of [sourceRegion].
             *
             * Unlike [sourceRegion], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("source_region")
            @ExcludeMissing
            fun _sourceRegion(): JsonField<String> = sourceRegion

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
                 * Returns a mutable builder for constructing an instance of
                 * [CopyFromNamespaceConfig].
                 *
                 * The following fields are required:
                 * ```java
                 * .sourceNamespace()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CopyFromNamespaceConfig]. */
            class Builder internal constructor() {

                private var sourceNamespace: JsonField<String>? = null
                private var sourceApiKey: JsonField<String> = JsonMissing.of()
                private var sourceRegion: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(copyFromNamespaceConfig: CopyFromNamespaceConfig) = apply {
                    sourceNamespace = copyFromNamespaceConfig.sourceNamespace
                    sourceApiKey = copyFromNamespaceConfig.sourceApiKey
                    sourceRegion = copyFromNamespaceConfig.sourceRegion
                    additionalProperties =
                        copyFromNamespaceConfig.additionalProperties.toMutableMap()
                }

                /** The namespace to copy documents from. */
                fun sourceNamespace(sourceNamespace: String) =
                    sourceNamespace(JsonField.of(sourceNamespace))

                /**
                 * Sets [Builder.sourceNamespace] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sourceNamespace] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun sourceNamespace(sourceNamespace: JsonField<String>) = apply {
                    this.sourceNamespace = sourceNamespace
                }

                /** An API key for the organization containing the source namespace */
                fun sourceApiKey(sourceApiKey: String) = sourceApiKey(JsonField.of(sourceApiKey))

                /**
                 * Sets [Builder.sourceApiKey] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sourceApiKey] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sourceApiKey(sourceApiKey: JsonField<String>) = apply {
                    this.sourceApiKey = sourceApiKey
                }

                /** The region of the source namespace. */
                fun sourceRegion(sourceRegion: String) = sourceRegion(JsonField.of(sourceRegion))

                /**
                 * Sets [Builder.sourceRegion] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sourceRegion] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sourceRegion(sourceRegion: JsonField<String>) = apply {
                    this.sourceRegion = sourceRegion
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
                 * Returns an immutable instance of [CopyFromNamespaceConfig].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .sourceNamespace()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CopyFromNamespaceConfig =
                    CopyFromNamespaceConfig(
                        checkRequired("sourceNamespace", sourceNamespace),
                        sourceApiKey,
                        sourceRegion,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CopyFromNamespaceConfig = apply {
                if (validated) {
                    return@apply
                }

                sourceNamespace()
                sourceApiKey()
                sourceRegion()
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
                (if (sourceNamespace.asKnown().isPresent) 1 else 0) +
                    (if (sourceApiKey.asKnown().isPresent) 1 else 0) +
                    (if (sourceRegion.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CopyFromNamespaceConfig &&
                    sourceNamespace == other.sourceNamespace &&
                    sourceApiKey == other.sourceApiKey &&
                    sourceRegion == other.sourceRegion &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(sourceNamespace, sourceApiKey, sourceRegion, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CopyFromNamespaceConfig{sourceNamespace=$sourceNamespace, sourceApiKey=$sourceApiKey, sourceRegion=$sourceRegion, additionalProperties=$additionalProperties}"
        }
    }

    /** The encryption configuration for a namespace. */
    class Encryption
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val cmek: JsonField<Cmek>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cmek") @ExcludeMissing cmek: JsonField<Cmek> = JsonMissing.of()
        ) : this(cmek, mutableMapOf())

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun cmek(): Optional<Cmek> = cmek.getOptional("cmek")

        /**
         * Returns the raw JSON value of [cmek].
         *
         * Unlike [cmek], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cmek") @ExcludeMissing fun _cmek(): JsonField<Cmek> = cmek

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

            /** Returns a mutable builder for constructing an instance of [Encryption]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Encryption]. */
        class Builder internal constructor() {

            private var cmek: JsonField<Cmek> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(encryption: Encryption) = apply {
                cmek = encryption.cmek
                additionalProperties = encryption.additionalProperties.toMutableMap()
            }

            fun cmek(cmek: Cmek) = cmek(JsonField.of(cmek))

            /**
             * Sets [Builder.cmek] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cmek] with a well-typed [Cmek] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cmek(cmek: JsonField<Cmek>) = apply { this.cmek = cmek }

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
             * Returns an immutable instance of [Encryption].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Encryption = Encryption(cmek, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Encryption = apply {
            if (validated) {
                return@apply
            }

            cmek().ifPresent { it.validate() }
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
        @JvmSynthetic internal fun validity(): Int = (cmek.asKnown().getOrNull()?.validity() ?: 0)

        class Cmek
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val keyName: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("key_name")
                @ExcludeMissing
                keyName: JsonField<String> = JsonMissing.of()
            ) : this(keyName, mutableMapOf())

            /**
             * The identifier of the CMEK key to use for encryption. For GCP, the fully-qualified
             * resource name of the key. For AWS, the ARN of the key.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun keyName(): String = keyName.getRequired("key_name")

            /**
             * Returns the raw JSON value of [keyName].
             *
             * Unlike [keyName], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key_name") @ExcludeMissing fun _keyName(): JsonField<String> = keyName

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
                 * Returns a mutable builder for constructing an instance of [Cmek].
                 *
                 * The following fields are required:
                 * ```java
                 * .keyName()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Cmek]. */
            class Builder internal constructor() {

                private var keyName: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cmek: Cmek) = apply {
                    keyName = cmek.keyName
                    additionalProperties = cmek.additionalProperties.toMutableMap()
                }

                /**
                 * The identifier of the CMEK key to use for encryption. For GCP, the
                 * fully-qualified resource name of the key. For AWS, the ARN of the key.
                 */
                fun keyName(keyName: String) = keyName(JsonField.of(keyName))

                /**
                 * Sets [Builder.keyName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.keyName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun keyName(keyName: JsonField<String>) = apply { this.keyName = keyName }

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
                 * Returns an immutable instance of [Cmek].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .keyName()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Cmek =
                    Cmek(checkRequired("keyName", keyName), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Cmek = apply {
                if (validated) {
                    return@apply
                }

                keyName()
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
            @JvmSynthetic internal fun validity(): Int = (if (keyName.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Cmek &&
                    keyName == other.keyName &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(keyName, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Cmek{keyName=$keyName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Encryption &&
                cmek == other.cmek &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(cmek, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Encryption{cmek=$cmek, additionalProperties=$additionalProperties}"
    }

    /** The patch and filter specifying which documents to patch. */
    class PatchByFilter
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val filters: JsonField<Filter>,
        private val patch: JsonField<Patch>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("filters") @ExcludeMissing filters: JsonField<Filter> = JsonMissing.of(),
            @JsonProperty("patch") @ExcludeMissing patch: JsonField<Patch> = JsonMissing.of(),
        ) : this(filters, patch, mutableMapOf())

        /**
         * Filter by attributes. Same syntax as the query endpoint.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filters(): Optional<Filter> = filters.getOptional("filters")

        /**
         * Returns the raw JSON value of [filters].
         *
         * Unlike [filters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filters") @ExcludeMissing fun _filters(): JsonField<Filter> = filters

        /**
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun patch(): Patch = patch.getRequired("patch")

        /**
         * Returns the raw JSON value of [patch].
         *
         * Unlike [patch], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("patch") @ExcludeMissing fun _patch(): JsonField<Patch> = patch

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
             * Returns a mutable builder for constructing an instance of [PatchByFilter].
             *
             * The following fields are required:
             * ```java
             * .filters()
             * .patch()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PatchByFilter]. */
        class Builder internal constructor() {

            private var filters: JsonField<Filter>? = null
            private var patch: JsonField<Patch>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(patchByFilter: PatchByFilter) = apply {
                filters = patchByFilter.filters
                patch = patchByFilter.patch
                additionalProperties = patchByFilter.additionalProperties.toMutableMap()
            }

            /** Filter by attributes. Same syntax as the query endpoint. */
            fun filters(filters: Filter) = filters(JsonField.of(filters))

            /**
             * Sets [Builder.filters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filters] with a well-typed [Filter] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filters(filters: JsonField<Filter>) = apply { this.filters = filters }

            fun patch(patch: Patch) = patch(JsonField.of(patch))

            /**
             * Sets [Builder.patch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.patch] with a well-typed [Patch] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun patch(patch: JsonField<Patch>) = apply { this.patch = patch }

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
             * Returns an immutable instance of [PatchByFilter].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .filters()
             * .patch()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PatchByFilter =
                PatchByFilter(
                    checkRequired("filters", filters),
                    checkRequired("patch", patch),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PatchByFilter = apply {
            if (validated) {
                return@apply
            }

            filters()
            patch().validate()
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
            (if (filters.asKnown().isPresent) 1 else 0) +
                (patch.asKnown().getOrNull()?.validity() ?: 0)

        class Patch
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

                /** Returns a mutable builder for constructing an instance of [Patch]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Patch]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(patch: Patch) = apply {
                    additionalProperties = patch.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Patch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Patch = Patch(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Patch = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Patch && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Patch{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PatchByFilter &&
                filters == other.filters &&
                patch == other.patch &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(filters, patch, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PatchByFilter{filters=$filters, patch=$patch, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceWriteParams &&
            namespace == other.namespace &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(namespace, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "NamespaceWriteParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
