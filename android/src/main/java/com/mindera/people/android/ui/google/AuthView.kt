package com.mindera.people.android.ui.google

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.gms.common.api.ApiException
import com.mindera.people.UiState
import com.mindera.people.android.R
import com.mindera.people.android.components.FullScreenLoaderComponent
import com.mindera.people.android.components.SignInGoogleButton
import com.mindera.people.android.ui.navigation.Screen
import com.mindera.people.user.User
import org.koin.androidx.compose.koinViewModel


@Composable
fun AuthScreen(navController: NavHostController) {
    val signInRequestCode = 1
    val viewModel = koinViewModel<SignInGoogleViewModel>()

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                task?.getResult(ApiException::class.java)?.let {
                    viewModel.fetchSignInUser(it.email, it.displayName)
                } ?: run {
                    viewModel.setError()
                }
            } catch (e: ApiException) {
                Log.d("Error in AuthScreen%s", e.toString())
            }
        }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        viewModel
    )

    if (viewModel.googleUser.value is UiState.Success) {
        LaunchedEffect(key1 = Unit) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }
    }
}

@Composable
private fun AuthView(
    onClick: () -> Unit,
    mSignInViewModel: SignInGoogleViewModel
) {
    val state = mSignInViewModel.googleUser.observeAsState()

    Scaffold { it
        if (state.value == UiState.Loading) {
            FullScreenLoaderComponent()
        } else {
            AuthBehaviorView(onClick, state)
        }
    }
}


@Composable
private fun AuthBehaviorView(
    onClick: () -> Unit,
    state: State<UiState<User>?>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painterResource(id = R.drawable.app_logo),
            contentDescription = stringResource(R.string.app_logo_desc),
        )
        Spacer(modifier = Modifier.weight(1F))
        SignInGoogleButton(onClick = {
            onClick()
        })
        Spacer(modifier = Modifier.weight(1F))

        if (state.value == UiState.Error) {
            Text(
                stringResource(R.string.auth_error_msg),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.error
            )
        }
    }
}