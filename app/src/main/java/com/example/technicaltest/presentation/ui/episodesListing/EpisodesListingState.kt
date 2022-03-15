package com.example.technicaltest.presentation.ui.episodesListing

import com.example.technicaltest.domain.models.DomainEpisode

sealed class EpisodesListingState {
    class Success(val list: List<DomainEpisode>) : EpisodesListingState()
    class Error(val errorMessage: String) : EpisodesListingState()
    object Loading : EpisodesListingState()
}
