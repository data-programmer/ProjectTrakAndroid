package com.kingsland.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    name: String,
    desc: String,
    dateCreated: String,
    contributors: List<String> = listOf(),
    onClick: () -> Unit = { }
) {
    Card(
        modifier = modifier.size(
            height = 140.dp,
            width = 120.dp
        ),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onBackground,
        elevation = 8.dp,
        contentColor = MaterialTheme.colors.onSurface,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = desc,
                    style = MaterialTheme.typography.body2
                )
            }
            ContributorsList(contributors)
        }
    }
}

@Composable
fun ContributorsList(
    contributors: List<String>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        contributors.forEach { _ ->
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectCardPreview() {
    ProjectCard(
        name = "FyreTrack",
        desc = "This is a wild fire spread project focused on create a app.",
        contributors = listOf("Bob", "Sally", "Kingsland"),
        dateCreated = "1/12/2023",
        onClick = {  }
    )
}