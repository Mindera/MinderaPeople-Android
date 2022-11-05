package com.mindera.people.utils

import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.stringWithContentsOfURL

actual fun getUrlContent(url: String): String? =
    NSString.stringWithContentsOfURL(NSURL(string = url))?.toString()
