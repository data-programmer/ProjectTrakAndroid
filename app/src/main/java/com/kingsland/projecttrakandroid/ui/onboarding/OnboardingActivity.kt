package com.kingsland.projecttrakandroid.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.kingsland.projecttrakandroid.ui.MainActivity
import com.kingsland.splash.ui.Onboarding
import com.kingsland.theme.ProjectTrakAndroidTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

// TODO: Remove from app module
class OnboardingActivity : ComponentActivity() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding")
    private val hasOnboardedKey = stringPreferencesKey("has_onboarded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (readStore()) {
            "yes" -> {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
                finish()
            }
            else -> {
                setContent {
                    ProjectTrakAndroidTheme {
                        Onboarding(
                            onGetStarted = { writeStore() }
                        )
                    }
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