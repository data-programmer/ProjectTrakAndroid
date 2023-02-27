package com.kingsland.home.presentation.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kingsland.home.R

@Composable
fun HomeEmpty() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: Place an image here
        Icon(
            imageVector = Icons.Filled.Create,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.empty_message),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeEmptyPreview() {
    HomeEmpty()
}