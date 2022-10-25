package com.mindera.people.android.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Auth : Screen("auth_screen")
    object Home : Screen("home_screen")
}