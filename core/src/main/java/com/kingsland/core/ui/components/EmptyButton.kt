package com.kingsland.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EmptyButton(
    imageVector: ImageVector,
    message: String,
    buttonIcon: ImageVector,
    onButtonClick: () -> Unit = { }
) {
    ButtonLayout(
        buttonIcon = buttonIcon,
        onButtonClick = onButtonClick,
    ) {
        Empty(
            imageVector = imageVector,
            message = message
        )
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyButtonPreview() {
    EmptyButton(
        imageVector = Icons.Filled.Create,
        message = "This screen is empty",
        buttonIcon = Icons.Filled.Add,
        onButtonClick = { }
    )
}