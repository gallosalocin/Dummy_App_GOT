package com.example.technicaltest.data.repositories.protocols

import com.example.technicaltest.data.remote.models.dto.error.ErrorDto
import com.example.technicaltest.domain.models.DomainError
import com.example.technicaltest.utils.ResultHandler
import com.squareup.moshi.Moshi
import java.io.IOException
import java.net.HttpURLConnection
import okhttp3.ResponseBody
import retrofit2.HttpException

interface SafeCallHandler {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultHandler<T> =
        try {
            val response = apiCall()
            if (response != null) {
                ResultHandler.Success(data = response)
            } else {
                val errorResponse: DomainError? = convertErrorBody(response)
                ResultHandler.Error(errorMessage = "Invalid data", data = errorResponse)
            }
        } catch (exception: HttpException) {
            exception.printStackTrace()
            when (exception.code()) {
                HttpURLConnection.HTTP_BAD_REQUEST -> ResultHandler.Error(errorMessage = "${exception.code()} - Bad Request")
                HttpURLConnection.HTTP_UNAUTHORIZED -> ResultHandler.Error(errorMessage = "${exception.code()} - Unauthorized")
                HttpURLConnection.HTTP_FORBIDDEN -> ResultHandler.Error(errorMessage = "${exception.code()} - Forbidden")
                HttpURLConnection.HTTP_NOT_FOUND -> ResultHandler.Error(errorMessage = "${exception.code()} - Not Found")
                HttpURLConnection.HTTP_CONFLICT -> ResultHandler.Error(errorMessage = "${exception.code()} - Conflict")
                HttpURLConnection.HTTP_BAD_GATEWAY, HttpURLConnection.HTTP_INTERNAL_ERROR -> ResultHandler.Error(errorMessage = "${exception.code()} - Internal Server Error")
                HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> ResultHandler.Error(errorMessage = "${exception.code()} - Gateway Time-out")
                else -> ResultHandler.Error(errorMessage = exception.message ?: "Something went wrong")
            }
        } catch (exception: IOException) {
            exception.printStackTrace()
            ResultHandler.Error(errorMessage = "Please check your network connection")
        }

    private fun convertErrorBody(errorBody: ResponseBody?): DomainError? =
        try {
            errorBody?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorDto::class.java)
                moshiAdapter.fromJson(it)?.toDomain()
            }
        } catch (exception: Exception) {
            null
        }

}