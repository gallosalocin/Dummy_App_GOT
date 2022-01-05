package com.example.technicaltest.data.models.entities

import com.example.technicaltest.data.models.domainMappingProtocols.DomainModelConvertible
import com.example.technicaltest.domain.models.DomainEpisode
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val url: String,
    val name: String,
    val season: Int,
    val number: Int,
    val airdate: String,
    val airtime: String,
    val runtime: Int,
    val image: ImageResponse,
    val summary: String
) : DomainModelConvertible<DomainEpisode> {
    override fun toDomain(): DomainEpisode =
        DomainEpisode(url, name, season, number, airdate, airtime, runtime, image.medium, image.original, summary)
}