package com.example.technicaltest.data.remote.models.dto

import com.squareup.moshi.Json

data class BodyDto(
    @field:Json(name = "_embedded") val embedded: EmbeddedDto
)
