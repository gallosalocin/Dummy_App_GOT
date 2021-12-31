package com.example.technicaltest.ui.modules.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.technicaltest.databinding.ViewHolderItemBinding
import com.example.technicaltest.presenter.models.UITestItem
import com.example.technicaltest.ui.modules.adapter.TestAdapterDelegate

class TestViewHolder(
    private val binding: ViewHolderItemBinding
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(uiTestItem: UITestItem, delegate: TestAdapterDelegate?) {
        with(binding) {

            firstTextView.text = uiTestItem.id.toString()
            secondTextView.text = uiTestItem.body

            cardView.setOnClickListener { delegate?.didSelectItem(uiTestItem) }
        }
    }
}