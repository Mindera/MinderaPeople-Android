package com.mindera.people.android.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.mindera.people.android.navigation.Navigator

/** The Home route id for the App Navigation Graph. */
const val HOME_ROUTE = "home"

@Composable
fun HomeRoute(
    navigator: Navigator,
    navBackStackEntry: NavBackStackEntry
) {
    // This allows you to define specific Routes to the Home screen, by:
    // - device screen size (portrait, landscape, tablet size, etc.)
    // - device screen density
    // - other device/system configuration

    HomeScreen(navigator)
}

// Define here the internal feature navigation
// that can be not exposed on the main [NavGraph]
