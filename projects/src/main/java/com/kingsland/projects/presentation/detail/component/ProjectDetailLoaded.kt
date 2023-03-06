package com.kingsland.projects.presentation.detail.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kingsland.projects.presentation.model.Project

@Composable
fun ProjectDetailLoaded(
    project: Project,
    onProjectEdit: () -> Unit = { },
    onProjectDelete: () -> Unit = { }
) {

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