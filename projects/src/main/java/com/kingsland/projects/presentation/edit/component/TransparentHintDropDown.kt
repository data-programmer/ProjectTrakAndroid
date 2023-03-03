package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kingsland.projects.presentation.model.ProjectPriority

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransparentHintDropDown(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    textStyle: TextStyle = TextStyle(fontSize = 16.sp),
    onValueChanged: (String) -> Unit = { },
) {
    val options = ProjectPriority.getProjectPriority()
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(text) }
    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            modifier = modifier,
            readOnly = true,
            singleLine = true,
            value = selectedOptionText,
            onValueChange = { },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            label = { Text(text = label) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = MaterialTheme.colors.background
            ),
            textStyle = textStyle
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                if (option.isNotBlank()) {
                    DropdownMenuItem(
                        onClick = {
                            onValueChanged(option)
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
@Preview(showBackground = true)
fun TransparentHintDropDownPreview() {
    TransparentHintDropDown(
        text = "",
        label = "",
        textStyle = TextStyle(),
        onValueChanged = { },
    )
}
