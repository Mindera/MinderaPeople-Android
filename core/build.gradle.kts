plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id(BuildPlugins.googleKsp).version(kspVersion)
    id(BuildPlugins.detekt).version(detektVersion)
    id(BuildPlugins.kermit)
}

group = "com.mindera"
version = "2.0.0"

repositories {
    google()
    mavenCentral()
}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                progressiveMode = true
                experimentalAnnotations.forEach { optIn(it) }
                //  languageVersion = "1.6" // possible values: '1.0', '1.1', .., '1.6'
                //  apiVersion = "1.6" // possible values: '1.0', .., '1.6'
                //  enableLanguageFeature("InlineClasses") // language feature name
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Dependencies.kotlinCoroutinesCore)
                implementation(Dependencies.kotlinDateTime)
                implementation(Dependencies.kotlinSerializationJson)
                implementation(Dependencies.ktorClientCore)
                implementation(Dependencies.koinCore)
                implementation(Dependencies.multiplatformSettings)
                implementation(Dependencies.multiplatformSettingsSerialization)
                implementation(Dependencies.kermit)
                implementation(Dependencies.kermitCrashlytics)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(Dependencies.kotlinCoroutinesTest)
                implementation(Dependencies.mockative)
                implementation(Dependencies.turbine)
            }
        }
    }

    sourceSets.matching { it.name.endsWith("Test") }
        .configureEach {
            languageSettings.optIn("kotlin.RequiresOptIn")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
}

dependencies {
    ksp(Dependencies.mockativeProcessor)
}

apply(plugin = ScriptPlugins.kmmAndroid)
apply(plugin = ScriptPlugins.kmmIoS)