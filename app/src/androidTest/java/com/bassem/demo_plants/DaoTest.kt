package com.bassem.demo_plants

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.bassem.demo_plants.data.local.AppDatabase
import com.bassem.demo_plants.data.local.AppsDao
import com.bassem.demo_plants.data.models.Data
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DaoTest {
    private lateinit var db: AppDatabase
    private lateinit var appDao: AppsDao
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val mockPlantsList = listOf(
        Data(localId = 1, id = 0, common_name = "Rose"),
        Data(localId = 2, id = 2, common_name = "oak"),
        Data(localId = 3, id = 3, common_name = "valved")
    )

    @Before
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
            .build()
        appDao = db.appsDao()
        appDao.insertAllPlants(mockPlantsList)
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun test_inserting_plants() = runTest {
        val actual = appDao.getAllPlants()
        Assert.assertEquals(3, actual.size)
    }

    @Test
    fun test_delete_all_plants() = runTest {
        appDao.deleteAllPlants()
        val actual = appDao.getAllPlants().size
        Assert.assertEquals(0, actual)
    }

}