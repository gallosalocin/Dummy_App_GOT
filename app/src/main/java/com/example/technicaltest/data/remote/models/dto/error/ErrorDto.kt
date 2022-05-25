package com.example.technicaltest.data.remote.models.dto.error

import com.example.technicaltest.data.remote.models.mapper.DomainModelMapper
import com.example.technicaltest.domain.models.DomainError
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorDto(
    @Json(name = "identifier") val identifier: String,
    @Json(name = "debug") val debug: String,
    @Json(name = "title") val title: String,
    @Json(name = "message") val message: String,
) : DomainModelMapper<DomainError> {

    override fun toDomain(): DomainError =
        DomainError(
            identifier = identifier,
            debug = debug,
            title = title,
            message = message,
        )
}
