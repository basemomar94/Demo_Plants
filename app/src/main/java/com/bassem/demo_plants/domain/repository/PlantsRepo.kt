package com.bassem.demo_plants.domain.repository

import com.bassem.demo_plants.data.models.Result
import kotlinx.coroutines.flow.Flow
interface PlantsRepo {

   suspend fun getPlants():  Flow<Result<Any?>>
}