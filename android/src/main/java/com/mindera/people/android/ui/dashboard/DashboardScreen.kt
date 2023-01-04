package com.mindera.people.android.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import co.touchlab.kermit.Logger
import com.mindera.people.android.ui.theme.MinderaTheme
import com.mindera.people.android.utils.PreviewUiState
import com.mindera.people.android.utils.getWith
import com.mindera.people.utils.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    logger: Logger = getWith("DashboardScreen")
) {
    val viewModel = koinViewModel<DashboardViewModel>()
    val dashboardState by remember(viewModel) { viewModel.state }.collectAsState()

    DashboardView(modifier, dashboardState)
}

@Composable
private fun DashboardView(
    modifier: Modifier = Modifier,
    state: UiState<Unit>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {}
}

@Preview
@Composable
private fun PreviewHomeScreen(
    @PreviewParameter(PreviewUiState::class) state: UiState<Unit>
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
