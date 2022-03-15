package com.example.technicaltest.data.remote.models.dto

import com.example.technicaltest.data.remote.models.mapper.DomainModelMapper
import com.example.technicaltest.domain.models.DomainEpisode
import com.squareup.moshi.Json

data class EmbeddedDto(
    @field:Json(name = "episodes") val episodes: List<EpisodeDto>
) : DomainModelMapper<List<DomainEpisode>> {

    override fun toDomain(): List<DomainEpisode> = episodes.map { it.toDomain() }
}