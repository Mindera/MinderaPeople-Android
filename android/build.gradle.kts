plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.googleServices)
    id(BuildPlugins.firebaseCrashlytics)
    id(BuildPlugins.firebaseDistribution)
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
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false

            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        // Alpha will be published via Firebase Distribution for QA testing
        create("alpha").initWith(buildTypes.getByName("release"))
        getByName("alpha") {
            isDebuggable = true

            applicationIdSuffix = ".alpha"
            versionNameSuffix = "-alpha"
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks.add("release")

            firebaseAppDistribution {
                groups = "alpha-group"
                serviceCredentialsFile = System.getenv("FB_DIST_FILE")
            }
        }

        // Beta will be published via Firebase Distribution for Staging testing
        create("beta").initWith(buildTypes.getByName("release"))
        getByName("beta") {
            isDebuggable = true

            applicationIdSuffix = ".beta"
            versionNameSuffix = "-beta"
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks.add("release")

            firebaseAppDistribution {
                groups = "beta-group"
                serviceCredentialsFile = System.getenv("FB_DIST_FILE")
            }
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
            "-Xskip-prerelease-check"
        )
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":core"))

    implementation(Dependencies.kotlinJdk)
    implementation(Dependencies.kotlinCoroutinesAndroid)

    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.koinCompose)

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
    implementation(Dependencies.composeLottie)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.googleAuth)
    implementation(Dependencies.composeLiveData)

    // androidTestImplementation(Dependencies.composeUITests)

 // implementation(platform(Dependencies.firebaseBoM))
 // implementation(Dependencies.firebaseAnalytics)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.androidCoreTesting)

    androidTestImplementation(Dependencies.androidTestRunner)
    androidTestImplementation(Dependencies.androidJunit)
    androidTestImplementation(Dependencies.androidExpressoCore)
}