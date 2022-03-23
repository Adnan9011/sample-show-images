package com.example.kilario.models.ui

import com.example.kilario.models.repo.MediaType
import java.util.*

data class SharedMediaUi(
    val id:String,
    val userId: String,
    val mediaType: MediaType,
    val filename: String,
    val size: Long,
    val createAt: Calendar?,
    val takenAt: Calendar?,
    val guessedTakenAt: Calendar?,
    val md5sum: String,
    val thumbnailUrl: String,
    val downloadUrl: String,
    val resX: Int,
    val resY: Int
    ) {
    fun getSizeOfImage(): String {
        return String.format("%.1f", (size/1024f)/1024f)+" MB"
    }
}