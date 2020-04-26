package com.r4mste1n.root

import android.app.Application
import com.r4mste1n.BuildConfig
import timber.log.Timber

/**
 * Created by Alex Shtain on 18.04.2020.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // initialise Timber
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}