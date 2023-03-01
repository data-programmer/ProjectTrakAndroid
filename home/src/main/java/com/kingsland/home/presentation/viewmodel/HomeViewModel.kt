package com.kingsland.home.presentation.viewmodel

import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.home.domain.usecase.ProjectUseCase
import com.kingsland.home.domain.usecase.StatisticUseCase
import com.kingsland.home.domain.usecase.TaskUseCase
import com.kingsland.home.presentation.model.HomeData
import com.kingsland.home.presentation.model.HomeState
import com.kingsland.home.presentation.model.Project
import com.kingsland.home.presentation.model.Statistic
import com.kingsland.home.presentation.model.Task
import com.kingsland.home.presentation.model.TaskStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val statisticUseCase: StatisticUseCase,
    private val projectUseCase: ProjectUseCase,
    private val taskUseCase: TaskUseCase
) : BaseViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState: StateFlow<HomeState> = _homeState

    init {
        getHomeData()
    }

    fun getHomeData() {
        execute(
            action = {
                _homeState.value = HomeState.Loading
                HomeData(
                    statistics = statisticUseCase.getAllStatistics(),
                    projects = projectUseCase.getAllProjects(),
                    inProgressTasks = taskUseCase.getTasksByStatus(TaskStatus.InProgress.ordinal),
                    backlogTasks = taskUseCase.getTasksByStatus(TaskStatus.Backlog.ordinal)
                )
            },
            onSuccess = { homeData ->
                when (homeData.isEmptyState()) {
                    true -> { _homeState.value = HomeState.Empty }
                    false -> {
                        _homeState.value = HomeState.Loaded(
                            statistics = homeData.statistics,
                            projects = homeData.projects,
                            inProgressTasks = homeData.inProgressTasks,
                            backlogTasks = homeData.backlogTasks
                        )
                    }
                }
            },
            onFailure = {
                _homeState.value = HomeState.Error(it.message ?: "")
            }
        )
    }

}
