package com.mindera.people.utils

import java.net.URL

actual fun getUrlContent(url: String): String? = URL(url).readText()
