package com.kingsland.splash.model

import androidx.compose.runtime.Composable

data class Page(
    val title: String,
    val description: String,
    /*@DrawableRes*/ val image: Int
) {
    companion object {
        @Composable
        fun getOnboardingPages(): List<Page> = listOf(
            Page(
                title = "Welcome",
                description = "It's so great that you are here!",
                image = 1
            ),
            Page(
                title = "Manage Projects",
                description = "You can manage projects and do things!",
                image = 1
            ),
            Page(
                title = "Create tasks ",
                description = "Beans are forever in the eyes of a beholder",
                image = 1
            ),
            Page(
                title = "Manage Contributors",
                description = "FJOIDUFOSDFSD",
                image = 1
            )
        )
    }
}
