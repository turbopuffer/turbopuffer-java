plugins {
    id("turbopuffer.kotlin")
    id("turbopuffer.publish")
}

dependencies {
    api(project(":turbopuffer-java-client-okhttp"))
}

// Redefine `dokkaJavadoc` to:
// - Depend on the root project's task for merging the docs of all the projects
// - Forward that task's output to this task's output
//
// Taken from OpenAI's Java client: https://github.com/openai/openai-java/blob/28e23c9ed1110ad6216e3d83c8be5cfae0de09ae/openai-java/build.gradle.kts
tasks.named("dokkaJavadoc").configure {
    actions.clear()

    val dokkaJavadocCollector = rootProject.tasks["dokkaJavadocCollector"]
    dependsOn(dokkaJavadocCollector)

    val outputDirectory = project.layout.buildDirectory.dir("dokka/javadoc")
    doLast {
        copy {
            from(dokkaJavadocCollector.outputs.files)
            into(outputDirectory)
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }

    outputs.dir(outputDirectory)
}
