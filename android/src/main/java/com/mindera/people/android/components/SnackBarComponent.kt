package com.mindera.people.android.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


@Composable
fun buildSnackbarHost(
    modifier: Modifier = Modifier,
    hostState: SnackbarHostState
) {
    SnackbarHost(
        modifier = modifier,
        hostState = hostState
    ) { snackbarData: SnackbarData ->
        CustomSnackBar(
            data = snackbarData,
            isRtl = true,
        )
    }
}

@Composable
fun buildErrorSnackbarHost(
    modifier: Modifier = Modifier,
    hostState: SnackbarHostState
) {
    SnackbarHost(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 24.dp),
        hostState = hostState
    ) { snackbarData: SnackbarData ->
        CustomSnackBar(
            data = snackbarData,
            containerColor = MaterialTheme.colors.error,
            contentColor = MaterialTheme.colors.onError
        )
    }
}

@Composable
fun CustomSnackBar(
    @DrawableRes drawableRes: Int? = null,
    data: SnackbarData,
    isRtl: Boolean = false,
    containerColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = MaterialTheme.colors.onSurface
) {
    Snackbar(
        backgroundColor = containerColor, action = if (data.actionLabel != null) {
            {
                TextButton(onClick = { data.performAction() }) {
                    Text(text = data.actionLabel?.uppercase() ?: "", color = contentColor)
                }
            }
        } else null
    ) {
        CompositionLocalProvider(
            LocalLayoutDirection provides
                    if (isRtl) LayoutDirection.Rtl else LayoutDirection.Ltr
        ) {
            Row {

                if (drawableRes != null) {
                    Icon(
                        painterResource(id = drawableRes),
                        contentDescription = null
                    )
                }

                Text(
                    modifier = Modifier.weight(weight = 1f),
                    text = data.message,
                    style = MaterialTheme.typography.subtitle1,
                    color = contentColor,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

