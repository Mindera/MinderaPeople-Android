package com.mindera.people.auth

import com.mindera.people.api.model.ApiUser


internal fun ApiUser.toUser(): User = user.run {
    User(
        email = this?.email ?: "",
        name = this?.name,
    )
}