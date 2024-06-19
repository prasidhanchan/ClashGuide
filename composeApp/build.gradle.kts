import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)

            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            // Ktor
            api(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.serializatiom)

            // Koin
            api(libs.koin.core)
            implementation(libs.koin.compose)

            // Coil
            api(libs.coil.compose.core)
            implementation(libs.coil)
            implementation(libs.coil.compose)
            implementation(libs.coil.network)

            // Lifecycle ViewModel
            implementation(libs.lifecycle.viewmodel)

            // Navigation compose
            implementation(libs.navigation.compose)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.preview)
            implementation(compose.components.uiToolingPreview)
        }
        desktopMain.dependencies {
            // Kotlin coroutines
            implementation(libs.kotlinx.coroutines)

            // Logger
            implementation(libs.slf4j.logger)
            implementation(libs.logback.classic)

            implementation(compose.desktop.currentOs)
            implementation(compose.preview)
        }
    }
    task("testClasses")
}

android {
    namespace = "com.clash.guide.app"
    compileSdk = ProjectConfig.compileSdkVersion

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.clash.guide.app"
        minSdk = ProjectConfig.minSdkVersion
        targetSdk = ProjectConfig.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Exe, TargetFormat.Deb)
            packageName = "com.clash.guide.app"
            packageVersion = "1.0.0"
        }
    }
}
