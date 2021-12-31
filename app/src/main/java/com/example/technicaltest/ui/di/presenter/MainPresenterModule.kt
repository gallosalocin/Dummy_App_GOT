package com.example.technicaltest.ui.di.presenter

import com.example.technicaltest.presenter.modules.MainDetailsPresenter
import com.example.technicaltest.presenter.modules.MainDetailsPresenterImpl
import com.example.technicaltest.presenter.modules.MainPresenter
import com.example.technicaltest.presenter.modules.MainPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainPresenterModule {

    @Binds
    abstract fun bindMainPresenter(mainPresenter: MainPresenterImpl): MainPresenter

    @Binds
    abstract fun bindMainDetailsPresenter(mainDetailsPresenter: MainDetailsPresenterImpl): MainDetailsPresenter
}