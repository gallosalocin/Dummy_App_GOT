package com.example.technicaltest.data.models.entities

import com.example.technicaltest.data.models.domainMappingProtocols.DomainModelConvertible
import com.example.technicaltest.domain.models.DomainEpisode
import kotlinx.serialization.Serializable

@Serializable
data class EmbeddedResponse(
    val episodes: List<EpisodeResponse>
) : DomainModelConvertible<List<DomainEpisode>> {
    override fun toDomain(): List<DomainEpisode> =
        episodes.map { it.toDomain() }
}