package com.mindera.people.android.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.auth.AuthState
import com.mindera.people.auth.User
import com.mindera.people.data.ApiError
import com.mindera.people.people.Person
import com.mindera.people.utils.UiState

class PreviewNavigatorWithBack : PreviewParameterProvider<Navigator> {
    override val values = sequenceOf(getNavigator(hasBackStack = true))
    override val count: Int = values.count()
}

class PreviewNavigatorWithoutBack : PreviewParameterProvider<Navigator> {
    override val values = sequenceOf(getNavigator(hasBackStack = false))
    override val count: Int = values.count()
}

private fun getNavigator(hasBackStack: Boolean): Navigator =
    object : Navigator {
        override fun hasBackStack(): Boolean = hasBackStack
        override fun goBack() {/* no-op */
        }

        override fun navigateToHome() {/* no-op */
        }

        override fun navigateToAuthentication() {/* no-op */
        }

        override fun openSystemAppSettings() {/* no-op */
        }
    }

class PreviewAuthState : PreviewParameterProvider<AuthState> {
    override val values = sequenceOf(
        AuthState.Idle,
        AuthState.Loading,
        AuthState.AuthSuccess(User(id = 123, email = "email", photo = "photo", name = "name")),
        AuthState.AuthError(
            ApiError(Exception())
        )
    )
    override val count: Int = values.count()
}


class PreviewUiState : PreviewParameterProvider<UiState<Person>> {
    override val values = sequenceOf(
        UiState.Idle,
        UiState.Loading,
        UiState.Success(
            Person(
                id = 1,
                email = "email",
                name = "name",
                photo = "photo",
                slack = "slack",
                skype = "skype",
                phone = "phone",
                primaryRoleId = 1,
                primarySeniorityId = 1,
                primarySkillId = 1,
                primaryLocationId = 1,
                countryId = 1,
                primaryCtc = 1,
                primaryRate = 1,
                primaryCurrency = "primaryCurrency",
                primaryOfficeId = 1,
            )
        ),
        UiState.Error("")
    )
    override val count: Int = values.count()
}
