package com.turbopuffer.models.namespaces

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.turbopuffer.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomTypesRoundtripTest {

    private val jsonMapper = jsonMapper()

    // ========== Filter Tests ==========

    @Test
    fun filterEqRoundtrip() {
        val filter = Filter.eq("attr1", "value1")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun filterNotEqRoundtrip() {
        val filter = Filter.notEq("attr1", 42)
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterInRoundtrip() {
        val filter = Filter.`in`("attr1", listOf("a", "b", "c"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterAndRoundtrip() {
        val filter = Filter.and(Filter.eq("attr1", "value1"), Filter.eq("attr2", "value2"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterOrRoundtrip() {
        val filter = Filter.or(Filter.eq("attr1", "value1"), Filter.eq("attr2", "value2"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNotRoundtrip() {
        val filter = Filter.not(Filter.eq("attr1", "value1"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNestedComplexRoundtrip() {
        val filter =
            Filter.and(
                Filter.eq("attr1", "value1"),
                Filter.or(Filter.eq("attr2", "value2"), Filter.not(Filter.eq("attr3", "value3"))),
            )
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsRoundtrip() {
        val filter = Filter.contains("attr1", "substring")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsAllTokensRoundtrip() {
        val filter = Filter.containsAllTokens("attr1", "quick brown fox")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsAllTokensArrayRoundtrip() {
        val filter = Filter.containsAllTokens("attr1", listOf("quick", "brown", "fox"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsAllTokensWithParamsRoundtrip() {
        val params = ContainsAllTokensFilterParams.builder().lastAsPrefix(true).build()
        val filter = Filter.containsAllTokens("attr1", "quick brown fox", params)
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterComparisonRoundtrip() {
        val filters =
            listOf(
                Filter.lt("age", 18),
                Filter.lte("age", 18),
                Filter.gt("age", 18),
                Filter.gte("age", 18),
            )
        for (filter in filters) {
            val json = jsonMapper.writeValueAsString(filter)
            val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
            assertThat(jsonMapper.writeValueAsString(deserialized))
                .isEqualTo(jsonMapper.writeValueAsString(filter))
        }
    }

    @Test
    fun filterAnyComparisonRoundtrip() {
        val filters =
            listOf(
                Filter.anyLt("scores", 10),
                Filter.anyLte("scores", 10),
                Filter.anyGt("scores", 10),
                Filter.anyGte("scores", 10),
            )
        for (filter in filters) {
            val json = jsonMapper.writeValueAsString(filter)
            val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
            assertThat(jsonMapper.writeValueAsString(deserialized))
                .isEqualTo(jsonMapper.writeValueAsString(filter))
        }
    }

    @Test
    fun filterNotContainsRoundtrip() {
        val filter = Filter.notContains("attr1", "substring")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsAnyRoundtrip() {
        val filter = Filter.containsAny("tags", listOf("tag1", "tag2", "tag3"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNotContainsAnyRoundtrip() {
        val filter = Filter.notContainsAny("tags", listOf("tag1", "tag2"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNotInRoundtrip() {
        val filter = Filter.notIn("status", listOf("deleted", "archived"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterGlobRoundtrip() {
        val filter = Filter.glob("filename", "*.txt")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNotGlobRoundtrip() {
        val filter = Filter.notGlob("filename", "*.tmp")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterIGlobRoundtrip() {
        val filter = Filter.iGlob("filename", "*.TXT")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterNotIGlobRoundtrip() {
        val filter = Filter.notIGlob("filename", "*.TMP")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterRegexRoundtrip() {
        val filter = Filter.regex("email", "^[a-z]+@[a-z]+\\.[a-z]+$")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsAllTokensArrayWithParamsRoundtrip() {
        val params = ContainsAllTokensFilterParams.builder().lastAsPrefix(true).build()
        val filter = Filter.containsAllTokens("attr1", listOf("quick", "brown", "fox"), params)
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsTokenSequenceRoundtrip() {
        val filter = Filter.containsTokenSequence("text", "quick brown")
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterContainsTokenSequenceArrayRoundtrip() {
        val filter = Filter.containsTokenSequence("text", listOf("quick", "brown", "fox"))
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    @Test
    fun filterWithDifferentValueTypesRoundtrip() {
        // Test filters with various value types
        // Note: We compare JSON strings instead of object equality because JsonValue
        // may deserialize numbers as different Number types (Int vs Long), causing
        // equality issues even though the JSON representation is identical
        val filters =
            listOf(
                Filter.eq("string_attr", "text"),
                Filter.eq("int_attr", 42),
                Filter.eq("long_attr", 123456789L),
                Filter.eq("double_attr", 3.14),
                Filter.eq("float_attr", 2.71f),
                Filter.eq("bool_attr", true),
            )
        for (filter in filters) {
            val json = jsonMapper.writeValueAsString(filter)
            val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
            // Compare JSON strings to verify round-trip serialization works correctly
            assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
        }
    }

    @Test
    fun filterDeeplyNestedRoundtrip() {
        // Test very deeply nested filter structures
        val filter =
            Filter.and(
                Filter.eq("a", 1),
                Filter.or(
                    Filter.and(Filter.eq("b", 2), Filter.not(Filter.eq("c", 3))),
                    Filter.and(Filter.gte("d", 4), Filter.lt("e", 5)),
                ),
                Filter.not(Filter.or(Filter.contains("f", "text"), Filter.regex("g", "pattern"))),
            )
        val json = jsonMapper.writeValueAsString(filter)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Filter>())
        assertThat(jsonMapper.writeValueAsString(deserialized))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
    }

    // ========== RankBy Tests ==========

    @Test
    fun rankByVectorRoundtrip() {
        val rankBy = RankBy.vector("embedding", listOf(0.1f, 0.2f, 0.3f))
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankBy>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByAttributeRoundtrip() {
        val rankBy = RankBy.attribute("score", RankByAttributeOrder.DESC)
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankBy>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    // ========== RankByText Tests ==========

    @Test
    fun rankByTextBM25Roundtrip() {
        val rankBy = RankByText.bm25("content", "search query")
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextBM25ArrayRoundtrip() {
        val rankBy = RankByText.bm25("content", listOf("query1", "query2"))
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextBM25WithParamsRoundtrip() {
        val params = Bm25ClauseParams.builder().lastAsPrefix(true).build()
        val rankBy = RankByText.bm25("content", "search query", params)
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextSumRoundtrip() {
        val rankBy =
            RankByText.sum(RankByText.bm25("title", "query"), RankByText.bm25("body", "query"))
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextMaxRoundtrip() {
        val rankBy =
            RankByText.max(RankByText.bm25("title", "query"), RankByText.bm25("body", "query"))
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextProductRoundtrip() {
        val rankBy = RankByText.product(2.0, RankByText.bm25("content", "query"))
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextProduct2Roundtrip() {
        val rankBy = RankByText.product(RankByText.bm25("content", "query"), 2.0)
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun rankByTextNestedComplexRoundtrip() {
        val rankBy =
            RankByText.sum(
                RankByText.product(2.0, RankByText.bm25("title", "query")),
                RankByText.bm25("body", "query"),
            )
        val json = jsonMapper.writeValueAsString(rankBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<RankByText>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    // ========== AggregateBy Tests ==========

    @Test
    fun aggregateByCountRoundtrip() {
        val aggregateBy = AggregateBy.count()
        val json = jsonMapper.writeValueAsString(aggregateBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<AggregateBy>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun aggregateByCountDeprecatedRoundtrip() {
        val aggregateBy = AggregateBy.count("attr1")
        val json = jsonMapper.writeValueAsString(aggregateBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<AggregateBy>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    @Test
    fun aggregateBySumRoundtrip() {
        val aggregateBy = AggregateBy.sum("attr1")
        val json = jsonMapper.writeValueAsString(aggregateBy)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<AggregateBy>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    // ========== Expr Tests ==========

    @Test
    fun exprRefNewRoundtrip() {
        val expr = Expr.refNew("ref_name")
        val json = jsonMapper.writeValueAsString(expr)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Expr>())
        assertThat(jsonMapper.writeValueAsString(deserialized)).isEqualTo(json)
    }

    // ========== Integration Tests ==========

    @Test
    fun queryWithFilterRoundtrip() {
        val query =
            Query.builder()
                .filters(Filter.and(Filter.eq("status", "active"), Filter.gte("age", 18)))
                .topK(10L)
                .build()

        val json = jsonMapper.writeValueAsString(query)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Query>())

        // Verify the filter was deserialized correctly
        val originalFilter = query.filters().get()
        val deserializedFilter = deserialized.filters().get()
        assertThat(jsonMapper.writeValueAsString(deserializedFilter))
            .isEqualTo(jsonMapper.writeValueAsString(originalFilter))
    }

    @Test
    fun queryWithRankByRoundtrip() {
        val query =
            Query.builder()
                .rankBy(RankBy.vector("embedding", listOf(0.1f, 0.2f, 0.3f)))
                .topK(10L)
                .build()

        val json = jsonMapper.writeValueAsString(query)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Query>())

        val originalRankBy = query.rankBy().get()
        val deserializedRankBy = deserialized.rankBy().get()
        assertThat(jsonMapper.writeValueAsString(deserializedRankBy))
            .isEqualTo(jsonMapper.writeValueAsString(originalRankBy))
    }

    @Test
    fun queryWithComplexFilterAndRankByRoundtrip() {
        val filter =
            Filter.and(
                Filter.eq("category", "electronics"),
                Filter.or(Filter.gte("price", 100), Filter.contains("name", "premium")),
            )
        val rankBy =
            RankByText.sum(
                RankByText.bm25("title", "laptop"),
                RankByText.bm25("description", "laptop"),
            )

        val query = Query.builder().filters(filter).rankBy(rankBy).topK(20L).build()

        val json = jsonMapper.writeValueAsString(query)
        val deserialized = jsonMapper.readValue(json, jacksonTypeRef<Query>())

        assertThat(jsonMapper.writeValueAsString(deserialized.filters().get()))
            .isEqualTo(jsonMapper.writeValueAsString(filter))
        assertThat(jsonMapper.writeValueAsString(deserialized.rankBy().get()))
            .isEqualTo(jsonMapper.writeValueAsString(rankBy))
    }
}
