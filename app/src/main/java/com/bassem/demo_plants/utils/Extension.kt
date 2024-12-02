package com.bassem.demo_plants.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.bassem.demo_plants.data.models.Data

fun Int.getYear() = if (this == -1) "N/A" else "$this"

fun Data.getFormattedIndex() = "$bibliography\n$scientific_name"

fun Data.getMoreInfoUrl(): String {
    val baseUrl = "https://en.wikipedia.org/wiki/"
    return "$baseUrl${this.scientific_name.replace(" ", "_")}"
}

fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}


