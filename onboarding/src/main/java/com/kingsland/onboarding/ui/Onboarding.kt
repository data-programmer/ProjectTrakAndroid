package com.kingsland.onboarding.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.kingsland.splash.R
import com.kingsland.onboarding.model.Page

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Onboarding(
    onGetStarted: () -> Unit = { },
) {
    val pageState = rememberPagerState()
    val pages: List<Page> = Page.getOnboardingPages()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.weight(1f),
            count = pages.size,
            state = pageState,
            content = { PageUI(page = pages[it]) }
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                pagerState = pageState,
                activeColor = MaterialTheme.colors.primary,
                inactiveColor = MaterialTheme.colors.onBackground
            )
            AnimatedVisibility(
                visible = pageState.currentPage == pages.lastIndex
            ) {
                GetStartedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    text = stringResource(R.string.get_started),
                    onClick = onGetStarted
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardingPreview() {
    Onboarding()
}