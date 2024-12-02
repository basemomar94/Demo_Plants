package com.bassem.demo_plants.viewmodel

import com.bassem.demo_plants.data.models.Result
import com.bassem.demo_plants.BaseTest
import com.bassem.demo_plants.domain.usecases.FetchPlantsUseCase
import com.bassem.demo_plants.presentation.viewmodels.HomeViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest : BaseTest() {

    private lateinit var viewModel: HomeViewModel
    private val mockUseCase: FetchPlantsUseCase = mockk(relaxed = true)


    override fun setup() {
        super.setup()
        viewModel = HomeViewModel(mockUseCase)
    }

    @Test
    fun fetchPlantsList_emits_loading_state_before_fetching_data() = runTest {
        val loadingState = Result.Loading

        coEvery { mockUseCase() } returns flowOf(loadingState)

        viewModel.fetchPlants()

        advanceUntilIdle()

        coVerify { mockUseCase() }

        val emittedResult = viewModel.plantsList.first()

        assert(emittedResult == loadingState)
    }


    @Test
    fun fetchPlantsList_updates_PlantsList_with_fetched_results() = runTest {


        val exceptedResult = Result.Success(mockPlantsList)

        coEvery { mockUseCase() } returns flowOf(exceptedResult)

        viewModel.fetchPlants()

        advanceUntilIdle()

        coVerify { mockUseCase() }

        val emittedResult = viewModel.plantsList.first()

        assert(emittedResult == exceptedResult)
    }

    @Test
    fun fetchPlantsList_fail_case() = runTest {

        val exceptedResult = Result.Fail("Fail")

        coEvery { mockUseCase() } returns flowOf(exceptedResult)

        viewModel.fetchPlants()

        advanceUntilIdle()

        coVerify { mockUseCase() }

        val actual  = viewModel.plantsList.first()

        assert(actual == exceptedResult)
    }


}







