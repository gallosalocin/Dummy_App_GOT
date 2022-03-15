package com.example.technicaltest.data.remote.api

import com.example.technicaltest.data.remote.models.dto.BodyDto

interface ServiceApi {

    suspend fun getEpisodesListing(): BodyDto
}