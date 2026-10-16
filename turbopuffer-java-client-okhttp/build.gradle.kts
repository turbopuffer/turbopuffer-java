plugins {
    id("turbopuffer.kotlin")
    id("turbopuffer.publish")
}

dependencies {
    api(project(":turbopuffer-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
}

// The client fills in request timings through the core module's internal observer API.
tasks.named<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileKotlin") {
    friendPaths.from(project(":turbopuffer-java-core").layout.buildDirectory.dir("classes/kotlin/main"))
}
