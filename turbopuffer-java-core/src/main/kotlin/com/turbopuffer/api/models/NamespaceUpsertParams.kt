// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.api.models

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
import com.turbopuffer.api.core.BaseDeserializer
import com.turbopuffer.api.core.BaseSerializer
import com.turbopuffer.api.core.Enum
import com.turbopuffer.api.core.ExcludeMissing
import com.turbopuffer.api.core.JsonField
import com.turbopuffer.api.core.JsonMissing
import com.turbopuffer.api.core.JsonValue
import com.turbopuffer.api.core.NoAutoDetect
import com.turbopuffer.api.core.Params
import com.turbopuffer.api.core.checkRequired
import com.turbopuffer.api.core.getOrThrow
import com.turbopuffer.api.core.http.Headers
import com.turbopuffer.api.core.http.QueryParams
import com.turbopuffer.api.core.immutableEmptyMap
import com.turbopuffer.api.core.toImmutable
import com.turbopuffer.api.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** Create, update, or delete documents. */
class NamespaceUpsertParams
private constructor(
    private val namespace: String,
    private val body: NamespaceUpsertBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /** Upsert documents in columnar format. */
    fun upsertColumnar(): Optional<UpsertColumnar> = body.upsertColumnar()

    /** Upsert documents in row-based format. */
    fun upsertRowBased(): Optional<UpsertRowBased> = body.upsertRowBased()

    /** Copy documents from another namespace. */
    fun copyFromNamespace(): Optional<CopyFromNamespace> = body.copyFromNamespace()

    /** Delete documents by filter. */
    fun deleteByFilter(): Optional<DeleteByFilter> = body.deleteByFilter()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): NamespaceUpsertBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> namespace
            else -> ""
        }
    }

    /** Upsert documents in columnar format. */
    @JsonDeserialize(using = NamespaceUpsertBody.Deserializer::class)
    @JsonSerialize(using = NamespaceUpsertBody.Serializer::class)
    class NamespaceUpsertBody
    internal constructor(
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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                upsertColumnar != null -> visitor.visitUpsertColumnar(upsertColumnar)
                upsertRowBased != null -> visitor.visitUpsertRowBased(upsertRowBased)
                copyFromNamespace != null -> visitor.visitCopyFromNamespace(copyFromNamespace)
                deleteByFilter != null -> visitor.visitDeleteByFilter(deleteByFilter)
                else -> visitor.unknown(_json)
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is NamespaceUpsertBody && upsertColumnar == other.upsertColumnar && upsertRowBased == other.upsertRowBased && copyFromNamespace == other.copyFromNamespace && deleteByFilter == other.deleteByFilter /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(upsertColumnar, upsertRowBased, copyFromNamespace, deleteByFilter) /* spotless:on */

        override fun toString(): String =
            when {
                upsertColumnar != null -> "NamespaceUpsertBody{upsertColumnar=$upsertColumnar}"
                upsertRowBased != null -> "NamespaceUpsertBody{upsertRowBased=$upsertRowBased}"
                copyFromNamespace != null ->
                    "NamespaceUpsertBody{copyFromNamespace=$copyFromNamespace}"
                deleteByFilter != null -> "NamespaceUpsertBody{deleteByFilter=$deleteByFilter}"
                _json != null -> "NamespaceUpsertBody{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid NamespaceUpsertBody")
            }

        companion object {

            /** Upsert documents in columnar format. */
            @JvmStatic
            fun ofUpsertColumnar(upsertColumnar: UpsertColumnar) =
                NamespaceUpsertBody(upsertColumnar = upsertColumnar)

            /** Upsert documents in row-based format. */
            @JvmStatic
            fun ofUpsertRowBased(upsertRowBased: UpsertRowBased) =
                NamespaceUpsertBody(upsertRowBased = upsertRowBased)

            /** Copy documents from another namespace. */
            @JvmStatic
            fun ofCopyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                NamespaceUpsertBody(copyFromNamespace = copyFromNamespace)

            /** Delete documents by filter. */
            @JvmStatic
            fun ofDeleteByFilter(deleteByFilter: DeleteByFilter) =
                NamespaceUpsertBody(deleteByFilter = deleteByFilter)
        }

        /**
         * An interface that defines how to map each variant of [NamespaceUpsertBody] to a value of
         * type [T].
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
             * Maps an unknown variant of [NamespaceUpsertBody] to a value of type [T].
             *
             * An instance of [NamespaceUpsertBody] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown NamespaceUpsertBody: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<NamespaceUpsertBody>(NamespaceUpsertBody::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): NamespaceUpsertBody {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<UpsertColumnar>())?.let {
                    return NamespaceUpsertBody(upsertColumnar = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<UpsertRowBased>())?.let {
                    return NamespaceUpsertBody(upsertRowBased = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<CopyFromNamespace>())?.let {
                    return NamespaceUpsertBody(copyFromNamespace = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<DeleteByFilter>())?.let {
                    return NamespaceUpsertBody(deleteByFilter = it, _json = json)
                }

                return NamespaceUpsertBody(_json = json)
            }
        }

        internal class Serializer :
            BaseSerializer<NamespaceUpsertBody>(NamespaceUpsertBody::class) {

            override fun serialize(
                value: NamespaceUpsertBody,
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
                    else -> throw IllegalStateException("Invalid NamespaceUpsertBody")
                }
            }
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpsertParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: NamespaceUpsertBody? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceUpsertParams: NamespaceUpsertParams) = apply {
            namespace = namespaceUpsertParams.namespace
            body = namespaceUpsertParams.body
            additionalHeaders = namespaceUpsertParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceUpsertParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String) = apply { this.namespace = namespace }

        /** Upsert documents in columnar format. */
        fun forUpsertColumnar(upsertColumnar: UpsertColumnar) = apply {
            body = NamespaceUpsertBody.ofUpsertColumnar(upsertColumnar)
        }

        /** Upsert documents in row-based format. */
        fun forUpsertRowBased(upsertRowBased: UpsertRowBased) = apply {
            body = NamespaceUpsertBody.ofUpsertRowBased(upsertRowBased)
        }

        /** Copy documents from another namespace. */
        fun forCopyFromNamespace(copyFromNamespace: CopyFromNamespace) = apply {
            body = NamespaceUpsertBody.ofCopyFromNamespace(copyFromNamespace)
        }

        /** Delete documents by filter. */
        fun forDeleteByFilter(deleteByFilter: DeleteByFilter) = apply {
            body = NamespaceUpsertBody.ofDeleteByFilter(deleteByFilter)
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

        fun build(): NamespaceUpsertParams =
            NamespaceUpsertParams(
                checkRequired("namespace", namespace),
                body ?: NamespaceUpsertBody(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** Upsert documents in columnar format. */
    @NoAutoDetect
    class UpsertColumnar
    @JsonCreator
    private constructor(
        @JsonProperty("attributes")
        @ExcludeMissing
        private val attributes: JsonField<DocumentColumns.Attributes> = JsonMissing.of(),
        @JsonProperty("ids")
        @ExcludeMissing
        private val ids: JsonField<List<DocumentColumns.Id>> = JsonMissing.of(),
        @JsonProperty("vectors")
        @ExcludeMissing
        private val vectors: JsonField<List<DocumentColumns.Vector?>> = JsonMissing.of(),
        @JsonProperty("distance_metric")
        @ExcludeMissing
        private val distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("schema")
        @ExcludeMissing
        private val schema: JsonField<Schema> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The attributes attached to each of the documents. */
        fun attributes(): Optional<DocumentColumns.Attributes> =
            Optional.ofNullable(attributes.getNullable("attributes"))

        /** The IDs of the documents. */
        fun ids(): Optional<List<DocumentColumns.Id>> = Optional.ofNullable(ids.getNullable("ids"))

        /** Vectors describing each of the documents. */
        fun vectors(): Optional<List<DocumentColumns.Vector?>> =
            Optional.ofNullable(vectors.getNullable("vectors"))

        /** A function used to calculate vector similarity. */
        fun distanceMetric(): Optional<DistanceMetric> =
            Optional.ofNullable(distanceMetric.getNullable("distance_metric"))

        /** The schema of the attributes attached to the documents. */
        fun schema(): Optional<Schema> = Optional.ofNullable(schema.getNullable("schema"))

        /** The attributes attached to each of the documents. */
        @JsonProperty("attributes")
        @ExcludeMissing
        fun _attributes(): JsonField<DocumentColumns.Attributes> = attributes

        /** The IDs of the documents. */
        @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<DocumentColumns.Id>> = ids

        /** Vectors describing each of the documents. */
        @JsonProperty("vectors")
        @ExcludeMissing
        fun _vectors(): JsonField<List<DocumentColumns.Vector?>> = vectors

        /** A function used to calculate vector similarity. */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /** The schema of the attributes attached to the documents. */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toDocumentColumns(): DocumentColumns =
            DocumentColumns.builder().attributes(attributes).ids(ids).vectors(vectors).build()

        private var validated: Boolean = false

        fun validate(): UpsertColumnar = apply {
            if (validated) {
                return@apply
            }

            attributes().ifPresent { it.validate() }
            ids().ifPresent { it.forEach { it.validate() } }
            vectors().ifPresent { it.forEach { it?.validate() } }
            distanceMetric()
            schema().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UpsertColumnar]. */
        class Builder internal constructor() {

            private var attributes: JsonField<DocumentColumns.Attributes> = JsonMissing.of()
            private var ids: JsonField<MutableList<DocumentColumns.Id>>? = null
            private var vectors: JsonField<MutableList<DocumentColumns.Vector?>>? = null
            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
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

            /** The attributes attached to each of the documents. */
            fun attributes(attributes: JsonField<DocumentColumns.Attributes>) = apply {
                this.attributes = attributes
            }

            /** The IDs of the documents. */
            fun ids(ids: List<DocumentColumns.Id>) = ids(JsonField.of(ids))

            /** The IDs of the documents. */
            fun ids(ids: JsonField<List<DocumentColumns.Id>>) = apply {
                this.ids = ids.map { it.toMutableList() }
            }

            /** The IDs of the documents. */
            fun addId(id: DocumentColumns.Id) = apply {
                ids =
                    (ids ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(id)
                    }
            }

            /** A UUID. */
            fun addId(string: String) = addId(DocumentColumns.Id.ofString(string))

            /** An integer ID. */
            fun addId(integer: Long) = addId(DocumentColumns.Id.ofInteger(integer))

            /** Vectors describing each of the documents. */
            fun vectors(vectors: List<DocumentColumns.Vector?>) = vectors(JsonField.of(vectors))

            /** Vectors describing each of the documents. */
            fun vectors(vectors: JsonField<List<DocumentColumns.Vector?>>) = apply {
                this.vectors = vectors.map { it.toMutableList() }
            }

            /** Vectors describing each of the documents. */
            fun addVector(vector: DocumentColumns.Vector) = apply {
                vectors =
                    (vectors ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(vector)
                    }
            }

            /** Vectors describing each of the documents. */
            fun addVector(number: Double) = addVector(DocumentColumns.Vector.ofNumber(number))

            /** Vectors describing each of the documents. */
            fun addVectorOfNumber(number: List<Double>) =
                addVector(DocumentColumns.Vector.ofNumber(number))

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                this.distanceMetric = distanceMetric
            }

            /** The schema of the attributes attached to the documents. */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /** The schema of the attributes attached to the documents. */
            fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

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

            fun build(): UpsertColumnar =
                UpsertColumnar(
                    attributes,
                    (ids ?: JsonMissing.of()).map { it.toImmutable() },
                    (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                    distanceMetric,
                    schema,
                    additionalProperties.toImmutable(),
                )
        }

        /** A function used to calculate vector similarity. */
        class DistanceMetric
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                @JvmField val COSINE_DISTANCE = of("cosine_distance")

                /** Defined as `sum((x - y)^2)`. Lower is better. */
                @JvmField val EUCLIDEAN_SQUARED = of("euclidean_squared")

                @JvmStatic fun of(value: String) = DistanceMetric(JsonField.of(value))
            }

            /** An enum containing [DistanceMetric]'s known values. */
            enum class Known {
                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                COSINE_DISTANCE,
                /** Defined as `sum((x - y)^2)`. Lower is better. */
                EUCLIDEAN_SQUARED,
            }

            /**
             * An enum containing [DistanceMetric]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [DistanceMetric] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                COSINE_DISTANCE,
                /** Defined as `sum((x - y)^2)`. Lower is better. */
                EUCLIDEAN_SQUARED,
                /**
                 * An enum member indicating that [DistanceMetric] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    COSINE_DISTANCE -> Value.COSINE_DISTANCE
                    EUCLIDEAN_SQUARED -> Value.EUCLIDEAN_SQUARED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    COSINE_DISTANCE -> Known.COSINE_DISTANCE
                    EUCLIDEAN_SQUARED -> Known.EUCLIDEAN_SQUARED
                    else -> throw TurbopufferInvalidDataException("Unknown DistanceMetric: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is DistanceMetric && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The schema of the attributes attached to the documents. */
        @NoAutoDetect
        class Schema
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Schema = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

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

                fun build(): Schema = Schema(additionalProperties.toImmutable())
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
    @NoAutoDetect
    class UpsertRowBased
    @JsonCreator
    private constructor(
        @JsonProperty("distance_metric")
        @ExcludeMissing
        private val distanceMetric: JsonField<DistanceMetric> = JsonMissing.of(),
        @JsonProperty("schema")
        @ExcludeMissing
        private val schema: JsonField<Schema> = JsonMissing.of(),
        @JsonProperty("upserts")
        @ExcludeMissing
        private val upserts: JsonField<List<DocumentRow>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** A function used to calculate vector similarity. */
        fun distanceMetric(): Optional<DistanceMetric> =
            Optional.ofNullable(distanceMetric.getNullable("distance_metric"))

        /** The schema of the attributes attached to the documents. */
        fun schema(): Optional<Schema> = Optional.ofNullable(schema.getNullable("schema"))

        fun upserts(): Optional<List<DocumentRow>> =
            Optional.ofNullable(upserts.getNullable("upserts"))

        /** A function used to calculate vector similarity. */
        @JsonProperty("distance_metric")
        @ExcludeMissing
        fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

        /** The schema of the attributes attached to the documents. */
        @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

        @JsonProperty("upserts")
        @ExcludeMissing
        fun _upserts(): JsonField<List<DocumentRow>> = upserts

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): UpsertRowBased = apply {
            if (validated) {
                return@apply
            }

            distanceMetric()
            schema().ifPresent { it.validate() }
            upserts().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UpsertRowBased]. */
        class Builder internal constructor() {

            private var distanceMetric: JsonField<DistanceMetric> = JsonMissing.of()
            private var schema: JsonField<Schema> = JsonMissing.of()
            private var upserts: JsonField<MutableList<DocumentRow>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(upsertRowBased: UpsertRowBased) = apply {
                distanceMetric = upsertRowBased.distanceMetric
                schema = upsertRowBased.schema
                upserts = upsertRowBased.upserts.map { it.toMutableList() }
                additionalProperties = upsertRowBased.additionalProperties.toMutableMap()
            }

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: DistanceMetric) =
                distanceMetric(JsonField.of(distanceMetric))

            /** A function used to calculate vector similarity. */
            fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                this.distanceMetric = distanceMetric
            }

            /** The schema of the attributes attached to the documents. */
            fun schema(schema: Schema) = schema(JsonField.of(schema))

            /** The schema of the attributes attached to the documents. */
            fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

            fun upserts(upserts: List<DocumentRow>) = upserts(JsonField.of(upserts))

            fun upserts(upserts: JsonField<List<DocumentRow>>) = apply {
                this.upserts = upserts.map { it.toMutableList() }
            }

            fun addUpsert(upsert: DocumentRow) = apply {
                upserts =
                    (upserts ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(upsert)
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

            fun build(): UpsertRowBased =
                UpsertRowBased(
                    distanceMetric,
                    schema,
                    (upserts ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        /** A function used to calculate vector similarity. */
        class DistanceMetric
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                @JvmField val COSINE_DISTANCE = of("cosine_distance")

                /** Defined as `sum((x - y)^2)`. Lower is better. */
                @JvmField val EUCLIDEAN_SQUARED = of("euclidean_squared")

                @JvmStatic fun of(value: String) = DistanceMetric(JsonField.of(value))
            }

            /** An enum containing [DistanceMetric]'s known values. */
            enum class Known {
                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                COSINE_DISTANCE,
                /** Defined as `sum((x - y)^2)`. Lower is better. */
                EUCLIDEAN_SQUARED,
            }

            /**
             * An enum containing [DistanceMetric]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [DistanceMetric] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                /** Defined as `1 - cosine_similarity` and ranges from 0 to 2. Lower is better. */
                COSINE_DISTANCE,
                /** Defined as `sum((x - y)^2)`. Lower is better. */
                EUCLIDEAN_SQUARED,
                /**
                 * An enum member indicating that [DistanceMetric] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    COSINE_DISTANCE -> Value.COSINE_DISTANCE
                    EUCLIDEAN_SQUARED -> Value.EUCLIDEAN_SQUARED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws TurbopufferInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    COSINE_DISTANCE -> Known.COSINE_DISTANCE
                    EUCLIDEAN_SQUARED -> Known.EUCLIDEAN_SQUARED
                    else -> throw TurbopufferInvalidDataException("Unknown DistanceMetric: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is DistanceMetric && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** The schema of the attributes attached to the documents. */
        @NoAutoDetect
        class Schema
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Schema = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

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

                fun build(): Schema = Schema(additionalProperties.toImmutable())
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

            return /* spotless:off */ other is UpsertRowBased && distanceMetric == other.distanceMetric && schema == other.schema && upserts == other.upserts && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(distanceMetric, schema, upserts, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UpsertRowBased{distanceMetric=$distanceMetric, schema=$schema, upserts=$upserts, additionalProperties=$additionalProperties}"
    }

    /** Copy documents from another namespace. */
    @NoAutoDetect
    class CopyFromNamespace
    @JsonCreator
    private constructor(
        @JsonProperty("copy_from_namespace")
        @ExcludeMissing
        private val copyFromNamespace: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The namespace to copy documents from. */
        fun copyFromNamespace(): Optional<String> =
            Optional.ofNullable(copyFromNamespace.getNullable("copy_from_namespace"))

        /** The namespace to copy documents from. */
        @JsonProperty("copy_from_namespace")
        @ExcludeMissing
        fun _copyFromNamespace(): JsonField<String> = copyFromNamespace

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CopyFromNamespace = apply {
            if (validated) {
                return@apply
            }

            copyFromNamespace()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CopyFromNamespace]. */
        class Builder internal constructor() {

            private var copyFromNamespace: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(copyFromNamespace: CopyFromNamespace) = apply {
                this.copyFromNamespace = copyFromNamespace.copyFromNamespace
                additionalProperties = copyFromNamespace.additionalProperties.toMutableMap()
            }

            /** The namespace to copy documents from. */
            fun copyFromNamespace(copyFromNamespace: String) =
                copyFromNamespace(JsonField.of(copyFromNamespace))

            /** The namespace to copy documents from. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): CopyFromNamespace =
                CopyFromNamespace(copyFromNamespace, additionalProperties.toImmutable())
        }

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
    @NoAutoDetect
    class DeleteByFilter
    @JsonCreator
    private constructor(
        @JsonProperty("delete_by_filter")
        @ExcludeMissing
        private val deleteByFilter: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        @JsonProperty("delete_by_filter")
        @ExcludeMissing
        fun _deleteByFilter(): JsonValue = deleteByFilter

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): DeleteByFilter = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DeleteByFilter]. */
        class Builder internal constructor() {

            private var deleteByFilter: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(deleteByFilter: DeleteByFilter) = apply {
                this.deleteByFilter = deleteByFilter.deleteByFilter
                additionalProperties = deleteByFilter.additionalProperties.toMutableMap()
            }

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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): DeleteByFilter =
                DeleteByFilter(deleteByFilter, additionalProperties.toImmutable())
        }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceUpsertParams && namespace == other.namespace && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceUpsertParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
