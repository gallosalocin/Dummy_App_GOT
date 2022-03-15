package com.example.technicaltest.presentation.ui.episodesListing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltest.domain.useCases.GetEpisodesListingUseCase
import com.example.technicaltest.utils.ResultHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class EpisodesListingViewModel @Inject constructor(
    private val getEpisodesListing: GetEpisodesListingUseCase,
) : ViewModel() {

    private val _viewState : MutableStateFlow<EpisodesListingState> = MutableStateFlow(EpisodesListingState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        getEpisodesListing()
    }

    private fun getEpisodesListing() {
        viewModelScope.launch {
            delay(1000)
            when (val result = getEpisodesListing.invoke()) {
                is ResultHandler.Success -> {
                    _viewState.update {
                        if (result.data != null) {
                            EpisodesListingState.Success(result.data)
                        } else {
                            EpisodesListingState.Error("liste vide")
                        }
                    }
                }
                is ResultHandler.Error -> {
                    _viewState.update {
                        EpisodesListingState.Error(result.errorMessage)
                    }
                }
            }
        }
    }
}