package com.example.technicaltest.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainError(
    val identifier: String,
    val debug: String,
    val title: String,
    val message: String,
) : Parcelable