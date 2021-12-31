package com.example.technicaltest.presenter.modules

import com.example.technicaltest.presenter.protocols.DisposablePresenter
import io.reactivex.rxjava3.disposables.CompositeDisposable
import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import javax.inject.Inject

interface MainDetailsView {

}

interface MainDetailsPresenter : DisposablePresenter<MainDetailsView> {
    fun setup()
}

class MainDetailsPresenterImpl @Inject constructor(
    private val networkSchedulers: NetworkSchedulers
) : MainDetailsPresenter {

    override var attachedUnsafeView: MainDetailsView? = null
    override val disposeBag = CompositeDisposable()

    override fun setup() {
    }
}
