package com.mindera.people.android.ui.user

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mindera.people.android.navigation.AppNavigator
import com.mindera.people.android.navigation.Navigator

// region Keys
const val USER_ROUTE = "user"
// internal Feature Rotes
private const val USER_EDIT_ROUTE = "user/edit"
// endregion

// region Routes
@Composable
fun UserRoute(
    navigator: Navigator,
    navBackStackEntry: NavBackStackEntry
) {
    UserNavGraph(navigator)
}
// endregion

// region Navigator
interface UserNavigator : Navigator {
    fun navigateToUserEditScreen()
}

class UserNavigatorImpl(
    private val context: Context,
    private val navigator: Navigator,
    private val controller: NavHostController
) : UserNavigator, Navigator by AppNavigator(context, controller) {

    override fun navigateToUserEditScreen() {
        controller.navigate(USER_EDIT_ROUTE)
    }
}
// endregion

// region NavGraph
@Composable
fun UserNavGraph(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController(),
    startDestination: String = USER_ROUTE
) {
    val context = LocalContext.current
    val userNavigator = remember(controller) { UserNavigatorImpl(context, navigator, controller) }

    NavHost(
        navController = controller,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(USER_ROUTE) {
            UserScreen(navigator)
        }

        composable(USER_EDIT_ROUTE) {
            UserEditScreen(userNavigator)
        }
    }
}
// endregion
