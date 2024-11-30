package com.bassem.demo_plants.data.models

data class PlantsResult(
    val `data`: List<Data>,
    val links: LinksX,
    val meta: Meta
)