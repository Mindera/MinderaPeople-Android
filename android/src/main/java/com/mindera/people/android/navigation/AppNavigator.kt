package com.mindera.people.android.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.navigation.NavHostController
import com.mindera.people.android.ui.auth.AUTH_ROUTE
import com.mindera.people.android.ui.home.HOME_ROUTE


class AppNavigator(
    private val context: Context,
    private val controller: NavHostController
) : Navigator {

    override fun hasBackStack(): Boolean = controller.previousBackStackEntry != null

    override fun goBack() {
        controller.navigateUp()
    }

    override fun navigateToHome() {
        controller.navigate(route = HOME_ROUTE) {
            popUpTo(AUTH_ROUTE) { inclusive = true }
            launchSingleTop = true
        }
    }

    override fun navigateToAuthentication() {
        controller.navigate(route = AUTH_ROUTE) {
            popUpTo(HOME_ROUTE) { inclusive = true }
            launchSingleTop = true
        }
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