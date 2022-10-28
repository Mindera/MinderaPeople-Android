package com.mindera.people.android.ui.home

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.mindera.people.utils.UiState
import com.mindera.people.android.R
import com.mindera.people.android.components.FullScreenLoaderComponent
import com.mindera.people.android.components.SignInGoogleButton
import com.mindera.people.android.ui.google.GoogleApiContract
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.user.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home() {
    val signInRequestCode = 1
    val viewModel = koinViewModel<HomeViewModel>()
    val googleUser by remember(viewModel) { viewModel.googleUser }.collectAsState()
    val context = LocalContext.current

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    viewModel.setError()
                } else {
                    viewModel.fetchSignInUser(account.email, account.displayName)
                }
            } catch (e: ApiException) {
                Log.d("Error in AuthScreen%s", e.toString())
            }
        }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        googleUser
    )

    GoogleSignIn.getLastSignedInAccount(context)?.run {
        viewModel.setUser(email, displayName)
    }

    if (googleUser is UiState.Success) {
        LaunchedEffect(key1 = Unit) {
            // TODO Nav
        }
    }
}


@Composable
private fun AuthView(
    onClick: () -> Unit,
    googleUser: UiState<User>
) {

    Scaffold { it
        if (googleUser == UiState.Loading) {
            FullScreenLoaderComponent()
        } else {
            AuthBehaviorView(onClick, googleUser)
        }
    }
}


@Composable
private fun AuthBehaviorView(
    onClick: () -> Unit,
    googleUser: UiState<User>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        SignInGoogleButton(onClick = {
            onClick()
        })
        Spacer(modifier = Modifier.weight(1F))

        if (googleUser == UiState.Error) {
            Text(
                stringResource(R.string.auth_error_msg),
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
