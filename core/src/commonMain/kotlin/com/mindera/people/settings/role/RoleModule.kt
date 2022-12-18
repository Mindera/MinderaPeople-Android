package com.mindera.people.settings.role

import org.koin.dsl.module

val roleModule = module {
    single<RoleRepository> { RoleRepositoryImpl(get()) }
    single<RoleService> { RoleServiceImpl(get()) }
    factory { GetRoleUseCase(get()) }
}
