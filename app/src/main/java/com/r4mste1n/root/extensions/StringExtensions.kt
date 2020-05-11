package com.r4mste1n.root.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

/**
 * Created by Alex Shtain on 24.04.2020.
 */

fun String?.formatCount(): String = DecimalFormat("#,###", DecimalFormatSymbols().apply {
    groupingSeparator = ' '
}).format(this?.toLong() ?: 0L)
