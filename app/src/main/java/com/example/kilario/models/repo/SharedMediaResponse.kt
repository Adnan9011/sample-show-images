package com.example.kilario.models.repo

import com.example.kilario.models.ui.SharedMediaUi
import com.google.gson.annotations.SerializedName
import java.util.*

data class SharedMediaResponse(
    val id: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("media_type")
    val mediaType: MediaType,
    val filename: String,
    val size: Long,
    @SerializedName("created_at")
    val createAt: Calendar?,
    @SerializedName("taken_at")
    val takenAt: Calendar?,
    @SerializedName("guessed_taken_at")
    val guessedTakenAt: Calendar?,
    val md5sum: String,
//    val contentType: MediaContentType,
//    val video: SharedMediaVideo,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    val resx: Int,
    val resy: Int
    ) {
    fun toSharedMediaUi(): SharedMediaUi = SharedMediaUi(
        id = id,
        userId = userId,
        mediaType = mediaType,
        filename = filename,
        size = size,
        createAt = createAt,
        takenAt = takenAt,
        guessedTakenAt = guessedTakenAt,
        md5sum = md5sum,
        thumbnailUrl = thumbnailUrl,
        downloadUrl = downloadUrl,
        resx = resx,
        resy = resy
    )
}

enum class MediaType {
    image,
    video;
}