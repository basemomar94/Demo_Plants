package com.bassem.demo_plants.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    val author: String,
    val bibliography: String,
    val common_name: String,
    val family: String,
    val family_common_name: String,
    val genus: String,
    val genus_id: Int,
    @PrimaryKey
    val id: Int,
    val image_url: String,
    val rank: String,
    val scientific_name: String,
    val slug: String,
    val status: String,
    val year: Int
)