plugins {
    id("turbopuffer.kotlin")
    id("java")
    application
}

dependencies {
    implementation(project(":turbopuffer-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(11)
}

application {
    mainClass = "com.turbopuffer.example.${project.property("com.turbopuffer.example")}"
}
