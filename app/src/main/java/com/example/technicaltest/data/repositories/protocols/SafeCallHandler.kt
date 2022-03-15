package com.example.technicaltest.data.repositories.protocols

import com.example.technicaltest.utils.ResultHandler
import java.io.IOException
import retrofit2.HttpException

interface SafeCallHandler {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultHandler<T> =
        try {
            val response = apiCall()
            if (response != null) {
                ResultHandler.Success(data = response)
            } else {
                ResultHandler.Error(errorMessage = "Invalid data")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            when(e.code()) {
                400 -> ResultHandler.Error(errorMessage = "${e.code()} - Bad request")
                401 -> ResultHandler.Error(errorMessage = "${e.code()} - Unauthorized")
                403 -> ResultHandler.Error(errorMessage = "${e.code()} - Forbidden")
                404 -> ResultHandler.Error(errorMessage = "${e.code()} - Not Found")
                500, 502, 503 -> ResultHandler.Error(errorMessage = "${e.code()} - Internal Server Error")
                504 -> ResultHandler.Error(errorMessage = "${e.code()} - Gateway Time-out")
                else -> ResultHandler.Error(errorMessage = e.message ?: "Something went wrong")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            ResultHandler.Error(errorMessage = "Please check your network connection")
        }
}