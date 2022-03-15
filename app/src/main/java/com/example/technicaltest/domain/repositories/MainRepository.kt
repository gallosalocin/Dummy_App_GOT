package com.example.technicaltest.domain.repositories

import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.utils.ResultHandler

interface MainRepository {

    suspend fun getCoroutinesEpisodes(): ResultHandler<List<DomainEpisode>>
}