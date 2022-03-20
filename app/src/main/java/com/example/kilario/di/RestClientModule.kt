package com.example.kilario.di

import android.content.Context
import com.example.kilario.BuildConfig
import com.example.kilario.data.api.ResponseCodeInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.coroutines.ContinuationInterceptor

@InstallIn(SingletonComponent::class)
@Module
class RestClientModule {

    companion object {
        private const val CONNECTION_TIME_OUT: Long = 30
        private const val READ_TIME_OUT: Long = 60
        private const val WRITE_TIME_OUT: Long = 60
        private const val BASE_URL = BuildConfig.BASEURL
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        context: Context,
        responseCodeInterceptor: ResponseCodeInterceptor
    ): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE


        val cache = Cache(context.cacheDir, (10*1024*1024).toLong())

        return OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .addInterceptor(responseCodeInterceptor)
            .cache(cache)
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create()
    }

}