package com.kingsland.contributors.presentation.contributor.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContributorCard(
    modifier: Modifier = Modifier,
    name: String,
    role: String,
    onClick: () -> Unit = { }
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onBackground,
        elevation = 8.dp,
        contentColor = MaterialTheme.colors.onSurface,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.body1
                )
            }
            Text(
                text = role,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContributorCardPreview() {
    ContributorCard(
        name = "John Kingsland",
        role = "Developer",
    )
}