package com.kingsland.contributors.domain.model

data class ContributorDomain(
    val id: Int,
    val name: String,
    val role: String,
    val projectId: Int
)