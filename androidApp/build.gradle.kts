plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)

    // KSP plugin (comes from libs.versions.toml)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.hathway.kmm_basic_app.android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.hathway.kmm_basic_app.android"
        minSdk = 24
        targetSdk = 35
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

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    debugImplementation(libs.compose.ui.tooling)

    // Lifecycle & Navigation
    implementation(libs.compose.livedata)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.ktx)

    // Other UI
    implementation(libs.constraintlayout.compose)
    implementation(libs.coil.compose)
    implementation(libs.material.icons.extended)

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)   // ✅ Room compiler with KSP

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Testing
    implementation(libs.kotlin.test)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    testImplementation(kotlin("test"))
}
