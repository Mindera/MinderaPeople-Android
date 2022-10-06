package com.mindera.people

import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.stringWithContentsOfURL

actual fun getUrlContent(url: String): String? =
    NSString.stringWithContentsOfURL(NSURL(string = url))?.toString()
