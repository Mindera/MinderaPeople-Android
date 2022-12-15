package com.mindera.people.auth

import co.touchlab.kermit.Logger
import com.mindera.people.data.toError

class SignInUseCase(
    private val authRepository: AuthRepository,
    private val log: Logger
) {
    operator fun invoke(token: String): Result<Unit> =
        runCatching { authRepository.authenticateToken(token) }
            .fold(onSuccess = { Result.success(Unit) },
                onFailure = {
                    val error = it.toError()
                    log.i(error) { "Error when try sign-in:($error)" }
                    Result.failure(error)
                })
}
