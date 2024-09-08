plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    id ("kotlin-kapt")
    kotlin("plugin.serialization") version "2.0.0"
    id ("com.google.dagger.hilt.android") version ("2.50") apply false
}

android {
    namespace = "com.example.chat.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.chat.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    // Compose dependencies
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.androidx.navigation.compose)

    // Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    // Coroutine Lifecycle Scopes
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // Dagger - Hilt
    implementation (libs.hilt.android)
    //noinspection UseTomlInstead
    kapt ("com.google.dagger:hilt-android-compiler:2.37")
    implementation (libs.androidx.hilt.lifecycle.viewmodel)
    kapt (libs.androidx.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)

    // Ktor
    implementation (libs.ktor.client.core)
    implementation (libs.ktor.client.cio)
    implementation (libs.ktor.client.serialization)
    implementation (libs.ktor.client.websockets)
    implementation (libs.ktor.client.logging)
    //noinspection UseTomlInstead
    implementation ("ch.qos.logback:logback-classic:1.4.14")

    implementation (libs.kotlinx.serialization.json)
}