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
    val resx: Int,
    val resy: Int
    )