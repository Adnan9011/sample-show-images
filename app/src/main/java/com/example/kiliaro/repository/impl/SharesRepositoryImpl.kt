package com.example.kiliaro.repository.impl

import com.example.kiliaro.data.api.shares.SharesApi
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.repository.SharesRepository
import javax.inject.Inject

class SharesRepositoryImpl @Inject constructor(
    private val sharesApi: SharesApi
): SharesRepository {

    override suspend fun getListMedia(sharedKey: String): List<SharedMediaUi> =
        sharesApi.getListMedia(sharedKey = sharedKey).map { it.toSharedMediaUi() }
}