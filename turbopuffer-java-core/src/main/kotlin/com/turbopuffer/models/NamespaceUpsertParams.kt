// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models

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
import com.turbopuffer.core.NoAutoDetect
import com.turbopuffer.core.Params
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional

/** Create, update, or delete documents. */
class NamespaceUpsertParams
private constructor(
    private val namespace: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): String = namespace

    /** Upsert documents in columnar format. */
    fun body(): Body = body

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> namespace
            else -> ""
        }
    }

    /** Upsert documents in columnar format. */
    @JsonDeserialize(using = Body.Deserializer::class)
    @JsonSerialize(using = Body.Serializer::class)
    class Body
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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                upsertColumnar != null -> visitor.visitUpsertColumnar(upsertColumnar)
                upsertRowBased != null -> visitor.visitUpsertRowBased(upsertRowBased)
                copyFromNamespace != null -> visitor.visitCopyFromNamespace(copyFromNamespace)
                deleteByFilter != null -> visitor.visitDeleteByFilter(deleteByFilter)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && upsertColumnar == other.upsertColumnar && upsertRowBased == other.upsertRowBased && copyFromNamespace == other.copyFromNamespace && deleteByFilter == other.deleteByFilter /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(upsertColumnar, upsertRowBased, copyFromNamespace, deleteByFilter) /* spotless:on */

        override fun toString(): String =
            when {
                upsertColumnar != null -> "Body{upsertColumnar=$upsertColumnar}"
                upsertRowBased != null -> "Body{upsertRowBased=$upsertRowBased}"
                copyFromNamespace != null -> "Body{copyFromNamespace=$copyFromNamespace}"
                deleteByFilter != null -> "Body{deleteByFilter=$deleteByFilter}"
                _json != null -> "Body{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Body")
            }

        companion object {

            /** Upsert documents in columnar format. */
            @JvmStatic
            fun ofUpsertColumnar(upsertColumnar: UpsertColumnar) =
                Body(upsertColumnar = upsertColumnar)

            /** Upsert documents in row-based format. */
            @JvmStatic
            fun ofUpsertRowBased(upsertRowBased: UpsertRowBased) =
                Body(upsertRowBased = upsertRowBased)

            /** Copy documents from another namespace. */
            @JvmStatic
            fun ofCopyFromNamespace(copyFromNamespace: CopyFromNamespace) =
                Body(copyFromNamespace = copyFromNamespace)

            /** Delete documents by filter. */
            @JvmStatic
            fun ofDeleteByFilter(deleteByFilter: DeleteByFilter) =
                Body(deleteByFilter = deleteByFilter)
        }

        /** An interface that defines how to map each variant of [Body] to a value of type [T]. */
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
             * Maps an unknown variant of [Body] to a value of type [T].
             *
             * An instance of [Body] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Body: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Body>(Body::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Body {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<UpsertColumnar>()) { it.validate() }
                    ?.let {
                        return Body(upsertColumnar = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<UpsertRowBased>()) { it.validate() }
                    ?.let {
                        return Body(upsertRowBased = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<CopyFromNamespace>()) { it.validate() }
                    ?.let {
                        return Body(copyFromNamespace = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<DeleteByFilter>()) { it.validate() }
                    ?.let {
                        return Body(deleteByFilter = it, _json = json)
                    }

                return Body(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Body>(Body::class) {

            override fun serialize(
                value: Body,
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
                    else -> throw IllegalStateException("Invalid Body")
                }
            }
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
            private val ids: JsonField<List<Id>> = JsonMissing.of(),
            @JsonProperty("vectors")
            @ExcludeMissing
            private val vectors: JsonField<List<List<Double>?>> = JsonMissing.of(),
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
            fun ids(): Optional<List<Id>> = Optional.ofNullable(ids.getNullable("ids"))

            /** Vectors describing each of the documents. */
            fun vectors(): Optional<List<List<Double>?>> =
                Optional.ofNullable(vectors.getNullable("vectors"))

            /** A function used to calculate vector similarity. */
            fun distanceMetric(): DistanceMetric = distanceMetric.getRequired("distance_metric")

            /** The schema of the attributes attached to the documents. */
            fun schema(): Optional<Schema> = Optional.ofNullable(schema.getNullable("schema"))

            /** The attributes attached to each of the documents. */
            @JsonProperty("attributes")
            @ExcludeMissing
            fun _attributes(): JsonField<DocumentColumns.Attributes> = attributes

            /** The IDs of the documents. */
            @JsonProperty("ids") @ExcludeMissing fun _ids(): JsonField<List<Id>> = ids

            /** Vectors describing each of the documents. */
            @JsonProperty("vectors")
            @ExcludeMissing
            fun _vectors(): JsonField<List<List<Double>?>> = vectors

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
                vectors()
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

                /** The attributes attached to each of the documents. */
                fun attributes(attributes: JsonField<DocumentColumns.Attributes>) = apply {
                    this.attributes = attributes
                }

                /** The IDs of the documents. */
                fun ids(ids: List<Id>) = ids(JsonField.of(ids))

                /** The IDs of the documents. */
                fun ids(ids: JsonField<List<Id>>) = apply {
                    this.ids = ids.map { it.toMutableList() }
                }

                /** The IDs of the documents. */
                fun addId(id: Id) = apply {
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
                fun addId(string: String) = addId(Id.ofString(string))

                /** An integer ID. */
                fun addId(integer: Long) = addId(Id.ofInteger(integer))

                /** Vectors describing each of the documents. */
                fun vectors(vectors: List<List<Double>?>) = vectors(JsonField.of(vectors))

                /** Vectors describing each of the documents. */
                fun vectors(vectors: JsonField<List<List<Double>?>>) = apply {
                    this.vectors = vectors.map { it.toMutableList() }
                }

                /** Vectors describing each of the documents. */
                fun addVector(vector: List<Double>) = apply {
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

                fun build(): UpsertColumnar =
                    UpsertColumnar(
                        attributes,
                        (ids ?: JsonMissing.of()).map { it.toImmutable() },
                        (vectors ?: JsonMissing.of()).map { it.toImmutable() },
                        checkRequired("distanceMetric", distanceMetric),
                        schema,
                        additionalProperties.toImmutable(),
                    )
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
            @JsonProperty("upserts")
            @ExcludeMissing
            private val upserts: JsonField<List<DocumentRow>> = JsonMissing.of(),
            @JsonProperty("schema")
            @ExcludeMissing
            private val schema: JsonField<Schema> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** A function used to calculate vector similarity. */
            fun distanceMetric(): DistanceMetric = distanceMetric.getRequired("distance_metric")

            fun upserts(): List<DocumentRow> = upserts.getRequired("upserts")

            /** The schema of the attributes attached to the documents. */
            fun schema(): Optional<Schema> = Optional.ofNullable(schema.getNullable("schema"))

            /** A function used to calculate vector similarity. */
            @JsonProperty("distance_metric")
            @ExcludeMissing
            fun _distanceMetric(): JsonField<DistanceMetric> = distanceMetric

            @JsonProperty("upserts")
            @ExcludeMissing
            fun _upserts(): JsonField<List<DocumentRow>> = upserts

            /** The schema of the attributes attached to the documents. */
            @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): UpsertRowBased = apply {
                if (validated) {
                    return@apply
                }

                distanceMetric()
                upserts().forEach { it.validate() }
                schema().ifPresent { it.validate() }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

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

                /** A function used to calculate vector similarity. */
                fun distanceMetric(distanceMetric: JsonField<DistanceMetric>) = apply {
                    this.distanceMetric = distanceMetric
                }

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

                fun build(): UpsertRowBased =
                    UpsertRowBased(
                        checkRequired("distanceMetric", distanceMetric),
                        checkRequired("upserts", upserts).map { it.toImmutable() },
                        schema,
                        additionalProperties.toImmutable(),
                    )
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
            fun copyFromNamespace(): String = copyFromNamespace.getRequired("copy_from_namespace")

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

                fun build(): CopyFromNamespace =
                    CopyFromNamespace(
                        checkRequired("copyFromNamespace", copyFromNamespace),
                        additionalProperties.toImmutable(),
                    )
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

                private var deleteByFilter: JsonValue? = null
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

                fun build(): DeleteByFilter =
                    DeleteByFilter(
                        checkRequired("deleteByFilter", deleteByFilter),
                        additionalProperties.toImmutable(),
                    )
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
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpsertParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body? = null
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
        fun body(body: Body) = apply { this.body = body }

        /** Upsert documents in columnar format. */
        fun body(upsertColumnar: Body.UpsertColumnar) = body(Body.ofUpsertColumnar(upsertColumnar))

        /** Upsert documents in row-based format. */
        fun body(upsertRowBased: Body.UpsertRowBased) = body(Body.ofUpsertRowBased(upsertRowBased))

        /** Copy documents from another namespace. */
        fun body(copyFromNamespace: Body.CopyFromNamespace) =
            body(Body.ofCopyFromNamespace(copyFromNamespace))

        /** Delete documents by filter. */
        fun body(deleteByFilter: Body.DeleteByFilter) = body(Body.ofDeleteByFilter(deleteByFilter))

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
                checkRequired("body", body),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
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
