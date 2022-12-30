package com.mindera.people.android.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.mindera.people.android.components.LoaderComponent
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.ui.theme.typography
import com.mindera.people.android.utils.PreviewUiState
import com.mindera.people.android.utils.getWith
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.timeoff.Summary
import com.mindera.people.utils.UiState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    logger: Logger = getWith("DashboardScreen")
) {
    val viewModel = koinViewModel<DashboardViewModel>()
    val state by remember(viewModel) { viewModel.state }.collectAsState()

    DashboardView(state, modifier)
}

@Composable
private fun DashboardView(
    state: DashboardState,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (state is DashboardState.UserData) SetName(state.user.name)
        if (state is DashboardState.TimeOffData) SetupCardTimeOff(state.timeOffData, modifier)
        if (state is DashboardState.MyTimeOffList) SetupListVacations(state.myTimeOffList, modifier)
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
private fun SetupListVacations(state: UiState<List<PersonTimeOff>>, modifier: Modifier) {
    if (state is UiState.Success) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
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

                LazyColumn(Modifier.padding(top = 16.dp)) {
                    items(state.data) { item ->
                        SetupItemList(item)
                    }
                }
            }
        }
    } else if (state is UiState.Loading) {
        LoaderComponent(modifier = modifier)
    } else if (state is UiState.Error) {
        ShowError()
    }
}

@Composable
private fun SetupItemList(item: PersonTimeOff) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Image(painter = painterResource(R.drawable.ic_google_logo), contentDescription = "")

        Column(Modifier.padding(horizontal = 12.dp)) {
            Text(text = "${item.startDate} - ${item.endDate}")
            Text(text = item.details)
        }
    }
}


@Composable
private fun SetupCardTimeOff(state: UiState<Summary>, modifier: Modifier) {

    if (state is UiState.Success) {
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
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(state.data.used)
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
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

    } else if (state is UiState.Loading) {
        LoaderComponent(modifier = modifier)
    } else if (state is UiState.Error) {
        ShowError()
    }
}

@Composable
private fun ShowError() {
    val scope = rememberCoroutineScope()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val message = stringResource(id = R.string.auth_error_msg)
    SideEffect {
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(message = message)
        }
    }
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
