package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle

@Composable
fun TransparentHintTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    isHintVisible: Boolean,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onValueChanged: (String) -> Unit,
    onFocusChanged: (FocusState) -> Unit,
    decorationBox: @Composable (@Composable () -> Unit) -> Unit = { }
) {
    Box(modifier = modifier) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { state ->
                    onFocusChanged(state)
                },
            value = text,
            onValueChange = onValueChanged,
            singleLine = singleLine,
            textStyle = textStyle,
            decorationBox = decorationBox
        )
        if (isHintVisible) {
            Text(
                text = hint,
                style = textStyle,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
