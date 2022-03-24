package com.example.kiliaro.common

import java.text.SimpleDateFormat
import java.util.*

private const val SERVER_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"
private val dateFormatter = SimpleDateFormat(SERVER_DATE_PATTERN, Locale.getDefault()).apply {
}

fun Calendar.fromIsoString(date: String): Calendar = apply {
    time = dateFormatter.parse(date)
}

fun Calendar.getMonthName(): String  {
    return when(this.get(Calendar.MONTH)) {
        0 -> "January"
        1 -> "February"
        2 -> "March"
        3 -> "April"
        4 -> "May"
        5 -> "June"
        6 -> "July"
        7 -> "August"
        8 -> "September"
        9 -> "October"
        10 -> "November"
        11 -> "December"
        else -> ""
    }
}