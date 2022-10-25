package com.mindera.people.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.mindera.people.android.ui.navigation.SetupNavGraph
import com.mindera.people.android.ui.theme.MinderaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // this app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MinderaTheme {
                SetupNavGraph(navController = rememberNavController())
            }
        }
    }
}
