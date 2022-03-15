package com.example.technicaltest.presentation.ui.episodesListing.adapter.viewHolder

import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.technicaltest.R
import com.example.technicaltest.databinding.ViewHolderBigItemBinding
import com.example.technicaltest.domain.models.DomainEpisode
import com.example.technicaltest.presentation.ui.episodesListing.adapter.AdapterDelegate

class BigCellViewHolder(
    private val binding: ViewHolderBigItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(domainEpisodeItem: DomainEpisode, delegate: AdapterDelegate?) {
        with(binding) {

            imageView.load(domainEpisodeItem.originalImage) {
                error(R.drawable.ic_no_image)
            }

            episodeTextView.text = domainEpisodeItem.name
            seasonTextView.text = String.format(root.context.getString(R.string.season_number), domainEpisodeItem.season.toString(), domainEpisodeItem.number.toString())
            summaryTextView.text = HtmlCompat.fromHtml(domainEpisodeItem.summary, HtmlCompat.FROM_HTML_MODE_COMPACT)

            itemLayout.setOnClickListener { delegate?.didSelectItem(domainEpisodeItem) }
        }
    }
}