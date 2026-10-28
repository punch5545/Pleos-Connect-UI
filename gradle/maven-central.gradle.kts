import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.jvm.tasks.Jar

// Kotlin API 선언과 실제 소스 문서를 포함합니다. 빈 Javadoc 대체물이 아닙니다.
val apiDocumentationJar = tasks.register<Jar>("apiDocumentationJar") {
    dependsOn(rootProject.tasks.named("generateApiDocumentation"))
    archiveClassifier.set("javadoc")
    from(rootProject.file("PUBLIC_API.md"))
    from(rootProject.file("README.md"))
    from(rootProject.file("AAOS_INTEGRATION.md"))
    from(rootProject.file("SPEC_DECISIONS.md"))
    from(rootProject.file("LICENSE"))
    from(rootProject.file("THIRD_PARTY_NOTICES.md"))
    from(rootProject.layout.buildDirectory.dir("api-docs/${project.name}"))
}

configure<PublishingExtension> {
    publications.withType<MavenPublication>().configureEach {
        artifact(apiDocumentationJar)
        pom {
            name.set("Pleos Connect UI - ${project.name}")
            description.set(
                "Kotlin and Jetpack Compose UI library for AAOS, based on the supplied Pleos Connect design snapshot."
            )
            url.set("https://github.com/punch5545/Pleos-Connect-UI")
            licenses {
                license {
                    name.set(providers.gradleProperty("pomLicenseName"))
                    url.set(providers.gradleProperty("pomLicenseUrl"))
                    distribution.set("repo")
                }
                if (project.name == "pleos-tokens") {
                    license {
                        name.set("SIL Open Font License 1.1")
                        url.set("https://github.com/punch5545/Pleos-Connect-UI/blob/v${project.version}/docs/assets/fonts/OFL.txt")
                        distribution.set("repo")
                    }
                }
            }
            developers {
                developer {
                    id.set("punch5545")
                    name.set("Mouser__")
                    url.set("https://github.com/punch5545")
                }
            }
            scm {
                url.set("https://github.com/punch5545/Pleos-Connect-UI")
                connection.set("scm:git:https://github.com/punch5545/Pleos-Connect-UI.git")
                developerConnection.set("scm:git:ssh://git@github.com/punch5545/Pleos-Connect-UI.git")
                tag.set("v${project.version}")
            }
        }
    }
}
