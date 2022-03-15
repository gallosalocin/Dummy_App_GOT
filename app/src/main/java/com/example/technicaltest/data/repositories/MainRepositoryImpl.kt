package com.example.technicaltest.data.repositories

import com.example.technicaltest.data.remote.api.ServiceApi
import com.example.technicaltest.data.repositories.protocols.SafeCallHandler
import com.example.technicaltest.utils.ResultHandler
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.repositories.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi,
) : MainRepository, SafeCallHandler {

        override suspend fun getCoroutinesEpisodes(): ResultHandler<List<DomainEpisode>> =
            safeApiCall { serviceApi.getEpisodesListing().embedded.toDomain() }

}