package com.mindera.people.android.ui.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mindera.people.android.navigation.Navigator

/** The Authentication route id for the App Navigation Graph. */
const val AUTH_ROUTE = "authentication"

@Composable
fun AuthRoute(
    navigator: Navigator,
    navBackStackEntry: NavBackStackEntry
) {
    // This allows you to define specific Routes to the Auth screen, by:
    // - device screen size (portrait, landscape, tablet size, etc.)
    // - device screen density
    // - other device/system configuration

    AuthScreen(navigator)
}

// Define here the internal feature navigation
// that should not be exposed on the main [NavGraph]
