package scripts

plugins {
    kotlin("multiplatform") apply false
    id("com.android.library")
}

android {
    namespace = "com.mindera.people"

    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
     // publishAllLibraryVariants()
    }

    sourceSets {
        val androidMain by getting {
            kotlin.srcDir("src/androidMain/kotlin")
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(Dependencies.androidSecurityCrypto)
                implementation(Dependencies.androidXAnnotation)
                implementation(Dependencies.ktorClientOkHttp)
                implementation(Dependencies.androidViewModel)
                implementation("io.ktor:ktor-client-android:2.1.3")
                implementation(Dependencies.androidViewModelSavedState)
                implementation(Dependencies.koinAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation(Dependencies.mockative)
                implementation(Dependencies.robolectric)
            }
        }
    }
}