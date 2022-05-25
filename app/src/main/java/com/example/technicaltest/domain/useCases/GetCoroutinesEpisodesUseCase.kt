//package com.example.technicaltest.domain.useCases
//
//import com.example.technicaltest.data.vendors.network.router.DummyRouter
//import com.example.technicaltest.domain.models.DomainEpisode
//import com.example.technicaltest.domain.repositories.DummyRepository
//import io.reactivex.rxjava3.core.Single
//import javax.inject.Inject
//
//class GetCoroutinesEpisodesUseCase @Inject constructor(
//    private val dummyRepository: DummyRepository
//) {
//    suspend fun invoke(): List<DomainEpisode> =
//        dummyRepository.getCoroutinesEpisodes()
//}