package com.kingsland.contributors.presentation.model

sealed class ContributorState {
    object Loading : ContributorState()
    object Empty : ContributorState()
    data class Loaded(val contributors: List<Contributor>) : ContributorState()
    data class Error(val message: String) : ContributorState()
}
