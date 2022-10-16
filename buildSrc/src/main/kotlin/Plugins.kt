object GradlePlugins {
    const val android = "com.android.tools.build:gradle:7.3.1"

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"

    const val googleServices = "com.google.gms:google-services:4.3.13"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.9.2"

    const val kermit = "co.touchlab:kermit-gradle-plugin:$kermitVersion"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
 // const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"

    const val detekt = "io.gitlab.arturbosch.detekt"

    const val googleKsp = "com.google.devtools.ksp"
    const val googleServices = "com.google.gms.google-services"
    const val firebaseCrashlytics = "com.google.firebase.crashlytics"

    const val kermit = "co.touchlab.kermit"
}

object ScriptPlugins {
    const val kmmAndroid = "scripts.kmm_android"
    const val kmmIoS = "scripts.kmm_ios"
}
