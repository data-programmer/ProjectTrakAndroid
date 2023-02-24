package com.kingsland.home.presentation.model

data class PriorityTask(
    val priority: Int,
    val title: String,
    val desc: String
) {
    companion object {
        fun getTestData() = listOf(
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
            PriorityTask(
                priority = 1,
                title = "Get eggs",
                desc = "Need to get eggs from Walmart"
            ),
        )
    }
}