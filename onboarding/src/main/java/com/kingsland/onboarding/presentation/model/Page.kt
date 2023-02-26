package com.kingsland.onboarding.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kingsland.splash.R

data class Page(
    val title: String,
    val description: String,
    // TODO: Get image from resources
    /*@DrawableRes*/ val image: Int
) {
    companion object {
        @Composable
        fun getOnboardingPages(): List<Page> = listOf(
            Page(
                title = stringResource(R.string.page_1_title),
                description = stringResource(R.string.page_1_desc),
                image = 1
            ),
            Page(
                title = stringResource(R.string.page_2_title),
                description = stringResource(R.string.page_2_desc),
                image = 1
            ),
            Page(
                title = stringResource(R.string.page_3_title),
                description = stringResource(R.string.page_3_desc),
                image = 1
            ),
            Page(
                title = stringResource(R.string.page_4_title),
                description = stringResource(R.string.page_4_desc),
                image = 1
            )
        )
    }
}
