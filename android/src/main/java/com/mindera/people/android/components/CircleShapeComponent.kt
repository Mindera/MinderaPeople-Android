package com.mindera.people.android.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mindera.people.android.R
import com.mindera.people.android.ui.theme.black
import com.mindera.people.android.ui.theme.grayBlue
import com.mindera.people.android.ui.theme.indigo100

@Composable
fun CircleShapePolicyComponent(icon: Int) {

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(indigo100)
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            contentScale = ContentScale.Inside,
            painter = painterResource(icon),
            contentDescription = stringResource(
                id = R.string.policy_icon
            )
        )
    }
}

@Composable
fun CircleShapeBorderComponent(icon: Int, contentDescription: Int) {

    Box(
        modifier = Modifier
            .size(40.dp)
            .border(
                width = 1.dp,
                color = grayBlue,
                shape = CircleShape
            )
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            contentScale = ContentScale.Inside,
            painter = painterResource(icon),
            contentDescription = stringResource(
                id = contentDescription
            )
        )
    }
}