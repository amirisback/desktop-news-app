import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}


group = "com.frogobox"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven { url = uri("https://jitpack.io") }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")

                implementation("com.google.code.gson:gson:2.8.8")
                implementation("com.github.nazmulidris:color-console:1.0.0")

                implementation("com.squareup.okhttp3:okhttp:4.9.1")
                implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

                implementation("com.squareup.retrofit2:retrofit:2.9.0")
                implementation("com.squareup.retrofit2:converter-gson:2.9.0")
                implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
                implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

                implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
                implementation("io.reactivex.rxjava2:rxjava:2.2.21")

                implementation("io.ktor:ktor-client-core:1.6.4")
                implementation("io.ktor:ktor-client-cio:1.6.4")
                implementation("io.ktor:ktor-client-json:1.6.4")
                implementation("io.ktor:ktor-client-logging:1.6.4")
                implementation("io.ktor:ktor-client-serialization:1.6.4")

                implementation("co.touchlab:kermit:0.1.8")

                implementation("io.insert-koin:koin-core:3.1.2")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "CaravanDesktopCompose"
            packageVersion = "1.0.0"
        }
    }
}