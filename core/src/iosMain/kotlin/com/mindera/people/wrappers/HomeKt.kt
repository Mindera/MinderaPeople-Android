package com.mindera.people.wrappers

import com.mindera.people.home.HomeState
import com.mindera.people.home.HomeViewModel
import com.mindera.people.user.User
import com.mindera.people.utils.MainScope
import com.mindera.people.utils.safeLaunchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object HomeKt : KoinComponent {
    private val mainScope = MainScope()

    private val viewModel: HomeViewModel by inject()

    fun setUser(user: User) {
        viewModel.setUser(user)
    }

    fun stateObservation(callback: (HomeState) -> Unit) {
        viewModel.state
            .onEach {callback.invoke(it) }
            .safeLaunchIn(mainScope)
    }
}
