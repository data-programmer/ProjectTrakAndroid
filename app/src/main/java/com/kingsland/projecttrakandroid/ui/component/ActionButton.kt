package com.kingsland.projecttrakandroid.ui.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(
    isVisible: Boolean,
    onClick: () -> Unit = { }
) {
    if (isVisible) {
        FloatingActionButton(
            onClick = onClick,
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ActionButtonPreview() {
    ActionButton(
        isVisible = true
    )
}