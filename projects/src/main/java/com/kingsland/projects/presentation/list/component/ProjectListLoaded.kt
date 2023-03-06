package com.kingsland.projects.presentation.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.core.ui.components.ButtonLayout
import com.kingsland.core.ui.components.ProjectCard
import com.kingsland.projects.presentation.model.Project

@Composable
fun ProjectListLoaded(
    projects: List<Project>,
    onProjectClick: (Int) -> Unit = { },
    onButtonClick: () -> Unit = { }
) {
    ButtonLayout(
        buttonIcon = Icons.Filled.Add,
        onButtonClick = onButtonClick
    ) { modifier ->
        LazyVerticalGrid(
            modifier = modifier.fillMaxWidth(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(projects) { project ->
                ProjectCard(
                    name = project.title,
                    desc = project.description,
                    dateCreated =  project.dateCreated,
                    onClick = { onProjectClick(project.id) }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectsLoadedPreview() {
    ProjectListLoaded(
        projects = listOf()
    )
}
