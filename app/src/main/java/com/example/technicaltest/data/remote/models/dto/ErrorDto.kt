package com.example.technicaltest.data.remote.models.dto

import com.example.technicaltest.data.remote.models.mapper.DomainErrorModelMapper
import com.example.technicaltest.domain.models.DomainError
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorDto(
    @Json(name = "code") val code: Int,
    @Json(name = "error") val error: String,
    @Json(name = "error_description") val errorDescription: String,
    @Json(name = "error_user_description") val errorUserDescription: String,
) : DomainErrorModelMapper {

    override fun toErrorList() =
        DomainError(
            code = code,
            key = error,
            message = errorUserDescription
        )
}
