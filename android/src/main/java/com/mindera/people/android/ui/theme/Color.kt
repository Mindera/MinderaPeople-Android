package com.mindera.people.android.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import kotlin.math.ln

val white = Color(0xffffffff)
val grayBlue = Color(0xffeceff1)
val grayBlue500 = Color(0xff607d8b)
val grayBlue900 = Color(0xff263238)
val gray200 = Color(0xffeeeeee)
val gray500 = Color(0xff9e9e9e)
val gray600 = Color(0xff757575)
val gray700 = Color(0xff616161)
val grayDarkPrimary = Color(0xff4f5b66)
val black = Color(0xff000000)
val black400 = Color(0x80000000)
val indigo100 = Color(0xffd8e0fe)
val indigo600 = Color(0xff1040e8)
val indigo800 = Color(0xff0a2eb2)
val red600 = Color(0xfff32738)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

/**
 * Elevation overlay logic copied from [Surface] — https://issuetracker.google.com/155181601
 */
fun Colors.elevatedSurface(elevation: Dp): Color {
    if (isLight) return surface
    val foreground = calculateForeground(elevation)
    return foreground.compositeOver(surface)
}

private fun calculateForeground(elevation: Dp): Color {
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return Color.White.copy(alpha = alpha)
}
