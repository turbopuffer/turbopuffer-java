plugins {
    `kotlin-dsl`
    kotlin("jvm") version "2.1.10"
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:7.0.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.10")
}
