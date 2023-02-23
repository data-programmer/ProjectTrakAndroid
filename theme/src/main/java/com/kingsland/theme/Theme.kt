package com.kingsland.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.kingsland.theme.color.black
import com.kingsland.theme.color.cardGray
import com.kingsland.theme.color.darkGray
import com.kingsland.theme.color.darkGreen
import com.kingsland.theme.color.errorRed
import com.kingsland.theme.color.lightGray
import com.kingsland.theme.color.red
import com.kingsland.theme.color.white
import com.kingsland.theme.color.yellow
import com.kingsland.theme.shape.RoundedShapes
import com.kingsland.theme.type.Typography

private val DarkColorPalette = darkColors(
    primary = red,
    primaryVariant = darkGreen,
    secondary = yellow,
    background = lightGray,
    surface = cardGray,
    onPrimary = white,
    onSecondary = white,
    onBackground = darkGray,
    onSurface = black,
    onError = errorRed
)

private val LightColorPalette = lightColors(
    primary = red,
    primaryVariant = darkGreen,
    secondary = yellow,
    background = lightGray,
    surface = cardGray,
    onPrimary = white,
    onSecondary = white,
    onBackground = darkGray,
    onSurface = black,
    onError = errorRed
)

@Composable
fun ProjectTrakAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = RoundedShapes,
        content = content
    )
}
