package com.example.technicaltest.data.vendors.network.api.protocols

import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface RxServiceApi {
    fun <T : Any> createSingle(call: Call<T>): Single<T> =
        Single.create { single ->
            call.clone().execute().apply {
                if (isSuccessful) {
                    when (val body = body()) {
                        null -> single.onError(Exception("Body null"))
                        else -> single.onSuccess(body)
                    }
                } else {
                    single.onError(Exception("Call not successful"))
                }
            }
        }
}