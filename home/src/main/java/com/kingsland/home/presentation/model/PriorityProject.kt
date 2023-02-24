package com.kingsland.home.presentation.model

data class PriorityProject(
    val priority: Int,
    val title: String,
    val desc: String,
    // TODO: Change later
    val contributors: List<String>
) {
    companion object {
        fun getTestData() = listOf(
            PriorityProject(
                priority = 1,
                title = "FyreTrack",
                desc = "An app for tracking wild fires throughout the US.",
                contributors = listOf("Bob", "Sally", "Kingsland")
            ),
            PriorityProject(
                priority = 2,
                title = "FyreTrack",
                desc = "An app for tracking wild fires throughout the US.",
                contributors = listOf("Bob", )
            ),
            PriorityProject(
                priority = 1,
                title = "FyreTrack",
                desc = "An app for tracking wild fires throughout the US.",
                contributors = listOf("Bob", "Sally")
            ),PriorityProject(
                priority = 3,
                title = "FyreTrack",
                desc = "An app for tracking wild fires throughout the US.",
                contributors = listOf( "Kingsland")
            ),PriorityProject(
                priority = 1,
                title = "FyreTrack",
                desc = "An app for tracking wild fires throughout the US.",
                contributors = listOf("Bob", "Kingsland")
            )
        )
    }
}
