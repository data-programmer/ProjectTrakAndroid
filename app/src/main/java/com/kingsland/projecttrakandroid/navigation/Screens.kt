package com.kingsland.projecttrakandroid.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.kingsland.projecttrakandroid.R

sealed class Screen (
    val route: String,
    val icon: ImageVector,
    @StringRes val resourceId: Int
) {
    object Home : Screen(
        route = "home",
        icon = Icons.Filled.Home,
        resourceId = R.string.screen_home
    )
    object Projects : Screen(
        route = "projects",
        icon = Icons.Filled.Build,
        resourceId = R.string.screen_project
    )
    object Contributors : Screen(
        route = "contributors",
        icon = Icons.Filled.Check,
        resourceId = R.string.screen_contributor
    )
}
