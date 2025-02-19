plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

allprojects {
    group = "com.turbopuffer"
    version = "0.1.0-beta.2" // x-release-please-version

    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jetbrains.dokka")
}
