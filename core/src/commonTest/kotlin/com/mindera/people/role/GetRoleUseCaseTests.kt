package com.mindera.people.role

import app.cash.turbine.test
import com.mindera.people.defaultRole
import com.mindera.people.settings.role.GetRoleUseCase
import com.mindera.people.settings.role.RoleRepository
import com.mindera.people.utils.UiState
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetRoleUseCaseTests {
    @Mock private val repository = mock(classOf<RoleRepository>())

    private lateinit var useCase: GetRoleUseCase

    @BeforeTest
    fun setup() {
        useCase = GetRoleUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Role`() = runTest {
        // Given
        given(repository).coroutine { repository.getRole() }
            .thenReturn(defaultRole)

        // When
        useCase().test {
            assertEquals(UiState.Success(defaultRole), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getRole() }.wasInvoked(exactly = once)
    }
}
