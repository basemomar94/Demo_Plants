package com.bassem.demo_plants.data.remote

import com.bassem.demo_plants.data.models.PlantsResult
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * When I select a zone filter from the available filters (All, Palestine, Sudan,
 * Myanmar,Transcaucasus, Uzbekistan), only plants with the selected filter must
 * be shown. this was asked as a part of the task, but the distribution field was deprecated according to the api
 * documentation https://docs.trefle.io/docs/advanced/plants-fields/
 */

interface ApiService {
    @GET("plants")
    suspend fun getPlants(
        @Query("token") token: String
    ): PlantsResult
}
