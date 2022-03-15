package com.example.technicaltest.utils

import com.example.technicaltest.data.remote.models.dto.ErrorDto

sealed class ResultHandler<T> {
    class Success<T>(val data: T?) : ResultHandler<T>()
    class Error<T>(val errorMessage: String, data: ErrorDto? = null) : ResultHandler<T>()
}