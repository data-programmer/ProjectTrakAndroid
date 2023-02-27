package com.kingsland.home.presentation.home.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TryAgainButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier.size(
            width = 120.dp,
            height = 40.dp
        ),
        onClick = onClick,
        elevation = ButtonDefaults.elevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TryAgainButtonPreview() {
    TryAgainButton(
        buttonText = "Try again",
    )
}
