package com.kingsland.splash.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Onboarding(
    onGetStarted: () -> Unit = { },
) {
    val pageState = rememberPagerState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppPager(
            state = pageState
        )
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            pagerState = pageState,
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = MaterialTheme.colors.onBackground
        )
        AnimatedVisibility(visible = pageState.currentPage == 4) {
            GetStartedButton(
                text = "Get Started",
                onClick = onGetStarted
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardingPreview() {
    Onboarding()
}