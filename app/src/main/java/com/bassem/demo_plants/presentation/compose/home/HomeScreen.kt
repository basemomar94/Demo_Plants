package com.bassem.demo_plants.presentation.compose.home

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.models.Data
import com.bassem.demo_plants.presentation.compose.details.DetailsScreen
import com.bassem.demo_plants.presentation.compose.shared.AppBar

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    val activity = LocalContext.current as? Activity

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                Scaffold(topBar = {
                    AppBar(stringResource(R.string.plants),{activity?.finish()})
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
