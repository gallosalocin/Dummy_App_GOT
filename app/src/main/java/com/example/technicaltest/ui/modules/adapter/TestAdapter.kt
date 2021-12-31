package com.example.technicaltest.ui.modules.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.databinding.ViewHolderItemBinding
import com.example.technicaltest.presenter.models.UITestItem
import com.example.technicaltest.ui.modules.adapter.diffUtils.UITestItemDiffUtil
import com.example.technicaltest.ui.modules.viewHolder.TestViewHolder
import javax.inject.Inject

class TestAdapter @Inject constructor(
    diffUtil: UITestItemDiffUtil
) : ListAdapter<UITestItem, TestViewHolder>(diffUtil) {

    var delegate: TestAdapterDelegate? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder =
        TestViewHolder(ViewHolderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.onBind(getItem(position), delegate)
    }
}