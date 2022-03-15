package com.example.technicaltest.data.remote.api

import com.example.technicaltest.data.remote.models.dto.BodyDto
import com.example.technicaltest.data.remote.router.Router
import javax.inject.Inject
import retrofit2.http.GET

class ServiceApiImpl @Inject constructor(
    private val router: Router
) : ServiceApi {

    @GET("/got.json")
    override suspend fun getEpisodesListing(): BodyDto =
        router.getEpisodesListing()
}