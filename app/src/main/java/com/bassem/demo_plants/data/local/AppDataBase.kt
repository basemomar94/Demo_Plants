package com.bassem.demo_plants.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassem.demo_plants.data.models.Data


@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appsDao(): AppsDao

}
