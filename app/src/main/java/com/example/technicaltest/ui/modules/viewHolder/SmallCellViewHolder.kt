package com.example.technicaltest.ui.modules.viewHolder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.technicaltest.R
import com.example.technicaltest.databinding.ViewHolderSmallItemBinding
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.ui.modules.adapter.DummyAdapterDelegate

class SmallCellViewHolder(
    private val binding: ViewHolderSmallItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(uiEpisodeItem: UIEpisodeItem, delegate: DummyAdapterDelegate?) {
        with(binding) {

            imageView.load(uiEpisodeItem.mediumImage) {
                error(R.drawable.ic_no_image)
            }

            seasonTextView.text = String.format(root.context.getString(R.string.season_number), uiEpisodeItem.season.toString(), uiEpisodeItem.number.toString())
            episodeTextView.text = uiEpisodeItem.name

            itemLayout.setOnClickListener { delegate?.didSelectItem(uiEpisodeItem) }
        }
    }
}