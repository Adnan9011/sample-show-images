package com.example.kiliaro.data.api.shares

import com.example.kiliaro.models.repo.SharedMediaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SharesApi {
    @GET("shared/{ssharedId}/media")
    suspend fun getListMedia(@Path("ssharedId") sharedId: String):
            List<SharedMediaResponse>
}