package com.bassem.demo_plants.presentation.compose.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.models.Data
import com.bassem.demo_plants.presentation.compose.home.PlantName
import com.bassem.demo_plants.presentation.compose.shared.PlantImage
import com.bassem.demo_plants.utils.getFormattedIndex
import com.bassem.demo_plants.utils.getMoreInfoUrl
import com.bassem.demo_plants.utils.openUrl

@Preview
@Composable
fun DetailsScreenPreview() {

}

@Composable
fun DetailsScreen(
    plant: Data,
    modifier: Modifier = Modifier,
) {
    with(plant) {
        DetailsCompose(
            plantName = common_name,
            image = image_url,
            family = family,
            formattedIndex = plant.getFormattedIndex(),
            author = author,
            infoUrl = plant.getMoreInfoUrl()
        )
    }


}

@Composable
fun DetailsCompose(
    plantName: String,
    image: String,
    family: String,
    formattedIndex: String,
    author: String,
    infoUrl: String,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.default_padding))
            .verticalScroll(scrollState)
    ) {
        PlantImage(
            imageUrl = image,
            modifier = modifier.height(dimensionResource(R.dimen.details_image_height))
        )
        PlantName(
            name = plantName,
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.default_padding)))

        DetailsText(stringResource(R.string.family), family)
        DetailsText(stringResource(R.string.index), formattedIndex)
        DetailsText(stringResource(R.string.author), author)
        MoreDetailsButton(onClick = {
            context.openUrl(infoUrl)
        })


    }
}