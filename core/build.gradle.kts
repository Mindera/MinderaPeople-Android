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
                optIn("kotlin.ExperimentalUnsignedTypes") // annotation FQ-name
                //  languageVersion = "1.7" // possible values: '1.4', '1.5', .., '1.7'
                //  apiVersion = "1.7" // possible values: '1.3', .., '1.7'
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
                implementation(Dependencies.ktorClientLogging)
                implementation(Dependencies.ktorClientContentNegotiation)
                implementation(Dependencies.ktorSerialization)
                implementation(Dependencies.multiplatformSettings)
                implementation(Dependencies.multiplatformSettingsSerialization)
                implementation(Dependencies.kermit)
                implementation(Dependencies.kermitCrashlytics)
                api(Dependencies.koinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(Dependencies.kotlinCoroutinesTest)
                implementation(Dependencies.multiplatformSettingsTest)
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

// Workaround for https://youtrack.jetbrains.com/issue/KT-51970
afterEvaluate {
    afterEvaluate {
        tasks.configureEach {
            if (
                name.startsWith("compile")
                && name.endsWith("KotlinMetadata")
            ) {
                println("disabling $this:$name")
                enabled = false
            }
        }
    }
}

dependencies {
//    configurations
//        .filter { it.name.startsWith("ksp") && it.name.contains("Test") }
//        .forEach {
//            add(it.name, Dependencies.mockativeProcessor)
//        }
    ksp(Dependencies.mockativeProcessor)
}

apply(plugin = ScriptPlugins.kmmAndroid)
apply(plugin = ScriptPlugins.kmmIoS)