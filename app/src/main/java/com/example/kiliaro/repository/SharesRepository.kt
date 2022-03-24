package com.example.kiliaro.repository

import com.example.kiliaro.models.ui.SharedMediaUi

interface SharesRepository {
    suspend fun getListMedia(sharedKey: String): List<SharedMediaUi>
}