package com.mindera.people.android.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.auth.AuthState
import com.mindera.people.auth.User
import com.mindera.people.data.ApiError

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
        AuthState.AuthSuccess(User("email", "name")),
        AuthState.AuthError(
            ApiError(Exception())
        )
    )
    override val count: Int = values.count()
}
