package com.r4mste1n.root.extensions

import android.content.Context

/**
 * Created by Alex Shtain on 26.04.2020.
 */

fun Context.convertDpToPix(dp: Int): Float = dp * resources.displayMetrics.density

fun Context.convertSpToPix(sp: Float): Float = sp * resources.displayMetrics.scaledDensity