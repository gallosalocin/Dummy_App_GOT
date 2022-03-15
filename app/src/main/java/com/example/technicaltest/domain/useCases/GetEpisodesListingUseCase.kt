package com.example.technicaltest.domain.useCases

import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.repositories.MainRepository
import com.example.technicaltest.utils.ResultHandler
import javax.inject.Inject

class GetEpisodesListingUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun invoke(): ResultHandler<List<DomainEpisode>> =
            mainRepository.getCoroutinesEpisodes()
}