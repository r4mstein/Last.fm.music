package com.r4mste1n.root.base

import android.os.Bundle
import androidx.annotation.CallSuper

/**
 * Created by Alex Shtain on 25.04.2020.
 */
abstract class BasePresenter<V : ViewContract> : PresenterContract {

    protected var view: V? = null
    protected var bundle: Bundle? = null

    @Suppress("UNCHECKED_CAST")
    @CallSuper
    override fun setContractView(view: ViewContract) {
        this.view = view as? V
    }

    @CallSuper
    override fun removeContractView() {
        view = null
    }

    override fun onCreateView() {

    }

    override fun onViewCreated() {

    }

    override fun onStart() {

    }

    @CallSuper
    override fun onStop() {
        view?.hideError()
    }

    override fun setBundleData(bundle: Bundle?) {
        this.bundle = bundle
    }

}