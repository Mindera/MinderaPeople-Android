package com.mindera.people.android.components

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewComponent(
    url: String,
    webViewClient: WebViewClient
) {
    AndroidView(factory = {
        WebView(it).apply {
            settings.userAgentString = "http.agent"
            settings.javaScriptEnabled = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            this.webViewClient = webViewClient
            loadUrl(url)
        }
    })
}