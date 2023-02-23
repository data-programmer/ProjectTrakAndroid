package com.kingsland.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsland.splash.R
import com.kingsland.splash.model.Page

@Composable
fun PageUI(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            // TODO: Get page image
            painter = painterResource(R.drawable.ic_launcher),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = page.title,
            style = MaterialTheme.typography.h4
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )
        Spacer(Modifier.height(12.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun PageUIPreview() {
    PageUI(
        page = Page(
            title = "This is a test",
            description = "This is a test description to see what things look like.",
            image = 1
        )
    )
}
