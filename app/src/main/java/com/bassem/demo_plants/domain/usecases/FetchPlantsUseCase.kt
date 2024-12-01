package com.bassem.demo_plants.domain.usecases

import com.bassem.demo_plants.data.remote.ApiService
import com.bassem.demo_plants.data.remote.TOKEN
import javax.inject.Inject

class FetchPlantsUseCase @Inject constructor(private val api: ApiService) {
    suspend operator fun invoke() = api.getPlants(TOKEN)
}