package com.example.technicaltest.ui.modules.adapter

import com.example.technicaltest.presenter.models.UIEpisodeItem

interface DummyAdapterDelegate {
    fun didSelectItem(item: UIEpisodeItem)
}