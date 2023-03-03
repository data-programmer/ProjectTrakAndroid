package com.kingsland.projects.presentation.edit.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun ProjectTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChanged,
        singleLine = singleLine,
        label = { Text(text = label) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.background
        ),
        textStyle = textStyle
    )
}
