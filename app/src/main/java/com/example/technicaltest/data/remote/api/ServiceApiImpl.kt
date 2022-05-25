package com.example.technicaltest.data.remote.api

import com.example.technicaltest.data.remote.models.dto.BodyDto
import com.example.technicaltest.data.remote.router.Router
import javax.inject.Inject

class ServiceApiImpl @Inject constructor(
    private val router: Router
) : ServiceApi {

    override suspend fun getEpisodesListing(): BodyDto =
        router.getEpisodesListing()
}