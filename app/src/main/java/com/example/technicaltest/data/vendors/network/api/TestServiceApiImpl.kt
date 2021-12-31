package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.models.entities.TestResponse
import com.example.technicaltest.data.vendors.network.api.protocols.RxServiceApi
import com.example.technicaltest.data.vendors.network.router.TestRouter
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TestServiceApiImpl @Inject constructor(
    private val testRouter: TestRouter
) : TestServiceApi, RxServiceApi {

    override fun getTest(): Single<List<TestResponse>> = createSingle(testRouter.getTest())
}