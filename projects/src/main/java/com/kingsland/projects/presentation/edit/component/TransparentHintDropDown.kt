package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.projects.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransparentHintDropDown(
    isHintVisible: Boolean,
    onValueChanged: (String) -> Unit,
    onFocusChanged: (FocusState) -> Unit
) {
    val options = listOf("", "High", "Medium-High", "Medium", "Medium-Low", "Low")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TransparentHintTextField(
            text = selectedOptionText,
            hint = stringResource(R.string.pro_detail_priority_hint),
            isHintVisible = isHintVisible,
            onValueChanged = onValueChanged,
            onFocusChanged = onFocusChanged,
            decorationBox = { innerTextField ->
                InnerTextField(innerTextField)
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                if (option.isNotBlank()) {
                    DropdownMenuItem(
                        onClick = {
                            selectedOptionText = option
                            expanded = false
                        }
                    ) {
                        Text(text = option)
                    }
                }
            }
        }
    }
}

@Composable
private fun InnerTextField(
    innerTextField: @Composable () -> Unit = { }
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        innerTextField()
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TransparentHintDropDownPreview() {
    TransparentHintDropDown(
        isHintVisible = true,
        onValueChanged = { },
        onFocusChanged = { }
    )
}