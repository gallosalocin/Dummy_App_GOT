package com.example.technicaltest.ui.di.repository

import com.example.technicaltest.data.repositories.TestRepositoryImpl
import com.example.technicaltest.domain.repositories.TestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class TestRepositoryModule {

    @Binds
    abstract fun bindTestRepository(testRepository: TestRepositoryImpl): TestRepository
}