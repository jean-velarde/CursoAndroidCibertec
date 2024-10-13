plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinxSerialization)
}

android {
    namespace = "com.jeancarlo.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jeancarlo.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation("io.ktor:ktor-client-core:2.3.4")       // Core de Ktor Client
    implementation("io.ktor:ktor-client-okhttp:2.3.4")     // Cliente OkHttp para Android
    implementation("io.ktor:ktor-client-serialization:2.3.4") // Serialización JSON
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4") // Serialización Kotlinx-JSON
    implementation("io.ktor:ktor-client-content-negotiation:2.3.4") // Plugin de negociación de contenido
    implementation("com.squareup.picasso:picasso:2.71828") //picasso
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}