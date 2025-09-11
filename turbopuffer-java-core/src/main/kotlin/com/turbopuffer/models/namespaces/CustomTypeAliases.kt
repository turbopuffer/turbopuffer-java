package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.JsonValue

typealias NamespaceSchemaResponse = Schema

typealias NamespaceUpdateSchemaResponse = Schema

typealias Id = JsonValue

// Schema, Row, and Columns are morally type aliases for Map<String,
// AttributeSchemaConfig>, Map<String, JsonValue>, and Map<String,
// List<JsonValue>>, respectively, but we implement them as subclasses in order
// to provide a builder API for convenient construction.

/** A schema for a namespace. */
class Schema : LinkedHashMap<String, AttributeSchemaConfig> {
    constructor(initialCapacity: Int) : super(initialCapacity)

    @JsonCreator constructor(original: Map<out String, AttributeSchemaConfig>) : super(original)

    /** Turns this [Schema] into a [Builder]. */
    fun toBuilder() = Builder().from(this)

    companion object {
        /**
         * Returns a mutable builder for constructing a new [Schema], initialized with the same
         * attributes as this [Schema].
         */
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private var attributes = LinkedHashMap<String, AttributeSchemaConfig>()

        @JvmSynthetic
        internal fun from(schema: Schema) = apply { attributes = LinkedHashMap(schema) }

        /** Adds an attribute to the schema. */
        fun put(key: String, value: AttributeSchemaConfig) = apply { attributes.put(key, value) }

        /** Adds all attributes from the map to the schema. */
        fun putAll(attributes: Map<String, AttributeSchemaConfig>) = apply {
            attributes.forEach { put(it.key, it.value) }
        }

        /** Removes the given attribute from the schema. */
        fun remove(key: String) = apply { attributes.remove(key) }

        /** Removes the specified attributes from the schema. */
        fun removeAll(keys: Set<String>) = apply { keys.forEach(::remove) }

        /** Returns an instance of [Schema]. */
        fun build() = Schema(attributes)
    }
}

/** A single document, in a row-based format. */
class Row : LinkedHashMap<String, JsonValue> {
    constructor(initialCapacity: Int) : super(initialCapacity)

    @JsonCreator constructor(original: Map<out String, JsonValue>) : super(original)

    /** Turns this [Row] into a [Builder]. */
    fun toBuilder() = Builder().from(this)

    companion object {
        /**
         * Returns a mutable builder for constructing a new [Row], initialized with the same
         * attributes as this [Row].
         */
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private var attributes = LinkedHashMap<String, JsonValue>()

        @JvmSynthetic internal fun from(row: Row) = apply { attributes = LinkedHashMap(row) }

        /** Adds a key-value pair to the row. */
        fun put(key: String, value: Any?) = apply { attributes.put(key, JsonValue.from(value)) }

        /** Adds all key-value pairs from the map to the row. */
        fun putAll(attributes: Map<String, Any?>) = apply {
            attributes.forEach { put(it.key, it.value) }
        }

        /** Removes the entry for the given key from the row. */
        fun remove(key: String) = apply { attributes.remove(key) }

        /** Removes all entries for the given keys from the row. */
        fun removeAll(keys: Set<String>) = apply { keys.forEach(::remove) }

        /** Returns an instance of [Row]. */
        fun build() = Row(attributes)
    }
}

/**
 * An aggregation group is just a Row without an ID field.
 *
 * In other languages we need a separate type for that, but in Java, we don't enforce that Rows have
 * an ID field, so we can just reuse the Row type directly for simplicity.
 */
typealias AggregationGroup = Row

/**
 * A list of documents in columnar format. Each key is a column name, mapped to an array of values
 * for that column.
 */
class Columns : HashMap<String, List<JsonValue>> {
    constructor(initialCapacity: Int) : super(initialCapacity)

    @JsonCreator constructor(original: Map<out String, List<JsonValue>>) : super(original)

    /** Turns this [Columns] into a [Builder]. */
    fun toBuilder() = Builder().from(this)

    companion object {
        /**
         * Returns a mutable builder for constructing a new [Columns], initialized with the same
         * attributes as this [Columns].
         */
        @JvmStatic fun builder() = Builder()
    }

    class Builder {
        private var attributes = LinkedHashMap<String, List<JsonValue>>()

        @JvmSynthetic
        internal fun from(columns: Columns) = apply { attributes = LinkedHashMap(columns) }

        /** Adds an entry for the given column to the [Columns]. */
        fun put(key: String, value: List<Any?>) = apply {
            attributes.put(key, value.map { JsonValue.from(it) })
        }

        /** Adds all the specified columns to the [Columns]. */
        fun putAll(attributes: Map<String, List<Any?>>) = apply {
            attributes.forEach { put(it.key, it.value) }
        }

        /** Removes the given column. */
        fun remove(key: String) = apply { attributes.remove(key) }

        /** Removes all of the specified columns. */
        fun removeAll(keys: Set<String>) = apply { keys.forEach(::remove) }

        /** Returns an instance of [Columns]. */
        fun build() = Columns(attributes)
    }
}
