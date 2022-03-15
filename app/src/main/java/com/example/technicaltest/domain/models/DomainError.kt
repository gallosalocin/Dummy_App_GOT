package com.example.technicaltest.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainError(
    val code: Int,
    val key: String,
    val message: String
) : Parcelable