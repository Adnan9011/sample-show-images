package com.example.kiliaro.data.db.sharedmedia

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SharedMediaDao {
    @Query("SELECT * FROM $SHARED_MEDIA_TABLE_NAME WHERE $SHARED_MEDIA_COLUMN_SHARED_ID = :sharedId")
    suspend fun getAll(sharedId: String): List<SharedMediaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<SharedMediaEntity>)

    @Query("DELETE FROM $SHARED_MEDIA_TABLE_NAME WHERE $SHARED_MEDIA_COLUMN_SHARED_ID = :sharedId")
    suspend fun deleteAll(sharedId:String)
}