package com.kingsland.projects.domain.model

data class ProjectDomain(
    val id: Int,
    val name: String,
    val priority: Int,
    val description: String,
    val dateCreated: String
)
