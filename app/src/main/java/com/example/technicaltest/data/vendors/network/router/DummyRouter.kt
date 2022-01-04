package com.example.technicaltest.data.vendors.network.router

import com.example.technicaltest.data.models.entities.GlobalResponse
import retrofit2.Call
import retrofit2.http.GET

interface DummyRouter {

    @GET("/got.json")
    fun getResponse(): Call<GlobalResponse>
}