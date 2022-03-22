package com.example.kilario.repository

import com.example.kilario.models.ui.SharedMediaUi

interface SharesRepository {
    suspend fun getListMedia(sharedKey: String): List<SharedMediaUi>
}