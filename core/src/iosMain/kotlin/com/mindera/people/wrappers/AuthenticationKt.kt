package com.mindera.people.wrappers

import com.mindera.people.auth.AuthState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import com.mindera.people.utils.MainScope
import com.mindera.people.utils.safeLaunchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object AuthenticationKt : KoinComponent {
    private val mainScope = MainScope()

    private val viewModel: AuthViewModel by inject()

    fun authenticate(user: User) {
        viewModel.authenticate(user)
    }

    fun stateObservation(callback: (AuthState) -> Unit) {
        viewModel.state
            .onEach {callback.invoke(it) }
            .safeLaunchIn(mainScope)
    }
}
