package com.mindera.people.auth

import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.ViewModel

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    fun authenticate(user: User) {
        runCatching { userRepository.authenticateUser(user) }
            .onFailure {
                // TODO feedback to User?
            }
    }
}
