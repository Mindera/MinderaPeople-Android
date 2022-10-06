package com.mindera.people.user

import com.mindera.people.data.SettingsStorage

interface UserRepository {
    val authenticated: User?
    fun authenticateUser(user: User)
    fun clearUser()
}

class UserRepositoryImpl(
    private val storage: SettingsStorage
) : UserRepository {

    override val authenticated: User?
        get() = storage.user

    override fun authenticateUser(user: User) {
        storage.user = user
    }

    override fun clearUser() {
        storage.user = null
    }
}
