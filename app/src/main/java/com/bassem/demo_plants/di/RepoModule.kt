package com.bassem.demo_plants.di

import com.bassem.demo_plants.domain.repository.PlantsRepo
import com.bassem.demo_plants.domain.repository.PlantsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun providesPlantsRepo(impl: PlantsRepoImpl): PlantsRepo
}