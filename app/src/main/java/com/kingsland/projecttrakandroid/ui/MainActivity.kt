package com.kingsland.projecttrakandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.kingsland.projecttrakandroid.model.ScaffoldState
import com.kingsland.projecttrakandroid.navigation.ProjectTrakAppBar
import com.kingsland.projecttrakandroid.navigation.ProjectTrakBottomNav
import com.kingsland.projecttrakandroid.navigation.ProjectTrakNavHost
import com.kingsland.projecttrakandroid.ui.component.ActionButton
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
    val scaffoldState = remember { mutableStateOf(ScaffoldState()) }
    val context = LocalContext.current
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
        floatingActionButton = {
            ActionButton(
                isVisible = scaffoldState.value.isFloatingActionButtonVisible,
                onClick = scaffoldState.value.floatingActionButtonAction
            )
        },
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        ProjectTrakNavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            scaffoldState = scaffoldState,
        )
    }
}
