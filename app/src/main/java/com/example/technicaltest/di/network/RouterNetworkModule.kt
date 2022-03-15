package com.example.technicaltest.di.network

import com.example.technicaltest.data.remote.router.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RouterNetworkModule {

    @Provides
    @Singleton
    fun provideRouter(retrofit: Retrofit): Router =
        retrofit.create(Router::class.java)
}