package com.bassem.demo_plants.presentation.compose.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.demo_plants.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

@Preview(showBackground = true)
@Composable
private fun PropertyImagePreview() {
    PlantImage(imageUrl = "test", modifier = Modifier)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlantImage(imageUrl: String?, modifier: Modifier=Modifier) {
    GlideImage(
        model = imageUrl,
        contentDescription = stringResource(id = R.string.plant_image),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        loading = placeholder({
            LoadingIndicator()
        }),
        )
}