package com.example.technicaltest.domain.repositories

import com.example.technicaltest.domain.models.DomainTest
import io.reactivex.rxjava3.core.Single

interface TestRepository {

    fun getTest(): Single<List<DomainTest>>
}