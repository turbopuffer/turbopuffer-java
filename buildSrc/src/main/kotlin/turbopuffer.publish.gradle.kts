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
                description.set("turbopuffer is a fast search engine that combines vector and full-text search\nusing object storage. This API allows you to manage namespaces and perform\ndocument operations (upsert, and delete) as well as query documents.")
                url.set("https://docs.turbopuffer.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Turbopuffer")
                        email.set("dev-feedback@turbopuffer.com")
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
