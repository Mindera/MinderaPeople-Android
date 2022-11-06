package com.mindera.people.android.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.navigation.NavHostController
import com.mindera.people.android.ui.auth.AUTH_ROUTE
import com.mindera.people.android.ui.home.HOME_ROUTE

interface Navigator {
    fun hasBackStack(): Boolean
    fun goBack()

    /** pop-up from to current screen to the Home screen. */
    fun getBackHome()

    fun navigateToAuthentication()

    fun openSystemAppSettings()
}

class NavigatorImpl(
    private val context: Context,
    private val controller: NavHostController
) : Navigator {
    override fun hasBackStack(): Boolean = controller.previousBackStackEntry != null
    override fun goBack() { controller.navigateUp() }

    override fun getBackHome() {
        controller.popBackStack(route = HOME_ROUTE, inclusive = false)
    }

    override fun navigateToAuthentication() {
        controller.popBackStack(route = AUTH_ROUTE, inclusive = false)
    }

    override fun openSystemAppSettings() {
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.parse("package:${context.packageName}")
        ).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(this)
        }
    }
}
