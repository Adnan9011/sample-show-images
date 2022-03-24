package com.example.kiliaro.di

import com.example.kiliaro.repository.SharesRepository
import com.example.kiliaro.repository.impl.SharesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSharesRepository(impl: SharesRepositoryImpl): SharesRepository = impl
}