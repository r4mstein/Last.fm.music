package com.r4mste1n.root.base

import android.content.Context
import android.view.View
import androidx.annotation.CallSuper

/**
 * Created by Alex Shtain on 25.04.2020.
 */
abstract class BaseView<P : PresenterContract> : ViewContract {

    protected var rootView: View? = null
    protected var presenter: P? = null
    protected var context: Context? = null

    abstract fun setupUI()

    @CallSuper
    override fun setContentView(rootView: View) {
        this.rootView = rootView
        context = rootView.context
    }

    @Suppress("UNCHECKED_CAST")
    @CallSuper
    override fun onFinishedInflate(presenter: PresenterContract) {
        this.presenter = (presenter as? P)
        setupUI()
    }

    @CallSuper
    override fun removePresenter() {
        presenter = null
    }

    override fun showLoader(isShow: Boolean) {
        (context as? BaseActivity)?.apply {
            if (isShow) showProgressBar() else hideProgressBar()
        }
    }

    override fun showError(error: String?) {
        (context as? BaseActivity)?.showError(error)
    }

    override fun hideError() {
        (context as? BaseActivity)?.hideError()
    }

}