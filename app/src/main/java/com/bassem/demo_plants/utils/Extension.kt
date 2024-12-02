package com.bassem.demo_plants.utils

import com.bassem.demo_plants.data.models.Data

fun Int.getYear() = if (this == -1) "N/A" else "$this"

fun Data.getFormattedIndex() = "$bibliography\n$scientific_name"

