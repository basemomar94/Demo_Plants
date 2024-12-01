package com.bassem.demo_plants.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bassem.demo_plants.data.models.Data

@Dao
interface AppsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPlants(plants: List<Data>)

    @Query("DELETE FROM data")
    fun deleteAllPlants()

    @Query("SELECT * FROM data")
    fun getAllPlants(): List<Data>

}
