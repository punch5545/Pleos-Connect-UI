plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
}

android {
    namespace = "com.jade.pleos.tokens"
    compileSdk { version = release(37) }
    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures { compose = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    publishing { singleVariant("release") { withSourcesJar() } }
    // AGP 9.4.1의 공개 DSL 타입으로 조회하여 legacy SourceSet bridge를 피합니다.
    (this as com.android.build.api.dsl.LibraryExtension).sourceSets.getByName("main")
        .assets.srcDir(rootProject.layout.buildDirectory.dir("license-assets").get().asFile)
}

kotlin { compilerOptions { jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11) } }

dependencies {
    api(libs.compose.runtime)
    api(libs.compose.ui)
    androidTestImplementation(libs.compose.ui.test.junit4)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.runner)
}

publishing {
    repositories { maven { name = "projectLocal"; url = uri(rootProject.layout.buildDirectory.dir("maven")) } }
    publications {
        register<MavenPublication>("release") {
            artifactId = "pleos-tokens"
            afterEvaluate { from(components["release"]) }
        }
    }
}

apply(from = rootProject.file("gradle/maven-central.gradle.kts"))
