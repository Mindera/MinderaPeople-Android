package com.mindera.people

import android.app.Application
import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.LogcatWriter
import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import co.touchlab.kermit.crashlytics.CrashlyticsLogWriter
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

@OptIn(ExperimentalKermitApi::class)
fun startSdk(app: Application, appModule: Module = module {  }) {
    initKoin {
        modules(
            module {
                single<Context> { app }
                val baseLogger = Logger(
                    config = LoggerConfig.default.copy(
                        logWriterList = listOf(LogcatWriter(), CrashlyticsLogWriter())
                    ),
                    tag = "MinderaPeople"
                )
                factory { (tag: String?) -> tag?.let { baseLogger.withTag(it) } ?: baseLogger }
            }
            + appModule
        )
    }
}

actual val platformModule: Module = module {
    single<Settings>(named(encryptedSettings)) {
        SharedPreferencesSettings(
            delegate = EncryptedSharedPreferences.create(
                get(),
                ENCRYPTED_STORAGE_NAME,
                MasterKey.Builder(get())
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            ),
            commit = false
        )
    }
    single<Settings>(named(unencryptedSettings)) {
        SharedPreferencesSettings.Factory(get()).create(name = STORAGE_NAME)
    }
}
