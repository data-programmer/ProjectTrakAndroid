package com.kingsland.contributors.presentation.contributor

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.kingsland.contributors.R
import com.kingsland.contributors.presentation.contributor.component.ContributorLoaded
import com.kingsland.contributors.presentation.model.ContributorState
import com.kingsland.contributors.presentation.viewmodel.ContributorViewModel
import com.kingsland.core.ui.components.Empty
import com.kingsland.core.ui.components.Loading
import com.kingsland.core.ui.components.Error

@Composable
fun ContributorsScreen(
    navController: NavController,
    viewModel: ContributorViewModel
) {
    val contributorState = viewModel.contributorState.collectAsState()
    viewModel.getContributors()
    when (val state = contributorState.value) {
        is ContributorState.Loading -> { Loading() }
        is ContributorState.Empty -> {
            Empty(
                imageVector = Icons.Filled.Create,
                message = stringResource(R.string.contributor_empty_message)
            )
        }
        is ContributorState.Loaded -> {
            ContributorLoaded(
                contributors = state.contributors,
                onContributorClick = { id -> navController.navigate("contributor/$id") }
            )
        }
        is ContributorState.Error -> {
            Error(
                imageVector = Icons.Filled.Close,
                message = stringResource(R.string.contributor_error_message),
                buttonText = stringResource(R.string.contributor_try_again),
                onClick = { viewModel.getContributors() }
            )
        }
    }
}
