package com.kingsland.contributors.presentation.contributor.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kingsland.contributors.presentation.model.Contributor
import com.kingsland.core.ui.components.ButtonLayout

@Composable
fun ContributorLoaded(
    contributors: List<Contributor>,
    navController: NavController,
    onContributorClick: (Int) -> Unit = { }
) {
    ButtonLayout(
        buttonIcon = Icons.Filled.Add,
        onButtonClick = { navController.navigate("") }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(contributors) { contributors ->
                ContributorCard(
                    name = contributors.name,
                    role = contributors.role,
                    onClick = { onContributorClick(contributors.id) }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContributorLoadedPreview() {
    ContributorLoaded(
        contributors = listOf(),
        navController = rememberNavController()
    )
}