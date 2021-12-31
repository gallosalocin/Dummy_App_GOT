package com.example.technicaltest.domain.useCases

import com.example.technicaltest.domain.models.DomainTest
import com.example.technicaltest.domain.repositories.TestRepository
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
class GetTestUseCaseTests {
    private val mockTestRepository: TestRepository = mock()
    private val useCase = GetTestUseCase(mockTestRepository)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockTestRepository)
    }

    @Test
    fun testInvoke() {
        val expectedDomain = listOf(DomainTest(userId = 1, id = 1, title = "title", body = "body"))
        whenever(mockTestRepository.getTest()).thenReturn(Single.just(expectedDomain))

        useCase.invoke()
            .test()
            .assertValue(expectedDomain)

        verify(mockTestRepository).getTest()
    }
}
