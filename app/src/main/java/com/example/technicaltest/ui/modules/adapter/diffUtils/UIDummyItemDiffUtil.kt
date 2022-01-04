package com.example.technicaltest.ui.modules.adapter.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.technicaltest.presenter.models.UIEpisodeItem
import javax.inject.Inject

class UIDummyItemDiffUtil @Inject constructor() : DiffUtil.ItemCallback<UIEpisodeItem>() {

    override fun areItemsTheSame(oldItem: UIEpisodeItem, newItem: UIEpisodeItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: UIEpisodeItem, newItem: UIEpisodeItem): Boolean =
        oldItem == newItem
}