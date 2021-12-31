package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.models.entities.TestResponse
import io.reactivex.rxjava3.core.Single

interface TestServiceApi {

    fun getTest(): Single<List<TestResponse>>
}