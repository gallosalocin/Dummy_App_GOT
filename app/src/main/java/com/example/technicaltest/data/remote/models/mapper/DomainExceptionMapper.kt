package com.example.technicaltest.data.remote.models.mapper

import com.example.technicaltest.domain.models.DomainException

/**
 * Interface used to implement toDomainExceptionType for Exceptions triggered from the Data
 */
interface DomainExceptionConvertible {
    fun toDomain(): DomainException
}