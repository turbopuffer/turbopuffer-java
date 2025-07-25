// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.ExcludeMissing
import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.Params
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.immutableEmptyMap
import com.turbopuffer.core.toImmutable
import com.turbopuffer.errors.TurbopufferInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update namespace schema. */
class NamespaceUpdateSchemaParams
private constructor(
    private val namespace: String?,
    private val schema: Schema?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /** The desired schema for the namespace. */
    fun schema(): Optional<Schema> = Optional.ofNullable(schema)

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        schema?._additionalProperties() ?: immutableEmptyMap()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceUpdateSchemaParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [NamespaceUpdateSchemaParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpdateSchemaParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var schema: Schema? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceUpdateSchemaParams: NamespaceUpdateSchemaParams) = apply {
            namespace = namespaceUpdateSchemaParams.namespace
            schema = namespaceUpdateSchemaParams.schema
            additionalHeaders = namespaceUpdateSchemaParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceUpdateSchemaParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /** The desired schema for the namespace. */
        fun schema(schema: Schema?) = apply { this.schema = schema }

        /** Alias for calling [Builder.schema] with `schema.orElse(null)`. */
        fun schema(schema: Optional<Schema>) = schema(schema.getOrNull())

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
         * Returns an immutable instance of [NamespaceUpdateSchemaParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceUpdateSchemaParams =
            NamespaceUpdateSchemaParams(
                namespace,
                schema,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Optional<Schema> = Optional.ofNullable(schema)

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The desired schema for the namespace. */
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

        return /* spotless:off */ other is NamespaceUpdateSchemaParams && namespace == other.namespace && schema == other.schema && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(namespace, schema, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "NamespaceUpdateSchemaParams{namespace=$namespace, schema=$schema, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
