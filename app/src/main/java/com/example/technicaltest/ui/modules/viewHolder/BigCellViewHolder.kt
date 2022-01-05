package com.example.technicaltest.ui.modules.viewHolder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.technicaltest.R
import com.example.technicaltest.databinding.ViewHolderBigItemBinding
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.ui.modules.adapter.DummyAdapterDelegate

class BigCellViewHolder(
    private val binding: ViewHolderBigItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(uiEpisodeItem: UIEpisodeItem, delegate: DummyAdapterDelegate?) {
        with(binding) {

            imageView.load(uiEpisodeItem.originalImage) {
                error(R.drawable.ic_no_image)
            }

            episodeTextView.text = uiEpisodeItem.name
            seasonTextView.text = String.format(root.context.getString(R.string.season_number), uiEpisodeItem.season.toString(), uiEpisodeItem.number.toString())
            summaryTextView.text = uiEpisodeItem.summary

            itemLayout.setOnClickListener { delegate?.didSelectItem(uiEpisodeItem) }
        }
    }
}