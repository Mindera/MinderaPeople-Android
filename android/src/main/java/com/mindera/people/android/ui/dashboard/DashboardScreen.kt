package com.mindera.people.android.ui.dashboard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.touchlab.kermit.Logger
import com.mindera.people.android.R
import com.mindera.people.android.components.CircleShapeBorderComponent
import com.mindera.people.android.components.CircleShapePolicyComponent
import com.mindera.people.android.components.LoaderComponent
import com.mindera.people.android.ui.theme.*
import com.mindera.people.android.utils.PoliciesToIcon
import com.mindera.people.android.utils.PreviewUiState
import com.mindera.people.android.utils.getWith
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.timeoff.Summary
import com.mindera.people.utils.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier, logger: Logger = getWith("DashboardScreen")
) {
    val viewModel = koinViewModel<DashboardViewModel>()
    val state by remember(viewModel) { viewModel.state }.collectAsState()

    DashboardView(state,
        modifier,
        onClick = { viewModel.createNewEvent() },
        onSwipe = { viewModel.deleteEvent(it) })
}

@Composable
private fun DashboardView(
    state: DashboardState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onSwipe: (PersonTimeOff) -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (state is DashboardState.AllData) {
            SetName(state.user.name)
            SetupCardTimeOff(state.timeOffData, modifier)
            SetupListVacations(state.myTimeOffList, modifier, onClick, onSwipe)
        }
    }
}

@Composable
private fun SetName(name: String?) {
    name?.let {
        Text(
            text = stringResource(id = R.string.dashboard_hello, it),
            modifier = Modifier
                .padding(top = 72.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = typography.h3
        )
    }
}

@Composable
private fun SetupListVacations(
    state: UiState<List<PersonTimeOff>>,
    modifier: Modifier,
    onClick: () -> Unit = {},
    onSwipe: (PersonTimeOff) -> Unit = {}
) {
    when (state) {
        is UiState.Success -> CreateCardListVacations(state, onClick, onSwipe)
        is UiState.Loading -> LoaderComponent(modifier = modifier)
        is UiState.Error -> ShowError()
        else -> {}
    }
}

@Composable
private fun CreateCardListVacations(
    state: UiState.Success<List<PersonTimeOff>>,
    onClick: () -> Unit,
    onSwipe: (PersonTimeOff) -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 60.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.dashboard_upcoming_events),
                    style = MaterialTheme.typography.body2,
                    color = Color.Black,
                )

                Text(
                    text = stringResource(id = R.string.view_all),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.secondary
                )
            }


            if (state.data.isEmpty()) SetupEmptyList(onClick)
            else SetupItemList(state.data, onClick, onSwipe)
        }
    }
}

@Composable
private fun SetupEmptyList(onClick: () -> Unit = {}) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp),
        text = stringResource(id = R.string.dashboard_dont_have_events),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1,
        color = black400
    )
    NewEventButton(onClick)


}

@Composable
private fun NewEventButton(onClick: () -> Unit = {}) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        border = BorderStroke(1.dp, grayBlue),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = indigo600)
    ) {
        Text(text = stringResource(id = R.string.dashboard_new_event))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SetupItemList(
    data: List<PersonTimeOff>, onClick: () -> Unit = {}, onSwipe: (PersonTimeOff) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(data, { data: PersonTimeOff -> data.id }) { item ->
            val dismissState = rememberDismissState(confirmStateChange = {
                if (it == DismissValue.DismissedToEnd) {
                    onSwipe(item)
                }
                true
            })

            SwipeToDismiss(state = dismissState,
                directions = setOf(DismissDirection.StartToEnd),
                dismissThresholds = { FractionalThreshold(0.2F) },
                background = {
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.Default -> Color.LightGray
                            else -> red600
                        }
                    )

                    val scale by animateFloatAsState(targetValue = if (dismissState.targetValue == DismissValue.Default) 0.8F else 1.2F)

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .background(color)
                            .padding(horizontal = (20.dp)),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        Icon(
                            modifier = Modifier.scale(scale),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_trash),
                            contentDescription = stringResource(id = R.string.delete_icon),
                            tint = Color.White
                        )
                    }
                },
                dismissContent = { ItemViewTimeOff(item, dismissState) })
        }
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onClick() }) {
                CircleShapeBorderComponent(R.drawable.ic_plus, R.string.plus_icon)
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    style = MaterialTheme.typography.subtitle1,
                    text = stringResource(id = R.string.dashboard_no_more_events),
                    color = black400
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ItemViewTimeOff(item: PersonTimeOff, dismissState: DismissState) {
    Card(
        elevation = animateDpAsState(
            if (dismissState.dismissDirection != null) 4.dp else 0.dp
        ).value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        shape = RoundedCornerShape(8.dp)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            CircleShapePolicyComponent(PoliciesToIcon.getIconToPolicy(item.timeOffPolicyId))

            Column(Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = "${item.startDate} - ${item.endDate}",
                    style = MaterialTheme.typography.body1,
                    color = grayBlue900
                )
                Text(
                    text = item.details,
                    style = MaterialTheme.typography.subtitle1,
                    color = black400
                )
            }
        }
    }
}


@Composable
private fun SetupCardTimeOff(
    state: UiState<Summary>,
    modifier: Modifier,
) {
    when (state) {
        is UiState.Success -> CardTimeOff(state)
        is UiState.Loading -> LoaderComponent(modifier = modifier)
        is UiState.Error -> ShowError()
        else -> {}
    }
}

@Composable
private fun CardTimeOff(state: UiState.Success<Summary>) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp),

            ) {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(state.data.used)
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append(
                            stringResource(
                                id = R.string.dashboard_card_vacations_days,
                                state.data.allowedAllowance
                            )
                        )
                    }
                    append(stringResource(id = R.string.dashboard_card_vacations))
                },
                color = Color.Black,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Divider(
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Text(
                text = stringResource(id = R.string.dashboard_card_vacations_description),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_listen_to_music),
                contentDescription = stringResource(id = R.string.dashboard_icon_content_description),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Composable
private fun ShowError() {
    // Need UI
}

@Preview
@Composable
private fun PreviewHomeScreen(
    @PreviewParameter(PreviewUiState::class) state: DashboardState
) {
    MinderaTheme {
        DashboardView(state = state)
    }
}

@Preview(name = "dashboard")
@Composable
private fun DashboardPreview() {
    MinderaTheme {
        DashboardScreen()
    }
}
