package com.example.technicaltest.ui.di.network

import com.example.technicaltest.data.vendors.network.router.TestRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class RouterNetworkModule {

    @Provides
    fun provideTestRouter(retrofit: Retrofit): TestRouter = retrofit.create(TestRouter::class.java)
}