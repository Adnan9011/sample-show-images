package com.example.kiliaro.repository

import com.example.kiliaro.models.ui.SharedMediaUi

interface SharesRepository {
    suspend fun getListMedia(
        sharedId: String,
        getFromServer: Boolean
    ): Pair<List<SharedMediaUi>, Boolean>

    suspend fun updateDatabase(listSharedMedia: List<SharedMediaUi>, sharedId: String)
}