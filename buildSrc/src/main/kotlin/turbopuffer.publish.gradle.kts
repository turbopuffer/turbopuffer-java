plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("turbopuffer API")
                description.set("turbopuffer is a fast search engine that combines vector and full-text search\nusing object storage.")
                url.set("https://turbopuffer.com/docs")

                licenses {
                    license {
                        name.set("MIT")
                    }
                }

                developers {
                    developer {
                        name.set("Turbopuffer")
                        email.set("info@turbopuffer.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/turbopuffer-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/turbopuffer-java.git")
                    url.set("https://github.com/stainless-sdks/turbopuffer-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
