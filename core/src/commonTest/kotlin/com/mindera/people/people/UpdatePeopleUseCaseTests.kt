package com.mindera.people.people

//import com.mindera.people.network.models.UserDomain
//import io.mockk.coEvery
//import io.mockk.coVerify
//import io.mockk.mockk
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.runBlocking
//import kotlin.test.BeforeTest
//import kotlin.test.Test
//
//class UpdatePeopleUseCaseTests {
//    private lateinit var repository: PeopleRepository
//    private lateinit var useCase: UpdatePersonUseCase
//
//    @BeforeTest
//    fun setup() {
//        repository = mockk()
//        useCase = UpdatePersonUseCase(repository)
//    }
//    private val userDomain = UserDomain(
//        id = 0,
//        name = "",
//        email = "",
//        photo = "",
//        slack = "",
//        skype = "",
//        phone = "",
//        primaryRoleId = 0,
//        primarySeniorityId = 0,
//        primarySkillId = 0,
//        primaryLocationId = 0,
//        countryId = 0,
//        primaryCtc = 0,
//        primaryRate = 0,
//        primaryCurrency = "",
//        primaryOfficeId = 0
//    )
//
//    @Test
//    fun `When execute then returns expected User`() {
//        runBlocking {
//            // Given
//            coEvery { repository.updatePersonById(userDomain) } returns Unit
//
//            // When
//            useCase(userDomain).first()
//
//            // Then
//            coVerify(exactly = 1) { repository.updatePersonById(userDomain) }
//        }
//    }
//}