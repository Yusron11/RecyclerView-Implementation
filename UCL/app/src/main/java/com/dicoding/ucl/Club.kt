package com.dicoding.ucl

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
