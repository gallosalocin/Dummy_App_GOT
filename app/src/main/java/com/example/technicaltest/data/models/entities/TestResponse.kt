package com.example.technicaltest.data.models.entities

import com.example.technicaltest.data.models.domainMappingProtocols.DomainModelConvertible
import com.example.technicaltest.domain.models.DomainTest
import kotlinx.serialization.Serializable

@Serializable
data class TestResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body:String
) : DomainModelConvertible<DomainTest> {
    override fun toDomain(): DomainTest =
        DomainTest(userId, id, title, body)
}