// Deserializers for sealed classes in CustomTypes.kt
// This file complements the code-generated CustomTypes.kt

package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.fasterxml.jackson.module.kotlin.readValue
import com.turbopuffer.core.BaseDeserializer

// Helper function to convert JsonNode to Any
private fun JsonNode.toAny(): Any? =
    when {
        isBoolean -> booleanValue()
        isInt -> intValue()
        isLong -> longValue()
        isDouble -> doubleValue()
        isFloat -> floatValue()
        isTextual -> textValue()
        isArray -> elements().asSequence().map { it.toAny() }.toList()
        isObject -> fields().asSequence().associate { it.key to it.value.toAny() }
        isNull -> null
        else -> throw IllegalArgumentException("Cannot convert JsonNode to Any: $nodeType")
    }

// Filter Deserializer
internal class FilterDeserializer : BaseDeserializer<Filter>(Filter::class) {
    override fun ObjectCodec.deserialize(node: JsonNode): Filter {
        if (!node.isArray) {
            throw IllegalArgumentException("Filter must be an array, got: ${node.nodeType}")
        }

        val elements = node.elements().asSequence().toList()
        if (elements.isEmpty()) {
            throw IllegalArgumentException("Filter array cannot be empty")
        }

        // Determine f0 position based on array structure
        // Most filters have @JsonPropertyOrder("attr", "f0", "value") so f0 is at index 1
        // But some have @JsonPropertyOrder("f0", "filters") so f0 is at index 0
        val f0: String
        val f0Index: Int

        // Check if first element is a known filter type (And, Or, Not) - these have f0 at index 0
        if (elements[0].isTextual) {
            val firstText = elements[0].asText()
            if (firstText == "And" || firstText == "Or" || firstText == "Not") {
                f0 = firstText
                f0Index = 0
            } else if (elements.size > 1 && elements[1].isTextual) {
                // f0 is at index 1 for most filters (attr, f0, value)
                f0 = elements[1].asText()
                f0Index = 1
            } else {
                throw IllegalArgumentException("Cannot find filter discriminator (f0) in array")
            }
        } else if (elements.size > 1 && elements[1].isTextual) {
            f0 = elements[1].asText()
            f0Index = 1
        } else {
            throw IllegalArgumentException("Cannot find filter discriminator (f0) in array")
        }

        return when (f0) {
            "And" -> {
                require(f0Index == 0 && elements.size >= 2) { "FilterAnd requires [f0, filters]" }
                val filters =
                    elements[1].map { filterNode ->
                        readValue(treeAsTokens(filterNode), jacksonTypeRef<Filter>())
                    }
                FilterAnd.create(filters)
            }
            "Or" -> {
                require(f0Index == 0 && elements.size >= 2) { "FilterOr requires [f0, filters]" }
                val filters =
                    elements[1].map { filterNode ->
                        readValue(treeAsTokens(filterNode), jacksonTypeRef<Filter>())
                    }
                FilterOr.create(filters)
            }
            "Not" -> {
                require(f0Index == 0 && elements.size >= 2) { "FilterNot requires [f0, filter]" }
                val filter = readValue(treeAsTokens(elements[1]), jacksonTypeRef<Filter>())
                FilterNot.create(filter)
            }
            "Eq" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterEq requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                // Extract the value - use toAny() to get the primitive/Kotlin type
                // FilterEq.create() will convert it to JsonValue internally
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterEq.create(attr, value)
            }
            "NotEq" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotEq requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterNotEq.create(attr, value)
            }
            "In" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterIn requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].map {
                        it.toAny()
                            ?: throw IllegalArgumentException(
                                "Null values not allowed in In filter"
                            )
                    }
                FilterIn.create(attr, value)
            }
            "NotIn" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotIn requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].map {
                        it.toAny()
                            ?: throw IllegalArgumentException(
                                "Null values not allowed in NotIn filter"
                            )
                    }
                FilterNotIn.create(attr, value)
            }
            "Contains" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterContains requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterContains.create(attr, value)
            }
            "NotContains" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotContains requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterNotContains.create(attr, value)
            }
            "ContainsAny" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterContainsAny requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].map {
                        it.toAny()
                            ?: throw IllegalArgumentException(
                                "Null values not allowed in ContainsAny filter"
                            )
                    }
                FilterContainsAny.create(attr, value)
            }
            "NotContainsAny" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotContainsAny requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].map {
                        it.toAny()
                            ?: throw IllegalArgumentException(
                                "Null values not allowed in NotContainsAny filter"
                            )
                    }
                FilterNotContainsAny.create(attr, value)
            }
            "Lt" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterLt requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterLt.create(attr, value)
            }
            "Lte" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterLte requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterLte.create(attr, value)
            }
            "Gt" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterGt requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterGt.create(attr, value)
            }
            "Gte" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterGte requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterGte.create(attr, value)
            }
            "AnyLt" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterAnyLt requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterAnyLt.create(attr, value)
            }
            "AnyLte" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterAnyLte requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterAnyLte.create(attr, value)
            }
            "AnyGt" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterAnyGt requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterAnyGt.create(attr, value)
            }
            "AnyGte" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterAnyGte requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value =
                    elements[2].toAny() ?: throw IllegalArgumentException("Value cannot be null")
                FilterAnyGte.create(attr, value)
            }
            "Glob" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterGlob requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value = elements[2].asText()
                FilterGlob.create(attr, value)
            }
            "NotGlob" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotGlob requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value = elements[2].asText()
                FilterNotGlob.create(attr, value)
            }
            "IGlob" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterIGlob requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value = elements[2].asText()
                FilterIGlob.create(attr, value)
            }
            "NotIGlob" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterNotIGlob requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value = elements[2].asText()
                FilterNotIGlob.create(attr, value)
            }
            "Regex" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterRegex requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val value = elements[2].asText()
                FilterRegex.create(attr, value)
            }
            "ContainsAllTokens" -> {
                require(f0Index == 1) { "FilterContainsAllTokens requires f0 at index 1" }
                val attr = elements[0].asText()
                val valueNode = elements[2]

                // Find params - it should be the last object element after value
                // Params can be at index 3 (for 4 elements) or later
                val paramsIndex = elements.indexOfFirst { it.isObject && it.size() > 0 }
                val hasParams = paramsIndex >= 3 && paramsIndex < elements.size

                when {
                    // Has params (4+ elements with a non-empty object after value)
                    hasParams -> {
                        val params =
                            readValue(
                                treeAsTokens(elements[paramsIndex]),
                                jacksonTypeRef<ContainsAllTokensFilterParams>(),
                            )
                        if (valueNode.isArray) {
                            val value = valueNode.map { it.asText() }
                            FilterContainsAllTokensArrayWithParams.create(attr, value, params)
                        } else {
                            val value = valueNode.asText()
                            FilterContainsAllTokensWithParams.create(attr, value, params)
                        }
                    }
                    // No params (3 elements: attr, f0, value) OR params is empty {}
                    else -> {
                        if (valueNode.isArray) {
                            val value = valueNode.map { it.asText() }
                            FilterContainsAllTokensArray.create(attr, value)
                        } else {
                            val value = valueNode.asText()
                            FilterContainsAllTokens.create(attr, value)
                        }
                    }
                }
            }
            "ContainsTokenSequence" -> {
                require(f0Index == 1 && elements.size >= 3) {
                    "FilterContainsTokenSequence requires [attr, f0, value]"
                }
                val attr = elements[0].asText()
                val valueNode = elements[2]
                if (valueNode.isArray) {
                    val value = valueNode.map { it.asText() }
                    FilterContainsTokenSequenceArray.create(attr, value)
                } else {
                    val value = valueNode.asText()
                    FilterContainsTokenSequence.create(attr, value)
                }
            }
            else -> throw IllegalArgumentException("Unknown filter type: $f0")
        }
    }
}

// AggregateBy Deserializer
internal class AggregateByDeserializer : BaseDeserializer<AggregateBy>(AggregateBy::class) {
    override fun ObjectCodec.deserialize(node: JsonNode): AggregateBy {
        if (!node.isArray) {
            throw IllegalArgumentException("AggregateBy must be an array, got: ${node.nodeType}")
        }

        val elements = node.elements().asSequence().toList()
        if (elements.isEmpty()) {
            throw IllegalArgumentException("AggregateBy array cannot be empty")
        }

        val f0 = elements[0].asText()

        return when (f0) {
            "Count" -> {
                if (elements.size == 1) {
                    AggregateByCount.create()
                } else {
                    val attr = elements[1].asText()
                    AggregateByCountDeprecated.create(attr)
                }
            }
            "Sum" -> {
                require(elements.size >= 2) { "AggregateBySum requires [f0, attr]" }
                val attr = elements[1].asText()
                AggregateBySum.create(attr)
            }
            else -> throw IllegalArgumentException("Unknown AggregateBy type: $f0")
        }
    }
}

// Expr Deserializer
internal class ExprDeserializer : BaseDeserializer<Expr>(Expr::class) {
    override fun ObjectCodec.deserialize(node: JsonNode): Expr {
        if (!node.isObject) {
            throw IllegalArgumentException("Expr must be an object, got: ${node.nodeType}")
        }

        // ExprRefNew has @JsonProperty("\$ref_new")
        if (node.has("\$ref_new")) {
            val refNew = node.get("\$ref_new").asText()
            return ExprRefNew.create(refNew)
        }

        throw IllegalArgumentException("Unknown Expr type")
    }
}

// RankBy and RankByText deserializers removed due to complex inheritance issues
// TODO: Re-implement with proper understanding of the class hierarchy
