package com.kingsland.onboarding.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kingsland.theme.ProjectTrakAndroidTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class OnboardActivity : ComponentActivity() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding")
    private val hasOnboardedKey = stringPreferencesKey("has_onboarded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ProjectTrakAndroidTheme {
                when (readStore()) {
                    "yes" -> { navToMainActivity() }
                    else -> {
                        Onboarding {
                            writeStore()
                            navToMainActivity()
                        }
                    }
                }
            }
        }
    }

    private fun navToMainActivity() {
        startActivity(Intent("com.kingsland.onboarding.MAIN_ACTIVITY"))
        finish()
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