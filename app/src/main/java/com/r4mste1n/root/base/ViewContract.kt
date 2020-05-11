package com.r4mste1n.root.base

import android.view.View

/**
 * Created by Alex Shtain on 24.04.2020.
 */
interface ViewContract {

    fun setContentView(rootView: View)

    fun onFinishedInflate(presenter: PresenterContract)

    fun removePresenter()

    fun showLoader(isShow: Boolean)

    fun showError(error: String?)

    fun hideError()

}