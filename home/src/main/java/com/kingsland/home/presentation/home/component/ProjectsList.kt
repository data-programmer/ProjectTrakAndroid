package com.kingsland.home.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.home.R
import com.kingsland.home.presentation.model.Project

@Composable
fun ProjectsList(
    projects: List<Project>,
    onProjectClick: (Int) -> Unit = {  }
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.your_projects),
            style = MaterialTheme.typography.h5
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(projects) { project ->
                ProjectCard(
                    title = project.title,
                    description = project.description,
                    onClick = { onProjectClick(project.id) }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectsListPreview() {
    ProjectsList(
        projects = Project.getTestData()
    )
}