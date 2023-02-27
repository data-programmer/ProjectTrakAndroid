package com.kingsland.home.presentation.viewmodel

import com.kingsland.core.ui.viewmodel.BaseViewModel
import com.kingsland.home.domain.usecase.ProjectUseCase
import com.kingsland.home.domain.usecase.TaskUseCase
import com.kingsland.home.presentation.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase,
    private val taskUseCase: TaskUseCase
) : BaseViewModel() {

    private val _homeState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState: StateFlow<HomeState> = _homeState

    // TODO: Start pulling data!

}