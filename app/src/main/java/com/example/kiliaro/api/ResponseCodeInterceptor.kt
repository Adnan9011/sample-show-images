package com.example.kiliaro.api

import com.example.kiliaro.common.ErrorMessages
import com.example.kiliaro.common.NetworkException
import com.example.kiliaro.common.NotFoundException
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import java.net.SocketTimeoutException
import javax.inject.Inject

class ResponseCodeInterceptor @Inject constructor(
    val gson: Gson
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().build()
        val response = try {
            chain.proceed(request)
        } catch (exp : SocketTimeoutException) {
            throw NetworkException(ErrorMessages.NETWORK_TIMEOUT.toString())
        }

        return when (response.code()) {

            // @Todo Other responseCode like 401, 403
            404 -> throw NotFoundException("Not Found")

            else -> response
        }
    }
}