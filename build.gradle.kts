plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

allprojects {
    group = "com.turbopuffer"
    version = "0.1.0-beta.4" // x-release-please-version
}

// Separate block from above to avoid merge conflicts with Stainless.
allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jetbrains.dokka")
}
