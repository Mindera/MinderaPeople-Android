package com.mindera.people.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp


val LightColorPalette = lightColors(
    primary = white,
    primaryVariant = white,
    secondary = indigo600,
    surface = white,
    error = red600,
    background = grayBlue,
    onPrimary = grayBlue900,
    onSecondary = white,
    onSurface = grayBlue900,
    onBackground = grayBlue900,
    onError = white
)

// FIXME define dark theme colors
//val DarkColorPalette = darkColors()
private val ThemeElevation = Elevations(card = 4.dp)

@Composable
fun MinderaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    // FIXME add darkTheme if else to show dark or light theme
    val colors = LightColorPalette


    CompositionLocalProvider(
        LocalElevations provides ThemeElevation
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            content = content
        )
    }
}
