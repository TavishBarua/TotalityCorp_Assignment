package com.totalitycorp.tavishbarua.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameDto(
    val icon: String,
    val name: String,
    val description: String,
    val size: Float
) : Parcelable