package com.example.kiliaro.data.db.sharedmedia

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kiliaro.models.entity.SharedMediaEntity

const val SHARED_MEDIA_DATABASE = "shared_media_database"

@Database(entities = [SharedMediaEntity::class], version = 1, exportSchema = false)
abstract class SharedMediaDatabase : RoomDatabase() {
    abstract fun sharedMediaDao(): SharedMediaDao
}