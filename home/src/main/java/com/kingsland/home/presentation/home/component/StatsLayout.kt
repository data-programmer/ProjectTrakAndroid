package com.kingsland.home.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.home.R
import com.kingsland.home.presentation.model.Statistic

@Composable
fun StatsLayout(
    statisticList: List<Statistic> = listOf()
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Statistics",
            style = MaterialTheme.typography.h5
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            when (statisticList.isEmpty()) {
                true -> item { Text(text = stringResource(R.string.home_no_statistics)) }
                else -> { items(statisticList) { stat -> StatCard(statistic = stat) } }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StatsLayoutPreview() {
    StatsLayout()
}

