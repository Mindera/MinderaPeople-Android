package com.mindera.people.android

import android.app.Application
import com.mindera.people.android.ui.auth.AuthViewModel
import com.mindera.people.android.ui.home.HomeViewModel
import com.mindera.people.startSdk
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

class MinderaPeopleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startSdk(
            app = this@MinderaPeopleApp,
            appModule = module {
                viewModelOf(::AuthViewModel)
                viewModelOf(::HomeViewModel)
            })
    }
}
