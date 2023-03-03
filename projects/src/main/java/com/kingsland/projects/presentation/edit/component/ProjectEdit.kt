package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsland.projects.R
import com.kingsland.projects.presentation.viewmodel.ProjectDetailViewModel

@Composable
fun ProjectEdit(
    modifier: Modifier = Modifier,
    viewModel: ProjectDetailViewModel
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ProjectTextField(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.title.value,
                label = stringResource(R.string.pro_detail_title_hint),
                onValueChanged = { viewModel.title.value = it },
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)
            )
        }
        item {
            TransparentHintDropDown(
                modifier = Modifier.fillMaxWidth(),
                onValueChanged = { viewModel.priority.value = it },
            )
        }
        item {
            ProjectTextField(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.description.value,
                label = stringResource(R.string.pro_detail_description_hint),
                onValueChanged = { viewModel.description.value = it },
                singleLine = false,
                textStyle = TextStyle(fontSize = 20.sp)
            )
        }
    }
}
