package com.kingsland.home.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.home.presentation.model.Project
import com.kingsland.home.presentation.model.Statistic
import com.kingsland.home.presentation.model.Task

@Composable
fun HomeLoaded(
    statistics: List<Statistic> = listOf(),
    projects: List<Project> = listOf(),
    tasksInProgress: List<Task> = listOf(),
    backlogTasks: List<Task> = listOf(),
    onProjectClick: (Int) -> Unit = { },
    onTaskClick: (Int) -> Unit = { },
    onBacklogClick: (Int) -> Unit = { }
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            StatsLayout(statisticList = statistics)
        }
        item {
            ProjectsList(
                projects = projects,
                onProjectClick = onProjectClick
            )
        }
        item {
            InProgressTaskList(
                tasksInProgress = tasksInProgress,
                onTaskClick = onTaskClick
            )
        }
        item {
            BacklogTaskList(
                backlogTasks = backlogTasks,
                onTaskClick = onBacklogClick
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeLoadedPreview() {
    HomeLoaded()
}
