package com.kingsland.projecttrakandroid.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProjectTrakAppBar(
    modifier: Modifier = Modifier,
    greeting: String? = null,
    name: String? = null,
    onProfileClick: () -> Unit = { }
) {
    TopAppBar(
        modifier = modifier,
        title = {
            name?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column {
                        Text(
                            text = greeting ?: "Good day",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onBackground
                        )
                        Text(
                            text = name,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        },
        actions = {
            IconButton(
                onClick = onProfileClick
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null,
                )
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}

@Composable
@Preview(showBackground = true)
fun ProjectTrakAppBarPreview() {
    ProjectTrakAppBar(
        greeting = "Good afternoon",
        name = "Allen"
    )
}