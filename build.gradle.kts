plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

repositories {
    mavenCentral()
}

allprojects {
    group = "com.turbopuffer"
    version = "0.1.0-beta.7" // x-release-please-version
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

// Avoid race conditions between `dokkaJavadocCollector` and `dokkaJavadocJar` tasks.
//
// Taken from OpenAI's Java client: https://github.com/openai/openai-java/blob/28e23c9ed1110ad6216e3d83c8be5cfae0de09ae/build.gradle.kts
tasks.named("dokkaJavadocCollector").configure {
    subprojects.flatMap { it.tasks }
        .filter { it.project.name != "turbopuffer-java" && it.name == "dokkaJavadocJar" }
        .forEach { mustRunAfter(it) }
}
