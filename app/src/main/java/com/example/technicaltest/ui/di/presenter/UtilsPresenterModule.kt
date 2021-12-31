package com.example.technicaltest.ui.di.presenter

import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import com.example.technicaltest.presenter.utlis.NetworkSchedulersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsPresenterModule {

    @Binds
    abstract fun bindNetworkSchedulers(networkSchedulers: NetworkSchedulersImpl): NetworkSchedulers
}