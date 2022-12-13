package com.mindera.people.auth

import co.touchlab.kermit.Logger

class GetAuthenticatedUserUseCase(
    private val authRepository: AuthRepository,
    private val log: Logger
): () -> User? {
    override operator fun invoke(): User? =
        authRepository.authenticated.also {
            log.i { "Authenticated user=($it)" }
        }
}
