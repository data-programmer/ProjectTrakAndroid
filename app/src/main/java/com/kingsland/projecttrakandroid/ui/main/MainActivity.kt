package com.kingsland.projecttrakandroid.ui.main

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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.kingsland.onboarding.presentation.Onboarding
import com.kingsland.projecttrakandroid.model.ScaffoldConfig
import com.kingsland.projecttrakandroid.navigation.ProjectTrakAppBar
import com.kingsland.projecttrakandroid.navigation.ProjectTrakBottomNav
import com.kingsland.projecttrakandroid.navigation.ProjectTrakNavHost
import com.kingsland.projecttrakandroid.ui.component.ActionButton
import com.kingsland.projecttrakandroid.util.Util
import com.kingsland.theme.ProjectTrakAndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding")
    private val hasOnboardedKey = stringPreferencesKey("has_onboarded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ProjectTrakAndroidTheme {
                when (readStore()) {
                    "yes" -> { ProjectTrakScaffold() }
                    else -> { Onboarding { writeStore() } }
                }
            }
        }
    }

    private fun readStore(): String = runBlocking {
        dataStore.data
            .map { preferences ->
                preferences[hasOnboardedKey] ?: "no"
            }
            .first()
    }

    private fun writeStore(data: String = "yes") {
        runBlocking {
            dataStore.edit { preferences ->
                preferences[hasOnboardedKey] = data
            }
        }
    }
}

@Composable
fun ProjectTrakScaffold() {
    val navController = rememberNavController()
    val scaffoldConfig = remember { mutableStateOf(ScaffoldConfig()) }
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
                isVisible = scaffoldConfig.value.isFloatingActionButtonVisible,
                onClick = scaffoldConfig.value.floatingActionButtonAction
            )
        },
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        ProjectTrakNavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            // TODO: Figure this out later
            scaffoldConfig = scaffoldConfig.value
        )
    }
}
