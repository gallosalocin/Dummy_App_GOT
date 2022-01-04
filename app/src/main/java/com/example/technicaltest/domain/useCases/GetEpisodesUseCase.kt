package com.example.technicaltest.domain.useCases

import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.repositories.DummyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val dummyRepository: DummyRepository
) {
    fun invoke(): Single<List<DomainEpisode>> = dummyRepository.getEpisodes()
}