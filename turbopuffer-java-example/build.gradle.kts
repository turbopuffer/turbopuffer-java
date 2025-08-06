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
    // Use `./gradlew :turbopuffer-java-example:run` to run `Main`
    // Use `./gradlew :turbopuffer-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.turbopuffer.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
