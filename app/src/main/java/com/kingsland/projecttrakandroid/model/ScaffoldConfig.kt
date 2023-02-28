package com.kingsland.projecttrakandroid.model

data class ScaffoldConfig(
    var isFloatingActionButtonVisible: Boolean = false,
    var floatingActionButtonAction: () -> Unit = { },
)
