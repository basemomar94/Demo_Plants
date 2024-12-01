package com.bassem.demo_plants.presentation.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.models.Data
import com.bassem.demo_plants.presentation.ui.details.DetailsScreen
import com.bassem.demo_plants.presentation.ui.shared.AppBar

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                Scaffold(topBar = {
                    AppBar(stringResource(R.string.plants),{navigator.navigateBack()})
                }) { padding ->
                    PlantsListScreen(modifier = modifier.padding(padding), onClick = { plant ->
                        navigator.navigateTo(
                            pane = ListDetailPaneScaffoldRole.Detail,
                            content = plant
                        )
                    })
                }
            }
        },
        detailPane = {
            AnimatedPane {
                navigator.currentDestination?.content?.let { plant ->
                    Scaffold(topBar = {
                        AppBar(
                            stringResource(R.string.details),
                            onBackClick = { navigator.navigateBack() })
                    }) { padding ->
                        DetailsScreen(plant = plant as Data, modifier.padding(padding))
                    }
                }
            }
        },
    )
}
