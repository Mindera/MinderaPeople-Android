package com.mindera.people.android.navigation

interface Navigator {
    fun hasBackStack(): Boolean

    fun goBack()

    fun navigateToHome()

    fun navigateToAuthentication()

    fun openSystemAppSettings()
}
