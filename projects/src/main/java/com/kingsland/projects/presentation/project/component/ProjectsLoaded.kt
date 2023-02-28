package com.kingsland.projects.presentation.project.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.core.ui.components.ProjectCard
import com.kingsland.projects.presentation.model.Project

@Composable
fun ProjectsLoaded(
    projects: List<Project>,
    onProjectClick: (Int) -> Unit = { }
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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

@Composable
@Preview(showBackground = true)
fun ProjectsLoadedPreview() {
    ProjectsLoaded(
        projects = listOf()
    )
}