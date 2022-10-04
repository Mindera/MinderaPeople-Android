package com.mindera.people

expect fun getUrlContent(url: String): String?

expect fun logError(tag: String, message: String, error: Throwable)
