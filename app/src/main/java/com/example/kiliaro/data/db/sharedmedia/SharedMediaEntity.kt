package com.example.kiliaro.data.db.sharedmedia

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kiliaro.models.ui.SharedMediaUi
import java.util.*

const val SHARED_MEDIA_TABLE_NAME = "shared_media_table"
const val SHARED_MEDIA_COLUMN_ID = "id"
const val SHARED_MEDIA_COLUMN_SHARED_ID = "sharedId"
const val SHARED_MEDIA_COLUMN_SIZE = "size"
const val SHARED_MEDIA_COLUMN_CREATE_AT = "createAt"
const val SHARED_MEDIA_COLUMN_THUMBNAIL_URL = "thumbnailUrl"

@Entity(tableName = SHARED_MEDIA_TABLE_NAME)
data class SharedMediaEntity(
    @PrimaryKey
    val id: String,
    val sharedId: String,
    val size: Long,
    val createAt: Long,
    val thumbnailUrl: String
) {
    fun toSharedMediaUi() = SharedMediaUi(
        id = id,
        size = size,
        createAt = Calendar.getInstance().apply {
            timeInMillis = createAt
        },
        thumbnailUrl = thumbnailUrl,
    )
}