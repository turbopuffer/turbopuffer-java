package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue

typealias Row = Map<String, JsonValue>

typealias Columns = Map<String, List<JsonValue>>

typealias Schema = Map<String, AttributeSchemaConfig>

typealias NamespaceSchemaResponse = Schema

typealias NamespaceUpdateSchemaResponse = Schema
