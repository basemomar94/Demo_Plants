package com.bassem.demo_plants.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    val author: String = "",
    val bibliography: String = "",
    val common_name: String = "",
    val family: String = "",
    val genus: String = "",
    val genus_id: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var localId: Int,
    var id: Int,
    val image_url: String = "",
    val rank: String = "",
    val scientific_name: String = "",
    val slug: String = "",
    val status: String = "",
    val year: Int = 0
)