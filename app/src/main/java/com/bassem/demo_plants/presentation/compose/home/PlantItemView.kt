package com.bassem.demo_plants.presentation.compose.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.demo_plants.R
import com.bassem.demo_plants.data.models.Data
import com.bassem.demo_plants.presentation.compose.details.DetailsText
import com.bassem.demo_plants.presentation.compose.shared.PlantImage
import com.bassem.demo_plants.utils.getYear


@Preview(showBackground = true)
@Composable
private fun PreviewPlantItemView() {
    PlantItemCompose(
        name = "Sphinx Hotel",
        imageUrl = "",
        year = -1,
        onCardClick = {},
    )
}

@Composable
fun PlantItemView(plant: Data, onCardClick: () -> Unit) {
    with(plant) {
        PlantItemCompose(
            name = common_name,
            imageUrl = image_url,
            onCardClick = onCardClick,
            year = year
        )
    }

}

@Composable
private fun PlantItemCompose(
    name: String,
    imageUrl: String?,
    year: Int,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClick,
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.card_side_margin))
            .shadow(
                elevation = dimensionResource(
                    id = R.dimen.small_padding,
                ), shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Box {
                PlantImage(
                    imageUrl = imageUrl, modifier = modifier
                        .fillMaxWidth()
                        .height(
                            dimensionResource(id = R.dimen.image_height)
                        )
                )
                Column(modifier = modifier.align(Alignment.BottomCenter)) {
                    DetailsText(stringResource(R.string.year), year.getYear())

                }
            }
            PlantName(name)
        }
    }


}