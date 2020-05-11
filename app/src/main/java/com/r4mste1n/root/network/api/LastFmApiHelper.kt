package com.r4mste1n.root.network.api

import com.r4mste1n.root.network.RetrofitHelper
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Alex Shtain on 18.04.2020.
 */
object LastFmApiHelper {

    val lastFmApi by lazy { createLastFmApi() }

    private fun createLastFmApi() =
        RetrofitHelper.createService(
            LastFmApi::class.java,
            HttpLoggingInterceptor.Level.BODY
        )

}