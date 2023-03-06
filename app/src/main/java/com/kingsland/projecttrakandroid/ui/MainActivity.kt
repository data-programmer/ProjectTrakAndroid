package com.kingsland.projecttrakandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kingsland.projecttrakandroid.navigation.ProjectTrakAppBar
import com.kingsland.projecttrakandroid.navigation.ProjectTrakBottomNav
import com.kingsland.projecttrakandroid.navigation.ProjectTrakNavHost
import com.kingsland.projecttrakandroid.util.Util
import com.kingsland.theme.ProjectTrakAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTrakAndroidTheme {
                ProjectTrakScaffold()
            }
        }
    }
}

@Composable
fun ProjectTrakScaffold() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            // TODO: Get info for app bar
            ProjectTrakAppBar(
                greeting = Util.getGreetingMessage(),
                name = "William"
            )
        },
        bottomBar = { ProjectTrakBottomNav(navController) },
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        ProjectTrakNavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController
        )
    }
}
