package com.kingsland.home.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class Statistic(
    val label: String,
    val data: Int,
    val icon: ImageVector
) {
    companion object {
        @Composable
        fun getTestStats() = listOf(
            Statistic(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
            Statistic(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
            Statistic(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
        )
    }
}
