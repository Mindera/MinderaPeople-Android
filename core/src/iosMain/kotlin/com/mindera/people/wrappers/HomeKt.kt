package com.mindera.people.wrappers

import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.Error
import com.mindera.people.data.toError
import com.mindera.people.utils.MainScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object HomeKt : KoinComponent {
    private val mainScope = MainScope()

    private val signInUseCase: SignInUseCase by inject()

    fun setUser(user: User, callback: (Result) -> Unit) {
        signInUseCase(user).fold(
            onSuccess = { callback.invoke(Result.AuthenticationState(user = user)) },
            onFailure = { callback.invoke(Result.AuthenticationState(error = it.toError())) }
        )
    }

    sealed class Result {
        data class AuthenticationState(
            val user: User? = null,
            val error: Error? = null
        ): Result()
    }
}
