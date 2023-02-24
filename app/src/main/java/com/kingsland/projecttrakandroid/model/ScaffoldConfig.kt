package com.kingsland.projecttrakandroid.model

data class ScaffoldConfig(
    var isFloatingActionButtonVisible: Boolean = true,
    var floatingActionButtonAction: () -> Unit = { },
)
