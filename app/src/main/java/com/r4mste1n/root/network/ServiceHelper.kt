package com.r4mste1n.root.network

import com.r4mste1n.main.MainService
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Alex Shtain on 18.04.2020.
 */
object ServiceHelper {

    val mainService by lazy { createMainService() }

    private fun createMainService() =
        RetrofitHelper.createService(MainService::class.java, HttpLoggingInterceptor.Level.BODY)

}