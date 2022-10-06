package com.mindera.people

import java.net.URL

actual fun getUrlContent(url: String): String? = URL(url).readText()
