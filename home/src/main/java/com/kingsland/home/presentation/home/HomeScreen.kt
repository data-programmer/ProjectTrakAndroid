package com.kingsland.home.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kingsland.home.presentation.home.component.ProjectsList
import com.kingsland.home.presentation.home.component.StatsLayout
import com.kingsland.home.presentation.home.component.TaskList
import com.kingsland.home.presentation.model.PriorityProject
import com.kingsland.home.presentation.model.PriorityTask
import com.kingsland.home.presentation.model.Statistic
import com.kingsland.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        item {
            StatsLayout(statisticList = Statistic.getTestStats())
        }
        item {
            ProjectsList(priorityProjects = PriorityProject.getTestData())
        }
        item {
            TaskList(tasksInProgress = PriorityTask.getTestData())
        }
    }
}
