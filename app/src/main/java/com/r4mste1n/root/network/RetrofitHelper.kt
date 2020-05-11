package com.r4mste1n.root.network

import com.google.gson.GsonBuilder
import com.r4mste1n.root.network.NetworkConstants.API_VERSION
import com.r4mste1n.root.network.NetworkConstants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Alex Shtain on 18.04.2020.
 */

object RetrofitHelper {

    fun <T> createService(_class: Class<T>, level: HttpLoggingInterceptor.Level): T =
        getRetrofit(getOkHttpBuilder(level)).create(_class)

    private fun getRetrofit(builder: OkHttpClient.Builder) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(builder.build())
        .baseUrl(BASE_URL + API_VERSION)
        .build()

    private fun getOkHttpBuilder(level: HttpLoggingInterceptor.Level) = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            this.level = level
        })
        .addInterceptor(RequestInterceptor())

}