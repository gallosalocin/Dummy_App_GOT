package com.example.technicaltest.data.remote.models.mapper

import com.example.technicaltest.domain.models.DomainError

/**
 * Interface used to transform ErrorDto to DomainError
 */
interface DomainErrorModelMapper {
    /**
     * @see #Domain Layer
     * Convert Model error to Domain error
     */
    fun toErrorList(): DomainError?
}