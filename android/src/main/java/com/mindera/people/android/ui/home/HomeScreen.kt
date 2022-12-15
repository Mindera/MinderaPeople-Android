package com.mindera.people.android.ui.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import com.mindera.people.android.R
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.ui.theme.typography
import com.mindera.people.android.utils.PreviewNavigatorWithoutBack
import com.mindera.people.android.utils.PreviewUiState
import com.mindera.people.android.utils.getWith
import com.mindera.people.auth.User
import com.mindera.people.utils.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    logger: Logger = getWith("HomeScreen")
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val homeState by remember(viewModel) { viewModel.state }.collectAsState()

    EmptyHomeView(modifier, homeState)
}

@Composable
private fun EmptyHomeView(
    modifier: Modifier = Modifier,
    state: UiState<User>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            painter = painterResource(R.drawable.empty_screen_img),
            contentDescription = stringResource(id = R.string.empty_screen_img_cont_desc),
        )
        Text(text = stringResource(id = R.string.empty_screen_title), style = typography.body2)
        Text(
            text = stringResource(id = R.string.empty_screen_description),
            style = typography.body1
        )
    }
    if (state is UiState.Success)
        Toast.makeText(
            LocalContext.current,
            "${state.data.name} \n ${state.data.email}",
            Toast.LENGTH_SHORT
        ).show()
}

@Preview
@Composable
private fun PreviewHomeScreen(
    @PreviewParameter(PreviewUiState::class) state: UiState<User>
) {
    MinderaTheme {
        EmptyHomeView(state = state)
    }
}

@Preview(name = "home")
@Composable
private fun HomePreview(
    @PreviewParameter(PreviewNavigatorWithoutBack::class) navigator: Navigator,
) {
    MinderaTheme {
        HomeScreen(navigator)
    }
}
