package com.mindera.people.people

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPerson
import com.mindera.people.defaultApiPersonAddress
import com.mindera.people.defaultPerson
import com.mindera.people.defaultPersonAddress
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class PeopleRepositoryTests {
    @Mock
    private val service = mock(classOf<PeopleService>())


    private lateinit var repository: PeopleRepository

    @BeforeTest
    fun setup() {
        repository = PeopleRepositoryImpl(service)
    }

    @Test
    fun `test getPeopleById save a given User properly`() = runTest {
        given(service).coroutine { getPeopleById("2") }.thenReturn(defaultApiPerson)

        val result = repository.getPersonById("2")

        assertEquals(defaultPerson, result)
    }

    @Test
    fun `test getPeopleAddressById save a given Unit properly`() = runTest {
        given(service).coroutine { getPeopleAddressById("2") }.thenReturn(defaultApiPersonAddress)

        val result = repository.getPersonAddressById("2")

        assertEquals(defaultPersonAddress, result)
    }

    @Test
    fun `test updatePeopleById save a given Unit properly`() = runTest {
        given(service).coroutine { updatePeopleById(defaultApiPerson) }.thenReturn(Unit)

        val result = repository.updatePersonById(defaultPerson)

        assertEquals(Unit, result)
    }

}