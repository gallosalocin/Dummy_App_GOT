package com.example.technicaltest.presenter.modules

import com.example.technicaltest.presenter.protocols.Presenter
import javax.inject.Inject

interface MainDetailsView {

}

interface MainDetailsPresenter : Presenter<MainDetailsView> {
    fun setup()
}

class MainDetailsPresenterImpl @Inject constructor() : MainDetailsPresenter {

    override var attachedUnsafeView: MainDetailsView? = null

    override fun setup() {
    }
}
