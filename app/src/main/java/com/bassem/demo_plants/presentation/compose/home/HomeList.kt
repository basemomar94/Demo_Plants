package com.bassem.demo_plants.presentation.compose.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.models.Data

@Preview(showBackground = true)
@Composable
fun HomeListPreview() {
    HomeList(propertiesList = listOf(), onClick = {})
}

@Composable
fun HomeList(
    propertiesList: List<Data>,
    onClick: (Data) -> Unit,
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(id = R.dimen.default_padding))
    ) {
        items(propertiesList, key = { it.id }) { item ->
            PlantItemView(
                item,
                onCardClick = { onClick(item) },
            )
        }
    }

}
