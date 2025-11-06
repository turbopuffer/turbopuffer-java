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
import com.turbopuffer.core.allMaxBy
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.getOrThrow
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Metadata about a namespace. */
class NamespaceMetadata
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val approxLogicalBytes: JsonField<Long>,
    private val approxRowCount: JsonField<Long>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val encryption: JsonField<Encryption>,
    private val index: JsonField<Index>,
    private val schema: JsonField<Schema>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("approx_logical_bytes")
        @ExcludeMissing
        approxLogicalBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("approx_row_count")
        @ExcludeMissing
        approxRowCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("encryption")
        @ExcludeMissing
        encryption: JsonField<Encryption> = JsonMissing.of(),
        @JsonProperty("index") @ExcludeMissing index: JsonField<Index> = JsonMissing.of(),
        @JsonProperty("schema") @ExcludeMissing schema: JsonField<Schema> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        approxLogicalBytes,
        approxRowCount,
        createdAt,
        encryption,
        index,
        schema,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The approximate number of logical bytes in the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun approxLogicalBytes(): Long = approxLogicalBytes.getRequired("approx_logical_bytes")

    /**
     * The approximate number of rows in the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun approxRowCount(): Long = approxRowCount.getRequired("approx_row_count")

    /**
     * The timestamp when the namespace was created.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /**
     * Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK).
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun encryption(): Encryption = encryption.getRequired("encryption")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun index(): Index = index.getRequired("index")

    /**
     * The schema of the namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun schema(): Schema = schema.getRequired("schema")

    /**
     * The timestamp when the namespace was last modified by a write operation.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * Returns the raw JSON value of [approxLogicalBytes].
     *
     * Unlike [approxLogicalBytes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("approx_logical_bytes")
    @ExcludeMissing
    fun _approxLogicalBytes(): JsonField<Long> = approxLogicalBytes

    /**
     * Returns the raw JSON value of [approxRowCount].
     *
     * Unlike [approxRowCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("approx_row_count")
    @ExcludeMissing
    fun _approxRowCount(): JsonField<Long> = approxRowCount

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [encryption].
     *
     * Unlike [encryption], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("encryption")
    @ExcludeMissing
    fun _encryption(): JsonField<Encryption> = encryption

    /**
     * Returns the raw JSON value of [index].
     *
     * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Index> = index

    /**
     * Returns the raw JSON value of [schema].
     *
     * Unlike [schema], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("schema") @ExcludeMissing fun _schema(): JsonField<Schema> = schema

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [NamespaceMetadata].
         *
         * The following fields are required:
         * ```java
         * .approxLogicalBytes()
         * .approxRowCount()
         * .createdAt()
         * .encryption()
         * .index()
         * .schema()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceMetadata]. */
    class Builder internal constructor() {

        private var approxLogicalBytes: JsonField<Long>? = null
        private var approxRowCount: JsonField<Long>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var encryption: JsonField<Encryption>? = null
        private var index: JsonField<Index>? = null
        private var schema: JsonField<Schema>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceMetadata: NamespaceMetadata) = apply {
            approxLogicalBytes = namespaceMetadata.approxLogicalBytes
            approxRowCount = namespaceMetadata.approxRowCount
            createdAt = namespaceMetadata.createdAt
            encryption = namespaceMetadata.encryption
            index = namespaceMetadata.index
            schema = namespaceMetadata.schema
            updatedAt = namespaceMetadata.updatedAt
            additionalProperties = namespaceMetadata.additionalProperties.toMutableMap()
        }

        /** The approximate number of logical bytes in the namespace. */
        fun approxLogicalBytes(approxLogicalBytes: Long) =
            approxLogicalBytes(JsonField.of(approxLogicalBytes))

        /**
         * Sets [Builder.approxLogicalBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approxLogicalBytes] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun approxLogicalBytes(approxLogicalBytes: JsonField<Long>) = apply {
            this.approxLogicalBytes = approxLogicalBytes
        }

        /** The approximate number of rows in the namespace. */
        fun approxRowCount(approxRowCount: Long) = approxRowCount(JsonField.of(approxRowCount))

        /**
         * Sets [Builder.approxRowCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.approxRowCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun approxRowCount(approxRowCount: JsonField<Long>) = apply {
            this.approxRowCount = approxRowCount
        }

        /** The timestamp when the namespace was created. */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /**
         * Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK).
         */
        fun encryption(encryption: Encryption) = encryption(JsonField.of(encryption))

        /**
         * Sets [Builder.encryption] to an arbitrary JSON value.
         *
         * You should usually call [Builder.encryption] with a well-typed [Encryption] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun encryption(encryption: JsonField<Encryption>) = apply { this.encryption = encryption }

        /** Alias for calling [encryption] with `Encryption.ofSse(sse)`. */
        fun encryption(sse: Encryption.Sse) = encryption(Encryption.ofSse(sse))

        /** Alias for calling [encryption] with `Encryption.ofCmek(cmek)`. */
        fun encryption(cmek: Encryption.Cmek) = encryption(Encryption.ofCmek(cmek))

        fun index(index: Index) = index(JsonField.of(index))

        /**
         * Sets [Builder.index] to an arbitrary JSON value.
         *
         * You should usually call [Builder.index] with a well-typed [Index] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun index(index: JsonField<Index>) = apply { this.index = index }

        /** Alias for calling [index] with `Index.ofUpToDate()`. */
        fun indexUpToDate() = index(Index.ofUpToDate())

        /** Alias for calling [index] with `Index.ofUpdating(updating)`. */
        fun index(updating: Index.IndexUpdating) = index(Index.ofUpdating(updating))

        /** The schema of the namespace. */
        fun schema(schema: Schema) = schema(JsonField.of(schema))

        /**
         * Sets [Builder.schema] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schema] with a well-typed [Schema] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun schema(schema: JsonField<Schema>) = apply { this.schema = schema }

        /** The timestamp when the namespace was last modified by a write operation. */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [NamespaceMetadata].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .approxLogicalBytes()
         * .approxRowCount()
         * .createdAt()
         * .encryption()
         * .index()
         * .schema()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceMetadata =
            NamespaceMetadata(
                checkRequired("approxLogicalBytes", approxLogicalBytes),
                checkRequired("approxRowCount", approxRowCount),
                checkRequired("createdAt", createdAt),
                checkRequired("encryption", encryption),
                checkRequired("index", index),
                checkRequired("schema", schema),
                checkRequired("updatedAt", updatedAt),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceMetadata = apply {
        if (validated) {
            return@apply
        }

        approxLogicalBytes()
        approxRowCount()
        createdAt()
        encryption().validate()
        index().validate()
        schema().validate()
        updatedAt()
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
        (if (approxLogicalBytes.asKnown().isPresent) 1 else 0) +
            (if (approxRowCount.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (encryption.asKnown().getOrNull()?.validity() ?: 0) +
            (index.asKnown().getOrNull()?.validity() ?: 0) +
            (schema.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /** Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK). */
    @JsonDeserialize(using = Encryption.Deserializer::class)
    @JsonSerialize(using = Encryption.Serializer::class)
    class Encryption
    private constructor(
        private val sse: Sse? = null,
        private val cmek: Cmek? = null,
        private val _json: JsonValue? = null,
    ) {

        fun sse(): Optional<Sse> = Optional.ofNullable(sse)

        /**
         * Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK).
         */
        fun cmek(): Optional<Cmek> = Optional.ofNullable(cmek)

        fun isSse(): Boolean = sse != null

        fun isCmek(): Boolean = cmek != null

        fun asSse(): Sse = sse.getOrThrow("sse")

        /**
         * Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK).
         */
        fun asCmek(): Cmek = cmek.getOrThrow("cmek")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                sse != null -> visitor.visitSse(sse)
                cmek != null -> visitor.visitCmek(cmek)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Encryption = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitSse(sse: Sse) {
                        sse.validate()
                    }

                    override fun visitCmek(cmek: Cmek) {
                        cmek.validate()
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
                    override fun visitSse(sse: Sse) = sse.validity()

                    override fun visitCmek(cmek: Cmek) = cmek.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Encryption && sse == other.sse && cmek == other.cmek
        }

        override fun hashCode(): Int = Objects.hash(sse, cmek)

        override fun toString(): String =
            when {
                sse != null -> "Encryption{sse=$sse}"
                cmek != null -> "Encryption{cmek=$cmek}"
                _json != null -> "Encryption{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Encryption")
            }

        companion object {

            @JvmStatic fun ofSse(sse: Sse) = Encryption(sse = sse)

            /**
             * Indicates that the namespace is encrypted with a customer-managed encryption key
             * (CMEK).
             */
            @JvmStatic fun ofCmek(cmek: Cmek) = Encryption(cmek = cmek)
        }

        /**
         * An interface that defines how to map each variant of [Encryption] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitSse(sse: Sse): T

            /**
             * Indicates that the namespace is encrypted with a customer-managed encryption key
             * (CMEK).
             */
            fun visitCmek(cmek: Cmek): T

            /**
             * Maps an unknown variant of [Encryption] to a value of type [T].
             *
             * An instance of [Encryption] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Encryption: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Encryption>(Encryption::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Encryption {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<Sse>())?.let {
                                Encryption(sse = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Cmek>())?.let {
                                Encryption(cmek = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Encryption(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Encryption>(Encryption::class) {

            override fun serialize(
                value: Encryption,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.sse != null -> generator.writeObject(value.sse)
                    value.cmek != null -> generator.writeObject(value.cmek)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Encryption")
                }
            }
        }

        class Sse
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val sse: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("sse") @ExcludeMissing sse: JsonField<Boolean> = JsonMissing.of()
            ) : this(sse, mutableMapOf())

            /**
             * Always true. Indicates that the namespace is encrypted with SSE.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun sse(): Boolean = sse.getRequired("sse")

            /**
             * Returns the raw JSON value of [sse].
             *
             * Unlike [sse], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sse") @ExcludeMissing fun _sse(): JsonField<Boolean> = sse

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
                 * Returns a mutable builder for constructing an instance of [Sse].
                 *
                 * The following fields are required:
                 * ```java
                 * .sse()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Sse]. */
            class Builder internal constructor() {

                private var sse: JsonField<Boolean>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(sse: Sse) = apply {
                    this.sse = sse.sse
                    additionalProperties = sse.additionalProperties.toMutableMap()
                }

                /** Always true. Indicates that the namespace is encrypted with SSE. */
                fun sse(sse: Boolean) = sse(JsonField.of(sse))

                /**
                 * Sets [Builder.sse] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sse] with a well-typed [Boolean] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun sse(sse: JsonField<Boolean>) = apply { this.sse = sse }

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
                 * Returns an immutable instance of [Sse].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .sse()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Sse =
                    Sse(checkRequired("sse", sse), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Sse = apply {
                if (validated) {
                    return@apply
                }

                sse()
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
            @JvmSynthetic internal fun validity(): Int = (if (sse.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Sse &&
                    sse == other.sse &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(sse, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Sse{sse=$sse, additionalProperties=$additionalProperties}"
        }

        /**
         * Indicates that the namespace is encrypted with a customer-managed encryption key (CMEK).
         */
        class Cmek
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cmek: JsonField<InnerCmek>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cmek") @ExcludeMissing cmek: JsonField<InnerCmek> = JsonMissing.of()
            ) : this(cmek, mutableMapOf())

            /**
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cmek(): InnerCmek = cmek.getRequired("cmek")

            /**
             * Returns the raw JSON value of [cmek].
             *
             * Unlike [cmek], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cmek") @ExcludeMissing fun _cmek(): JsonField<InnerCmek> = cmek

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
                 * .cmek()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Cmek]. */
            class Builder internal constructor() {

                private var cmek: JsonField<InnerCmek>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cmek: Cmek) = apply {
                    this.cmek = cmek.cmek
                    additionalProperties = cmek.additionalProperties.toMutableMap()
                }

                fun cmek(cmek: InnerCmek) = cmek(JsonField.of(cmek))

                /**
                 * Sets [Builder.cmek] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cmek] with a well-typed [InnerCmek] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cmek(cmek: JsonField<InnerCmek>) = apply { this.cmek = cmek }

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
                 * .cmek()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Cmek =
                    Cmek(checkRequired("cmek", cmek), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Cmek = apply {
                if (validated) {
                    return@apply
                }

                cmek().validate()
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
            internal fun validity(): Int = (cmek.asKnown().getOrNull()?.validity() ?: 0)

            class InnerCmek
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
                 * The name of the CMEK key in use.
                 *
                 * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type
                 *   or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun keyName(): String = keyName.getRequired("key_name")

                /**
                 * Returns the raw JSON value of [keyName].
                 *
                 * Unlike [keyName], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("key_name")
                @ExcludeMissing
                fun _keyName(): JsonField<String> = keyName

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
                     * Returns a mutable builder for constructing an instance of [InnerCmek].
                     *
                     * The following fields are required:
                     * ```java
                     * .keyName()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [InnerCmek]. */
                class Builder internal constructor() {

                    private var keyName: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(innerCmek: InnerCmek) = apply {
                        keyName = innerCmek.keyName
                        additionalProperties = innerCmek.additionalProperties.toMutableMap()
                    }

                    /** The name of the CMEK key in use. */
                    fun keyName(keyName: String) = keyName(JsonField.of(keyName))

                    /**
                     * Sets [Builder.keyName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.keyName] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [InnerCmek].
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
                    fun build(): InnerCmek =
                        InnerCmek(
                            checkRequired("keyName", keyName),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): InnerCmek = apply {
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
                @JvmSynthetic
                internal fun validity(): Int = (if (keyName.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is InnerCmek &&
                        keyName == other.keyName &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(keyName, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "InnerCmek{keyName=$keyName, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Cmek &&
                    cmek == other.cmek &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(cmek, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Cmek{cmek=$cmek, additionalProperties=$additionalProperties}"
        }
    }

    @JsonDeserialize(using = Index.Deserializer::class)
    @JsonSerialize(using = Index.Serializer::class)
    class Index
    private constructor(
        private val upToDate: JsonValue? = null,
        private val updating: IndexUpdating? = null,
        private val _json: JsonValue? = null,
    ) {

        fun upToDate(): Optional<JsonValue> = Optional.ofNullable(upToDate)

        fun updating(): Optional<IndexUpdating> = Optional.ofNullable(updating)

        fun isUpToDate(): Boolean = upToDate != null

        fun isUpdating(): Boolean = updating != null

        fun asUpToDate(): JsonValue = upToDate.getOrThrow("upToDate")

        fun asUpdating(): IndexUpdating = updating.getOrThrow("updating")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                upToDate != null -> visitor.visitUpToDate(upToDate)
                updating != null -> visitor.visitUpdating(updating)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Index = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUpToDate(upToDate: JsonValue) {
                        upToDate.let {
                            if (it != JsonValue.from(mapOf("status" to "up-to-date"))) {
                                throw TurbopufferInvalidDataException(
                                    "'upToDate' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitUpdating(updating: IndexUpdating) {
                        updating.validate()
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
                    override fun visitUpToDate(upToDate: JsonValue) =
                        upToDate.let {
                            if (it == JsonValue.from(mapOf("status" to "up-to-date"))) 1 else 0
                        }

                    override fun visitUpdating(updating: IndexUpdating) = updating.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Index && upToDate == other.upToDate && updating == other.updating
        }

        override fun hashCode(): Int = Objects.hash(upToDate, updating)

        override fun toString(): String =
            when {
                upToDate != null -> "Index{upToDate=$upToDate}"
                updating != null -> "Index{updating=$updating}"
                _json != null -> "Index{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Index")
            }

        companion object {

            @JvmStatic
            fun ofUpToDate() = Index(upToDate = JsonValue.from(mapOf("status" to "up-to-date")))

            @JvmStatic fun ofUpdating(updating: IndexUpdating) = Index(updating = updating)
        }

        /** An interface that defines how to map each variant of [Index] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitUpToDate(upToDate: JsonValue): T

            fun visitUpdating(updating: IndexUpdating): T

            /**
             * Maps an unknown variant of [Index] to a value of type [T].
             *
             * An instance of [Index] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws TurbopufferInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw TurbopufferInvalidDataException("Unknown Index: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Index>(Index::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Index {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { Index(upToDate = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<IndexUpdating>())?.let {
                                Index(updating = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Index(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Index>(Index::class) {

            override fun serialize(
                value: Index,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.upToDate != null -> generator.writeObject(value.upToDate)
                    value.updating != null -> generator.writeObject(value.updating)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Index")
                }
            }
        }

        class IndexUpdating
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val status: JsonValue,
            private val unindexedBytes: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
                @JsonProperty("unindexed_bytes")
                @ExcludeMissing
                unindexedBytes: JsonField<Long> = JsonMissing.of(),
            ) : this(status, unindexedBytes, mutableMapOf())

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("updating")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

            /**
             * The number of bytes in the namespace that are in the write-ahead log but have not yet
             * been indexed.
             *
             * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun unindexedBytes(): Long = unindexedBytes.getRequired("unindexed_bytes")

            /**
             * Returns the raw JSON value of [unindexedBytes].
             *
             * Unlike [unindexedBytes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("unindexed_bytes")
            @ExcludeMissing
            fun _unindexedBytes(): JsonField<Long> = unindexedBytes

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
                 * Returns a mutable builder for constructing an instance of [IndexUpdating].
                 *
                 * The following fields are required:
                 * ```java
                 * .unindexedBytes()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [IndexUpdating]. */
            class Builder internal constructor() {

                private var status: JsonValue = JsonValue.from("updating")
                private var unindexedBytes: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(indexUpdating: IndexUpdating) = apply {
                    status = indexUpdating.status
                    unindexedBytes = indexUpdating.unindexedBytes
                    additionalProperties = indexUpdating.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("updating")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun status(status: JsonValue) = apply { this.status = status }

                /**
                 * The number of bytes in the namespace that are in the write-ahead log but have not
                 * yet been indexed.
                 */
                fun unindexedBytes(unindexedBytes: Long) =
                    unindexedBytes(JsonField.of(unindexedBytes))

                /**
                 * Sets [Builder.unindexedBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.unindexedBytes] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun unindexedBytes(unindexedBytes: JsonField<Long>) = apply {
                    this.unindexedBytes = unindexedBytes
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
                 * Returns an immutable instance of [IndexUpdating].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .unindexedBytes()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): IndexUpdating =
                    IndexUpdating(
                        status,
                        checkRequired("unindexedBytes", unindexedBytes),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): IndexUpdating = apply {
                if (validated) {
                    return@apply
                }

                _status().let {
                    if (it != JsonValue.from("updating")) {
                        throw TurbopufferInvalidDataException("'status' is invalid, received $it")
                    }
                }
                unindexedBytes()
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
                status.let { if (it == JsonValue.from("updating")) 1 else 0 } +
                    (if (unindexedBytes.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is IndexUpdating &&
                    status == other.status &&
                    unindexedBytes == other.unindexedBytes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(status, unindexedBytes, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "IndexUpdating{status=$status, unindexedBytes=$unindexedBytes, additionalProperties=$additionalProperties}"
        }
    }

    /** The schema of the namespace. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Schema && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Schema{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceMetadata &&
            approxLogicalBytes == other.approxLogicalBytes &&
            approxRowCount == other.approxRowCount &&
            createdAt == other.createdAt &&
            encryption == other.encryption &&
            index == other.index &&
            schema == other.schema &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            approxLogicalBytes,
            approxRowCount,
            createdAt,
            encryption,
            index,
            schema,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceMetadata{approxLogicalBytes=$approxLogicalBytes, approxRowCount=$approxRowCount, createdAt=$createdAt, encryption=$encryption, index=$index, schema=$schema, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
