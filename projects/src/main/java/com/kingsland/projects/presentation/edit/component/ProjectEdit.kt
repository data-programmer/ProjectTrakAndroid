package com.kingsland.projects.presentation.edit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsland.projects.R
import com.kingsland.projects.presentation.model.ProjectDetailState
import com.kingsland.projects.presentation.viewmodel.ProjectDetailViewModel

@Composable
fun ProjectEdit(
    modifier: Modifier = Modifier,
    state: ProjectDetailState.Edit,
    viewModel: ProjectDetailViewModel
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TransparentHintTextField(
                text = state.title,
                hint = stringResource(R.string.pro_detail_title_hint),
                isHintVisible = state.isTitleHintVisible,
                onValueChanged = { },
                onFocusChanged = { },
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp)
            )
        }
        item {
            // TODO: Propagate to view model
            TransparentHintDropDown(
                isHintVisible = state.isPriorityHintVisible,
                onValueChanged = { },
                onFocusChanged = { }
            )
        }
        item {
            TransparentHintTextField(
                text = state.description,
                hint = stringResource(R.string.pro_detail_description_hint),
                isHintVisible = state.isDescriptionHintVisible,
                onValueChanged = { },
                onFocusChanged = { }
            )
        }
    }
}
