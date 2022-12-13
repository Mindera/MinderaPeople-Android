package com.mindera.people.auth

import co.touchlab.kermit.Logger
import com.mindera.people.data.toError

class SignOutUseCase(
    private val authRepository: AuthRepository,
    private val log: Logger
): () -> Result<Unit> {
    override operator fun invoke(): Result<Unit> =
        runCatching { authRepository.clearUser() }
            .fold(onSuccess = { Result.success(Unit) },
                  onFailure = {
                      val error = it.toError()
                      log.i(error) { "Error when try sign-out current user" }
                      Result.failure(error)
                  })
}
