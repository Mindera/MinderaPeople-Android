package com.mindera.people.auth

import co.touchlab.kermit.Logger
import com.mindera.people.data.toError

class SignInUseCase(
    private val authRepository: AuthRepository,
    private val log: Logger
): (User) -> Result<User> {
    override operator fun invoke(user: User): Result<User> =
        runCatching { authRepository.authenticateUser(user) }
            .fold(onSuccess = { Result.success(user) },
                  onFailure = {
                      val error = it.toError()
                      log.i(error) { "Error when try sign-in: user=($user)" }
                      Result.failure(error)
                  })
}
