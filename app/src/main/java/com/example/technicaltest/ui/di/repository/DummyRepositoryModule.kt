package com.example.technicaltest.ui.di.repository

import com.example.technicaltest.data.repositories.DummyRepositoryImpl
import com.example.technicaltest.domain.repositories.DummyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DummyRepositoryModule {

    @Binds
    abstract fun bindTestRepository(testRepository: DummyRepositoryImpl): DummyRepository
}