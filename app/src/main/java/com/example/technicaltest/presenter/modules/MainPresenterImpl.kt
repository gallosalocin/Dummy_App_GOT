package com.example.technicaltest.presenter.modules

import android.util.Log
import com.example.technicaltest.data.vendors.network.router.DummyRouter
import com.example.technicaltest.domain.useCases.GetCoroutinesEpisodesUseCase
import com.example.technicaltest.domain.useCases.GetEpisodesUseCase
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.presenter.models.toUIItem
import com.example.technicaltest.presenter.protocols.DisposablePresenter
import com.example.technicaltest.presenter.protocols.plusAssign
import io.reactivex.rxjava3.disposables.CompositeDisposable
import com.example.technicaltest.presenter.utlis.NetworkSchedulers
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MainView {
    fun onReceiveTestItemsList(episodesList: List<UIEpisodeItem>)
    fun onReceiveError(error: String)
}

interface MainPresenter : DisposablePresenter<MainView> {
    fun setup()
}

class MainPresenterImpl @Inject constructor(
    private val getEpisodes: GetEpisodesUseCase,
    private val networkSchedulers: NetworkSchedulers,
    private val getCoroutinesEpisodes: GetCoroutinesEpisodesUseCase
) : MainPresenter {

    override var attachedUnsafeView: MainView? = null
    override val disposeBag = CompositeDisposable()

    /**
     * Call with coroutines
     */
    override fun setup() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = getCoroutinesEpisodes.invoke()
                .map { it.toUIItem() }

            withContext(Dispatchers.Main) {
                view.onReceiveTestItemsList(result)
            }
        }
    }

    /**
     * Call with rxjava
     */
//    override fun setup() {
//        disposeBag += getEpisodes.invoke()
//            .map { domainEpisodesList -> domainEpisodesList.map { it.toUIItem() } }
//            .subscribeOn(networkSchedulers.io)
//            .observeOn(networkSchedulers.main)
//            .subscribe({ uiEpisodeItemsList ->
//                view.onReceiveTestItemsList(uiEpisodeItemsList)
//            }, { view.onReceiveError() })
//    }
}
