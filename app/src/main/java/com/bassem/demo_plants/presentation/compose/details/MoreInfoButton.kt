package com.bassem.demo_plants.presentation.compose.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bassem.demo_plants.R

@Preview
@Composable
fun MoreDetailsButtonPreview() {
    MoreDetailsButton({})
}

@Composable
fun MoreDetailsButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = dimensionResource(R.dimen.small_padding))
            .background(
                color = Color.Blue,
                shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
            )
            .padding(dimensionResource(R.dimen.default_padding))
    ) {
        Text(
            text = stringResource(R.string.more_details),
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
