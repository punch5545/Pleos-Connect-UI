plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

allprojects {
    group = "io.github.punch5545"
    version = "0.1.0"
}

tasks.register<Sync>("prepareLicenseAssets") {
    from("LICENSE", "NOTICE", "THIRD_PARTY_NOTICES.md")
    into(layout.buildDirectory.dir("license-assets/pleos/licenses"))
}

tasks.register<Exec>("generateApiDocumentation") {
    inputs.file("tools/generate_api_docs.py")
    inputs.file("build.gradle.kts")
    inputs.files(fileTree("pleos-tokens/src/main/java"), fileTree("pleos-compose/src/main/java"), fileTree("pleos-aaos/src/main/java"))
    outputs.file("PUBLIC_API.md")
    outputs.dir(layout.buildDirectory.dir("api-docs"))
    commandLine("python3", "tools/generate_api_docs.py")
}
