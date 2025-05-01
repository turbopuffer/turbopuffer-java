plugins {
    id("turbopuffer.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":turbopuffer-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.turbopuffer.example.Main"
}
