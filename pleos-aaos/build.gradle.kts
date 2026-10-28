plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    useLibrary("android.car", false)
    namespace = "com.jade.pleos.aaos"
    compileSdk { version = release(37) }
    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    publishing { singleVariant("release") { withSourcesJar() } }
}

kotlin { compilerOptions { jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11) } }

dependencies {
    implementation("androidx.lifecycle:lifecycle-runtime:2.9.3")
    api(project(":pleos-compose"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.runner)
}

publishing {
    repositories { maven { name = "projectLocal"; url = uri(rootProject.layout.buildDirectory.dir("maven")) } }
    publications {
        register<MavenPublication>("release") {
            artifactId = "pleos-aaos"
            afterEvaluate { from(components["release"]) }
        }
    }
}

apply(from = rootProject.file("gradle/maven-central.gradle.kts"))
