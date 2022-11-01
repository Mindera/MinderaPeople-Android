package com.mindera.people.android.ui.home

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.mindera.people.android.R
import com.mindera.people.android.components.FullScreenLoaderComponent
import com.mindera.people.android.components.SignInGoogleButton
import com.mindera.people.android.services.GoogleSignInApiContract
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.home.HomeState
import com.mindera.people.home.HomeViewModel
import com.mindera.people.user.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    val signInRequestCode = 1
    val viewModel = koinViewModel<HomeViewModel>()
    val homeState by remember(viewModel) { viewModel.state }.collectAsState()
    val context = LocalContext.current

    val authResultLauncher = rememberLauncherForActivityResult(
        contract = GoogleSignInApiContract()
    ) { task ->
        try {
            val account = task?.getResult(ApiException::class.java)
            when {
                account == null -> {/* TODO what feedback? */}
                account.email.isNullOrBlank() -> {/* TODO what feedback? */}
                else -> viewModel.setUser(
                    User(email = account.email!!, name = account.displayName)
                )
            }
        } catch (error: ApiException) {
            Log.d("Home", "Error in AuthScreen", error)
        }
    }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        homeState = homeState,
        modifier = modifier
    )

    GoogleSignIn.getLastSignedInAccount(context)?.run {
        email?.run { viewModel.setUser(User(email = this, name = displayName)) }
    }

    if (homeState is HomeState.AuthenticationState) {
        LaunchedEffect(key1 = Unit) {
            // TODO Nav
        }
    }
}

@Composable
private fun AuthView(
    onClick: () -> Unit,
    homeState: HomeState,
    modifier: Modifier = Modifier
) {
    Scaffold { it
        when (homeState) {
            is HomeState.Idle -> {/* no-op */}
            is HomeState.Loading -> FullScreenLoaderComponent()
            is HomeState.AuthenticationState -> {
                AuthBehaviorView(onClick, homeState, modifier)
            }
        }
    }
}

@Composable
private fun AuthBehaviorView(
    onClick: () -> Unit,
    state: HomeState.AuthenticationState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        SignInGoogleButton(onClick = onClick, modifier = Modifier.wrapContentSize())
        Spacer(modifier = Modifier.weight(1F))

        if (state.error != null) {
            Text(
                text = stringResource(R.string.auth_error_msg),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.error
            )
        }
    }
}

@Preview(name = "home")
@Composable
private fun HomePreview() {
    MinderaTheme {
        Home()
    }
}
