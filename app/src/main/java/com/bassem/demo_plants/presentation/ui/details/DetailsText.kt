package com.bassem.demo_plants.presentation.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.demo_plants.R

@Preview
@Composable
private fun DetailsTextPreview() {
DetailsText("rate","good")

}

@Composable
fun DetailsText(title: String, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.default_padding))
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_padding)))
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyLarge
        )
    }

}