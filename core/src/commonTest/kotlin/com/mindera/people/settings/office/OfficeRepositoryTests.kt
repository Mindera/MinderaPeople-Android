package com.mindera.people.settings.office

import com.mindera.people.defaultApiOffice
import com.mindera.people.defaultOffice
import com.mindera.people.settings.office.OfficeRepository
import com.mindera.people.settings.office.OfficeRepositoryImpl
import com.mindera.people.settings.office.OfficeService
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class OfficeRepositoryTests {
    @Mock
    private val service = mock(classOf<OfficeService>())


    private lateinit var repository: OfficeRepository

    @BeforeTest
    fun setup() {
        repository = OfficeRepositoryImpl(service)
    }

    @Test
    fun `test getOffice save a given Policy properly`() = runTest {
        given(service).coroutine { getOffices() }.thenReturn(listOf(defaultApiOffice))

        val result = repository.getOffices()

        assertEquals(listOf(defaultOffice), result)
    }

}
