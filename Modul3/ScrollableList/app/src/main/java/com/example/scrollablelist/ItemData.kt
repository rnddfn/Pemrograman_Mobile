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

val itemList = listOf(
    ItemData("Cirrostratus", R.drawable.cirrostratus, "https://id.wikipedia.org/wiki/Awan_sirostratus", R.string.cirrostratus_desc),
    ItemData("Cirrocumulus", R.drawable.cirrocumulus, "https://id.wikipedia.org/wiki/Awan_sirokumulus", R.string.cirrocumulus_desc),
    ItemData("Cumulus", R.drawable.cumulus, "https://id.wikipedia.org/wiki/Awan_kumulus", R.string.cumulus_desc),
    ItemData("Altostratus", R.drawable.altostratus, "https://id.wikipedia.org/wiki/Awan_altostratus", R.string.altostratus_desc),
    ItemData("Cumulonimbus", R.drawable.cumulonimbus, "https://id.wikipedia.org/wiki/Awan_kumulonimbus", R.string.cumulonimbus_desc),
)
