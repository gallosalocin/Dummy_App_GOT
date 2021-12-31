package com.example.technicaltest.domain.useCases

import com.example.technicaltest.domain.models.DomainTest
import com.example.technicaltest.domain.repositories.TestRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetTestUseCase @Inject constructor(
    private val testRepository: TestRepository
) {
    fun invoke(): Single<List<DomainTest>> = testRepository.getTest()
}