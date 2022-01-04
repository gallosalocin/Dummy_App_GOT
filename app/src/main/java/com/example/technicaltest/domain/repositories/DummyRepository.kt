package com.example.technicaltest.domain.repositories

import com.example.technicaltest.domain.models.DomainEpisode
import io.reactivex.rxjava3.core.Single

interface DummyRepository {

    fun getEpisodes(): Single<List<DomainEpisode>>
}