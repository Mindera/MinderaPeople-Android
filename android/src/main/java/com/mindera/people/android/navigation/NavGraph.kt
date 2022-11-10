package com.mindera.people.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mindera.people.android.ui.auth.AUTH_ROUTE
import com.mindera.people.android.ui.auth.AuthRoute
import com.mindera.people.android.ui.home.HOME_ROUTE
import com.mindera.people.android.ui.home.HomeRoute
import com.mindera.people.user.UserRepository
import org.koin.androidx.compose.get

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController(),
    userRepository: UserRepository = get()
) {
    val context = LocalContext.current
    val navigator = remember(controller) { NavigatorImpl(context, controller) }

    val start = if (userRepository.authenticated != null) HOME_ROUTE else AUTH_ROUTE

    NavHost(
        navController = controller,
        startDestination = start,
        modifier = modifier
    ) {
        composable(AUTH_ROUTE) {
            AuthRoute(
                navigator = navigator,
                navBackStackEntry = it
            )
        }

        composable(HOME_ROUTE) {
            HomeRoute(
                navigator = navigator,
                navBackStackEntry = it
            )
        }
    }
}
