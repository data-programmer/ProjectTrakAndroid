package com.kingsland.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    fun <T> execute(
        action: () -> T,
        onSuccess: (T) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            Result
                .runCatching { action() }
                .onSuccess { onSuccess(it) }
                .onFailure { onFailure(it) }
        }
    }
}
