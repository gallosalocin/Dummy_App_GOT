package com.example.technicaltest.domain.useCases

import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.repositories.MainRepository
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
class GetEpisodesUseCaseTests {
    private val mockMainRepository: MainRepository = mock()
    private val useCase = GetEpisodesUseCase(mockMainRepository)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockMainRepository)
    }

    @Test
    fun testInvoke() {
        val expectedDomain = listOf(DomainEpisode(url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
            runtime = 60, mediumImage = "medium", originalImage = "original", summary = "summary"))
        whenever(mockMainRepository.getEpisodes()).thenReturn(Single.just(expectedDomain))

        useCase.invoke()
            .test()
            .assertValue(expectedDomain)

        verify(mockMainRepository).getEpisodes()
    }
}
