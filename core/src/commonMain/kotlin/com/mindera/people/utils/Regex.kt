package com.mindera.people.utils

val emailAddressRegex: Regex
    get() = Regex(pattern = buildString {
        append("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}")
        append("\\@")
        append("[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}")
        append("(")
        append("\\.")
        append("[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}")
        append(")+")
    })
