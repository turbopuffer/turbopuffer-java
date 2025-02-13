plugins {
    id("turbopuffer.kotlin")
    id("turbopuffer.publish")
}

dependencies {
    api(project(":turbopuffer-java-client-okhttp"))
}
