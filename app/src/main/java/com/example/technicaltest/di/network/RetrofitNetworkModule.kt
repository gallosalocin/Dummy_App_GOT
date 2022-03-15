package com.example.technicaltest.di.network

import com.example.technicaltest.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitNetworkModule {

//    @Singleton
//    @Provides
//    fun provideHttpClient(): OkHttpClient =
//        OkHttpClient.Builder()
//            .readTimeout(10, TimeUnit.SECONDS)
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}