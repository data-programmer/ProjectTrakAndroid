package com.kingsland.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonLayout(
    buttonIcon: ImageVector,
    onButtonClick: () -> Unit = { },
    content: @Composable (Modifier) -> Unit = { }
) {
    Box(Modifier.fillMaxSize()) {
        content(Modifier.align(Alignment.TopCenter))
        FloatingActionButton(
            modifier = Modifier
                .size(85.dp)
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            shape = CircleShape,
            backgroundColor = MaterialTheme.colors.primary,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            onClick = onButtonClick
        ) {
            Icon(
                imageVector = buttonIcon,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ButtonLayoutPreview() {
    ButtonLayout(
        buttonIcon = Icons.Filled.Add,
        onButtonClick = { },
        content = { modifier ->
            Text(
                modifier = modifier,
                text = "This is an example"
            )
        }
    )
}