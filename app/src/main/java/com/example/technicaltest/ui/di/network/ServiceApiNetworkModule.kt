package com.example.technicaltest.ui.di.network

import com.example.technicaltest.data.vendors.network.api.TestServiceApi
import com.example.technicaltest.data.vendors.network.api.TestServiceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ServiceApiNetworkModule {

    @Binds
    abstract fun bindTestServiceApi(testServiceApi: TestServiceApiImpl): TestServiceApi
}