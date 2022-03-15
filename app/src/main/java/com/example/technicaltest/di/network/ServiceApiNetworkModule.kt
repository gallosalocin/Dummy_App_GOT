package com.example.technicaltest.di.network

import com.example.technicaltest.data.remote.api.ServiceApi
import com.example.technicaltest.data.remote.api.ServiceApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceApiNetworkModule {

    @Binds
    abstract fun bindServiceApi(serviceApi: ServiceApiImpl): ServiceApi
}