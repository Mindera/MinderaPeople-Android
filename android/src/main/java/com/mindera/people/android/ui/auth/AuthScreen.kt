package com.mindera.people.android.ui.auth

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import co.touchlab.kermit.Logger
import com.mindera.people.android.R
import com.mindera.people.android.components.FullScreenLoaderComponent
import com.mindera.people.android.components.SimpleButton
import com.mindera.people.android.components.WebViewComponent
import com.mindera.people.android.components.buildErrorSnackbarHost
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.utils.Constants.authURL
import com.mindera.people.android.utils.Constants.mathUrlPickToken
import com.mindera.people.android.utils.PreviewAuthState
import com.mindera.people.android.utils.PreviewNavigatorWithoutBack
import com.mindera.people.android.utils.getWith
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AuthScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
    logger: Logger = getWith("AuthScreen")
) {
    val viewModel = koinViewModel<AuthViewModel> { parametersOf(navigator) }
    val authState by remember(viewModel) { viewModel.state }.collectAsState()

    AuthView(
        onClick = { viewModel.startAuthentication() },
        resultHandler = { viewModel.validateAuthentication(it) },
        state = authState,
        modifier = modifier
    )
}

@Composable
private fun AuthView(
    modifier: Modifier = Modifier,
    state: AuthState,
    onClick: () -> Unit = {},
    resultHandler: (String) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            buildErrorSnackbarHost(
                modifier = Modifier.padding(WindowInsets.navigationBars.asPaddingValues()),
                hostState = scaffoldState.snackbarHostState
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        AuthBehaviorView(
            onClick = onClick,
            state = state,
            modifier = modifier.padding(it)
        )

        if (state is AuthState.Loading) {
            FullScreenLoaderComponent(modifier = modifier.padding(it))
        }
    }

    if (state is AuthState.AuthError) {
        // FIXME Fetch the correct error message/code from the AuthError and show respective message
        val message = stringResource(id = R.string.auth_error_msg)
        SideEffect {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(message = message)
            }
        }
    }

    if (state is AuthState.AuthWebView) {
        Scaffold(
            topBar = { TopAppBar(backgroundColor = MaterialTheme.colors.primary) { } },
            bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { } },
            content = {
                WebViewComponent(
                    url = authURL,
                    webViewClient = authWebViewClient(resultHandler = resultHandler)
                )
            }
        )
    }
}

private fun authWebViewClient(resultHandler: (String) -> Unit) = object : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (url.contains(mathUrlPickToken)) {
            resultHandler(url.replace(mathUrlPickToken, ""))
            return true
        }
        return false
    }
}

@Composable
private fun AuthBehaviorView(
    onClick: () -> Unit,
    state: AuthState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .background(MaterialTheme.colors.primary),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            painter = painterResource(R.drawable.mindera_logo_img),
            contentDescription = stringResource(id = R.string.login_img_cont_desc),
        )

        SimpleButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 40.dp, vertical = 24.dp),
            textRes = R.string.login_btn_label,
            onClick = onClick
        )
    }
}

//@Composable
//fun WebViewComponent(
//    state: AuthState,
//    resultHandler: (String) -> Unit
//) {
//    AndroidView(factory = {
//        WebView(it).apply {
//            settings.userAgentString = "http.agent"
//            settings.javaScriptEnabled = true
//            layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//            webViewClient = object : WebViewClient() {
//
//                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                    if (url.contains(mathUrlPickToken)) {
//                        resultHandler(url.replace(mathUrlPickToken, ""))
//                        return true
//                    }
//                    return false
//                }
//            }
//
//            loadUrl(authURL)
//        }
//    })
//}

@Preview(name = "home")
@Composable
private fun AuthPreview(
    @PreviewParameter(PreviewNavigatorWithoutBack::class) navigator: Navigator
) {
    MinderaTheme {
        AuthScreen(navigator)
    }
}

@Preview
@Composable
private fun AuthScreenPreview(
    @PreviewParameter(PreviewAuthState::class) state: AuthState
) {
    MinderaTheme {
        AuthView(state = state)
    }
}
