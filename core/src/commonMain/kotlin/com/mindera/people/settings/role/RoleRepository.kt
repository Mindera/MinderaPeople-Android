package com.mindera.people.settings.role


interface RoleRepository {
    suspend fun getRoles(): List<Role>
}

internal class RoleRepositoryImpl(private val roleService: RoleService) : RoleRepository {
    override suspend fun getRoles(): List<Role> = roleService.getRoles().toRoles()
}
