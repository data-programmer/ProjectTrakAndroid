package com.kingsland.projects.presentation.model

data class Project(
    val name: String,
    val priority: Int,
    val dateCreated: String,
) {
    companion object {
        fun getTestProjects() = listOf(
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
            Project(
                name = "FyreTrack",
                priority = 1,
                dateCreated = "1/23/2023"
            ),
        )
    }
}
