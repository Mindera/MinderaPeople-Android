/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object Dependencies {
    // region Kotlin libraries
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val kotlinCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val kotlinCoroutinesNativeMt =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesMtVersion"
    const val kotlinCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"


    // Kotlin DateTime
    const val kotlinDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$datetimeVersion"

    // Kotlin Serialization
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
    // endregion

    // region Ktor libraries
    const val ktorClientCore = "io.ktor:ktor-client-core:$ktorVersion"
    const val ktorClientOkHttp = "io.ktor:ktor-client-okhttp:$ktorVersion"
    const val ktorClientDarwin = "io.ktor:ktor-client-darwin:$ktorVersion"
    // endregion

    // region Koin libraries
    const val koinCore = "io.insert-koin:koin-core:$koinVersion"
    const val koinTest = "io.insert-koin:koin-test:$koinVersion"
    const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:$koinComposeVersion"
    // endregion

    // region Jetpack Compose libraries
    const val composeCompiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"
    const val composeUI = "androidx.compose.ui:ui:$composeVersion"

    // Tooling support (Previews, etc.)
    const val composeUITooling = "androidx.compose.ui:ui-tooling:$composeVersion"

    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    const val composeFoundation = "androidx.compose.foundation:foundation:$composeVersion"

    // Material Design
    const val composeMaterialDesign = "androidx.compose.material:material:$composeVersion"

    // Material design icons
    const val composeMaterialIconsCore =
        "androidx.compose.material:material-icons-core:$composeVersion"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:$composeVersion"

    // Compose APIs for Activity
    const val composeActivity = "androidx.activity:activity-compose:1.6.0"

    // Integration with observables
    const val composeRuntime = "androidx.compose.runtime:runtime:$composeVersion"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:$composeVersion"

    // UI tests
    const val composeUITests = "androidx.compose.ui:ui-test:$composeVersion"
    // endregion

    // region AndroidX libraries
    const val androidXAppCompact = "androidx.appcompat:appcompat:1.5.1"
    const val androidXAnnotation = "androidx.annotation:annotation:1.5.0"
    const val androidXCoreKtx = "androidx.core:core-ktx:1.9.0"
    const val androidSecurityCrypto = "androidx.security:security-crypto:1.1.0-alpha03"
    const val androidViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
    const val androidViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1"

    const val androidCoreTesting = "androidx.arch.core:core-testing:2.1.0"
    const val androidTestRunner = "androidx.test:runner:1.4.0"
    const val androidJunit = "androidx.test.ext:junit:1.1.3"
    const val androidExpressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    // endregion

    // region Firebase libraries
    const val firebaseBoM = "com.google.firebase:firebase-bom:30.5.0"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"
    // endregion

    // region google libraries
    const val googleAuth = "com.google.android.gms:play-services-auth:$googleAuthVersion"
    // endregion

    // region Misc libraries
    const val multiplatformSettings =
        "com.russhwolf:multiplatform-settings:$multiplatformSettingsVersion"
    const val multiplatformSettingsSerialization =
        "com.russhwolf:multiplatform-settings-serialization:$multiplatformSettingsVersion"
    const val multiplatformSettingsTest =
        "com.russhwolf:multiplatform-settings-test:$multiplatformSettingsVersion"

    // Logging library
    const val kermit = "co.touchlab:kermit:$kermitVersion"
    const val kermitCrashlytics = "co.touchlab:kermit-crashlytics:$kermitVersion"
    // endregion

    // region Test libraries
    const val junit = "junit:junit:4.13.2"
    const val turbine = "app.cash.turbine:turbine:0.12.0"
    const val robolectric = "org.robolectric:robolectric:4.8.1"

    // Mock library
    private const val mockativeVersion = "1.2.6"
    private const val mockkVersion = "1.12.2"
    const val mockative = "io.mockative:mockative:$mockativeVersion"
    const val mockativeProcessor = "io.mockative:mockative-processor:$mockativeVersion"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAgentJvm = "io.mockk:mockk-agent-jvm:$mockkVersion"
    // endregion
}
