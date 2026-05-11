plugins {
    id("turbopuffer.kotlin")
    id("turbopuffer.publish")
}

configurations.all {
    resolutionStrategy {
        // Compile and test against a lower Jackson version to ensure we're compatible with it. Note that
        // we generally support 2.13.4, but test against 2.14.0 because 2.13.4 has some annoying (but
        // niche) bugs (users should upgrade if they encounter them). We publish with a higher version
        // (see below) to ensure users depend on a secure version by default.
        force("com.fasterxml.jackson.core:jackson-core:2.14.0")
        force("com.fasterxml.jackson.core:jackson-databind:2.14.0")
        force("com.fasterxml.jackson.core:jackson-annotations:2.14.0")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.14.0")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.0")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")
    }
}

// Extracts the nested `class Query` out of NamespaceMultiQueryParams.kt and
// promotes it to a top-level `Query` class in the same package, so that Java
// callers can refer to it as `com.turbopuffer.models.namespaces.Query`. Done at
// build time to avoid divergence from the Stainless-generated source on disk.
val extractQueryClass by tasks.registering {
    val mainSrc = file("src/main/kotlin/com/turbopuffer/models/namespaces/NamespaceMultiQueryParams.kt")
    val outDir = layout.buildDirectory.dir("generated/sources/extractQueryClass")

    inputs.file(mainSrc)
    outputs.dir(outDir)

    doLast {
        val mainOut = outDir.get().dir("main/kotlin/com/turbopuffer/models/namespaces").asFile
        mainOut.mkdirs()

        val lines = mainSrc.readLines()

        // Find `    class Query` (4-space indent inside NamespaceMultiQueryParams).
        val classIdx = lines.indexOfFirst { it == "    class Query" }
        check(classIdx >= 0) { "Could not find `    class Query` in ${mainSrc.name}" }

        // Walk back to the previous blank line to capture the doc comment.
        var startIdx = classIdx
        while (startIdx > 0 && lines[startIdx - 1].isNotBlank()) startIdx--

        // Walk forward to the first line that is exactly `    }` — the close brace
        // at the nested-class indent level.
        val endIdx = (classIdx until lines.size).firstOrNull { lines[it] == "    }" }
            ?: error("Could not find closing `    }` for class Query")

        // Carry over the package and imports from the source file.
        val packageLine = lines.first { it.startsWith("package ") }
        val importLines = lines.filter { it.startsWith("import ") }

        // De-indent the extracted block by 4 spaces.
        val classBlock = lines.subList(startIdx, endIdx + 1)
            .map { if (it.startsWith("    ")) it.substring(4) else it }

        mainOut.resolve("Query.kt").writeText(buildString {
            appendLine("// Extracted at build time from NamespaceMultiQueryParams.kt — see build.gradle.kts.")
            appendLine()
            appendLine(packageLine)
            appendLine()
            importLines.forEach { appendLine(it) }
            appendLine()
            classBlock.forEach { appendLine(it) }
        })

        // Rewrite NamespaceMultiQueryParams.kt: replace the Query block with a
        // nested typealias pointing at the now-top-level Query, so that any
        // existing `NamespaceMultiQueryParams.Query` references (e.g. in
        // Stainless-generated tests) keep resolving without further patching.
        val replacement = listOf(
            "    /** @see com.turbopuffer.models.namespaces.Query */",
            "    typealias Query = com.turbopuffer.models.namespaces.Query",
        )
        val rewrittenLines = lines.subList(0, startIdx) + replacement + lines.subList(endIdx + 1, lines.size)
        val rewritten = rewrittenLines.joinToString("\n") + "\n"
        // Use a distinct filename so the source-set `exclude` pattern targeting
        // the original NamespaceMultiQueryParams.kt doesn't also exclude this one.
        mainOut.resolve("NamespaceMultiQueryParamsRewritten.kt").writeText(rewritten)
    }
}

tasks.named("compileKotlin") { dependsOn(extractQueryClass) }
tasks.named("compileTestKotlin") { dependsOn(extractQueryClass) }
tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach { dependsOn(extractQueryClass) }
tasks.withType<Jar>().configureEach { dependsOn(extractQueryClass) }

kotlin {
    sourceSets {
        main {
            kotlin {
                // These files are obsoleted by custom code. Ignoring them like
                // this rather than removing them from the tree minimizes
                // Stainless-generated conflicts.
                exclude("com/turbopuffer/models/namespaces/AggregationGroup.kt")
                exclude("com/turbopuffer/models/namespaces/AttributeSchema.kt")
                exclude("com/turbopuffer/models/namespaces/Columns.kt")
                exclude("com/turbopuffer/models/namespaces/Id.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceSchemaResponse.kt")
                exclude("com/turbopuffer/models/namespaces/Row.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceUpdateSchemaResponse.kt")
                // Replaced by the build-time extractQueryClass task.
                exclude("com/turbopuffer/models/namespaces/NamespaceMultiQueryParams.kt")
                srcDir(layout.buildDirectory.dir("generated/sources/extractQueryClass/main/kotlin"))
            }
        }

        test {
            kotlin {
                exclude("com/turbopuffer/models/namespaces/AggregationGroupTest.kt")
                exclude("com/turbopuffer/models/namespaces/AttributeSchemaTest.kt")
                exclude("com/turbopuffer/models/namespaces/ColumnsTest.kt")
                exclude("com/turbopuffer/models/namespaces/IdTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceBranchFromResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceCopyFromResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceMultiQueryParamsTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceMultiQueryResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceExplainQueryParamsTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceExplainQueryResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceQueryParamsTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceQueryResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceSchemaResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceUpdateSchemaParamsTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceUpdateSchemaResponseTest.kt")
                exclude("com/turbopuffer/models/namespaces/NamespaceWriteParamsTest.kt")
                exclude("com/turbopuffer/models/namespaces/QueryTest.kt")
                exclude("com/turbopuffer/models/namespaces/RowTest.kt")
            }
        }
    }
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-core:2.18.2")
    api("com.fasterxml.jackson.core:jackson-databind:2.18.2")
    api("com.google.errorprone:error_prone_annotations:2.33.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.18.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")

    testImplementation(kotlin("test"))
    testImplementation(project(":turbopuffer-java-client-okhttp"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
