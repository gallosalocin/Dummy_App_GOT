package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.models.entities.GlobalResponse
import com.example.technicaltest.data.vendors.network.api.protocols.RxServiceApi
import com.example.technicaltest.data.vendors.network.router.DummyRouter
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DummyServiceApiImpl @Inject constructor(
    private val dummyRouter: DummyRouter
) : DummyServiceApi, RxServiceApi {

    override fun getEpisodes(): Single<GlobalResponse> = createSingle(dummyRouter.getResponse())
}