package com.example.kiliaro.models.ui

import android.os.Parcelable
import com.example.kiliaro.common.getMonthName
import com.example.kiliaro.models.repo.MediaType
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
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
    ): Parcelable {
    fun getSizeOfImage(): String {
        return String.format("%.1f", (size/1024f)/1024f)+" MB"
    }
    fun getFullDate(): String {
        return createAt?.run {
            val str = StringBuilder()
            str.append(this.get(Calendar.DATE).toString())
            str.append(" ")
            str.append(this.getMonthName())
            str.append(" ")
            str.append(this.get(Calendar.YEAR))
            str.append(", ")
            if(this.get(Calendar.HOUR_OF_DAY)>9)
                str.append(this.get(Calendar.HOUR_OF_DAY))
            else
                str.append("0"+this.get(Calendar.HOUR_OF_DAY))
            str.append(":")
            if(this.get(Calendar.MINUTE)>9)
                str.append(this.get(Calendar.MINUTE))
            else
                str.append("0"+this.get(Calendar.MINUTE))

            str.toString()
        }
            ?: "Missing date of created"
    }
    fun getThumbnailUrl(width: Int,height: Int,scaleType: ScaleType=ScaleType.CROP): String {
        val str = StringBuilder()
        str.append(thumbnailUrl)
        str.append("?")
        str.append("w=")
        str.append(width)
        str.append("&")
        str.append("h=")
        str.append(height)
        str.append("&")
        str.append("m=")
        str.append(scaleType.type)

        return str.toString()
    }

    enum class ScaleType(val type:String) {
        BOUND("bb"),
        CROP("crop"),
        MINIMUM("md");
    }
}