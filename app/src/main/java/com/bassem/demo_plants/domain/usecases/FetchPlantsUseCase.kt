package com.bassem.demo_plants.domain.usecases

import com.bassem.demo_plants.domain.repository.PlantsRepo
import javax.inject.Inject

class FetchPlantsUseCase @Inject constructor(private val plantsRepo: PlantsRepo) {

    suspend operator fun invoke() = plantsRepo.getPlants()
}