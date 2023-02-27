package com.kingsland.home.presentation.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kingsland.home.R
import com.kingsland.home.presentation.home.component.TryAgainButton

@Composable
fun HomeError(
    onClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.error_message),
            style = MaterialTheme.typography.body1
        )
        TryAgainButton(
            buttonText = stringResource(R.string.try_again),
            onClick = onClick
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeErrorPreview() {
    HomeError()
}
