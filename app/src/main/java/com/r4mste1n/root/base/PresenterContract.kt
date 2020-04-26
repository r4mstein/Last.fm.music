package com.r4mste1n.root.base

import android.os.Bundle

/**
 * Created by Alex Shtain on 24.04.2020.
 */
interface PresenterContract {

    fun setContractView(view: ViewContract)

    fun removeContractView()

    fun onCreateView()

    fun onViewCreated()

    fun onStart()

    fun onStop()

    fun setBundleData(bundle: Bundle?)

}