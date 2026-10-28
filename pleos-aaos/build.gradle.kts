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
    // AGP 9.4.1의 공개 DSL 타입으로 조회하여 legacy SourceSet bridge를 피합니다.
    (this as com.android.build.api.dsl.LibraryExtension).sourceSets.getByName("main")
        .assets.srcDir(rootProject.layout.buildDirectory.dir("license-assets").get().asFile)
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
