package com.mindera.people.settings.location

import com.mindera.people.defaultApiLocation
import com.mindera.people.defaultLocation
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LocationLocationTests {
    @Mock
    private val service = mock(classOf<LocationService>())


    private lateinit var repository: LocationRepository

    @BeforeTest
    fun setup() {
        repository = LocationRepositoryImpl(service)
    }

    @Test
    fun `test getLocation save a given Policy properly`() = runTest {
        given(service).coroutine { getLocations() }.thenReturn(listOf(defaultApiLocation))

        val result = repository.getLocations()

        assertEquals(listOf(defaultLocation), result)
    }

}
