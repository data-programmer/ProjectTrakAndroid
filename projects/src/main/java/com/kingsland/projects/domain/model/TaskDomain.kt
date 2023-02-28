package com.kingsland.projects.domain.model

data class TaskDomain(
    val id: Int,
    val title: String,
    val date: String,
    val description: String,
    val priority: Int,
    val statusDomain: Int,
    val projectId: Int,
    val contributorId: Int
)
