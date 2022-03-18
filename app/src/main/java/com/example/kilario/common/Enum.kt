package com.example.kilario.common


inline fun <reified T : Enum<*>> valueOfOrNull(name: String): T? =
    T::class.java.enumConstants?.firstOrNull { it.name == name }