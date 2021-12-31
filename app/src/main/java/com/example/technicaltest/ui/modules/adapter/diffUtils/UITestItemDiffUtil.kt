package com.example.technicaltest.ui.modules.adapter.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.technicaltest.presenter.models.UITestItem
import javax.inject.Inject

class UITestItemDiffUtil @Inject constructor() : DiffUtil.ItemCallback<UITestItem>() {

    override fun areItemsTheSame(oldItem: UITestItem, newItem: UITestItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: UITestItem, newItem: UITestItem): Boolean =
        oldItem == newItem
}