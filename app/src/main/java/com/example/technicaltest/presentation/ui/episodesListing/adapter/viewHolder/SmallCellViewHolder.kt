package com.example.technicaltest.presentation.ui.episodesListing.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.technicaltest.R
import com.example.technicaltest.databinding.ViewHolderSmallItemBinding
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.presentation.ui.episodesListing.adapter.AdapterDelegate

class SmallCellViewHolder(
    private val binding: ViewHolderSmallItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(domainEpisodeItem: DomainEpisode, delegate: AdapterDelegate?) {
        with(binding) {

            imageView.load(domainEpisodeItem.mediumImage) {
                error(R.drawable.ic_no_image)
            }

            seasonTextView.text = String.format(root.context.getString(R.string.season_number), domainEpisodeItem.season.toString(), domainEpisodeItem.number.toString())
            episodeTextView.text = domainEpisodeItem.name

            itemLayout.setOnClickListener { delegate?.didSelectItem(domainEpisodeItem) }
        }
    }
}