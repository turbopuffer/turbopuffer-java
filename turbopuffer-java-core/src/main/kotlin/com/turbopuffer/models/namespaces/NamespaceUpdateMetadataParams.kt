// File generated from our OpenAPI spec by Stainless.

package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue
import com.turbopuffer.core.Params
import com.turbopuffer.core.http.Headers
import com.turbopuffer.core.http.QueryParams
import com.turbopuffer.core.immutableEmptyMap
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Update metadata configuration for a namespace. */
class NamespaceUpdateMetadataParams
private constructor(
    private val namespace: String?,
    private val namespaceMetadataPatch: NamespaceMetadataPatch?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun namespace(): Optional<String> = Optional.ofNullable(namespace)

    /** Request to update namespace metadata configuration. */
    fun namespaceMetadataPatch(): Optional<NamespaceMetadataPatch> =
        Optional.ofNullable(namespaceMetadataPatch)

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        namespaceMetadataPatch?._additionalProperties() ?: immutableEmptyMap()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): NamespaceUpdateMetadataParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [NamespaceUpdateMetadataParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceUpdateMetadataParams]. */
    class Builder internal constructor() {

        private var namespace: String? = null
        private var namespaceMetadataPatch: NamespaceMetadataPatch? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(namespaceUpdateMetadataParams: NamespaceUpdateMetadataParams) = apply {
            namespace = namespaceUpdateMetadataParams.namespace
            namespaceMetadataPatch = namespaceUpdateMetadataParams.namespaceMetadataPatch
            additionalHeaders = namespaceUpdateMetadataParams.additionalHeaders.toBuilder()
            additionalQueryParams = namespaceUpdateMetadataParams.additionalQueryParams.toBuilder()
        }

        fun namespace(namespace: String?) = apply { this.namespace = namespace }

        /** Alias for calling [Builder.namespace] with `namespace.orElse(null)`. */
        fun namespace(namespace: Optional<String>) = namespace(namespace.getOrNull())

        /** Request to update namespace metadata configuration. */
        fun namespaceMetadataPatch(namespaceMetadataPatch: NamespaceMetadataPatch?) = apply {
            this.namespaceMetadataPatch = namespaceMetadataPatch
        }

        /**
         * Alias for calling [Builder.namespaceMetadataPatch] with
         * `namespaceMetadataPatch.orElse(null)`.
         */
        fun namespaceMetadataPatch(namespaceMetadataPatch: Optional<NamespaceMetadataPatch>) =
            namespaceMetadataPatch(namespaceMetadataPatch.getOrNull())

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
         * Returns an immutable instance of [NamespaceUpdateMetadataParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): NamespaceUpdateMetadataParams =
            NamespaceUpdateMetadataParams(
                namespace,
                namespaceMetadataPatch,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Optional<NamespaceMetadataPatch> = Optional.ofNullable(namespaceMetadataPatch)

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> namespace ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is NamespaceUpdateMetadataParams &&
            namespace == other.namespace &&
            namespaceMetadataPatch == other.namespaceMetadataPatch &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(namespace, namespaceMetadataPatch, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "NamespaceUpdateMetadataParams{namespace=$namespace, namespaceMetadataPatch=$namespaceMetadataPatch, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
