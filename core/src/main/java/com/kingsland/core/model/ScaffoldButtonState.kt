package com.kingsland.core.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector

data class ScaffoldButtonState(
    var isFloatingActionButtonVisible: Boolean = true,
    var floatingActionButtonAction: () -> Unit = { },
    var floatingActionButtonIcon: ImageVector = Icons.Filled.Add
) {
    companion object {
        private var instance: ScaffoldButtonState? = null
        fun getInstance(): ScaffoldButtonState {
            synchronized(ScaffoldButtonState::class.java) {
                if (instance == null) {
                    instance = ScaffoldButtonState()
                }
                return instance as ScaffoldButtonState
            }
        }
    }
}
