package com.example.technicaltest.data.repositories

import com.example.technicaltest.data.vendors.network.api.DummyServiceApi
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.repositories.DummyRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyServiceApi: DummyServiceApi
) : DummyRepository {

    override fun getEpisodes(): Single<List<DomainEpisode>> =
        dummyServiceApi.getEpisodes()
            .map { it.embedded.toDomain() }
}