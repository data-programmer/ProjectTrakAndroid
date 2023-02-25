package com.kingsland.projects.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kingsland.core.ui.components.ProjectCard
import com.kingsland.projects.presentation.model.Project

@Composable
fun ProjectsScreen(
    navController: NavController
) {
    // TODO: Get Projects
    val projects = Project.getTestProjects()
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(projects) { project ->
            ProjectCard(
                name = project.name,
                desc = "",
                dateCreated =  project.dateCreated,
                onClick = {
                    // TODO: Nav to project detail
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectsScreenPreview() {
    ProjectsScreen(rememberNavController())
}