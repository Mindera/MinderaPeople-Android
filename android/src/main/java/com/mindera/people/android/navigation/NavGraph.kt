package com.mindera.people.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mindera.people.android.ui.home.HOME_ROUTE
import com.mindera.people.android.ui.home.HomeRoute

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController(),
    startDestination: String = HOME_ROUTE
) {
    val context = LocalContext.current
    val navigator = remember(controller) { NavigatorImpl(context, controller) }

    NavHost(
        navController = controller,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HOME_ROUTE) {
            HomeRoute(
                navigator = navigator,
                navBackStackEntry = it
            )
        }
    }
}
