package com.kingsland.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    fun <T> execute(
        action: () -> T,
        onSuccess: (T) -> Unit = { },
        onFailure: (Throwable) -> Unit = { }
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            Result
                .runCatching { action() }
                .onSuccess { onSuccess(it) }
                .onFailure { onFailure(it) }
        }
    }

}
