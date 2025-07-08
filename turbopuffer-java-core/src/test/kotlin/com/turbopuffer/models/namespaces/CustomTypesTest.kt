package com.turbopuffer.models.namespaces

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomTypesTest {

    // We're not trying to exhaustively test JSON serialization of custom types
    // here. We're just doing a basic sanity check that these custom types have
    // usable toString() methods, which allows users to print/log/debug them.

    @Test
    fun filterToString() {
        val filter = Filter.and(Filter.eq("attr1", "value1"), Filter.eq("attr2", "value2"))
        assertThat(filter.toString())
            .isEqualTo("""["And",[["attr1","Eq","value1"],["attr2","Eq","value2"]]]""")
    }

    @Test
    fun rankByToString() {
        val rankBy = RankByText.product(2.0, RankByText.bm25("attr1", "quick brown fox"))
        assertThat(rankBy.toString())
            .isEqualTo("""["Product",[2.0,["attr1","BM25","quick brown fox"]]]""")
    }
}
