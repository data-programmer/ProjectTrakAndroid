package com.kingsland.projects.presentation.model

enum class ProjectPriority(val text: String) {
    High("High"),
    MediumHigh("Medium-High"),
    Medium("Medium"),
    MediumLow("Medium-Low"),
    Low("Low");

    companion object {
        fun getProjectPriority(): List<String> = listOf(
            High.text,
            MediumHigh.text,
            Medium.text,
            MediumLow.text,
            Low.text
        )
    }
}
