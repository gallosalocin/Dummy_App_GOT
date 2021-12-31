package com.example.technicaltest.data.repositories

import com.example.technicaltest.data.models.entities.TestResponse
import com.example.technicaltest.data.vendors.network.api.TestServiceApi
import com.example.technicaltest.domain.models.DomainTest
import io.reactivex.rxjava3.core.Single
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class TestRepositoryImplTests {
    private val mockTestServiceApi: TestServiceApi = mock()
    private val repository = TestRepositoryImpl(mockTestServiceApi)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockTestServiceApi)
    }

    @Test
    fun testSuccess() {
        val expectedResponse = listOf(TestResponse(userId = 1, id = 1, title = "title", body = "body"))
        val expectedDomain = listOf(DomainTest(userId = 1, id = 1, title = "title", body = "body"))

        whenever(mockTestServiceApi.getTest()).thenReturn(Single.just(expectedResponse))

        repository.getTest()
            .test()
            .assertValue(expectedDomain)

        verify(mockTestServiceApi).getTest()
    }

//    @Test
//    fun testFailure() {
//        val errorMessage = "Internal error"
//        val expectedDataException = DataExceptionsFixtures.DataNetworkExceptionUtils.create(500, errorMessage)
//        val expectedDomainException = DomainExceptionsFixtures.DomainNetworkUtils.createInternalError(errorMessage)
//
//        whenever(mockTestServiceApi.getTest()).thenReturn(Single.error(expectedDataException))
//
//        repository.getTest()
//            .test()
//            .assertError { it.toDomainExceptionType() as DomainNetworkException == expectedDomainException }
//
//        verify(mockTestServiceApi).getTest()
//    }
}