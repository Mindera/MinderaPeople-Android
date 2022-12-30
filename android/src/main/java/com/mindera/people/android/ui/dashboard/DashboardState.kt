package com.mindera.people.android.ui.dashboard

import com.mindera.people.auth.User
import com.mindera.people.data.Error
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.timeoff.Summary
import com.mindera.people.utils.UiState

sealed class DashboardState {
    object Idle: DashboardState()
    data class UserData(val user: User) : DashboardState()
    data class TimeOffData(val timeOffData: UiState<Summary>): DashboardState()
    data class MyTimeOffList(val myTimeOffList: UiState<List<PersonTimeOff>>): DashboardState()
    data class DashboardError(val error: String?): DashboardState()
}
