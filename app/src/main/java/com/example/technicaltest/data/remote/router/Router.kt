package com.example.technicaltest.data.remote.router

import com.example.technicaltest.data.remote.models.dto.BodyDto
import retrofit2.http.GET

interface Router {

    @GET("/got.json")
    suspend fun getEpisodesListing(): BodyDto
}