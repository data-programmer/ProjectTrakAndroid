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
) {
    companion object {
        fun getTestData() = listOf(
            Task(
              id = 1,
              title = "Get eggs",
              dateCreated = "3/23/2023",
              description = "Get some eggs from Walmart",
              priority = 1,
              status = 2,
              projectId = 1,
              contributorId = 1
            ),
            Task(
                id = 2,
                title = "Grab some beans from the market",
                dateCreated = "3/23/2023",
                description = "We'll need these tonight for dinner",
                priority = 3,
                status = 1,
                projectId = 2,
                contributorId = 1
            ),
            Task(
                id = 3,
                title = "Drink milk!",
                dateCreated = "3/23/2023",
                description = "Don't forget to drink milk",
                priority = 2,
                status = 2,
                projectId = 4,
                contributorId = 1
            ),
            Task(
                id = 4,
                title = "Buy dog food",
                dateCreated = "3/23/2023",
                description = "The dogs will need more food. Should pick some up",
                priority = 2,
                status = 3,
                projectId = 3,
                contributorId = 1
            ),
        )
    }
}
