package com.bassem.demo_plants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bassem.demo_plants.data.models.Data
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

@OptIn(ExperimentalCoroutinesApi::class)
open class BaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = TestResult

    internal val mockPlantsList = listOf(
        Data(localId = 1, id = 0, common_name = "Rose"),
        Data(localId = 2, id = 2, common_name = "oak"),
        Data(localId = 3, id = 3, common_name = "valved")
    )


    @BeforeEach
    open fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterEach
    open fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

}