package com.kingsland.projecttrakandroid.model

data class ScaffoldState(
    var isFloatingActionButtonVisible: Boolean = true,
    var floatingActionButtonAction: () -> Unit = { }
)
