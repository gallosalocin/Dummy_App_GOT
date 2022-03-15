package com.example.technicaltest.presentation.ui.episodesListing.adapter.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.technicaltest.domain.models.DomainEpisode
import javax.inject.Inject

class DomainEpisodeItemDiffUtil @Inject constructor() : DiffUtil.ItemCallback<DomainEpisode>() {

    override fun areItemsTheSame(oldItem: DomainEpisode, newItem: DomainEpisode): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: DomainEpisode, newItem: DomainEpisode): Boolean =
        oldItem == newItem
}