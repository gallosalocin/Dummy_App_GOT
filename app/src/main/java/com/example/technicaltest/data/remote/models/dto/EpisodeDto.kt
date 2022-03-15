package com.example.technicaltest.data.remote.models.dto

import com.example.technicaltest.data.remote.models.mapper.DomainModelMapper
import com.example.technicaltest.domain.models.DomainEpisode
import com.squareup.moshi.Json

data class EpisodeDto(
    @field:Json(name = "url") val url: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "season") val season: Int,
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "airdate") val airdate: String,
    @field:Json(name = "airtime") val airtime: String,
    @field:Json(name = "runtime") val runtime: Int,
    @field:Json(name = "image") val image: ImageDto,
    @field:Json(name = "summary") val summary: String,
) : DomainModelMapper<DomainEpisode> {

    override fun toDomain(): DomainEpisode =
        DomainEpisode(
            url = url,
            name = name,
            season = season,
            number = number,
            airdate = airdate,
            airtime = airtime,
            runtime = runtime,
            mediumImage = image.medium,
            originalImage = image.original,
            summary = summary
        )
}