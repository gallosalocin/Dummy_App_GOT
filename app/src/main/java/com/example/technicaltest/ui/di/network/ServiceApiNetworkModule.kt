package com.example.technicaltest.ui.di.network

import com.example.technicaltest.data.vendors.network.api.DummyServiceApi
import com.example.technicaltest.data.vendors.network.api.DummyServiceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ServiceApiNetworkModule {

    @Binds
    abstract fun bindTestServiceApi(testServiceApi: DummyServiceApiImpl): DummyServiceApi
}