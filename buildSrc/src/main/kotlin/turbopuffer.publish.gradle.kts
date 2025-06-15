import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    signAllPublications()
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("turbopuffer API")
        description.set("turbopuffer is a fast search engine that combines vector and full-text search\nusing object storage.")
        url.set("https://turbopuffer.com/docs/auth")

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
            connection.set("scm:git:git://github.com/turbopuffer/turbopuffer-java.git")
            developerConnection.set("scm:git:git://github.com/turbopuffer/turbopuffer-java.git")
            url.set("https://github.com/turbopuffer/turbopuffer-java")
        }
    }
}
