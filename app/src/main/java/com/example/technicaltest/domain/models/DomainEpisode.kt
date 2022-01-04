package com.example.technicaltest.domain.models

data class DomainEpisode(
    val url: String,
    val name: String,
    val season: Int,
    val number: Int,
    val airdate: String,
    val mediumImage: String,
    val originalImage: String,
    val summary: String
)
