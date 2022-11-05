package com.mindera.people.android.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.navigation.NavHostController

interface Navigator {
    fun hasBackStack(): Boolean
    fun goBack()

    fun navigateToSettingsScreen()
}

class NavigatorImpl(
    private val context: Context,
    private val controller: NavHostController
): Navigator {
    override fun hasBackStack(): Boolean =
        controller.previousBackStackEntry != null

    override fun goBack() {
        controller.navigateUp()
    }

    override fun navigateToSettingsScreen() {
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
