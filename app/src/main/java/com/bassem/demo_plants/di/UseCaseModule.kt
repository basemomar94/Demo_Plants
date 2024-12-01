package com.bassem.demo_plants.di

import com.bassem.demo_plants.domain.repository.PlantsRepo
import com.bassem.demo_plants.domain.usecases.FetchPlantsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchPlantsUseCase(
        propertiesRepo: PlantsRepo
    ): FetchPlantsUseCase {
        return FetchPlantsUseCase(propertiesRepo)
    }
}
