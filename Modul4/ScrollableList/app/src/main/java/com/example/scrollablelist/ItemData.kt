package com.example.scrollablelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    val name: String,
    val pictureId: Int,
    val url: String,
    val description: Int
) : Parcelable
