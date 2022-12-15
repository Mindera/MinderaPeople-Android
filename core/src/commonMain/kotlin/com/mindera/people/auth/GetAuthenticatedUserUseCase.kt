package com.mindera.people.auth

import co.touchlab.kermit.Logger

class GetAuthenticatedUserUseCase(
    private val authRepository: AuthRepository,
    private val log: Logger
) {
    operator fun invoke(): User? = authRepository.authenticated
}