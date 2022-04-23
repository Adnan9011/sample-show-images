package com.example.kiliaro.repository.impl

import com.example.kiliaro.data.api.shares.SharesApi
import com.example.kiliaro.data.db.sharedmedia.SharedMediaDao
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.repository.SharesRepository
import javax.inject.Inject

class SharesRepositoryImpl @Inject constructor(
    private val sharesApi: SharesApi,
    private val sharedMediaDao: SharedMediaDao
) : SharesRepository {

    override suspend fun getListMedia(
        sharedId: String,
        getFromServer: Boolean
    ): Pair<List<SharedMediaUi>, Boolean> {
        var isLoadFromServer: Boolean
        var listSharedMedia = listOf<SharedMediaUi>()
        if (getFromServer) {
            isLoadFromServer = true
            listSharedMedia =
                sharesApi.getListMedia(sharedId = sharedId).map { it.toSharedMediaUi() }
            // Update Database
            updateDatabase(listSharedMedia, sharedId)
        } else {
            isLoadFromServer = false
            listSharedMedia = sharedMediaDao.getAll(sharedId).map { it.toSharedMediaUi() }
        }
        return Pair(listSharedMedia, isLoadFromServer)
    }

    override suspend fun updateDatabase(listSharedMedia: List<SharedMediaUi>, sharedId: String) {
        sharedMediaDao.deleteAll(sharedId)
        sharedMediaDao.insertAll(listSharedMedia.map { it.toSharedMediaEntiry(sharedId) })
    }
}