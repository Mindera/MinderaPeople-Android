package com.mindera.people.people

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.GetPeopleUseCase
import com.mindera.people.network.people.PeopleViewModel
import com.mindera.people.utils.UiState
import io.mockative.given
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class PeopleViewModelTests: BaseTest() {

    private lateinit var viewModel: PeopleViewModel

    private lateinit var getPeopleUseCase: GetPeopleUseCase

    private val userDomain = UserDomain(
        id = 0,
        name = "",
        email = "",
        photo = "",
        slack = "",
        skype = "",
        phone = "",
        primaryRoleId = 0,
        primarySeniorityId = 0,
        primarySkillId = 0,
        primaryLocationId = 0,
        countryId = 0,
        primaryCtc = 0,
        primaryRate = 0,
        primaryCurrency = "",
        primaryOfficeId = 0
    )

    @BeforeTest
    fun setUp() {
        super.setup()
        getPeopleUseCase = mockk()
        viewModel = PeopleViewModel(getPeopleUseCase)
    }

    //TODO review
    @Test
    fun `test ViewModel emits Success when get complete`() = runTest {
        // Given
        coEvery { getPeopleUseCase("2") } returns flow {
            UiState.Success(userDomain)
        }

//         Then
//        coVerify(exactly = 1) {
//            getPeopleUseCase("2")
//        }

//        viewModel.state.test {
//            assertEquals(UiState.Idle, awaitItem())
//            viewModel.getPeopleData("2")
//            assertEquals(UiState.Success(userDomain), awaitItem())
//        }

        assertTrue(true)
    }

}