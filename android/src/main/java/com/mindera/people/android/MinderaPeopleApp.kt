package com.mindera.people.android

import android.app.Application
import com.mindera.people.startSdk

class MinderaPeopleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startSdk(this@MinderaPeopleApp)
    }
}
