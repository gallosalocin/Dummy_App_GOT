package com.example.technicaltest.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainEpisode(
    val url: String,
    val name: String,
    val season: Int,
    val number: Int,
    val airdate: String,
    val airtime: String,
    val runtime: Int,
    val mediumImage: String,
    val originalImage: String,
    val summary: String,
) : Parcelable
