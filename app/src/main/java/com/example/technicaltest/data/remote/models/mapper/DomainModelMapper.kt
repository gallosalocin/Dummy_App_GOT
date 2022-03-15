package com.example.technicaltest.data.remote.models.mapper

/**
 * Interface used to transform DataType to DomainType
 */
interface DomainModelMapper<DomainType> {
    /**
     * @see #Domain Layer
     * Convert Model entity to Domain Entity
     */
    fun toDomain(): DomainType
}