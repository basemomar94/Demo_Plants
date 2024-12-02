package com.bassem.demo_plants.presentation.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.bassem.demo_plants.R

@Preview
@Composable
private fun DetailsTextPreview() {
DetailsText("rate","good")

}

@Composable
fun DetailsText(
    title: String,
    text: String,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.small_padding)),
        color = backgroundColor,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        shadowElevation = dimensionResource(R.dimen.small_padding)
    ) {
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.small_padding)),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = stringResource(R.string.icon),
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_size)).align(Alignment.CenterVertically),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_padding)))

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.small_padding)))
                Text(
                    text = text,
                    style =  MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

