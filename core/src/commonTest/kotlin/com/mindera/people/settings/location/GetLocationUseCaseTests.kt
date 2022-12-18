package com.mindera.people.settings.location

import app.cash.turbine.test
import com.mindera.people.defaultLocation
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

class GetLocationUseCaseTests {
    @Mock private val repository = mock(classOf<LocationRepository>())

    private lateinit var useCase: GetLocationUseCase

    @BeforeTest
    fun setup() {
        useCase = GetLocationUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Location`() = runTest {
        // Given
        given(repository).coroutine { repository.getLocations() }
            .thenReturn(listOf(defaultLocation))

        // When
        useCase().test {
            assertEquals(UiState.Success(listOf(defaultLocation)), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getLocations() }.wasInvoked(exactly = once)
    }
}
