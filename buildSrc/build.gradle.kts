plugins {
    `kotlin-dsl`
    // buildSrc itself stays on 2.2.x because `kotlin-dsl` pins its scripts to
    // languageVersion 1.8, which Kotlin 2.3 no longer supports. The main
    // project uses 2.3.x via the kotlin-gradle-plugin dependency below.
    kotlin("jvm") version "2.2.21"
    id("com.vanniktech.maven.publish") version "0.28.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.21")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.28.0")
}
