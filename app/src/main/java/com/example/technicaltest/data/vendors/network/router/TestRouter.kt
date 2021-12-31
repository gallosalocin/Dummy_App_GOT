package com.example.technicaltest.data.vendors.network.router

import com.example.technicaltest.data.models.entities.TestResponse
import retrofit2.Call
import retrofit2.http.GET

interface TestRouter {

    @GET("/posts")
    fun getTest(): Call<List<TestResponse>>
}