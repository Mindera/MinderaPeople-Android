package com.mindera.people.android.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindera.people.android.R
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.ui.theme.btnHorizontalMargin
import com.mindera.people.android.ui.theme.btnIconSize
import com.mindera.people.android.ui.theme.btnSmallHorizontalMargin
import com.mindera.people.android.ui.theme.btnSmallVerticalMargin
import com.mindera.people.android.ui.theme.btnVerticalMargin
import com.mindera.people.android.ui.theme.typography


@Composable
fun SimpleIconButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    paddingValues: PaddingValues = PaddingValues(horizontal = btnHorizontalMargin, vertical = btnVerticalMargin),
    @DrawableRes iconRes: Int? = null,
    @StringRes contentDescRes: Int? = null,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary
        ),
        contentPadding = paddingValues
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (iconRes != null) {
                Icon(
                    modifier = Modifier.size(btnIconSize),
                    painter = painterResource(id = iconRes),
                    contentDescription = contentDescRes?.let {
                        stringResource(id = it)
                    })
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            }
            Text(text, style = typography.button)
        }
    }
}

@Composable
fun SimpleButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    SimpleIconButton(modifier = modifier, text = text, onClick = onClick)
}

@Composable
fun SimpleButton(
    modifier: Modifier = Modifier,
    @StringRes textRes: Int,
    onClick: () -> Unit = {}
) {
    SimpleIconButton(modifier = modifier, text = stringResource(id = textRes), onClick = onClick)
}

@Composable
fun SimpleSmallIconButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    paddingValues: PaddingValues = PaddingValues(
        horizontal = btnSmallHorizontalMargin,
        vertical = btnSmallVerticalMargin
    ),
    @DrawableRes iconRes: Int? = null,
    @StringRes contentDescRes: Int? = null,
) {
    SimpleIconButton(
        modifier = modifier,
        text = text,
        onClick = onClick,
        paddingValues = paddingValues,
        iconRes = iconRes,
        contentDescRes = contentDescRes
    )
}

@Composable
fun SimpleSmallButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    SimpleIconButton(modifier = modifier, text = text, onClick = onClick)
}

@Composable
fun SimpleSmallButton(
    modifier: Modifier = Modifier,
    @StringRes textRes: Int,
    onClick: () -> Unit = {}
) {
    SimpleSmallIconButton(modifier = modifier, text = stringResource(id = textRes), onClick = onClick)
}


@Preview
@Composable
fun PreviewSimpleButton() {
    MinderaTheme {
        SimpleButton(textRes = R.string.login_btn_label)
    }
}

@Preview
@Composable
fun PreviewIconButton() {
    MinderaTheme {
        SimpleIconButton(
            iconRes = R.drawable.ic_arrow_left,
            contentDescRes = R.string.login_btn_label_desc,
            text = stringResource(id = R.string.login_btn_label)
        )
    }
}

@Preview
@Composable
fun PreviewSmallSimpleButton() {
    MinderaTheme {
        SimpleSmallButton(textRes = R.string.login_btn_label)
    }
}

@Preview
@Composable
fun PreviewSmallIconButton() {
    MinderaTheme {
        SimpleSmallIconButton(
            iconRes = R.drawable.ic_arrow_left,
            contentDescRes = R.string.login_btn_label_desc,
            text = stringResource(id = R.string.login_btn_label)
        )
    }
}
