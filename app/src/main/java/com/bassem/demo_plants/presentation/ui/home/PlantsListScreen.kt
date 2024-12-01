package com.bassem.demo_plants.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.demo_plants.data.models.Data
import com.bassem.demo_plants.data.models.Result
import com.bassem.demo_plants.presentation.ui.shared.ErrorTextCompose
import com.bassem.demo_plants.presentation.ui.shared.LoadingIndicator
import com.bassem.demo_plants.presentation.viewmodels.HomeViewModel
import com.bassem.demo_plants.utils.Logger

@Composable
fun PlantsListScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: (Data) -> Unit,
    modifier: Modifier = Modifier
) {
    val logger = Logger("HomeScreen")
    val result by viewModel.plantsList.collectAsState(initial = Result.Loading)

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        logger.i("plants is $result")

        when (result) {
            is Result.Loading -> {
                LoadingIndicator()
            }

            is Result.Success -> {
                val successResult = (result as Result.Success).plantsList
                HomeList(
                    propertiesList = successResult,
                    onClick = onClick,
                )
            }

            is Result.Fail -> {
                ErrorTextCompose((result as Result.Fail).reasons)
            }
        }

    }
}
