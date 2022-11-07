package com.mindera.people.android.ui.auth

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import com.google.android.gms.common.api.ApiException
import com.mindera.people.android.R
import com.mindera.people.android.components.FullScreenLoaderComponent
import com.mindera.people.android.components.SignInGoogleButton
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.services.GoogleSignInApiContract
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.utils.PreviewNavigatorWithoutBack
import com.mindera.people.android.utils.getWith
import com.mindera.people.auth.AuthState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    logger: Logger = getWith("AuthScreen")
) {
    val signInRequestCode = 511
    val viewModel = koinViewModel<AuthViewModel>()
    val authState by remember(viewModel) { viewModel.state }.collectAsState()

    val authResultLauncher = rememberLauncherForActivityResult(
        contract = GoogleSignInApiContract()
    ) { task ->
        try {
            val account = task?.getResult(ApiException::class.java)
            when {
                account == null -> {/* TODO what feedback? */}
                account.email.isNullOrBlank() -> {/* TODO what feedback? */}
                else -> viewModel.authenticate(
                    User(email = account.email!!, name = account.displayName)
                )
            }
        } catch (error: ApiException) {
            logger.d("Error in AuthScreen", error)
        }
    }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        state = authState,
        modifier = modifier
    )

    if (authState is AuthState.AuthSuccess) {
        navigator.getBackHome()
    }
}

@Composable
private fun AuthView(
    onClick: () -> Unit,
    state: AuthState,
    modifier: Modifier = Modifier
) {
    Scaffold {
        when (state) {
            is AuthState.Loading -> {
                FullScreenLoaderComponent(modifier = modifier.padding(it))
            }
            is AuthState.Idle, is AuthState.AuthSuccess, is AuthState.AuthError -> {
                AuthBehaviorView(
                    onClick = onClick,
                    state = state,
                    modifier = modifier.padding(it)
                )
            }
            is AuthState.UserCleared -> {/* to do */}
        }
    }
}

@Composable
private fun AuthBehaviorView(
    onClick: () -> Unit,
    state: AuthState,
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

        if (state is AuthState.AuthError) {
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
private fun AuthPreview(
    @PreviewParameter(PreviewNavigatorWithoutBack::class) navigator: Navigator
) {
    MinderaTheme {
        AuthScreen(navigator)
    }
}
