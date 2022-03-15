package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.models.entities.GlobalResponse
import io.reactivex.rxjava3.core.Single

interface DummyServiceApi {

    fun getEpisodes(): Single<GlobalResponse>

    suspend fun getCoroutinesEpisodes(): GlobalResponse
}