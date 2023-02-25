package com.kingsland.home.presentation.model

data class Task(
    val id: Int,
    val title: String,
    val dateCreated: String,
    val description: String,
    val priority: Int,
    val status: Int,
    val projectId: Int,
    val contributorId: Int
)
