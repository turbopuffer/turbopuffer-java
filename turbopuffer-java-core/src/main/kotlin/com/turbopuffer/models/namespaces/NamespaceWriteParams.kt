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
    private val namespace: String,
    private val write: Write?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /** Write documents. */
    fun write(): Optional<Write> = Optional.ofNullable(write)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceWriteParams].
         *
         * The following fields are required:
         * ```java
         * .namespace()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceWriteParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var write: Write? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceWriteParams: NamespaceWriteParams) = apply {
            namespace = namespaceWriteParams.namespace
            write = namespaceWriteParams.write
            additionalHeaders = namespaceWriteParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceWriteParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String) = apply { this.namespace = namespace }

        /** Write documents. */
        fun write(write: Write?) = apply { this.write = write }

        /** Alias for calling [Builder.write] with `write.orElse(null)`. */
        fun write(write: Optional<Write>) = write(write.getOrNull())

        /** Alias for calling [write] with `Write.ofDocuments(documents)`. */
        fun write(documents: Write.WriteDocuments) = write(Write.ofDocuments(documents))

        /** Alias for calling [write] with `Write.ofCopyFromNamespace(copyFromNamespace)`. */
        fun write(copyFromNamespace: Write.CopyFromNamespace) =
            write(Write.ofCopyFromNamespace(copyFromNamespace))

        /** Alias for calling [write] with `Write.ofDeleteByFilter(deleteByFilter)`. */
        fun write(deleteByFilter: Write.DeleteByFilter) =
            write(Write.ofDeleteByFilter(deleteByFilter))

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
         *
         * The following fields are required:
         * ```java
         * .namespace()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceWriteParams =
            NamespaceWriteParams(
                checkRequired("namespace", namespace),
                write,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Optional<Write> = Optional.ofNullable(write)

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Write documents. */
    @JsonDeserialize(using = Write.Deserializer::class)
    @JsonSerialize(using = Write.Serializer::class)
    class Write
    private constructor(
        private val documents: WriteDocuments? = null,
        private val copyFromNamespace: CopyFromNamespace? = null,
        private val deleteByFilter: DeleteByFilter? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Write documents. */
        fun documents(): Optional<WriteDocuments> = Optional.ofNullable(documents)

        /** Copy documents from another namespace. */
        fun copyFromNamespace(): Optional<CopyFromNamespace> =
            Optional.ofNullable(copyFromNamespace)

        /** Delete documents by filter. */
        fun deleteByFilter(): Optional<DeleteByFilter> = Optional.ofNullable(deleteByFilter)

        fun isDocuments(): Boolean = documents != null

        fun isCopyFromNamespace(): Boolean = copyFromNamespace != null

        fun isDeleteByFilter(): Boolean = deleteByFilter != null

        /** Write documents. */
        fun asDocuments(): WriteDocuments = documents.getOrThrow("documents")

        /** Copy documents from another namespace. */
        fun asCopyFromNamespace(): CopyFromNamespace =
            copyFromNamespace.getOrThrow("copyFromNamespace")

        /** Delete documents by filter. */
        fun asDeleteByFilter(): DeleteByFilter = deleteByFilter.getOrThrow("deleteByFilter")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                documents != null -> visitor.visitDocuments(documents)
                copyFromNamespace != null -> visitor.visitCopyFromNamespace(copyFromNamespace)
                deleteByFilter != null -> visitor.visitDeleteByFilter(deleteByFilter)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Write = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitDocuments(documents: WriteDocuments) {
                        documents.validate()
                    }

                    override fun visitCopyFromNamespace(copyFromNamespace: CopyFromNamespace) {
                        copyFromNamespace.validate()
                    }

                    override fun visitDeleteByFilter(deleteByFilter: DeleteByFilter) {
                        deleteByFilter.validate()
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
                    override fun visitDocuments(documents: WriteDocuments) = documents.validity()

                    override fun visitCopyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                        copyFromNamespace.validity()

                    override fun visitDeleteByFilter(deleteByFilter: DeleteByFilter) =
                        deleteByFilter.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Write && documents == other.documents && copyFromNamespace == other.copyFromNamespace && deleteByFilter == other.deleteByFilter /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(documents, copyFromNamespace, deleteByFilter) /* spotless:on */

        override fun toString(): String =
            when {
                documents != null -> "Write{documents=$documents}"
                copyFromNamespace != null -> "Write{copyFromNamespace=$copyFromNamespace}"
                deleteByFilter != null -> "Write{deleteByFilter=$deleteByFilter}"
                _json != null -> "Write{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Write")
            }

        companion object {

            /** Write documents. */
            @JvmStatic fun ofDocuments(documents: WriteDocuments) = Write(documents = documents)

            /** Copy documents from another namespace. */
            @JvmStatic
            fun ofCopyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                Write(copyFromNamespace = copyFromNamespace)

            /** Delete documents by filter. */
            @JvmStatic
            fun ofDeleteByFilter(deleteByFilter: DeleteByFilter) =
                Write(deleteByFilter = deleteByFilter)
        }

        /** An interface that defines how to map each variant of [Write] to a value of type [T]. */
        interface Visitor<out T> {

            /** Write documents. */
            fun visitDocuments(documents: WriteDocuments): T

            /** Copy documents from another namespace. */
            fun visitCopyFromNamespace(copyFromNamespace: CopyFromNamespace): T

            /** Delete documents by filter. */
            fun visitDeleteByFilter(deleteByFilter: DeleteByFilter): T

            /**
             * Maps an unknown variant of [Write] to a value of type [T].
             *
             * An instance of [Write] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Write: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Write>(Write::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Write {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<WriteDocuments>())?.let {
                                Write(documents = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CopyFromNamespace>())?.let {
                                Write(copyFromNamespace = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<DeleteByFilter>())?.let {
                                Write(deleteByFilter = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Write(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Write>(Write::class) {

            override fun serialize(
                value: Write,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.documents != null -> generator.writeObject(value.documents)
                    value.copyFromNamespace != null ->
                        generator.writeObject(value.copyFromNamespace)
                    value.deleteByFilter != null -> generator.writeObject(value.deleteByFilter)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Write")
                }
            }
        }

        /** Write documents. */
        class WriteDocuments
        private constructor(
            private val distanceMetric: JsonField<DistanceMetric>,
            private val patchColumns: JsonField<DocumentColumns>,
            private val patchRows: JsonField<List<DocumentRow>>,
            private val schema: JsonField<Schema>,
            private val upsertColumns: JsonField<DocumentColumns>,
            private val upsertRows: JsonField<List<DocumentRow>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("distance_metric")
                @ExcludeMissing
                distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
                @JsonProperty("patch_columns")
                @ExcludeMissing
                patchColumns: JsonField<DocumentColumns> = JsonMissing.of(),
                @JsonProperty("patch_rows")
                @ExcludeMissing
                patchRows: JsonField<List<DocumentRow>> = JsonMissing.of(),
                @JsonProperty("schema")
                @ExcludeMissing
                schema: JsonField<Schema> = JsonMissing.of(),
                @JsonProperty("upsert_columns")
                @ExcludeMissing
                upsertColumns: JsonField<DocumentColumns> = JsonMissing.of(),
                @JsonProperty("upsert_rows")
                @ExcludeMissing
                upsertRows: JsonField<List<DocumentRow>> = JsonMissing.of(),
            ) : this(
                distanceMetric,
                patchColumns,
                patchRows,
                schema,
                upsertColumns,
                upsertRows,
                mutableMapOf(),
            )

            /**
             * A function used to calculate vector similarity.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun distanceMetric(): Optional<DistanceMetric> =
                distanceMetric.getOptional("distance_metric")

            /**
             * A list of documents in columnar format. The keys are the column names.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun patchColumns(): Optional<DocumentColumns> =
                patchColumns.getOptional("patch_columns")

            /**
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun patchRows(): Optional<List<DocumentRow>> = patchRows.getOptional("patch_rows")

            /**
             * The schema of the attributes attached to the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun schema(): Optional<Schema> = schema.getOptional("schema")

            /**
             * A list of documents in columnar format. The keys are the column names.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun upsertColumns(): Optional<DocumentColumns> =
                upsertColumns.getOptional("upsert_columns")

            /**
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun upsertRows(): Optional<List<DocumentRow>> = upsertRows.getOptional("upsert_rows")

            /**
             * Returns the raw JSON value of [distanceMetric].
             *
             * Unlike [distanceMetric], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("distance_metric")
            @ExcludeMissing
            fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

            /**
             * Returns the raw JSON value of [patchColumns].
             *
             * Unlike [patchColumns], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("patch_columns")
            @ExcludeMissing
            fun _patchColumns(): JsonField<DocumentColumns> = patchColumns

            /**
             * Returns the raw JSON value of [patchRows].
             *
             * Unlike [patchRows], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("patch_rows")
            @ExcludeMissing
            fun _patchRows(): JsonField<List<DocumentRow>> = patchRows

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
            fun _upsertColumns(): JsonField<DocumentColumns> = upsertColumns

            /**
             * Returns the raw JSON value of [upsertRows].
             *
             * Unlike [upsertRows], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("upsert_rows")
            @ExcludeMissing
            fun _upsertRows(): JsonField<List<DocumentRow>> = upsertRows

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

                /** Returns a mutable builder for constructing an instance of [WriteDocuments]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [WriteDocuments]. */
            class Builder internal constructor() {

                private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
                private var patchColumns: JsonField<DocumentColumns> = JsonMissing.of()
                private var patchRows: JsonField<MutableList<DocumentRow>>? = null
                private var schema: JsonField<Schema> = JsonMissing.of()
                private var upsertColumns: JsonField<DocumentColumns> = JsonMissing.of()
                private var upsertRows: JsonField<MutableList<DocumentRow>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(writeDocuments: WriteDocuments) = apply {
                    distanceMetric = writeDocuments.distanceMetric
                    patchColumns = writeDocuments.patchColumns
                    patchRows = writeDocuments.patchRows.map { it.toMutableList() }
                    schema = writeDocuments.schema
                    upsertColumns = writeDocuments.upsertColumns
                    upsertRows = writeDocuments.upsertRows.map { it.toMutableList() }
                    additionalProperties = writeDocuments.additionalProperties.toMutableMap()
                }

                /** A function used to calculate vector similarity. */
                fun distanceMetric(distanceMetric: DistanceMetric) =
                    distanceMetric(JsonField.of(distanceMetric))

                /**
                 * Sets [Builder.distanceMetric] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.distanceMetric] with a well-typed
                 * [DistanceMetric] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                    this.distanceMetric = distanceMetric
                }

                /** A list of documents in columnar format. The keys are the column names. */
                fun patchColumns(patchColumns: DocumentColumns) =
                    patchColumns(JsonField.of(patchColumns))

                /**
                 * Sets [Builder.patchColumns] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.patchColumns] with a well-typed
                 * [DocumentColumns] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun patchColumns(patchColumns: JsonField<DocumentColumns>) = apply {
                    this.patchColumns = patchColumns
                }

                fun patchRows(patchRows: List<DocumentRow>) = patchRows(JsonField.of(patchRows))

                /**
                 * Sets [Builder.patchRows] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.patchRows] with a well-typed `List<DocumentRow>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun patchRows(patchRows: JsonField<List<DocumentRow>>) = apply {
                    this.patchRows = patchRows.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DocumentRow] to [patchRows].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPatchRow(patchRow: DocumentRow) = apply {
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
                 * You should usually call [Builder.schema] with a well-typed [Schema] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

                /** A list of documents in columnar format. The keys are the column names. */
                fun upsertColumns(upsertColumns: DocumentColumns) =
                    upsertColumns(JsonField.of(upsertColumns))

                /**
                 * Sets [Builder.upsertColumns] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.upsertColumns] with a well-typed
                 * [DocumentColumns] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun upsertColumns(upsertColumns: JsonField<DocumentColumns>) = apply {
                    this.upsertColumns = upsertColumns
                }

                fun upsertRows(upsertRows: List<DocumentRow>) = upsertRows(JsonField.of(upsertRows))

                /**
                 * Sets [Builder.upsertRows] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.upsertRows] with a well-typed
                 * `List<DocumentRow>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun upsertRows(upsertRows: JsonField<List<DocumentRow>>) = apply {
                    this.upsertRows = upsertRows.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DocumentRow] to [upsertRows].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUpsertRow(upsertRow: DocumentRow) = apply {
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
                 * Returns an immutable instance of [WriteDocuments].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): WriteDocuments =
                    WriteDocuments(
                        distanceMetric,
                        patchColumns,
                        (patchRows ?: JsonMissing.of()).map { it.toImmutable() },
                        schema,
                        upsertColumns,
                        (upsertRows ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): WriteDocuments = apply {
                if (validated) {
                    return@apply
                }

                distanceMetric().ifPresent { it.validate() }
                patchColumns().ifPresent { it.validate() }
                patchRows().ifPresent { it.forEach { it.validate() } }
                schema().ifPresent { it.validate() }
                upsertColumns().ifPresent { it.validate() }
                upsertRows().ifPresent { it.forEach { it.validate() } }
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
                (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
                    (patchColumns.asKnown().getOrNull()?.validity() ?: 0) +
                    (patchRows.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (schema.asKnown().getOrNull()?.validity() ?: 0) +
                    (upsertColumns.asKnown().getOrNull()?.validity() ?: 0) +
                    (upsertRows.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            /** The schema of the attributes attached to the documents. */
            class Schema
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

                    /** Returns a mutable builder for constructing an instance of [Schema]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Schema]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(schema: Schema) = apply {
                        additionalProperties = schema.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Schema].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Schema = Schema(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): Schema = apply {
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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Schema && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Schema{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is WriteDocuments && distanceMetric == other.distanceMetric && patchColumns == other.patchColumns && patchRows == other.patchRows && schema == other.schema && upsertColumns == other.upsertColumns && upsertRows == other.upsertRows && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(distanceMetric, patchColumns, patchRows, schema, upsertColumns, upsertRows, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "WriteDocuments{distanceMetric=$distanceMetric, patchColumns=$patchColumns, patchRows=$patchRows, schema=$schema, upsertColumns=$upsertColumns, upsertRows=$upsertRows, additionalProperties=$additionalProperties}"
        }

        /** Copy documents from another namespace. */
        class CopyFromNamespace
        private constructor(
            private val copyFromNamespace: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("copy_from_namespace")
                @ExcludeMissing
                copyFromNamespace: JsonField<String> = JsonMissing.of()
            ) : this(copyFromNamespace, mutableMapOf())

            /**
             * The namespace to copy documents from.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun copyFromNamespace(): String = copyFromNamespace.getRequired("copy_from_namespace")

            /**
             * Returns the raw JSON value of [copyFromNamespace].
             *
             * Unlike [copyFromNamespace], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("copy_from_namespace")
            @ExcludeMissing
            fun _copyFromNamespace(): JsonField<String> = copyFromNamespace

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
                 * Returns a mutable builder for constructing an instance of [CopyFromNamespace].
                 *
                 * The following fields are required:
                 * ```java
                 * .copyFromNamespace()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CopyFromNamespace]. */
            class Builder internal constructor() {

                private var copyFromNamespace: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(copyFromNamespace: CopyFromNamespace) = apply {
                    this.copyFromNamespace = copyFromNamespace.copyFromNamespace
                    additionalProperties = copyFromNamespace.additionalProperties.toMutableMap()
                }

                /** The namespace to copy documents from. */
                fun copyFromNamespace(copyFromNamespace: String) =
                    copyFromNamespace(JsonField.of(copyFromNamespace))

                /**
                 * Sets [Builder.copyFromNamespace] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.copyFromNamespace] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun copyFromNamespace(copyFromNamespace: JsonField<String>) = apply {
                    this.copyFromNamespace = copyFromNamespace
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
                 * Returns an immutable instance of [CopyFromNamespace].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .copyFromNamespace()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CopyFromNamespace =
                    CopyFromNamespace(
                        checkRequired("copyFromNamespace", copyFromNamespace),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CopyFromNamespace = apply {
                if (validated) {
                    return@apply
                }

                copyFromNamespace()
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
            internal fun validity(): Int = (if (copyFromNamespace.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CopyFromNamespace && copyFromNamespace == other.copyFromNamespace && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(copyFromNamespace, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CopyFromNamespace{copyFromNamespace=$copyFromNamespace, additionalProperties=$additionalProperties}"
        }

        /** Delete documents by filter. */
        class DeleteByFilter
        private constructor(
            private val deleteByFilter: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("delete_by_filter")
                @ExcludeMissing
                deleteByFilter: JsonValue = JsonMissing.of()
            ) : this(deleteByFilter, mutableMapOf())

            /** The filter specifying which documents to delete. */
            @JsonProperty("delete_by_filter")
            @ExcludeMissing
            fun _deleteByFilter(): JsonValue = deleteByFilter

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
                 * Returns a mutable builder for constructing an instance of [DeleteByFilter].
                 *
                 * The following fields are required:
                 * ```java
                 * .deleteByFilter()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DeleteByFilter]. */
            class Builder internal constructor() {

                private var deleteByFilter: JsonValue? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(deleteByFilter: DeleteByFilter) = apply {
                    this.deleteByFilter = deleteByFilter.deleteByFilter
                    additionalProperties = deleteByFilter.additionalProperties.toMutableMap()
                }

                /** The filter specifying which documents to delete. */
                fun deleteByFilter(deleteByFilter: JsonValue) = apply {
                    this.deleteByFilter = deleteByFilter
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
                 * Returns an immutable instance of [DeleteByFilter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .deleteByFilter()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): DeleteByFilter =
                    DeleteByFilter(
                        checkRequired("deleteByFilter", deleteByFilter),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): DeleteByFilter = apply {
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
            @JvmSynthetic internal fun validity(): Int = 0

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is DeleteByFilter && deleteByFilter == other.deleteByFilter && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(deleteByFilter, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DeleteByFilter{deleteByFilter=$deleteByFilter, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceWriteParams && namespace == other.namespace && write == other.write && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, write, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceWriteParams{namespace=$namespace, write=$write, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
