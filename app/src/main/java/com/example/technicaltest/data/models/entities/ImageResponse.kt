package com.example.technicaltest.data.models.entities

import kotlinx.serialization.Serializable

@Serializable
data class ImageResponse(
    val medium: String,
    val original: String
)
