package com.example.kiliaro.models.repo

import com.example.kiliaro.models.ui.SharedMediaUi
import com.google.gson.annotations.SerializedName
import java.util.*

data class SharedMediaResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("media_type")
    val mediaType: MediaType,
    @SerializedName("filename")
    val filename: String,
    @SerializedName("size")
    val size: Long,
    @SerializedName("created_at")
    val createAt: Calendar?,
    @SerializedName("taken_at")
    val takenAt: Calendar?,
    @SerializedName("guessed_taken_at")
    val guessedTakenAt: Calendar?,
    @SerializedName("md5sum")
    val md5sum: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    @SerializedName("resx")
    val resX: Int,
    @SerializedName("resy")
    val resY: Int
    ) {
    fun toSharedMediaUi(): SharedMediaUi = SharedMediaUi(
        id = id,
        size = size,
        createAt = createAt,
        thumbnailUrl = thumbnailUrl,
        downloadUrl = downloadUrl
    )
}

enum class MediaType {
    image,
    video;
}