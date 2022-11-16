package com.mindera.people.android.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.mindera.people.android.utils.getWith
import com.mindera.people.home.HomeState
import com.mindera.people.home.HomeViewModel
import com.mindera.people.user.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    log: Logger = getWith("HomeScreen")
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val homeState by remember(viewModel) { viewModel.state }.collectAsState()

    GoogleSignIn.getLastSignedInAccount(LocalContext.current)?.run {
        log.i { "GoogleSignIn.getLastSignedInAccount -> email=$email" }
        val email = email ?: return@run
        val token = idToken ?: return@run
        viewModel.setUser(User(email = email, token = token, name = displayName))
    }

    if (homeState is HomeState.AuthenticationState) {
        LaunchedEffect(key1 = Unit) {
            // TODO Nav
        }
    }
}

@Preview(name = "home")
@Composable
private fun HomePreview(
    @PreviewParameter(PreviewNavigatorWithoutBack::class) navigator: Navigator
) {
    MinderaTheme {
        HomeScreen(navigator)
    }
}
