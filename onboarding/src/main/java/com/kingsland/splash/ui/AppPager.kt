package com.kingsland.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.kingsland.splash.model.Page

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppPager(
    modifier: Modifier = Modifier,
    state: PagerState,
) {
    val pages: List<Page> = Page.getOnboardingPages()
    HorizontalPager(
        modifier = modifier,
        count = 4,
        state = state
    ) { page ->
        PageUI(page = pages[page])
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview(showBackground = true)
fun AppPagerPreview() {
    AppPager(
        modifier = Modifier,
        state = rememberPagerState()
    )
}