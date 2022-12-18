package com.mindera.people.people

import com.mindera.people.auth.AuthRepository
import com.mindera.people.auth.User
import com.mindera.people.utils.UseCaseOut

class GetMyUserUseCase(
    private val repository: PeopleRepository,
    private val repositoryAuth: AuthRepository,
    override val block: suspend () -> User = { repository.getUser().also {
        repositoryAuth.authenticateUser(it)
    } }
) : UseCaseOut<User>()
