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
    val image: ImageResponse,
    val summary: String
) : DomainModelConvertible<DomainEpisode> {
    override fun toDomain(): DomainEpisode =
        DomainEpisode(url, name, season, number, airdate, image.medium, image.original, summary)
}