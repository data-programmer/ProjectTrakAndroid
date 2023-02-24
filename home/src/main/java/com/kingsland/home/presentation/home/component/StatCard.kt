package com.kingsland.home.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.home.presentation.model.Stat

@Composable
fun StatCard(
    stat: Stat
) {
    Card(
        modifier = Modifier.size(
            height = 80.dp,
            width = 110.dp
        ),
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = stat.icon,
                contentDescription = null
            )
            Text(
                text = stat.label,
                style = MaterialTheme.typography.caption
            )
            Text(
                text = stat.data.toString(),
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StatCardPreview() {
    StatCard(
        Stat(
            label ="Tasks Completed",
            data = 26,
            icon = Icons.Filled.Check
        )
    )
}
