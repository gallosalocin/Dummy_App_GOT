package com.example.technicaltest.utils

import com.example.technicaltest.domain.models.DomainError

sealed class ResultHandler<T> {
    class Success<T>(val data: T?) : ResultHandler<T>()
    class Error<T>(val errorMessage: String, val data: DomainError? = null) : ResultHandler<T>()
//    class Error<T>(val data: DomainError? = null) : ResultHandler<T>()
}