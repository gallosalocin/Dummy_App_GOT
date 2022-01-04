package com.example.technicaltest.presenter.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIEpisodeItem(
    val url: String,
    val name: String,
    val season: Int,
    val number: Int,
    val airdate: String,
    val mediumImage: String,
    val originalImage: String,
    val summary: String
) : Parcelable
