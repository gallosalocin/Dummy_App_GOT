package com.example.technicaltest.data.repositories

import com.example.technicaltest.data.vendors.network.api.TestServiceApi
import com.example.technicaltest.domain.models.DomainTest
import com.example.technicaltest.domain.repositories.TestRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val testServiceApi: TestServiceApi
) : TestRepository {

    override fun getTest(): Single<List<DomainTest>> =
        testServiceApi.getTest()
            .map { it.map { testResponse -> testResponse.toDomain() } }
}