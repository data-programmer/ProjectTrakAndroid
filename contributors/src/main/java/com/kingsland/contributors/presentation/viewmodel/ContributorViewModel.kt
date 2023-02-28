package com.kingsland.contributors.presentation.viewmodel

import com.kingsland.contributors.domain.usecase.ContributorUseCase
import com.kingsland.contributors.presentation.model.ContributorState
import com.kingsland.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContributorViewModel @Inject constructor(
    private val contributorUseCase: ContributorUseCase
) : BaseViewModel() {

    private val _contributorState = MutableStateFlow<ContributorState>(ContributorState.Loading)
    val contributorState: StateFlow<ContributorState> = _contributorState

    fun getContributors() {
        execute(
            action = {
                _contributorState.value = ContributorState.Loading
                contributorUseCase.getAllContributors()
            },
            onSuccess = { contributors ->
                when (contributors.isEmpty()) {
                    true -> { _contributorState.value = ContributorState.Empty }
                    false -> {
                        _contributorState.value = ContributorState.Loaded(
                            contributors = contributors
                        )
                    }
                }
            },
            onFailure = {
                _contributorState.value = ContributorState.Error(it.message ?: "")
            }
        )
    }

}
