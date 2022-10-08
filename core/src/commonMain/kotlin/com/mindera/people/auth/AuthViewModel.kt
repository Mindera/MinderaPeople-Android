package com.mindera.people.auth

import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.ViewModel

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    fun authenticate(user: User) {
        try {
            userRepository.authenticateUser(user)
        } catch (error: Throwable) {
            // TODO feedback to User?
        }
    }
}
