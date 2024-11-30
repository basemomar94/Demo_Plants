package com.bassem.demo_plants.data.remote

import com.bassem.demo_plants.data.models.PlantsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("plants")
    suspend fun getPlants(
        @Query("token") token: String
    ): PlantsResult
}