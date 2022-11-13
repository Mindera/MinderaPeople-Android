package com.mindera.people.di

import com.mindera.people.network.models.PolicyDTOMapper
import com.mindera.people.network.models.PolicyDTOMapperImpl
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDTOMapperImpl
import com.mindera.people.network.models.UserAllocationDTOMapper
import com.mindera.people.network.models.UserAllocationDTOMapperImpl
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDTOMapperImpl
import com.mindera.people.network.models.UserTimeOffDTOMapper
import com.mindera.people.network.models.UserTimeOffDTOMapperImpl
import com.mindera.people.network.people.GetPeopleAddressUseCase
import com.mindera.people.network.people.GetPeopleUseCase
import com.mindera.people.network.people.PeopleRepository
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.people.UpdatePeopleUseCase
import com.mindera.people.network.policy.GetPolicyUseCase
import com.mindera.people.network.policy.PolicyRepository
import com.mindera.people.network.policy.PolicyRepositoryImpl
import com.mindera.people.network.setupHTTP
import com.mindera.people.network.timeoff.GetTimeOffCalendarUseCase
import com.mindera.people.network.timeoff.GetTimeOffUseCase
import com.mindera.people.network.timeoff.TimeOffRepository
import com.mindera.people.network.timeoff.TimeOffRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule = module {
    single { setupHTTP() }
}

val repositoryModule = module {
    single<PeopleRepository> { PeopleRepositoryImpl(get(), get(), get()) }
    single<PolicyRepository> { PolicyRepositoryImpl(get(), get()) }
    single<TimeOffRepository> { TimeOffRepositoryImpl(get(), get()) }
}

val useCasesModule: Module = module {
    factory { GetPeopleUseCase(get()) }
    factory { GetPeopleAddressUseCase(get()) }
    factory { UpdatePeopleUseCase(get()) }
    factory { GetPolicyUseCase(get()) }
    factory { GetTimeOffUseCase(get()) }
    factory { GetTimeOffCalendarUseCase(get()) }
}

val mapperModule = module {
    factory<UserDTOMapper> { UserDTOMapperImpl() }
    factory<PolicyDTOMapper> { PolicyDTOMapperImpl() }
    factory<UserAddressDTOMapper> { UserAddressDTOMapperImpl() }
    factory<UserAllocationDTOMapper> { UserAllocationDTOMapperImpl() }
    factory<UserTimeOffDTOMapper> { UserTimeOffDTOMapperImpl(get()) }
}

