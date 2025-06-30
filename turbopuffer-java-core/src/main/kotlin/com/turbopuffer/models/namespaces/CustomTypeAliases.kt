package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.annotation.JsonCreator
import com.turbopuffer.core.JsonValue

typealias Schema = Map<String, AttributeSchemaConfig>

typealias NamespaceSchemaResponse = Schema

typealias NamespaceUpdateSchemaResponse = Schema

typealias Id = JsonValue

// Row and Columns are morally type aliases for Map<String, JsonValue> and
// Map<String, List<JsonValue>>, respectively, but we implement them as
// subclasses in order to provide a builder API for convenient construction.

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
