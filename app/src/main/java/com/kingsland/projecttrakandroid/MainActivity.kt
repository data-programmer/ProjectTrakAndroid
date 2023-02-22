package com.kingsland.projecttrakandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kingsland.projecttrakandroid.navigation.ProjectTrakNavHost
import com.kingsland.theme.ProjectTrakAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTrakAndroidTheme {
                ProjectTrakNavHost()
            }
        }
    }
}
