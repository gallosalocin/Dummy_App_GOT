package com.example.technicaltest.data.models.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GlobalResponse(
    @SerializedName("_embedded")
    val embedded: EmbeddedResponse
)
