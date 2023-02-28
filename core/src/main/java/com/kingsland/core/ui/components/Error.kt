package com.kingsland.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Error(
    imageVector: ImageVector,
    message: String,
    buttonText: String,
    onClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(60.dp),
            imageVector = imageVector,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(vertical = 18.dp),
            text = message,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        TryAgainButton(
            buttonText = buttonText,
            onClick = onClick
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeErrorPreview() {
    Error(
        imageVector = Icons.Filled.Close,
        message = "",
        buttonText = ""
    )
}
