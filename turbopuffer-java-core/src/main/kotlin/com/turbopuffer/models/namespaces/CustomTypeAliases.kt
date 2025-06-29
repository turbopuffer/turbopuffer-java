package com.turbopuffer.models.namespaces

import com.turbopuffer.core.JsonValue

typealias Row = MutableMap<String, JsonValue>

typealias Columns = MutableMap<String, List<JsonValue>>

typealias Schema = MutableMap<String, AttributeSchemaConfig>

typealias NamespaceSchemaResponse = Schema
