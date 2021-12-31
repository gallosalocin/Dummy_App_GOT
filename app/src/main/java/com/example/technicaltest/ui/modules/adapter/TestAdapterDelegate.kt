package com.example.technicaltest.ui.modules.adapter

import com.example.technicaltest.presenter.models.UITestItem

interface TestAdapterDelegate {
    fun didSelectItem(item: UITestItem)
}