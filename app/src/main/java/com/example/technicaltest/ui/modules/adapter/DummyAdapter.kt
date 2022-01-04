package com.example.technicaltest.ui.modules.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.databinding.ViewHolderBigItemBinding
import com.example.technicaltest.databinding.ViewHolderSmallItemBinding
import com.example.technicaltest.presenter.models.UIEpisodeItem
import com.example.technicaltest.ui.modules.adapter.diffUtils.UIDummyItemDiffUtil
import com.example.technicaltest.ui.modules.viewHolder.BigCellViewHolder
import com.example.technicaltest.ui.modules.viewHolder.SmallCellViewHolder
import javax.inject.Inject

class DummyAdapter @Inject constructor(
    diffUtil: UIDummyItemDiffUtil
) : ListAdapter<UIEpisodeItem, RecyclerView.ViewHolder>(diffUtil) {

    var delegate: DummyAdapterDelegate? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            BIG_CELL -> BigCellViewHolder(ViewHolderBigItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            SMALL_CELL -> SmallCellViewHolder(ViewHolderSmallItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalStateException("Invalid view type")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BigCellViewHolder -> holder.onBind(getItem(position), delegate)
            is SmallCellViewHolder -> holder.onBind(getItem(position), delegate)
            else -> throw IllegalStateException("Invalid binding at position ~> $position")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0 || position % 5 == 0) {
            BIG_CELL
        } else {
            SMALL_CELL
        }
    }

    companion object {
        const val BIG_CELL = 10
        const val SMALL_CELL = 20
    }
}