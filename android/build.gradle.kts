plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.googleServices)
    id(BuildPlugins.firebaseCrashlytics)
}

repositories {
    google()
    mavenCentral()
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    compileSdk = 33
    buildToolsVersion = "33.0.0"

    defaultConfig {
        applicationId = "org.mindera.peopleandroid"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "2.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("./keys/debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    composeOptions {
        // kotlinCompilerVersion = kotlinVersion
        kotlinCompilerExtensionVersion = composeCompilerVersion
    }

    testOptions.unitTests.isIncludeAndroidResources = true

    buildFeatures {
        compose = true

        // disable unused AGP features
        // buildConfig false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources.excludes.add("META-INF/common.kotlin_module")
        resources.excludes.add("META-INF/*.kotlin_module")

        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")

        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += listOf(
            "-Xallow-jvm-ir-dependencies",
            "-Xskip-prerelease-check",
            //"-P",
            //"plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
        )
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":core"))

    implementation(Dependencies.kotlinJdk)
    implementation(Dependencies.kotlinCoroutinesAndroid)

    implementation(Dependencies.koinAndroid)

    implementation(Dependencies.androidXAppCompact)
    implementation(Dependencies.androidXCoreKtx)

    implementation(Dependencies.composeCompiler)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUITooling)
    implementation(Dependencies.composeMaterialDesign)
    implementation(Dependencies.composeMaterialIconsCore)
    implementation(Dependencies.composeMaterialIconsExtended)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.composeRuntime)
 // androidTestImplementation(Dependencies.composeUITests)

 // implementation(platform(Dependencies.firebaseBoM))
 // implementation(Dependencies.firebaseAnalytics)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.androidCoreTesting)

    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.androidExpressoCore)
}