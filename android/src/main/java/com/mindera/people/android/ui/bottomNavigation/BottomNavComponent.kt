package com.mindera.people.android.ui.bottomNavigation

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.touchlab.kermit.Logger
import com.mindera.people.android.ui.calendar.CalendarScreen
import com.mindera.people.android.ui.dashboard.DashboardScreen
import com.mindera.people.android.ui.profile.ProfileScreen
import com.mindera.people.android.utils.getWith

const val MAIN_ROUTE = "main"

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    logger: Logger = getWith("MainScreen")
) {
    MainScreenView(modifier)
}

@Composable
fun MainScreenView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
            NavigationGraph(navController = navController, modifier = modifier)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        getNavItems().forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Dashboard.screen_route) {
        composable(BottomNavItem.Dashboard.screen_route) {
            DashboardScreen(modifier= modifier)
        }
        composable(BottomNavItem.Calendar.screen_route) {
            CalendarScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    MainScreenView()
}