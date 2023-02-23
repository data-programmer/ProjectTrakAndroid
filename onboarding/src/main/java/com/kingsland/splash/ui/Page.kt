package com.kingsland.splash.ui

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
) {

}

@Composable
@Preview(showBackground = true)
fun PagePreview() {
    Page()
}