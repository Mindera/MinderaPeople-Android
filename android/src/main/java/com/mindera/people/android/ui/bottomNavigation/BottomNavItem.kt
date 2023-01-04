package com.mindera.people.android.ui.bottomNavigation

import com.mindera.people.android.R

sealed class BottomNavItem(var title: Int, var icon: Int, var screen_route: String) {
    object Dashboard :
        BottomNavItem(R.string.navigation_dashboard_title, R.drawable.ic_nav_dashboard, "dashboard")

    object Calendar :
        BottomNavItem(R.string.navigation_calendar_title, R.drawable.ic_nav_calendar, "calendar")

    object Profile :
        BottomNavItem(R.string.navigation_profile_title, R.drawable.ic_nav_profile, "profile")
}

fun getNavItems() = listOf(
    BottomNavItem.Dashboard,
    BottomNavItem.Calendar,
    BottomNavItem.Profile
)