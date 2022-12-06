package com.mindera.people.location

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiLocation
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultLocation
import com.mindera.people.defaultPolicy
import com.mindera.people.settings.location.LocationRepository
import com.mindera.people.settings.location.LocationRepositoryImpl
import com.mindera.people.settings.location.LocationService
import com.mindera.people.settings.policy.PolicyRepository
import com.mindera.people.settings.policy.PolicyRepositoryImpl
import com.mindera.people.timeoff.TimeOffService
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
        given(service).coroutine { getLocation() }.thenReturn(defaultApiLocation)

        val result = repository.getLocation()

        assertEquals(defaultLocation, result)
    }

}
