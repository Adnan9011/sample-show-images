package com.example.kilario.data.api.shares

import com.example.kilario.models.repo.SharedMediaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SharesApi {
    @GET("shared/{sharedkey}/media")
    suspend fun getListMedia(@Path("sharedkey") sharedKey: String):
            List<SharedMediaResponse>
}