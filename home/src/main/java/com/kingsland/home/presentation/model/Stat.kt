package com.kingsland.home.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class Stat(
    val label: String,
    val data: Int,
    val icon: ImageVector
) {
    companion object {
        @Composable
        fun getTestStats() = listOf(
            Stat(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
            Stat(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
            Stat(
                label = "Tasks Completed",
                data = 26,
                icon = Icons.Filled.Check
            ),
        )
    }
}
