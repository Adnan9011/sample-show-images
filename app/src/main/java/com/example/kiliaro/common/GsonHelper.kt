package com.example.kiliaro.common

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.util.*

class CalendarGsonDeserializer: JsonDeserializer<Calendar> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Calendar {
        return Calendar.getInstance().fromIsoString(json!!.asString)
    }
}