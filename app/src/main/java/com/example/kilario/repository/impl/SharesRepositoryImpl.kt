package com.example.kilario.repository.impl

import com.example.kilario.data.api.shares.SharesApi
import com.example.kilario.models.ui.SharedMediaUi
import com.example.kilario.repository.SharesRepository
import javax.inject.Inject

class SharesRepositoryImpl @Inject constructor(
    private val sharesApi: SharesApi
): SharesRepository{

    override suspend fun getListMedia(sharedKey: String): List<SharedMediaUi> =
        sharesApi.getListMedia(sharedKey = sharedKey).map { it.toSharedMediaUi() }
}