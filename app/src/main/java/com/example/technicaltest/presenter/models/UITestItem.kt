package com.example.technicaltest.presenter.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UITestItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val body:String
) : Parcelable
