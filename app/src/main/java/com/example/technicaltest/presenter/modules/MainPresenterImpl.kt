package com.example.technicaltest.presenter.modules

import com.example.technicaltest.domain.useCases.GetEpisodesUseCase
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.presenter.models.toUIItem
import com.example.technicaltest.presenter.protocols.DisposablePresenter
import com.example.technicaltest.presenter.protocols.plusAssign
import io.reactivex.rxjava3.disposables.CompositeDisposable
import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import javax.inject.Inject

interface MainView {
    fun onReceiveTestItemsList(episodesList: List<UIEpisodeItem>)
    fun onReceiveError()
}

interface MainPresenter : DisposablePresenter<MainView> {
    fun setup()
}

class MainPresenterImpl @Inject constructor(
    private val getEpisodes: GetEpisodesUseCase,
    private val networkSchedulers: NetworkSchedulers
) : MainPresenter {

    override var attachedUnsafeView: MainView? = null
    override val disposeBag = CompositeDisposable()

    override fun setup() {
        disposeBag += getEpisodes.invoke()
            .map { domainEpisodesList -> domainEpisodesList.map { it.toUIItem() } }
            .subscribeOn(networkSchedulers.io)
            .observeOn(networkSchedulers.main)
            .subscribe({ uiEpisodeItemsList ->
                view.onReceiveTestItemsList(uiEpisodeItemsList)
            }, { view.onReceiveError() })
    }
}
