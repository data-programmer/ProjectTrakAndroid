package com.kingsland.projects.presentation.model

data class Project(
  val id: Int? = null,
  val title: String,
  val priority: String,
  val description: String,
  val dateCreated: String,
  // TODO: Add contributors later
) {
  companion object {
    fun getTestData() = listOf(
      Project(
        id = 1,
        priority = "High",
        title = "FyreTrack",
        description = "An app for tracking wild fires throughout the US.",
        dateCreated = "3/12/2023"
      ),
      Project(
        id = 2,
        priority = "High",
        title = "FyreTrack",
        description = "An app for tracking wild fires throughout the US.",
        dateCreated = "1/03/2023"
      ),
      Project(
        id = 3,
        priority = "High",
        title = "FyreTrack",
        description = "An app for tracking wild fires throughout the US.",
        dateCreated = "05/23/2023"
      ),
      Project(
        id = 4,
        priority = "High",
        title = "FyreTrack",
        description = "An app for tracking wild fires throughout the US.",
        dateCreated = "01/25/2023"
      ),
      Project(
        id = 5,
        priority = "High",
        title = "FyreTrack",
        description = "An app for tracking wild fires throughout the US.",
        dateCreated = "11/09/2023"
      )
    )
  }
}
