package com.example.technicaltest.presenter.modules

import com.example.technicaltest.domain.useCases.GetTestUseCase
import com.example.technicaltest.presenter.models.UITestItem
import com.example.technicaltest.presenter.models.toUIItem
import com.example.technicaltest.presenter.protocols.DisposablePresenter
import com.example.technicaltest.presenter.protocols.plusAssign
import io.reactivex.rxjava3.disposables.CompositeDisposable
import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import javax.inject.Inject

interface MainView {
    fun onReceiveTestItemsList(testItemsList: List<UITestItem>)
    fun onReceiveError()
}

interface MainPresenter : DisposablePresenter<MainView> {
    fun setup()
}

class MainPresenterImpl @Inject constructor(
    private val getTest: GetTestUseCase,
    private val networkSchedulers: NetworkSchedulers
) : MainPresenter {

    override var attachedUnsafeView: MainView? = null
    override val disposeBag = CompositeDisposable()

    override fun setup() {
        disposeBag += getTest.invoke()
            .map { domainTest -> domainTest.map { it.toUIItem() } }
            .subscribeOn(networkSchedulers.io)
            .observeOn(networkSchedulers.main)
            .subscribe({ uiTestItemsList ->
                view.onReceiveTestItemsList(uiTestItemsList)
            }, { view.onReceiveError() })
    }
}
