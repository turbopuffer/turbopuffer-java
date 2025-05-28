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

/** The result of a query. */
class NamespaceQueryResponse
private constructor(
    private val billing: JsonField<QueryBilling>,
    private val performance: JsonField<QueryPerformance>,
    private val aggregations: JsonField<List<Aggregation>>,
    private val rows: JsonField<List<DocumentRow>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billing")
        @ExcludeMissing
        billing: JsonField<QueryBilling> = JsonMissing.of(),
        @JsonProperty("performance")
        @ExcludeMissing
        performance: JsonField<QueryPerformance> = JsonMissing.of(),
        @JsonProperty("aggregations")
        @ExcludeMissing
        aggregations: JsonField<List<Aggregation>> = JsonMissing.of(),
        @JsonProperty("rows") @ExcludeMissing rows: JsonField<List<DocumentRow>> = JsonMissing.of(),
    ) : this(billing, performance, aggregations, rows, mutableMapOf())

    /**
     * The billing information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun billing(): QueryBilling = billing.getRequired("billing")

    /**
     * The performance information for a query.
     *
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun performance(): QueryPerformance = performance.getRequired("performance")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun aggregations(): Optional<List<Aggregation>> = aggregations.getOptional("aggregations")

    /**
     * @throws TurbopufferInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rows(): Optional<List<DocumentRow>> = rows.getOptional("rows")

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing") @ExcludeMissing fun _billing(): JsonField<QueryBilling> = billing

    /**
     * Returns the raw JSON value of [performance].
     *
     * Unlike [performance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("performance")
    @ExcludeMissing
    fun _performance(): JsonField<QueryPerformance> = performance

    /**
     * Returns the raw JSON value of [aggregations].
     *
     * Unlike [aggregations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aggregations")
    @ExcludeMissing
    fun _aggregations(): JsonField<List<Aggregation>> = aggregations

    /**
     * Returns the raw JSON value of [rows].
     *
     * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<List<DocumentRow>> = rows

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
         * Returns a mutable builder for constructing an instance of [NamespaceQueryResponse].
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [NamespaceQueryResponse]. */
    class Builder internal constructor() {

        private var billing: JsonField<QueryBilling>? = null
        private var performance: JsonField<QueryPerformance>? = null
        private var aggregations: JsonField<MutableList<Aggregation>>? = null
        private var rows: JsonField<MutableList<DocumentRow>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(namespaceQueryResponse: NamespaceQueryResponse) = apply {
            billing = namespaceQueryResponse.billing
            performance = namespaceQueryResponse.performance
            aggregations = namespaceQueryResponse.aggregations.map { it.toMutableList() }
            rows = namespaceQueryResponse.rows.map { it.toMutableList() }
            additionalProperties = namespaceQueryResponse.additionalProperties.toMutableMap()
        }

        /** The billing information for a query. */
        fun billing(billing: QueryBilling) = billing(JsonField.of(billing))

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [QueryBilling] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billing(billing: JsonField<QueryBilling>) = apply { this.billing = billing }

        /** The performance information for a query. */
        fun performance(performance: QueryPerformance) = performance(JsonField.of(performance))

        /**
         * Sets [Builder.performance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.performance] with a well-typed [QueryPerformance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun performance(performance: JsonField<QueryPerformance>) = apply {
            this.performance = performance
        }

        fun aggregations(aggregations: List<Aggregation>) = aggregations(JsonField.of(aggregations))

        /**
         * Sets [Builder.aggregations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aggregations] with a well-typed `List<Aggregation>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun aggregations(aggregations: JsonField<List<Aggregation>>) = apply {
            this.aggregations = aggregations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Aggregation] to [aggregations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAggregation(aggregation: Aggregation) = apply {
            aggregations =
                (aggregations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("aggregations", it).add(aggregation)
                }
        }

        fun rows(rows: List<DocumentRow>) = rows(JsonField.of(rows))

        /**
         * Sets [Builder.rows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rows] with a well-typed `List<DocumentRow>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rows(rows: JsonField<List<DocumentRow>>) = apply {
            this.rows = rows.map { it.toMutableList() }
        }

        /**
         * Adds a single [DocumentRow] to [rows].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRow(row: DocumentRow) = apply {
            rows = (rows ?: JsonField.of(mutableListOf())).also { checkKnown("rows", it).add(row) }
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
         * Returns an immutable instance of [NamespaceQueryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .billing()
         * .performance()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): NamespaceQueryResponse =
            NamespaceQueryResponse(
                checkRequired("billing", billing),
                checkRequired("performance", performance),
                (aggregations ?: JsonMissing.of()).map { it.toImmutable() },
                (rows ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NamespaceQueryResponse = apply {
        if (validated) {
            return@apply
        }

        billing().validate()
        performance().validate()
        aggregations().ifPresent { it.forEach { it.validate() } }
        rows().ifPresent { it.forEach { it.validate() } }
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
            (performance.asKnown().getOrNull()?.validity() ?: 0) +
            (aggregations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (rows.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    class Aggregation
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

            /** Returns a mutable builder for constructing an instance of [Aggregation]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Aggregation]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(aggregation: Aggregation) = apply {
                additionalProperties = aggregation.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Aggregation].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Aggregation = Aggregation(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Aggregation = apply {
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

            return /* spotless:off */ other is Aggregation && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Aggregation{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is NamespaceQueryResponse && billing == other.billing && performance == other.performance && aggregations == other.aggregations && rows == other.rows && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(billing, performance, aggregations, rows, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "NamespaceQueryResponse{billing=$billing, performance=$performance, aggregations=$aggregations, rows=$rows, additionalProperties=$additionalProperties}"
}
