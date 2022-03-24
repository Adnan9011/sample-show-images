package com.example.kiliaro.di

import android.content.Context
import androidx.room.Room
import com.example.kiliaro.data.db.sharedmedia.SHARED_MEDIA_DATABASE
import com.example.kiliaro.data.db.sharedmedia.SharedMediaDao
import com.example.kiliaro.data.db.sharedmedia.SharedMediaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideSharedMediaDatabase(context: Context): SharedMediaDatabase {
        return Room.databaseBuilder(
            context,
            SharedMediaDatabase::class.java,
            SHARED_MEDIA_DATABASE
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideSharedMediaDao(db: SharedMediaDatabase): SharedMediaDao {
        return db.sharedMediaDao()
    }
}