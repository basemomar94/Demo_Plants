package com.bassem.demo_plants.di

import android.content.Context
import androidx.room.Room
import com.bassem.demo_plants.data.local.AppDatabase
import com.bassem.demo_plants.data.remote.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATA_BASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAppsDao(appDatabase: AppDatabase) = appDatabase.appsDao()
}