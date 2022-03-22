package com.example.kilario.common

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private const val SERVER_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
private val dateFormatter = SimpleDateFormat(SERVER_DATE_PATTERN, Locale.getDefault()).apply {
}

fun Calendar.fromIsoString(date: String): Calendar = apply {
    time = dateFormatter.parse(date)
}