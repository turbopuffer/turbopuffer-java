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
class NamespaceUpsertParams
private constructor(
    private val namespace: String,
    private val documents: Documents?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /** Upsert documents in columnar format. */
    fun documents(): Optional<Documents> = Optional.ofNullable(documents)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceUpsertParams].
         *
         * The following fields are required:
         * ```java
         * .namespace()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpsertParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var documents: Documents? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceUpsertParams: NamespaceUpsertParams) = apply {
            namespace = namespaceUpsertParams.namespace
            documents = namespaceUpsertParams.documents
            additionalHeaders = namespaceUpsertParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceUpsertParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String) = apply { this.namespace = namespace }

        /** Upsert documents in columnar format. */
        fun documents(documents: Documents?) = apply { this.documents = documents }

        /** Alias for calling [Builder.documents] with `documents.orElse(null)`. */
        fun documents(documents: Optional<Documents>) = documents(documents.getOrNull())

        /** Alias for calling [documents] with `Documents.ofUpsertColumnar(upsertColumnar)`. */
        fun documents(upsertColumnar: Documents.UpsertColumnar) =
            documents(Documents.ofUpsertColumnar(upsertColumnar))

        /** Alias for calling [documents] with `Documents.ofUpsertRowBased(upsertRowBased)`. */
        fun documents(upsertRowBased: Documents.UpsertRowBased) =
            documents(Documents.ofUpsertRowBased(upsertRowBased))

        /**
         * Alias for calling [documents] with `Documents.ofCopyFromNamespace(copyFromNamespace)`.
         */
        fun documents(copyFromNamespace: Documents.CopyFromNamespace) =
            documents(Documents.ofCopyFromNamespace(copyFromNamespace))

        /** Alias for calling [documents] with `Documents.ofDeleteByFilter(deleteByFilter)`. */
        fun documents(deleteByFilter: Documents.DeleteByFilter) =
            documents(Documents.ofDeleteByFilter(deleteByFilter))

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
         * Returns an immutable instance of [NamespaceUpsertParams].
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
        fun build(): NamespaceUpsertParams =
            NamespaceUpsertParams(
                checkRequired("namespace", namespace),
                documents,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Optional<Documents> = Optional.ofNullable(documents)

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Upsert documents in columnar format. */
    @JsonDeserialize(using = Documents.Deserializer::class)
    @JsonSerialize(using = Documents.Serializer::class)
    class Documents
    private constructor(
        private val upsertColumnar: UpsertColumnar? = null,
        private val upsertRowBased: UpsertRowBased? = null,
        private val copyFromNamespace: CopyFromNamespace? = null,
        private val deleteByFilter: DeleteByFilter? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Upsert documents in columnar format. */
        fun upsertColumnar(): Optional<UpsertColumnar> = Optional.ofNullable(upsertColumnar)

        /** Upsert documents in row-based format. */
        fun upsertRowBased(): Optional<UpsertRowBased> = Optional.ofNullable(upsertRowBased)

        /** Copy documents from another namespace. */
        fun copyFromNamespace(): Optional<CopyFromNamespace> =
            Optional.ofNullable(copyFromNamespace)

        /** Delete documents by filter. */
        fun deleteByFilter(): Optional<DeleteByFilter> = Optional.ofNullable(deleteByFilter)

        fun isUpsertColumnar(): Boolean = upsertColumnar != null

        fun isUpsertRowBased(): Boolean = upsertRowBased != null

        fun isCopyFromNamespace(): Boolean = copyFromNamespace != null

        fun isDeleteByFilter(): Boolean = deleteByFilter != null

        /** Upsert documents in columnar format. */
        fun asUpsertColumnar(): UpsertColumnar = upsertColumnar.getOrThrow("upsertColumnar")

        /** Upsert documents in row-based format. */
        fun asUpsertRowBased(): UpsertRowBased = upsertRowBased.getOrThrow("upsertRowBased")

        /** Copy documents from another namespace. */
        fun asCopyFromNamespace(): CopyFromNamespace =
            copyFromNamespace.getOrThrow("copyFromNamespace")

        /** Delete documents by filter. */
        fun asDeleteByFilter(): DeleteByFilter = deleteByFilter.getOrThrow("deleteByFilter")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                upsertColumnar != null -> visitor.visitUpsertColumnar(upsertColumnar)
                upsertRowBased != null -> visitor.visitUpsertRowBased(upsertRowBased)
                copyFromNamespace != null -> visitor.visitCopyFromNamespace(copyFromNamespace)
                deleteByFilter != null -> visitor.visitDeleteByFilter(deleteByFilter)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Documents = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUpsertColumnar(upsertColumnar: UpsertColumnar) {
                        upsertColumnar.validate()
                    }

                    override fun visitUpsertRowBased(upsertRowBased: UpsertRowBased) {
                        upsertRowBased.validate()
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
                    override fun visitUpsertColumnar(upsertColumnar: UpsertColumnar) =
                        upsertColumnar.validity()

                    override fun visitUpsertRowBased(upsertRowBased: UpsertRowBased) =
                        upsertRowBased.validity()

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

            return /* spotless:off */ other is Documents && upsertColumnar == other.upsertColumnar && upsertRowBased == other.upsertRowBased && copyFromNamespace == other.copyFromNamespace && deleteByFilter == other.deleteByFilter /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(upsertColumnar, upsertRowBased, copyFromNamespace, deleteByFilter) /* spotless:on */

        override fun toString(): String =
            when {
                upsertColumnar != null -> "Documents{upsertColumnar=$upsertColumnar}"
                upsertRowBased != null -> "Documents{upsertRowBased=$upsertRowBased}"
                copyFromNamespace != null -> "Documents{copyFromNamespace=$copyFromNamespace}"
                deleteByFilter != null -> "Documents{deleteByFilter=$deleteByFilter}"
                _json != null -> "Documents{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Documents")
            }

        companion object {

            /** Upsert documents in columnar format. */
            @JvmStatic
            fun ofUpsertColumnar(upsertColumnar: UpsertColumnar) =
                Documents(upsertColumnar = upsertColumnar)

            /** Upsert documents in row-based format. */
            @JvmStatic
            fun ofUpsertRowBased(upsertRowBased: UpsertRowBased) =
                Documents(upsertRowBased = upsertRowBased)

            /** Copy documents from another namespace. */
            @JvmStatic
            fun ofCopyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                Documents(copyFromNamespace = copyFromNamespace)

            /** Delete documents by filter. */
            @JvmStatic
            fun ofDeleteByFilter(deleteByFilter: DeleteByFilter) =
                Documents(deleteByFilter = deleteByFilter)
        }

        /**
         * An interface that defines how to map each variant of [Documents] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Upsert documents in columnar format. */
            fun visitUpsertColumnar(upsertColumnar: UpsertColumnar): T

            /** Upsert documents in row-based format. */
            fun visitUpsertRowBased(upsertRowBased: UpsertRowBased): T

            /** Copy documents from another namespace. */
            fun visitCopyFromNamespace(copyFromNamespace: CopyFromNamespace): T

            /** Delete documents by filter. */
            fun visitDeleteByFilter(deleteByFilter: DeleteByFilter): T

            /**
             * Maps an unknown variant of [Documents] to a value of type [T].
             *
             * An instance of [Documents] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Documents: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Documents>(Documents::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Documents {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UpsertColumnar>())?.let {
                                Documents(upsertColumnar = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<UpsertRowBased>())?.let {
                                Documents(upsertRowBased = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CopyFromNamespace>())?.let {
                                Documents(copyFromNamespace = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<DeleteByFilter>())?.let {
                                Documents(deleteByFilter = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Documents(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Documents>(Documents::class) {

            override fun serialize(
                value: Documents,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.upsertColumnar != null -> generator.writeObject(value.upsertColumnar)
                    value.upsertRowBased != null -> generator.writeObject(value.upsertRowBased)
                    value.copyFromNamespace != null ->
                        generator.writeObject(value.copyFromNamespace)
                    value.deleteByFilter != null -> generator.writeObject(value.deleteByFilter)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Documents")
                }
            }
        }

        /** Upsert documents in columnar format. */
        class UpsertColumnar
        private constructor(
            private val attributes: JsonField<DocumentColumns.Attributes>,
            private val ids: JsonField<List<Id>>,
            private val vectors: JsonField<List<List<Double>?>>,
            private val distanceMetric: JsonField<DistanceMetric>,
            private val schema: JsonField<Schema>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("attributes")
                @ExcludeMissing
                attributes: JsonField<DocumentColumns.Attributes> = JsonMissing.of(),
                @JsonProperty("ids") @ExcludeMissing ids: JsonField<List<Id>> = JsonMissing.of(),
                @JsonProperty("vectors")
                @ExcludeMissing
                vectors: JsonField<List<List<Double>?>> = JsonMissing.of(),
                @JsonProperty("distance_metric")
                @ExcludeMissing
                distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
                @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
            ) : this(attributes, ids, vectors, distanceMetric, schema, mutableMapOf())

            fun toDocumentColumns(): DocumentColumns =
                DocumentColumns.builder().attributes(attributes).ids(ids).vectors(vectors).build()

            /**
             * The attributes attached to each of the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun attributes(): Optional<DocumentColumns.Attributes> =
                attributes.getOptional("attributes")

            /**
             * The IDs of the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun ids(): Optional<List<Id>> = ids.getOptional("ids")

            /**
             * Vectors describing each of the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun vectors(): Optional<List<List<Double>?>> = vectors.getOptional("vectors")

            /**
             * A function used to calculate vector similarity.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun distanceMetric(): DistanceMetric = distanceMetric.getRequired("distance_metric")

            /**
             * The schema of the attributes attached to the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun schema(): Optional<Schema> = schema.getOptional("schema")

            /**
             * Returns the raw JSON value of [attributes].
             *
             * Unlike [attributes], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("attributes")
            @ExcludeMissing
            fun _attributes(): JsonField<DocumentColumns.Attributes> = attributes

            /**
             * Returns the raw JSON value of [ids].
             *
             * Unlike [ids], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

            /**
             * Returns the raw JSON value of [vectors].
             *
             * Unlike [vectors], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("vectors")
            @ExcludeMissing
            fun _vectors(): JsonField<List<List<Double>?>> = vectors

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
             * Returns the raw JSON value of [schema].
             *
             * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

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
                 * Returns a mutable builder for constructing an instance of [UpsertColumnar].
                 *
                 * The following fields are required:
                 * ```java
                 * .distanceMetric()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UpsertColumnar]. */
            class Builder internal constructor() {

                private var attributes: JsonField<DocumentColumns.Attributes> = JsonMissing.of()
                private var ids: JsonField<MutableList<Id>>? = null
                private var vectors: JsonField<MutableList<List<Double>?>>? = null
                private var distanceMetric: JsonField<DistanceMetric>? = null
                private var schema: JsonField<Schema> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(upsertColumnar: UpsertColumnar) = apply {
                    attributes = upsertColumnar.attributes
                    ids = upsertColumnar.ids.map { it.toMutableList() }
                    vectors = upsertColumnar.vectors.map { it.toMutableList() }
                    distanceMetric = upsertColumnar.distanceMetric
                    schema = upsertColumnar.schema
                    additionalProperties = upsertColumnar.additionalProperties.toMutableMap()
                }

                /** The attributes attached to each of the documents. */
                fun attributes(attributes: DocumentColumns.Attributes) =
                    attributes(JsonField.of(attributes))

                /**
                 * Sets [Builder.attributes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.attributes] with a well-typed
                 * [DocumentColumns.Attributes] value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun attributes(attributes: JsonField<DocumentColumns.Attributes>) = apply {
                    this.attributes = attributes
                }

                /** The IDs of the documents. */
                fun ids(ids: List<Id>) = ids(JsonField.of(ids))

                /**
                 * Sets [Builder.ids] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ids] with a well-typed `List<Id>` value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun ids(ids: JsonField<List<Id>>) = apply {
                    this.ids = ids.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Id] to [ids].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addId(id: Id) = apply {
                    ids =
                        (ids ?: JsonField.of(mutableListOf())).also {
                            checkKnown("ids", it).add(id)
                        }
                }

                /** Alias for calling [addId] with `Id.ofString(string)`. */
                fun addId(string: String) = addId(Id.ofString(string))

                /** Alias for calling [addId] with `Id.ofInteger(integer)`. */
                fun addId(integer: Long) = addId(Id.ofInteger(integer))

                /** Vectors describing each of the documents. */
                fun vectors(vectors: List<List<Double>?>) = vectors(JsonField.of(vectors))

                /**
                 * Sets [Builder.vectors] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectors] with a well-typed `List<List<Double>?>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun vectors(vectors: JsonField<List<List<Double>?>>) = apply {
                    this.vectors = vectors.map { it.toMutableList() }
                }

                /**
                 * Adds a single [List<Double>] to [vectors].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVector(vector: List<Double>) = apply {
                    vectors =
                        (vectors ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectors", it).add(vector)
                        }
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
                 * Returns an immutable instance of [UpsertColumnar].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .distanceMetric()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UpsertColumnar =
                    UpsertColumnar(
                        attributes,
                        (ids ?: JsonMissing.of()).map { it.toImmutable() },
                        (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                        checkRequired("distanceMetric", distanceMetric),
                        schema,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): UpsertColumnar = apply {
                if (validated) {
                    return@apply
                }

                attributes().ifPresent { it.validate() }
                ids().ifPresent { it.forEach { it.validate() } }
                vectors()
                distanceMetric().validate()
                schema().ifPresent { it.validate() }
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
                (attributes.asKnown().getOrNull()?.validity() ?: 0) +
                    (ids.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (vectors.asKnown().getOrNull()?.sumOf { (it?.size ?: 0).toInt() } ?: 0) +
                    (distanceMetric.asKnown().getOrNull()?.validity() ?: 0) +
                    (schema.asKnown().getOrNull()?.validity() ?: 0)

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

                return /* spotless:off */ other is UpsertColumnar && attributes == other.attributes && ids == other.ids && vectors == other.vectors && distanceMetric == other.distanceMetric && schema == other.schema && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(attributes, ids, vectors, distanceMetric, schema, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UpsertColumnar{attributes=$attributes, ids=$ids, vectors=$vectors, distanceMetric=$distanceMetric, schema=$schema, additionalProperties=$additionalProperties}"
        }

        /** Upsert documents in row-based format. */
        class UpsertRowBased
        private constructor(
            private val distanceMetric: JsonField<DistanceMetric>,
            private val upserts: JsonField<List<DocumentRow>>,
            private val schema: JsonField<Schema>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("distance_metric")
                @ExcludeMissing
                distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
                @JsonProperty("upserts")
                @ExcludeMissing
                upserts: JsonField<List<DocumentRow>> = JsonMissing.of(),
                @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
            ) : this(distanceMetric, upserts, schema, mutableMapOf())

            /**
             * A function used to calculate vector similarity.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun distanceMetric(): DistanceMetric = distanceMetric.getRequired("distance_metric")

            /**
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun upserts(): List<DocumentRow> = upserts.getRequired("upserts")

            /**
             * The schema of the attributes attached to the documents.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun schema(): Optional<Schema> = schema.getOptional("schema")

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
             * Returns the raw JSON value of [upserts].
             *
             * Unlike [upserts], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("upserts")
            @ExcludeMissing
            fun _upserts(): JsonField<List<DocumentRow>> = upserts

            /**
             * Returns the raw JSON value of [schema].
             *
             * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

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
                 * Returns a mutable builder for constructing an instance of [UpsertRowBased].
                 *
                 * The following fields are required:
                 * ```java
                 * .distanceMetric()
                 * .upserts()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UpsertRowBased]. */
            class Builder internal constructor() {

                private var distanceMetric: JsonField<DistanceMetric>? = null
                private var upserts: JsonField<MutableList<DocumentRow>>? = null
                private var schema: JsonField<Schema> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(upsertRowBased: UpsertRowBased) = apply {
                    distanceMetric = upsertRowBased.distanceMetric
                    upserts = upsertRowBased.upserts.map { it.toMutableList() }
                    schema = upsertRowBased.schema
                    additionalProperties = upsertRowBased.additionalProperties.toMutableMap()
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

                fun upserts(upserts: List<DocumentRow>) = upserts(JsonField.of(upserts))

                /**
                 * Sets [Builder.upserts] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.upserts] with a well-typed `List<DocumentRow>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun upserts(upserts: JsonField<List<DocumentRow>>) = apply {
                    this.upserts = upserts.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DocumentRow] to [upserts].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUpsert(upsert: DocumentRow) = apply {
                    upserts =
                        (upserts ?: JsonField.of(mutableListOf())).also {
                            checkKnown("upserts", it).add(upsert)
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
                 * Returns an immutable instance of [UpsertRowBased].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .distanceMetric()
                 * .upserts()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UpsertRowBased =
                    UpsertRowBased(
                        checkRequired("distanceMetric", distanceMetric),
                        checkRequired("upserts", upserts).map { it.toImmutable() },
                        schema,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): UpsertRowBased = apply {
                if (validated) {
                    return@apply
                }

                distanceMetric().validate()
                upserts().forEach { it.validate() }
                schema().ifPresent { it.validate() }
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
                    (upserts.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (schema.asKnown().getOrNull()?.validity() ?: 0)

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

                return /* spotless:off */ other is UpsertRowBased && distanceMetric == other.distanceMetric && upserts == other.upserts && schema == other.schema && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(distanceMetric, upserts, schema, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UpsertRowBased{distanceMetric=$distanceMetric, upserts=$upserts, schema=$schema, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is NamespaceUpsertParams && namespace == other.namespace && documents == other.documents && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, documents, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceUpsertParams{namespace=$namespace, documents=$documents, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
