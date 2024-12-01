package com.bassem.demo_plants.domain.repository

import android.content.Context
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.local.AppsDao
import com.bassem.demo_plants.data.models.Result
import com.bassem.demo_plants.data.remote.ApiService
import com.bassem.demo_plants.data.remote.TOKEN
import com.bassem.demo_plants.utils.Logger
import com.google.gson.JsonParseException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.withContext
import java.io.IOException
import java.sql.SQLException
import javax.inject.Inject

class PlantsRepoImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiService: ApiService,
    private val dao: AppsDao
) : PlantsRepo {
    private val logger = Logger("PlantsRepoImpl")


    override suspend fun getPlants() = flow {
        emit(Result.Loading)
        logger.i("Loading data...")

        var localPlants = withContext(Dispatchers.IO) { dao.getAllPlants() }

        try {
            val remoteBreeds = apiService.getPlants(TOKEN).data

            withContext(Dispatchers.IO) {
                dao.deleteAllPlants()
                dao.insertAllPlants(remoteBreeds)
                localPlants = dao.getAllPlants()
            }

            emit(Result.Success(localPlants))


        } catch (e: Exception) {
            logger.e("Unexpected error: ${e.message}")
            if (localPlants.isEmpty()) {
                emit(Result.Fail(context.getExceptionMessage(e)))
            } else {
                emit(Result.Success(localPlants))
            }


        }
    }.retry(3)


    private fun Context.getExceptionMessage(e: Exception) = when (e) {
        is IOException -> getString(R.string.net_work_error)
        is SQLException -> getString(R.string.local_parsing_error)
        is JsonParseException -> getString(R.string.remote_parsing_error)
        else -> getString(R.string.unexpected_error)
    }

}