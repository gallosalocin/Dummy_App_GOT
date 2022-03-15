package com.example.technicaltest.presentation.ui.episodesListing.adapter

import com.example.technicaltest.domain.models.DomainEpisode

interface AdapterDelegate {
    fun didSelectItem(domainEpisode: DomainEpisode)
}