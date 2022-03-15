//package com.example.technicaltest.data.repositories
//
//import com.example.technicaltest.data.remote.models.entities.EmbeddedResponse
//import com.example.technicaltest.data.remote.models.entities.EpisodeResponse
//import com.example.technicaltest.data.remote.models.entities.GlobalResponse
//import com.example.technicaltest.data.remote.models.entities.ImageResponse
//import com.example.technicaltest.data.remote.api.ServiceApi
//import com.example.technicaltest.domain.models.DomainEpisode
//import io.reactivex.rxjava3.core.Single
//import org.junit.After
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.junit.MockitoJUnitRunner
//import org.mockito.kotlin.mock
//import org.mockito.kotlin.verify
//import org.mockito.kotlin.verifyNoMoreInteractions
//import org.mockito.kotlin.whenever
//
//
//@RunWith(MockitoJUnitRunner::class)
//class MainRepositoryImplTests {
//    private val mockServiceApi: ServiceApi = mock()
//    private val repository = MainRepositoryImpl(mockServiceApi)
//
//    @After
//    fun tearDown() {
//        verifyNoMoreInteractions(mockServiceApi)
//    }
//
//    @Test
//    fun testSuccess() {
//        val expectedDomain = DomainEpisode(
//            url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
//            runtime = 60, mediumImage = "medium", originalImage = "original", summary = "summary"
//        )
//        val episodeResponse = EpisodeResponse(
//            url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
//            runtime = 60, image = ImageResponse(medium = "medium", original = "original"), summary = "summary"
//        )
//        val expectedResponse = GlobalResponse(embedded = EmbeddedResponse(episodes = listOf(episodeResponse)))
//
//        whenever(mockServiceApi.getEpisodes()).thenReturn(Single.just(expectedResponse))
//
//        repository.getEpisodes()
//            .test()
//            .assertValue(listOf(expectedDomain))
//
//        verify(mockServiceApi).getEpisodes()
//    }
//}