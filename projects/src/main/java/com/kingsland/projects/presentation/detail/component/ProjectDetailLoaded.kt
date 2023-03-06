package com.kingsland.projects.presentation.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kingsland.core.ui.components.ButtonLayout
import com.kingsland.projects.presentation.model.Project

@Composable
fun ProjectDetailLoaded(
    modifier: Modifier = Modifier,
    project: Project,
    onProjectEdit: () -> Unit = { },
    onProjectDelete: () -> Unit = { }
) {
    ButtonLayout(
        buttonIcon = Icons.Filled.Edit,
        onButtonClick = onProjectEdit
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectDetailLoadedPreview() {
    ProjectDetailLoaded(
        project = Project(
            id = 1,
            title = "This is a title",
            priority = "Medium-High",
            description = "This is the project detail.",
            dateCreated = "01/12/2023"
        )
    )
}
