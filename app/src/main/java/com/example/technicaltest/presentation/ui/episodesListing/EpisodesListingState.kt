package com.example.technicaltest.presentation.ui.episodesListing

import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.domain.models.DomainError

sealed class EpisodesListingState {
    class Success(val list: List<DomainEpisode>) : EpisodesListingState()
    class Error(val errorMessage: String, val domainError: DomainError? = null) : EpisodesListingState()
    object Loading : EpisodesListingState()
}
