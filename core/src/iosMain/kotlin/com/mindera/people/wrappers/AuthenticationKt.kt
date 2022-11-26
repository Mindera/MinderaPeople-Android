package com.mindera.people.wrappers

import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.SignOutUseCase
import com.mindera.people.data.Error
import com.mindera.people.data.toError
import com.mindera.people.auth.User
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object AuthenticationKt : KoinComponent {
    //private val mainScope = MainScope()

    private val signInUseCase: SignInUseCase by inject()
    private val signOutUseCase: SignOutUseCase by inject()

    fun signIn(user: User, callback: (Result) -> Unit) {
        signInUseCase(user).fold(
            onSuccess = { callback.invoke(Result.AuthSuccess(user)) },
            onFailure = { callback.invoke(Result.AuthError(it.toError())) }
        )
    }

    fun signOut(callback: (Result) -> Unit) {
        signOutUseCase().fold(
            onSuccess = { callback.invoke(Result.UserCleared) },
            onFailure = { callback.invoke(Result.AuthError(it.toError())) }
        )
    }

    sealed class Result {
        data class AuthSuccess(val user: User): Result()
        data class AuthError(val error: Error): Result()
        object UserCleared: Result()
    }
}
