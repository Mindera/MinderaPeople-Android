package com.mindera.people.android.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import co.touchlab.kermit.Logger
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.theme.MinderaTheme
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

    LaunchedEffect(true) {
        GoogleSignIn.getLastSignedInAccount(context)?.run {
            logger.d { "GoogleSignIn.getLastSignedInAccount email=($email)" }
            email?.run { viewModel.setUser(User(email = this, name = displayName)) }
        }
    }

    if (homeState is HomeState.AuthenticationState) {
        LaunchedEffect(key1 = Unit) {
            // TODO Nav
        }
    }
    if (state is UiState.Success)
        Toast.makeText(
            LocalContext.current,
            "${state.data.name} \n ${state.data.email}",
            Toast.LENGTH_SHORT
        ).show()
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
