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
import com.turbopuffer.core.Params
import com.turbopuffer.core.checkRequired
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Copy all documents from another namespace into this one. */
class NamespaceCopyFromParams
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
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sourceNamespace(): String = body.sourceNamespace()

    /**
     * (Optional) An API key for the organization containing the source namespace
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceApiKey(): Optional<String> = body.sourceApiKey()

    /**
     * (Optional) The region of the source namespace.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceRegion(): Optional<String> = body.sourceRegion()

    /**
     * Returns the raw JSON value of [sourceNamespace].
     *
     * Unlike [sourceNamespace], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceNamespace(): JsonField<String> = body._sourceNamespace()

    /**
     * Returns the raw JSON value of [sourceApiKey].
     *
     * Unlike [sourceApiKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceApiKey(): JsonField<String> = body._sourceApiKey()

    /**
     * Returns the raw JSON value of [sourceRegion].
     *
     * Unlike [sourceRegion], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceRegion(): JsonField<String> = body._sourceRegion()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceCopyFromParams].
         *
         * The following fields are required:
         * ```java
         * .sourceNamespace()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceCopyFromParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceCopyFromParams: NamespaceCopyFromParams) = apply {
            namespace = namespaceCopyFromParams.namespace
            body = namespaceCopyFromParams.body.toBuilder()
            additionalHeaders = namespaceCopyFromParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceCopyFromParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [sourceNamespace]
         * - [sourceApiKey]
         * - [sourceRegion]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The namespace to copy documents from. */
        fun sourceNamespace(sourceNamespace: String) = apply {
            body.sourceNamespace(sourceNamespace)
        }

        /**
         * Sets [Builder.sourceNamespace] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceNamespace] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceNamespace(sourceNamespace: JsonField<String>) = apply {
            body.sourceNamespace(sourceNamespace)
        }

        /** (Optional) An API key for the organization containing the source namespace */
        fun sourceApiKey(sourceApiKey: String) = apply { body.sourceApiKey(sourceApiKey) }

        /**
         * Sets [Builder.sourceApiKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceApiKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceApiKey(sourceApiKey: JsonField<String>) = apply {
            body.sourceApiKey(sourceApiKey)
        }

        /** (Optional) The region of the source namespace. */
        fun sourceRegion(sourceRegion: String) = apply { body.sourceRegion(sourceRegion) }

        /**
         * Sets [Builder.sourceRegion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceRegion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceRegion(sourceRegion: JsonField<String>) = apply {
            body.sourceRegion(sourceRegion)
        }

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
         * Returns an immutable instance of [NamespaceCopyFromParams].
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
        fun build(): NamespaceCopyFromParams =
            NamespaceCopyFromParams(
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

    class Body
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
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sourceNamespace(): String = sourceNamespace.getRequired("source_namespace")

        /**
         * (Optional) An API key for the organization containing the source namespace
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sourceApiKey(): Optional<String> = sourceApiKey.getOptional("source_api_key")

        /**
         * (Optional) The region of the source namespace.
         *
         * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sourceRegion(): Optional<String> = sourceRegion.getOptional("source_region")

        /**
         * Returns the raw JSON value of [sourceNamespace].
         *
         * Unlike [sourceNamespace], this method doesn't throw if the JSON field has an unexpected
         * type.
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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .sourceNamespace()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sourceNamespace: JsonField<String>? = null
            private var sourceApiKey: JsonField<String> = JsonMissing.of()
            private var sourceRegion: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sourceNamespace = body.sourceNamespace
                sourceApiKey = body.sourceApiKey
                sourceRegion = body.sourceRegion
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The namespace to copy documents from. */
            fun sourceNamespace(sourceNamespace: String) =
                sourceNamespace(JsonField.of(sourceNamespace))

            /**
             * Sets [Builder.sourceNamespace] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceNamespace] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceNamespace(sourceNamespace: JsonField<String>) = apply {
                this.sourceNamespace = sourceNamespace
            }

            /** (Optional) An API key for the organization containing the source namespace */
            fun sourceApiKey(sourceApiKey: String) = sourceApiKey(JsonField.of(sourceApiKey))

            /**
             * Sets [Builder.sourceApiKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceApiKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceApiKey(sourceApiKey: JsonField<String>) = apply {
                this.sourceApiKey = sourceApiKey
            }

            /** (Optional) The region of the source namespace. */
            fun sourceRegion(sourceRegion: String) = sourceRegion(JsonField.of(sourceRegion))

            /**
             * Sets [Builder.sourceRegion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceRegion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             *
             * The following fields are required:
             * ```java
             * .sourceNamespace()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("sourceNamespace", sourceNamespace),
                    sourceApiKey,
                    sourceRegion,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
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

            return other is Body &&
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
            "Body{sourceNamespace=$sourceNamespace, sourceApiKey=$sourceApiKey, sourceRegion=$sourceRegion, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceCopyFromParams &&
            namespace == other.namespace &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(namespace, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "NamespaceCopyFromParams{namespace=$namespace, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
