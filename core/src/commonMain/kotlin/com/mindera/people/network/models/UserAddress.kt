package com.mindera.people.network.models

import kotlinx.serialization.Serializable

@Serializable
data class UserAddressDTO(
    val id: Int? = null,
    val type: String? = null,
    val person_id: Int? = null,
    val street: String? = null,
    val state: String? = null,
    val post_code: String? = null,
    val city: String? = null,
)

interface UserAddressDTOMapper {
    fun mapperToDomain(userAddressDTO: UserAddressDTO): UserAddressDomain
}

class UserAddressDTOMapperImpl : UserAddressDTOMapper {

    override fun mapperToDomain(userAddressDTO: UserAddressDTO): UserAddressDomain {
        return userAddressDTO.run {
            UserAddressDomain(
                id = id ?: 0,
                type = type?.let { UserAddressType.mapperEnum(it) }
                    ?: kotlin.run { UserAddressType.ANOTHER },
                personId = person_id ?: 0,
                street = street ?: "",
                state = state ?: "",
                postCode = post_code ?: "",
                city = city ?: ""
            )
        }
    }

}

data class UserAddressDomain(
    val id: Int,
    val type: UserAddressType,
    val personId: Int,
    val street: String,
    val state: String,
    val postCode: String,
    val city: String
)

enum class UserAddressType {
    FISCAL,
    CURRENT,
    ANOTHER;

    companion object {

        fun mapperEnum(data: String): UserAddressType {
            return try {
                valueOf(data)
            } catch (exception: IllegalArgumentException) {
                ANOTHER
            }
        }
    }
}