package com.example.technicaltest.di.repositories

import com.example.technicaltest.data.repositories.MainRepositoryImpl
import com.example.technicaltest.domain.repositories.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}