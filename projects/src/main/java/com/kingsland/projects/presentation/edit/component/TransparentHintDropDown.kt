package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kingsland.projects.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransparentHintDropDown(
    modifier: Modifier = Modifier,
    onValueChanged: (String) -> Unit,
) {
    val options = listOf("", "High", "Medium-High", "Medium", "Medium-Low", "Low")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        ProjectTextField(
            modifier = modifier,
            text = selectedOptionText,
            label = stringResource(R.string.pro_detail_priority_hint),
            onValueChanged = onValueChanged
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
@Preview(showBackground = true)
fun TransparentHintDropDownPreview() {
    TransparentHintDropDown(
        onValueChanged = { },
    )
}
